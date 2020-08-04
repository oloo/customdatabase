package core;

import java.util.List;

import static java.util.Arrays.asList;

public class QueryPlan {

    private final List<QueryExpression> queryExpressions;

    public QueryPlan(QueryExpression... queryExpressions) {
        this.queryExpressions = asList(queryExpressions);
    }

    public List<QueryExpression> getQueryExpressions() {
        return queryExpressions;
    }
}
