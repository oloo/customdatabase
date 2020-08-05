package core;

import java.util.List;

import static java.util.Arrays.asList;

public class QueryExpression {
    private final Node node;
    private final List<String> values;

    public QueryExpression(Node node, String... values) {
        this.node = node;
        this.values = asList(values);
    }

    public Node getNode() {
        return node;
    }

    public List<String> getValues() {
        return values;
    }
}
