package iurii.job.interview.dynamic_programming;

import java.util.List;
import java.util.Stack;

/**
 * Searches max possible sum of elements that are not neighbors from the list
 */
public class WeightedIndependentSets {

    private final Stack<Integer> indexes = new Stack<Integer>();
    private final Stack<Integer> elements = new Stack<Integer>();
    private final int maxValue;

    public WeightedIndependentSets(List<Integer> list) {
        int[] cache = new int[list.size() + 1];
        cache[0] = 0;
        cache[1] = list.get(0);
        for (int i = 2; i < list.size() + 1; i++) {
            if (cache[i - 1] > cache[i - 2] + list.get(i - 1)) {
                cache[i] = cache[i - 1];
            } else {
                cache[i] = cache[i - 2] + list.get(i - 1);
            }
        }
        maxValue = cache[list.size()];
        int i = list.size();
        while (i > 0) {
            if (cache[i] == cache[i - 1]) {
                i--;
            } else {
                indexes.push(i - 1);
                elements.push(list.get(i - 1));
                i = i - 2;
            }
        }
    }

    public Stack<Integer> getIndexes() {
        return indexes;
    }

    public Stack<Integer> getElements() {
        return elements;
    }

    public int maxValue() {
        return maxValue;
    }

}
