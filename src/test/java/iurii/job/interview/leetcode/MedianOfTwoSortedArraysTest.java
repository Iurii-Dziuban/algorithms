package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MedianOfTwoSortedArraysTest {

    @Test
    public void test() {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();

        assertThat(medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{}, new int[]{})).isEqualTo(-1);
        assertThat(medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{}, new int[]{3})).isEqualTo(3);
        assertThat(medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{2}, new int[]{})).isEqualTo(2);
        assertThat(medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1}, new int[]{2})).isEqualTo(1.5);
        assertThat(medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1}, new int[]{2,3,4})).isEqualTo(2.5);
        assertThat(medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{2,3}, new int[]{})).isEqualTo(2.5);
        assertThat(medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1,3}, new int[]{2})).isEqualTo(2);
        assertThat(medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4})).isEqualTo(2.5);
        assertThat(medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4,5,6})).isEqualTo(3.5);
        assertThat(medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1,2,3,4}, new int[]{5,6,7,8})).isEqualTo(4.5);
        assertThat(medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1,2,3,4}, new int[]{5,6,7})).isEqualTo(4);
    }
}
