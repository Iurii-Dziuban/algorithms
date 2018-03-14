package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestValidParenthesesTest {
    @Test
    public void test() {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        assertThat(longestValidParentheses.longestValidParentheses(")()())")).isEqualTo(4);
        assertThat(longestValidParentheses.longestValidParentheses("()")).isEqualTo(2);
        assertThat(longestValidParentheses.longestValidParentheses(")))(((")).isEqualTo(0);
    }
}
