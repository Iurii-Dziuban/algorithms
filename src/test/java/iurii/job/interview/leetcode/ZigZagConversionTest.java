package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ZigZagConversionTest {

    @Test
    public void test() {
        assertThat(new ZigZagConversion().convert("PAYPALISHIRING", 3)).isEqualTo("PAHNAPLSIIGYIR");
        assertThat(new ZigZagConversion().convert("PAYPALISHIRING", 1)).isEqualTo("PAYPALISHIRING");
    }
}
