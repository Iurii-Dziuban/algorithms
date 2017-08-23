package iurii.job.interview.codility;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 23/08/2017.
 */
public class BinaryGapTest {

    @Test
    public void test() {
        BinaryGap binaryGap = new BinaryGap();
        assertThat(binaryGap.findMaxGap(1041)).isEqualTo(5);
        assertThat(binaryGap.findMaxGap(15)).isEqualTo(0);
        assertThat(binaryGap.findMaxGap(10)).isEqualTo(1);
    }
}
