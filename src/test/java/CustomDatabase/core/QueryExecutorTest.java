package CustomDatabase.core;

import org.junit.jupiter.api.Test;

import static CustomDatabase.core.Node.*;
import static org.junit.jupiter.api.Assertions.*;

class QueryExecutorTest {

    @Test
    void testQuery() {
        QueryPlan queryPlan = new QueryPlan(
                new QueryExpression(PROJECTION, "title"),
                new QueryExpression(SELECTION, "movieId", "EQUALS", "5000"),
                new QueryExpression(SCAN, "movies"));

        QueryExecutor queryExecutor = new QueryExecutor(queryPlan);
        QueryResultSet resultSet = queryExecutor.execute();

        assertEquals("QueryResultSet{tuples=Tuple{values=Copycat}}", resultSet.toString());
    }
}