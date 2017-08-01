package iurii.job.interview.multiplication;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 01/08/2017.
 */
public class MultiplyNumbersTest {

    @Test
    public void test() {
        assertThat(new MultiplyNumbers().multiply(1234, 5678)).isEqualTo(7006652);
        System.out.println(1234 * 5678);
    }
}
