package iurii.job.interview.leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class FourSumTest {

    @Test
    public void testWith2Sums() {
        FourSum fourSum = new FourSum();
        assertThat(fourSum.fourSumWith2Sums(new int[]{1, 0}, 0)).isEmpty();
        assertThat(fourSum.fourSumWith2Sums(new int[]{1, 0, 0, 0, -1}, 2)).isEmpty();
        assertThat(fourSum.fourSumWith2Sums(new int[]{1, 0, -1, 0, -2, 2}, 0))
                .containsExactlyInAnyOrder(Arrays.asList(-1, 0, 0, 1),
                        Arrays.asList(-2, 0, 0, 2), Arrays.asList(-2, -1, 1, 2));
        assertThat(fourSum.fourSumWith2Sums(new int[]{1, 0, -1, 0, -2, 2}, 0))
                .containsExactlyInAnyOrder(Arrays.asList(-1, 0, 0, 1),
                        Arrays.asList(-2, 0, 0, 2), Arrays.asList(-2, -1, 1, 2));

        assertThat(fourSum.fourSumWith2Sums(new int[]{-4,-3,-2, -1, 0, 0, 1, 2, 3, 4}, 0))
                .containsExactlyInAnyOrder(
                        Arrays.asList(-4,-3,3,4),
                        Arrays.asList(-4,-2,2,4),
                        Arrays.asList(-4,-1,1,4),
                        Arrays.asList(-4,-1,2,3),
                        Arrays.asList(-4,0,0,4),
                        Arrays.asList(-4,0,1,3),
                        Arrays.asList(-3,-2,1,4),
                        Arrays.asList(-3,-2,2,3),
                        Arrays.asList(-3,-1,0,4),
                        Arrays.asList(-3,-1,1,3),
                        Arrays.asList(-3,0,0,3),
                        Arrays.asList(-3,0,1,2),
                        Arrays.asList(-2,-1,0,3),
                        Arrays.asList(-2,-1,1,2),
                        Arrays.asList(-2,0,0,2),
                        Arrays.asList(-1,0,0,1)
                );
    }

    @Test
    public void test() {
        FourSum fourSum = new FourSum();
        assertThat(fourSum.fourSum(new int[]{1, 0}, 0)).isEmpty();
        assertThat(fourSum.fourSumWith2Sums(new int[]{1, 0, 0, 0, -1}, 2)).isEmpty();
        assertThat(fourSum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0))
                .containsExactlyInAnyOrder(Arrays.asList(-1, 0, 0, 1),
                Arrays.asList(-2, 0, 0, 2), Arrays.asList(-2, -1, 1, 2));
        assertThat(fourSum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0))
                .containsExactlyInAnyOrder(Arrays.asList(-1, 0, 0, 1),
                        Arrays.asList(-2, 0, 0, 2), Arrays.asList(-2, -1, 1, 2));

        assertThat(fourSum.fourSum(new int[]{-4,-3,-2, -1, 0, 0, 1, 2, 3, 4}, 0))
                .containsExactlyInAnyOrder(
                        Arrays.asList(-4,-3,3,4),
                        Arrays.asList(-4,-2,2,4),
                        Arrays.asList(-4,-1,1,4),
                        Arrays.asList(-4,-1,2,3),
                        Arrays.asList(-4,0,0,4),
                        Arrays.asList(-4,0,1,3),
                        Arrays.asList(-3,-2,1,4),
                        Arrays.asList(-3,-2,2,3),
                        Arrays.asList(-3,-1,0,4),
                        Arrays.asList(-3,-1,1,3),
                        Arrays.asList(-3,0,0,3),
                        Arrays.asList(-3,0,1,2),
                        Arrays.asList(-2,-1,0,3),
                        Arrays.asList(-2,-1,1,2),
                        Arrays.asList(-2,0,0,2),
                        Arrays.asList(-1,0,0,1)
                        );
    }
}
