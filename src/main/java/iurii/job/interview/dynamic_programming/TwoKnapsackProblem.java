package iurii.job.interview.dynamic_programming;

import java.util.List;

public class TwoKnapsackProblem {

    public TwoKnapsackProblem(int capacity1, int capacity2, List<KnapsackItem> items) {
        int[][] cache = new int[capacity1 + 1][capacity2 + 1];
        for (KnapsackItem item : items) {
            for (int w1 = capacity1; w1 >= item.getWeight(); w1--) {
                for (int w2 = capacity2; w2 >= item.getWeight(); w2--) {
                    if (cache[w1 - item.getWeight()][w2] + item.getValue() >= cache[w1][w2] &&
                            cache[w1 - item.getWeight()][w2] + item.getValue() >= cache[w1][w2 - item.getWeight()]
                                    + item.getValue()) {
                        cache[w1][w2] = cache[w1 - item.getWeight()][w2] + item.getValue();
                    } else if (cache[w1][w2 - item.getWeight()] + item.getValue() >= cache[w1 - item.getWeight()][w2]
                            + item.getValue() &&
                            cache[w1][w2 - item.getWeight()] + item.getValue() >= cache[w1][w2]) {
                        cache[w1][w2] = cache[w1][w2 - item.getWeight()] + item.getValue();
                    }
                }
            }
        }
    }

}
