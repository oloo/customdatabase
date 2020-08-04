package core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QueryResultSet {

    private final List<Tuple> tuples;

    public QueryResultSet() {
        tuples = new ArrayList<>();
    }

    public void addTuple(Tuple tuple) {
        tuples.add(tuple);
    }

    @Override
    public String toString() {
        return "QueryResultSet{" +
                "tuples=" + tuples.stream().map(Object::toString).collect(Collectors.joining()) +
                '}';
    }
}
