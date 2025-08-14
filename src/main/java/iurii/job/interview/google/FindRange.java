package iurii.job.interview.google;

import java.util.Set;
import java.util.TreeSet;

/**
 * This is google interview question I have heard.
 * You have a set of int numbers, let`s say there are no duplicates.
 * You need to implement function which accepts range [from to ] . for simplicity including both.
 * You need to return - number of values exists in range;
 * or even return all the numbers in the range.
 *
 * The solution should be based on Search in Tree - tree should be balanced, so probably red-black tree ?
 *
 */
public class FindRange {

    /**
     *  Here solution is based on TreeSet, which sorts
     */
    TreeSet<Integer> values = new TreeSet<>();

    void putValue(int value) {
        values.add(value);
    }


    /**
     * To insert new value into TreeSet operation is guaranteed to take O (log N)
     * because tree is balanced and being rebalanced if not balanced yet;
     *
     * To get answer:
     * Complexity: O(N) - for subset operation it is needed to go via all the nodes once;
     * Memory: O(N) - to store maximum all the numbers or subset of numbers
     *
     * Important to note that on average operations needed will be O (log N) as you need to go into only one side of tree;
     *
     * @param from - first value from range. Can be configured inclusive/exclusive
     * @param to - last value from the range. Can be configured inclusive/exclusive
     * @return values from the range;
     */
    Set<Integer> findValues(int from, int to) {
        return values.subSet(from, true, to, true);
    }

    int findCount(int from, int to) {
        return findValues(from, to).size();
    }

}
