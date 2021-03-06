package CustomDatabase.core;

import java.util.List;

public interface Iterator {
    void init();

    Tuple next();

    void close();

    List<Iterator> iterators();

}
