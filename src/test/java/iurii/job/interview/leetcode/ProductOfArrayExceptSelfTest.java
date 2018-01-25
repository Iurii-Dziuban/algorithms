package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductOfArrayExceptSelfTest {

    @Test
    public void test() {
        ProductOfArrayExceptSelf product = new ProductOfArrayExceptSelf();
        assertThat(product.productExceptSelf(new int[]{1, 0, 1})).containsExactly(0, 1, 0);
        assertThat(product.productExceptSelf(new int[]{3, 4, 2})).containsExactly(8, 6, 12);
        assertThat(product.productExceptSelf(new int[]{-3, 4, -2})).containsExactly(-8, 6, -12);
        assertThat(product.productExceptSelf(new int[]{-3, 4, 2})).containsExactly(8, -6, -12);
        assertThat(product.productExceptSelf(new int[]{-3, 0, -2})).containsExactly(0, 6, 0);
    }

    @Test
    public void testWithLogs() {
        ProductOfArrayExceptSelf product = new ProductOfArrayExceptSelf();
        assertThat(product.productExceptSelfWithLog(new int[]{1, 0, 1})).containsExactly(0, 1, 0);
        assertThat(product.productExceptSelfWithLog(new int[]{3, 4, 2})).containsExactly(8, 6, 12);
        assertThat(product.productExceptSelfWithLog(new int[]{-3, 4, -2})).containsExactly(-8, 6, -12);
        assertThat(product.productExceptSelfWithLog(new int[]{-3, 4, 2})).containsExactly(8, -6, -12);
        assertThat(product.productExceptSelfWithLog(new int[]{-3, 0, -2})).containsExactly(0, 6, 0);
    }
}
