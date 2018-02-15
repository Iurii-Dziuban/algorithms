package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SqrtTest {

    @Test
    public void testLibrary() {
        Sqrt sqrt = new Sqrt();
        assertThat(sqrt.mySqrtLibrary(9)).isEqualTo(3);
        assertThat(sqrt.mySqrtLibrary(8)).isEqualTo(2);
        assertThat(sqrt.mySqrtLibrary(4)).isEqualTo(2);
    }

    @Test
    public void testBinarySearch() {
        Sqrt sqrt = new Sqrt();
        assertThat(sqrt.mySqrt(9)).isEqualTo(3);
        assertThat(sqrt.mySqrt(8)).isEqualTo(2);
        assertThat(sqrt.mySqrt(4)).isEqualTo(2);
    }
}
