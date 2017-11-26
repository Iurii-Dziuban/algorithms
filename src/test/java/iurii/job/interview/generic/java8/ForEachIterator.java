package iurii.job.interview.generic.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * Example of using lambdas in Iterator api.
 *
 * There are as well lambdas in Collection API, Concurrent Collections API, Executors, Java IO
 *
 * added standard min, max, Comparator methods
 */
public class ForEachIterator {

    public List<Integer> iteratePlus1(List<Integer> values) {
        List<Integer> valuesPlusOne = new ArrayList<>();
        values.forEach(value -> valuesPlusOne.add(value + 1));
        return  valuesPlusOne;
    }
}
