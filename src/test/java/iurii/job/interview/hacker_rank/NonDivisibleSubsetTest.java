package iurii.job.interview.hacker_rank;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NonDivisibleSubsetTest {

    @Test
    public void test() {
        NonDivisibleSubset subset = new NonDivisibleSubset();
        assertThat(subset.nonDivisibleSubset(3, new int[]{1,7,2,4})).isEqualTo(3);
    }

    @Test
    public void testWithStream() {
        NonDivisibleSubset subset = new NonDivisibleSubset();
        assertThat(subset.nonDivisibleSubsetWithStreams(3, new int[]{1,7,2,4})).isEqualTo(3);
    }
}
