package CustomDatabase.queryexecutor;

import CustomDatabase.core.QueryExpression;
import CustomDatabase.core.QueryPlan;
import CustomDatabase.core.QueryResultSet;
import CustomDatabase.core.Tuple;

import java.util.List;

import static CustomDatabase.core.Node.PROJECTION;
import static CustomDatabase.core.Node.SELECTION;
import static java.util.Objects.isNull;

public class QueryExecutor {

    private final QueryPlan queryPlan;
    private final Iterator iteratorTree;

    public QueryExecutor(QueryPlan queryPlan) {
        this.queryPlan = queryPlan;
        this.iteratorTree = buildIteratorTree();
        this.iteratorTree.init();
    }

    public QueryResultSet execute() {
        QueryResultSet queryResultSet = new QueryResultSet();
        while (true) {
            Tuple tuple = iteratorTree.next();
            if (isNull(tuple)) {
                return queryResultSet;
            }
            queryResultSet.addTuple(tuple);
        }
    }

    private Iterator buildIteratorTree() {
        List<QueryExpression> queryExpressions = queryPlan.getQueryExpressions();
        return buildIterator(queryExpressions, null, queryExpressions.size() - 1);
    }

    private Iterator buildIterator(List<QueryExpression> expressions, Iterator currentIterator, int currentIndex) {
        if (isNull(currentIterator)) {
            FileScan fileScan = new FileScan(expressions.get(currentIndex).getValues().get(0));
            currentIndex--;
            return buildIterator(expressions, fileScan, currentIndex);
        }

        if (currentIndex < 0) {
            return currentIterator;
        }

        QueryExpression currentExpression = expressions.get(currentIndex);

        if (currentExpression.getNode() == SELECTION) {
            Iterator filterIterator = Filter.getFilter(currentExpression.getValues(), currentIterator);
            currentIndex--;
            return buildIterator(expressions, filterIterator, currentIndex);
        }

        if (currentExpression.getNode() == PROJECTION) {
            Projection projection = new Projection(currentExpression.getValues(), currentIterator);
            currentIndex--;
            return buildIterator(expressions, projection, currentIndex);
        }

        throw new IllegalArgumentException("This is not setup right");
    }
}
