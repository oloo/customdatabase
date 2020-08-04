import core.QueryPlan;
import core.QueryExpression;
import core.QueryResultSet;
import queryexecutor.QueryExecutor;

import static core.Node.*;

public class Application {

    public static void main(String[] args) {

        QueryPlan queryPlan = new QueryPlan(
                new QueryExpression(PROJECTION, "title"),
                new QueryExpression(SELECTION, "movieId", "EQUALS", "5000"),
                new QueryExpression(SCAN, "movies"));

        QueryExecutor queryExecutor = new QueryExecutor(queryPlan);
        QueryResultSet resultSet = queryExecutor.execute();
        System.out.println(resultSet);
    }
}
