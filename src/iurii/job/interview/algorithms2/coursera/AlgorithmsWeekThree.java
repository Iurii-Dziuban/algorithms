package iurii.job.interview.algorithms2.coursera;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Solving Knapsack problem
 */
public class AlgorithmsWeekThree {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("knapsack1.txt"));
        int capacity1 = sc1.nextInt();
        List<KnapsackItem> items1 = new ArrayList<KnapsackItem>(sc1.nextInt());
        while (sc1.hasNextInt()) {
            items1.add(new KnapsackItem(sc1.nextInt(), sc1.nextInt()));
        }
        sc1.close();
        KnapsackProblem knapsackProblem1 = new KnapsackProblem(capacity1, items1);
        System.out.println(knapsackProblem1.getMaxValue());
        
        Scanner sc2 = new Scanner(new File("knapsack_big.txt"));
        int capacity2 = sc2.nextInt();
        List<KnapsackItem> items2 = new ArrayList<KnapsackItem>(sc2.nextInt());
        while (sc2.hasNextInt()) {
            items2.add(new KnapsackItem(sc2.nextInt(), sc2.nextInt()));
        }
        sc2.close();
        KnapsackProblem knapsackProblem2 = new KnapsackProblem(capacity2, items2);
        System.out.println(knapsackProblem2.getMaxValue());
    }

}
