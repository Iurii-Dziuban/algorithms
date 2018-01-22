package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContainerWithMostWaterTest {

    @Test
    public void test() {
        assertThat(new ContainerWithMostWater().maxArea(new int[]{2,2,2})).isEqualTo(4);
        assertThat(new ContainerWithMostWater().maxArea(new int[]{1,2,4,3})).isEqualTo(4);
        assertThat(new ContainerWithMostWater().maxArea(new int[]{1,0,4,1})).isEqualTo(3);
        assertThat(new ContainerWithMostWater().maxArea(new int[]{1,4,4,1})).isEqualTo(4);
        assertThat(new ContainerWithMostWater().maxArea(new int[]{1,2})).isEqualTo(1);
    }
}
