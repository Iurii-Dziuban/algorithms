package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveInvalidParenthesesTest {

    @Test
    public void test() {
        RemoveInvalidParentheses removeInvalidParentheses = new RemoveInvalidParentheses();
        assertThat(removeInvalidParentheses.removeInvalidParentheses("()())()"))
                .containsExactlyInAnyOrder("()()()","(())()");
        assertThat(removeInvalidParentheses.removeInvalidParentheses("(a)())()"))
                .containsExactlyInAnyOrder("(a)()()","(a())()");
        assertThat(removeInvalidParentheses.removeInvalidParentheses(")(")).containsExactlyInAnyOrder("");
        assertThat(removeInvalidParentheses.removeInvalidParentheses("x(")).containsExactlyInAnyOrder("x");
    }
}
