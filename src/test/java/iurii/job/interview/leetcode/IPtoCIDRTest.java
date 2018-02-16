package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IPtoCIDRTest {

    @Test
    public void test() {
        IPtoCIDR iPtoCIDR = new IPtoCIDR();

        assertThat(iPtoCIDR.ipToCIDR("255.0.0.7", 10))
                .containsExactly("255.0.0.7/32","255.0.0.8/29","255.0.0.16/32");
    }
}
