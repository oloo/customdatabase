package CustomDatabase.queryexecutor;

import java.util.List;

public class Filter {

    public static Iterator getFilter(List<String> values, Iterator previousIterator) {
        if ("EQUALS".equals(values.get(1))) {
            return new Equals(values.get(0), values.get(2), previousIterator);
        }

        return null;
    }
}
