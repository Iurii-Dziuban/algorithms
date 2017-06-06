package iurii.job.interview.dynamic_programming;

import java.util.List;

public class TwoKnapsackProblem {

    public TwoKnapsackProblem(int capacity1, int capacity2, List<KnapsackItem> items) {
        int[][] cache = new int[capacity1 + 1][capacity2 + 1];
        for (int i = 0; i < items.size(); i++) {
            for (int w1 = capacity1; w1 >= items.get(i).getWeight(); w1--) {
                for (int w2 = capacity2; w2 >= items.get(i).getWeight(); w2--) {
                    if (cache[w1 - items.get(i).getWeight()][w2] + items.get(i).getValue() >= cache[w1][w2] &&
                            cache[w1 - items.get(i).getWeight()][w2] + items.get(i).getValue() >= cache[w1][w2 - items.get(i).getWeight()] + items.get(i).getValue()) {
                        cache[w1][w2] = cache[w1 - items.get(i).getWeight()][w2] + items.get(i).getValue();
                    } else if (cache[w1][w2 - items.get(i).getWeight()] + items.get(i).getValue() >= cache[w1 - items.get(i).getWeight()][w2] + items.get(i).getValue() &&
                            cache[w1][w2 - items.get(i).getWeight()] + items.get(i).getValue() >= cache[w1][w2]) {
                        cache[w1][w2] = cache[w1][w2 - items.get(i).getWeight()] + items.get(i).getValue();
                    }
                }
            }
        }
        //TODO
        /*for i = 1 to n do
            for w1 = maxW1 down to a[i].weight do
              for w2 = maxW2 down to a[i].weight do
                dp[w1, w2] = max
                             {
                                 dp[w1, w2], <- we already have the best choice for this pair
                                 dp[w1 - a[i].weight, w2] + a[i].gain <- put in knapsack 1
                                 dp[w1, w2 - a[i].weight] + a[i].gain <- put in knapsack 2
                             }*/
    }

}
