package iurii.job.interview.hacker_rank;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RepeatedStringTest {

    @Test
    public void test() {
        RepeatedString repeatedString = new RepeatedString();
        assertThat(repeatedString.repeatedString("a", 1000000000000L)).isEqualTo(1000000000000L);
        assertThat(repeatedString.repeatedString("aba", 10L)).isEqualTo(7L);
    }
}
