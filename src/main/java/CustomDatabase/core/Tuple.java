package CustomDatabase.core;

import java.util.Map;
import java.util.stream.Collectors;

public class Tuple {

    Map<String, String> values;

    public Tuple(Map<String, String> values) {
        this.values = values;
    }

    public Map<String, String> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "values=" + values.values().stream().map(Object::toString).collect(Collectors.joining()) +
                '}';
    }
}
