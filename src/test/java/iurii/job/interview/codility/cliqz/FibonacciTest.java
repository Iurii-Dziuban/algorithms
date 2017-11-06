package iurii.job.interview.codility.cliqz;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IuriiDziuban on 10/29/17.
 */
public class FibonacciTest {

    @Test
    public void test() {
        Fibonacci fibonacci = new Fibonacci();
        assertThat(fibonacci.fibonacciLeast6Digits(8)).isEqualTo(21);
        assertThat(fibonacci.fibonacciLeast6Digits(36)).isEqualTo(930352);
        assertThat(fibonacci.fibonacciLeast6Digits(2147483647)).isEqualTo(282973);
    }
}
