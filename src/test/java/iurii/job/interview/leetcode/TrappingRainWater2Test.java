package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TrappingRainWater2Test {

    @Test
    public void test() {
        TrappingRainWater2 trappingRainWater2 = new TrappingRainWater2();
        assertThat(trappingRainWater2.trapRainWater(null)).isEqualTo(0);
        assertThat(trappingRainWater2.trapRainWater(new int[][]{})).isEqualTo(0);
        assertThat(trappingRainWater2.trapRainWater(new int[][]{{}})).isEqualTo(0);
        assertThat(trappingRainWater2.trapRainWater(new int[][]{{1, 2, 3}})).isEqualTo(0);
        assertThat(trappingRainWater2.trapRainWater(new int[][]{{1}, {2}, {3}})).isEqualTo(0);
        assertThat(trappingRainWater2.trapRainWater(new int[][]{{1,2},
                                                                {2,3}})).isEqualTo(0);
        assertThat(trappingRainWater2.trapRainWater(new int[][]{{2,2,2},
                                                                {2,1,2},
                                                                {2,2,2}})).isEqualTo(1);
        assertThat(trappingRainWater2.trapRainWater(new int[][]{{1, 4, 3, 1, 3, 2},
                                                                {3, 2, 1, 3, 2, 4},
                                                                {2, 3, 3, 2, 3, 1}})).isEqualTo(4);
    }
}
