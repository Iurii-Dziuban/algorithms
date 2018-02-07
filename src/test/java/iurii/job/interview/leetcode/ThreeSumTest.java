package iurii.job.interview.leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ThreeSumTest {

    @Test
    public void test() {
        ThreeSum threeSum = new ThreeSum();
        assertThat(threeSum.threeSum(new int[]{-1, 0,1,2,-1,-4}))
                .containsExactly(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1));
        assertThat(threeSum.threeSum(new int[]{-1, 0, 4, 1, 2, -1,-4}))
                .containsExactly(Arrays.asList(-4, 0, 4), Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1));
        assertThat(threeSum.threeSum(new int[]{-1, 0, -1, -4})).isEmpty();
    }
}
