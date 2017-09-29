package iurii.job.interview.codility;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MissingIntegerTest {

    @Test
    public void test() {
        MissingInteger missingInteger = new MissingInteger();
        assertThat(missingInteger.solution(new int[]{1, 3, 6, 4, 1, 2})).isEqualTo(5);
        assertThat(missingInteger.solution(new int[]{1, 3, 2})).isEqualTo(4);
        assertThat(missingInteger.solution(new int[]{-1, -3})).isEqualTo(1);
        assertThat(missingInteger.solution(new int[]{-1, -3, 100001})).isEqualTo(1);
    }

}
