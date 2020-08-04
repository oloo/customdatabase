package queryexecutor;

import core.Tuple;

import java.util.List;

import static java.util.Objects.isNull;

public class Equals implements Iterator {
    private final String field;
    private final String value;
    private final Iterator previousIterator;

    public Equals(List<String> values, Iterator previousIterator) {
        this.previousIterator = previousIterator;
        this.field = values.get(0);
        this.value = values.get(2);
    }

    @Override
    public void init() {
        previousIterator.init();
    }

    @Override
    public Tuple next() {
        while (true) {
            Tuple currentTuple = previousIterator.next();
            if (isNull(currentTuple)) {
                return null;
            }
            if (currentTuple.getValues().get(field).equals(value)) {
                return currentTuple;
            }
        }
    }

    @Override
    public void close() {
        previousIterator.close();
    }

    @Override
    public List<Iterator> iterators() {
        return null;
    }
}
