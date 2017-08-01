package iurii.job.interview.multiplication;

import iurii.job.interview.sorting.Utilities;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 01/08/2017.
 */
public class MultiplyMatricesTest {

    @Test
    public void test() {
        int[][] res = new MultiplyMatrices().bruteForce(
                new int[][]{{1, 2, 3, 4},
                        {2, 3, 4, 5},
                        {3, 4, 5, 6},
                        {4, 5, 6, 7}},
                new int[][]{{1, 2, 3, 4},
                        {2, 3, 4, 5},
                        {3, 4, 5, 6},
                        {4, 5, 6, 7}});
        Utilities.println(res);

        assertThat(res).containsExactly(
                new int []{
                        30, 40, 50, 60
                },
                new int[]{
                        40, 54, 68, 82
                },
                new int[] {
                        50, 68, 86, 104
                },
                new int[] {
                        60, 82, 104, 126
                }
        );

        int[][] res2 = new MultiplyMatrices().multiply(
                new int[][]{{1, 2, 3, 4},
                        {2, 3, 4, 5},
                        {3, 4, 5, 6},
                        {4, 5, 6, 7}},
                new int[][]{{1, 2, 3, 4},
                        {2, 3, 4, 5},
                        {3, 4, 5, 6},
                        {4, 5, 6, 7}});
        Utilities.println(res2);

        assertThat(res2).containsExactly(
                new int []{
                        30, 40, 50, 60
                },
                new int[]{
                        40, 54, 68, 82
                },
                new int[] {
                        50, 68, 86, 104
                },
                new int[] {
                        60, 82, 104, 126
                }
        );
    }
}
