package queryexecutor;

import core.Tuple;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class FileScan implements Iterator {
    private final String relation;
    private List<Tuple> relationTuples;
    private int counter;

    public Map<String, List<Tuple>> hardCodedValues = Map.of("movies",
            asList(new Tuple(Map.of("movieId", "1", "title", "Toy Story")),
                    new Tuple(Map.of("movieId", "5000", "title", "Copycat")),
                    new Tuple(Map.of("movieId", "2", "title", "Jumanji"))));
    ;

    public FileScan(String relation) {
        this.relation = relation;
    }

    @Override
    public void init() {
        relationTuples = hardCodedValues.get(relation);
        counter = 0;
    }

    @Override
    public Tuple next() {
        if (counter >= relationTuples.size()) {
            return null;
        }

        Tuple tuple = relationTuples.get(counter);
        counter++;
        return tuple;
    }

    @Override
    public void close() {

    }

    @Override
    public List<Iterator> iterators() {
        return null;
    }
}
