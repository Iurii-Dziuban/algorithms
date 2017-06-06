package iurii.job.interview.algorithms2.coursera;

import java.util.List;

/**
 * Solving Knapsack Problem. Max possible value from the items limited by capacity > = Sum (weights)
 */
public class KnapsackProblem {
    private final int capacity;
    private final int maxValue;

    public KnapsackProblem(int capacity, List<KnapsackItem> items) {
        this.capacity = capacity;
        int[][] cache = new int[2][(int) (capacity + 1)];
        // initialization step
        for (int i = 0; i < capacity + 1; i++) {
            cache[0][i] = 0;
        }
        // end
        for (int i = 1; i < items.size() + 1; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                int possiblePreviousWeight = j - items.get(i - 1).getWeight();
                if (possiblePreviousWeight < 0 || cache[0][j] > cache[0][possiblePreviousWeight] + items.get(i - 1).getValue()) {
                    cache[1][j] = cache[0][j];
                } else {
                    cache[1][j] = cache[0][possiblePreviousWeight] + items.get(i - 1).getValue();
                }
            }
            for (int index = 0; index < capacity + 1; index++) {
                cache[0][index] = cache[1][index];
                cache[1][index] = 0;
            }

        }
        maxValue = cache[0][capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    public int getMaxValue() {
        return maxValue;
    }

}
