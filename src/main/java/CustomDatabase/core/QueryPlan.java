package CustomDatabase.core;

import java.util.List;

import static java.util.Arrays.asList;

// For later
/*
Sample input

{
  "projection": [
    "name"
  ],
  "selection": {
    "operation": "and",
    input: [
      {
        operation: "=",
        input: [
          "movieId",
          "5000"
        ]
      },
      {
        operation: ">=",
        input: [
          "rating",
          "80"
        ]
      }
    ]
  }
}
 */
public class QueryPlan {

    private List<QueryExpression> queryExpressions;

    public QueryPlan(QueryExpression... queryExpressions) {
        this.queryExpressions = asList(queryExpressions);
    }

    public List<QueryExpression> getQueryExpressions() {
        return queryExpressions;
    }
}
