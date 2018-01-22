package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TrappingRainWaterTest {

    @Test
    public void test() {
        assertThat(new TrappingRainWater().trap(new int[]{4, 1, 1, 0, 2, 3 })).isEqualByComparingTo(8);
        assertThat(new TrappingRainWater().trap(new int[]{0, 3, -1, 1, 3, 0})).isEqualByComparingTo(6);
        assertThat(new TrappingRainWater().trap(new int[]{0, 3, 4, 4, 3, 0})).isEqualByComparingTo(0);
    }
}
