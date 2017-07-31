package iurii.job.interview.algorithms2.coursera;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Solving Knapsack problem
 */
public class AlgorithmsWeekThreeTest {

    @Test
    public void main() throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("src/main/resources/knapsack1.txt"));
        int capacity1 = sc1.nextInt();
        List<KnapsackItem> items1 = new ArrayList<KnapsackItem>(sc1.nextInt());
        while (sc1.hasNextInt()) {
            items1.add(new KnapsackItem(sc1.nextInt(), sc1.nextInt()));
        }
        sc1.close();
        KnapsackProblem knapsackProblem1 = new KnapsackProblem(capacity1, items1);
        assertThat(knapsackProblem1.getMaxValue()).isEqualTo(2493893);

        Scanner sc2 = new Scanner(new File("src/main/resources/knapsack_big.txt"));
        int capacity2 = sc2.nextInt();
        List<KnapsackItem> items2 = new ArrayList<KnapsackItem>(sc2.nextInt());
        while (sc2.hasNextInt()) {
            items2.add(new KnapsackItem(sc2.nextInt(), sc2.nextInt()));
        }
        sc2.close();
        KnapsackProblem knapsackProblem2 = new KnapsackProblem(capacity2, items2);
        assertThat(knapsackProblem2.getMaxValue()).isEqualTo(4243395);
    }

}
