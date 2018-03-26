package iurii.job.interview.facebook;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LeastDisruptiveSubrangeTest {

    @Test
    public void test() {
        LeastDisruptiveSubrange leastDisruptiveSubrange = new LeastDisruptiveSubrange();
        assertThat(leastDisruptiveSubrange.findLeastDisruptiveSubrangeIndex(
                new int[]{1,2,3,4,5}, new int[]{3,5,3})).isEqualTo(2);
        assertThat(leastDisruptiveSubrange.findLeastDisruptiveSubrangeIndex(
                new int[]{1,2,3}, new int[]{3,5,3})).isEqualTo(0);
        assertThat(leastDisruptiveSubrange.findLeastDisruptiveSubrangeIndex(
                new int[]{1,2}, new int[]{3,5,3})).isEqualTo(-1);
    }
}
