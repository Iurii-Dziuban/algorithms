package iurii.job.interview.dynamic_programming;

import java.util.List;
import java.util.Stack;
/**
 * Solving Knapsack Problem. Max possible value from the items limited by capacity > = Sum (weights)
 */
public class KnapsackProblem {
    private final int capacity;
    private final int maxValue;
    private final Stack<Integer> indexes = new Stack<Integer>();
    private final Stack<KnapsackItem> elements = new Stack<KnapsackItem>();
    
    public KnapsackProblem(int capacity, List<KnapsackItem> items) {
        this.capacity = capacity;
        int[][] cache = new int[items.size() + 1][capacity + 1];
        // initialization step
        for (int i = 0; i < capacity + 1; i++) {
            cache[0][i] = 0;
        }
        // end
        for (int i = 1; i < items.size() + 1; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                int possiblePreviousWeight = j-items.get(i-1).getWeight();
                if ((possiblePreviousWeight < 0) || (cache[i-1][j] > cache[i-1][possiblePreviousWeight] + items.get(i-1).getValue())) {
                    cache[i][j] = cache[i-1][j];
                } else {
                    cache[i][j] = cache[i-1][possiblePreviousWeight] + items.get(i-1).getValue();
                }
            }
        }
        maxValue = cache[items.size()][capacity];
        int i = items.size();
        int j = capacity;
        while (i>0 && j>0) {
            if (cache[i][j] == cache[i-1][j]) {
                i--;
            } else {
                indexes.push(i-1);
                elements.push(items.get(i-1));
                j = j - items.get(i-1).getWeight();
                i--;
            }
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public Stack<Integer> getIndexes() {
        return indexes;
    }

    public Stack<KnapsackItem> getElements() {
        return elements;
    }

}
