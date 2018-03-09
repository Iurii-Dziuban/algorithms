package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GenerateParenthesesTest {

    @Test
    public void testWithClosureNumber() {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        assertThat(generateParentheses.generateParenthesisClosureNumber(2))
                .containsExactlyInAnyOrder("()()", "(())");
        assertThat(generateParentheses.generateParenthesisClosureNumber(3))
                .containsExactlyInAnyOrder("()()()", "()(())", "((()))", "(()())", "(())()");
    }

    @Test
    public void testWithBacktracking() {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        assertThat(generateParentheses.generateParenthesisBacktracking(2))
                .containsExactlyInAnyOrder("()()", "(())");
        assertThat(generateParentheses.generateParenthesisBacktracking(3))
                .containsExactlyInAnyOrder("()()()", "()(())", "((()))", "(()())", "(())()");
    }

    @Test
    public void testCatalanAndWays() {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        assertThat(generateParentheses.catalan(2)).isEqualTo(2);
        assertThat(generateParentheses.catalan(3)).isEqualTo(5);
        assertThat(generateParentheses.catalan(4)).isEqualTo(14);

        assertThat(generateParentheses.findWays(2)).isEqualTo(1);
        assertThat(generateParentheses.findWays(3)).isEqualTo(0);
        assertThat(generateParentheses.findWays(4)).isEqualTo(2);
        assertThat(generateParentheses.findWays(6)).isEqualTo(5);
    }
}