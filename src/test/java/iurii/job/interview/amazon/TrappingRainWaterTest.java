package iurii.job.interview.amazon;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 06/11/2017.
 */
public class TrappingRainWaterTest {

    @Test(expected = IllegalArgumentException.class)
    public void testException() {
        new TrappingRainWater().findWater(null);
    }

    @Test
    public void test() {
        assertThat(new TrappingRainWater().findWater(new int[]{4, 1, 1, 0, 2, 3 })).isEqualByComparingTo(8L);
        assertThat(new TrappingRainWater().findWater(new int[]{2_147_483_647, -2_147_483_648, 2_147_483_647}))
                .isEqualByComparingTo(4294967295L);
        assertThat(new TrappingRainWater().findWater(new int[]{0, 3, -1, 1, 3, 0})).isEqualByComparingTo(6L);
        assertThat(new TrappingRainWater().findWater(new int[]{0, 3, 4, 4, 3, 0})).isEqualByComparingTo(0L);
    }
}
