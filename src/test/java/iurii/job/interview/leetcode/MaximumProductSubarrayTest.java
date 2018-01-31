package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaximumProductSubarrayTest {
    @Test
    public void testMyMaxProduct() {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        assertThat(maximumProductSubarray.myMaxProduct(new int[]{})).isEqualTo(0);
        assertThat(maximumProductSubarray.myMaxProduct(null)).isEqualTo(0);
        assertThat(maximumProductSubarray.myMaxProduct(new int[]{2,3,-2,4})).isEqualTo(6);
        assertThat(maximumProductSubarray.myMaxProduct(new int[]{2,1,-2,4,-1})).isEqualTo(16);
        assertThat(maximumProductSubarray.myMaxProduct(new int[]{2,1,0,4,-1})).isEqualTo(4);
        assertThat(maximumProductSubarray.myMaxProduct(new int[]{2,1,0,4,-1,-2})).isEqualTo(8);
        assertThat(maximumProductSubarray.myMaxProduct(new int[]{0,-16,0})).isEqualTo(0);
        assertThat(maximumProductSubarray.myMaxProduct(new int[]{-5})).isEqualTo(-5);
        assertThat(maximumProductSubarray.myMaxProduct(new int[]{2,-5,-2,-4,3})).isEqualTo(24);
        assertThat(maximumProductSubarray.myMaxProduct(new int[]{1,0,-1,2,3,-5,-2})).isEqualTo(60);
    }

    @Test
    public void testMaxProduct() {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        assertThat(maximumProductSubarray.maxProduct(new int[]{})).isEqualTo(0);
        assertThat(maximumProductSubarray.maxProduct(null)).isEqualTo(0);
        assertThat(maximumProductSubarray.maxProduct(new int[]{2,3,-2,4})).isEqualTo(6);
        assertThat(maximumProductSubarray.maxProduct(new int[]{2,1,-2,4,-1})).isEqualTo(16);
        assertThat(maximumProductSubarray.maxProduct(new int[]{2,1,0,4,-1})).isEqualTo(4);
        assertThat(maximumProductSubarray.maxProduct(new int[]{2,1,0,4,-1,-2})).isEqualTo(8);
        assertThat(maximumProductSubarray.maxProduct(new int[]{0,-16,0})).isEqualTo(0);
        assertThat(maximumProductSubarray.maxProduct(new int[]{-5})).isEqualTo(-5);
        assertThat(maximumProductSubarray.maxProduct(new int[]{2,-5,-2,-4,3})).isEqualTo(24);
        assertThat(maximumProductSubarray.maxProduct(new int[]{1,0,-1,2,3,-5,-2})).isEqualTo(60);
    }

    @Test
    public void testMaxProductDynamic() {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        assertThat(maximumProductSubarray.maxProductDynamic(new int[]{})).isEqualTo(0);
        assertThat(maximumProductSubarray.maxProductDynamic(null)).isEqualTo(0);
        assertThat(maximumProductSubarray.maxProductDynamic(new int[]{2,3,-2,4})).isEqualTo(6);
        assertThat(maximumProductSubarray.maxProductDynamic(new int[]{2,1,-2,4,-1})).isEqualTo(16);
        assertThat(maximumProductSubarray.maxProductDynamic(new int[]{2,1,0,4,-1})).isEqualTo(4);
        assertThat(maximumProductSubarray.maxProductDynamic(new int[]{2,1,0,4,-1,-2})).isEqualTo(8);
        assertThat(maximumProductSubarray.maxProductDynamic(new int[]{0,-16,0})).isEqualTo(0);
        assertThat(maximumProductSubarray.maxProductDynamic(new int[]{-5})).isEqualTo(-5);
        assertThat(maximumProductSubarray.maxProductDynamic(new int[]{2,-5,-2,-4,3})).isEqualTo(24);
        assertThat(maximumProductSubarray.maxProductDynamic(new int[]{1,0,-1,2,3,-5,-2})).isEqualTo(60);
    }
}
