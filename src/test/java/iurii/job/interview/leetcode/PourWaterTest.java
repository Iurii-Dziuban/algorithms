package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PourWaterTest {

    @Test
    public void test() {
        PourWater pourWater = new PourWater();
        assertThat(pourWater.pourWater(new int[]{2, 1, 1, 2, 1, 2, 2}, 4,3)).containsExactly(2,2,2,3,2,2,2);
        assertThat(pourWater.pourWater(new int[]{3, 1, 3}, 5,1)).containsExactly(4,4,4);
    }
}
