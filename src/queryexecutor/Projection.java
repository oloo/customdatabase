package queryexecutor;

import core.Tuple;

import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Objects.isNull;

public class Projection implements Iterator {
    private final List<String> selectionSet;
    private final Iterator iterator;

    public Projection(List<String> selectionSet, Iterator iterator) {
        this.selectionSet = selectionSet;
        this.iterator = iterator;
    }

    @Override
    public void init() {
        iterator.init();
    }

    @Override
    public Tuple next() {
        Tuple tuple = iterator.next();
        if (isNull(tuple)) {
            return null;
        }

        HashMap<String, String> newMap = new HashMap<>();
        for (String selection : selectionSet) {
            newMap.put(selection, tuple.getValues().get(selection));
        }

        return new Tuple(newMap);
    }

    @Override
    public void close() {
        iterator.close();
    }

    @Override
    public List<Iterator> iterators() {
        return asList(iterator);
    }
}
