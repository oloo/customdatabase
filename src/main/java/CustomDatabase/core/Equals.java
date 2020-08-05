package CustomDatabase.core;

import java.util.List;

import static java.util.Objects.isNull;

public class Equals implements Iterator {
    private final String field;
    private final String value;
    private final Iterator previousIterator;

    public Equals(String field, String value, Iterator previousIterator) {
        this.previousIterator = previousIterator;
        this.field = field;
        this.value = value;
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
