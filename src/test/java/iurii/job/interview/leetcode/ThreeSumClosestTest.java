package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ThreeSumClosestTest {

    @Test
    public void test() {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        assertThat(threeSumClosest.threeSumClosest(new int[]{2, 0, 4, 0, 5, 3, 7, 8}, 1)).isEqualTo(2);
        assertThat(threeSumClosest.threeSumClosest(new int[]{2, 0, 4, 0, 5, 3, 7, 8}, 2)).isEqualTo(2);
        assertThat(threeSumClosest.threeSumClosest(new int[]{2, 0, 4, 0, 5, 3, 7, 8}, 40)).isEqualTo(20);
        assertThat(threeSumClosest.threeSumClosest(new int[]{2, 0, 3, 0, 5, 8}, 6)).isEqualTo(5);
        assertThat(threeSumClosest.threeSumClosest(new int[]{-2, 0, -3, 0, -5, -8}, -6)).isEqualTo(-5);
    }
}
