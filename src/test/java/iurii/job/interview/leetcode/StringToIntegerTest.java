package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringToIntegerTest {
    @Test
    public void test() {
        assertThat(new StringToInteger().myAtoi(null)).isEqualTo(0);
        assertThat(new StringToInteger().myAtoi("")).isEqualTo(0);
        assertThat(new StringToInteger().myAtoi("   ")).isEqualTo(0);
        assertThat(new StringToInteger().myAtoi("   +490")).isEqualTo(490);
        assertThat(new StringToInteger().myAtoi("   -531")).isEqualTo(-531);
        assertThat(new StringToInteger().myAtoi("   21")).isEqualTo(21);
        assertThat(new StringToInteger().myAtoi("" + Integer.MAX_VALUE)).isEqualTo(Integer.MAX_VALUE);
        assertThat(new StringToInteger().myAtoi("" + Integer.MIN_VALUE)).isEqualTo(Integer.MIN_VALUE);
    }
}
