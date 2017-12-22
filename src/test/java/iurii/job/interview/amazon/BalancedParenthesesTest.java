package iurii.job.interview.amazon;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 02/06/2017.
 */
public class BalancedParenthesesTest {

    private BalancedParentheses balancedParentheses = new BalancedParentheses();

    @Test
    public void testBalanced() {
        assertThat(balancedParentheses.areParenthesesBalanced("{([a],b)}")).isTrue();
    }

    @Test
    public void testNotBalanced() {
        assertThat(balancedParentheses.areParenthesesBalanced("{(a},b)")).isFalse();
        assertThat(balancedParentheses.areParenthesesBalanced("{)(a,b}")).isFalse();
        assertThat(balancedParentheses.areParenthesesBalanced(")(a,b)")).isFalse();
    }
}
