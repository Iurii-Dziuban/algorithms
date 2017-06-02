package iurii.job.interview.amazon;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 02/06/2017.
 */
public class BalancedParenthensiesTest {

    private BalancedParenthensies balancedParenthensies = new BalancedParenthensies();

    @Test
    public void testBalanced() {
        assertThat(balancedParenthensies.areParenthensiesBalanced("{(a,b)}")).isTrue();
    }

    @Test
    public void testNotBalanced() {
        assertThat(balancedParenthensies.areParenthensiesBalanced("{(a},b)")).isFalse();
        assertThat(balancedParenthensies.areParenthensiesBalanced("{)(a,b}")).isFalse();
    }
}
