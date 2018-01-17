package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReverseIntegerTest {

    @Test
    public void test() {
        assertThat(new ReverseInteger().reverse(Integer.MIN_VALUE)).isEqualTo(0);
        assertThat(new ReverseInteger().reverse(Integer.MAX_VALUE)).isEqualTo(0);
        assertThat(new ReverseInteger().reverse(0)).isEqualTo(0);
        assertThat(new ReverseInteger().reverse(12345)).isEqualTo(54321);
    }
}
