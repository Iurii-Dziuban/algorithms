package iurii.job.interview.amazon;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 02/06/2017.
 */
public class BalancedParenthensiesTest {

    private BalancedParentheses balancedParenthensies = new BalancedParentheses();

    @Test
    public void testBalanced() {
        assertThat(balancedParenthensies.areParenthesesBalanced("{(a,b)}")).isTrue();
    }

    @Test
    public void testNotBalanced() {
        assertThat(balancedParenthensies.areParenthesesBalanced("{(a},b)")).isFalse();
        assertThat(balancedParenthensies.areParenthesesBalanced("{)(a,b}")).isFalse();
        assertThat(balancedParenthensies.areParenthesesBalanced(")(a,b)")).isFalse();
    }
}
