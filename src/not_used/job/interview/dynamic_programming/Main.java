package iurii.job.interview.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        WeightedIndependentSets wis = new WeightedIndependentSets(Arrays.asList(2, 4, 5, 4));
        System.out.println(wis.getIndexes());
        System.out.println(wis.getElements());
        
        List<KnapsackItem> knapsackItems = new ArrayList<KnapsackItem>();
        knapsackItems.add(new KnapsackItem(3, 4));
        knapsackItems.add(new KnapsackItem(2, 3));
        knapsackItems.add(new KnapsackItem(4, 2));
        knapsackItems.add(new KnapsackItem(4, 3));
        
        KnapsackProblem knapsackProblem = new KnapsackProblem(6, knapsackItems);
        System.out.println(knapsackProblem.getMaxValue());
        System.out.println(knapsackProblem.getIndexes());
        System.out.println(knapsackProblem.getElements());
        
        //TwoKnapsackProblem twoKnapsacks = new TwoKnapsackProblem(7, 7, knapsackItems);
    }

}
