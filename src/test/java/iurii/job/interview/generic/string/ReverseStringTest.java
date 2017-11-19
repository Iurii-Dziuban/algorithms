package iurii.job.interview.generic.string;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Easiest way to reverse a string is to use StringBuilder
 * <p>
 * https://stackoverflow.com/questions/7569335/reverse-a-string-in-java
 */
public class ReverseStringTest {

    @Test
    public void test() {
        assertThat(new StringBuilder("hello jackie").reverse().toString()).isEqualToIgnoringCase("eikcaj olleh");
    }
}
