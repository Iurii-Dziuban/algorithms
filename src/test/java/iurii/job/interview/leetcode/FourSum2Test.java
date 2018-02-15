package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FourSum2Test {

    @Test
    public void testWith2Sums() {
        int[] A = new int[]{1,2};
        int[] B = new int[]{-2,-1};
        int[] C = new int[]{-1,2};
        int[] D = new int[]{0,2};
        int[] D5 = new int[]{0,2,0};
        int[] empty = new int[]{};
        FourSum2 fourSum2 = new FourSum2();
        assertThat(fourSum2.fourSumCountWith2Sums(A, B, C, D)).isEqualTo(2);
        assertThat(fourSum2.fourSumCountWith2Sums(empty, B, C, D)).isEqualTo(0);
        assertThat(fourSum2.fourSumCountWith2Sums(A, empty, C, D)).isEqualTo(0);
        assertThat(fourSum2.fourSumCountWith2Sums(A, B, empty, D)).isEqualTo(0);
        assertThat(fourSum2.fourSumCountWith2Sums(A, B, C, empty)).isEqualTo(0);
        assertThat(fourSum2.fourSumCountWith2Sums(A, B, C, D5)).isEqualTo(3);
        int[] A1 = new int[]{-1,-1};
        int[] B1 = new int[]{-1,1};
        int[] C1 = new int[]{-1,1};
        int[] D1 = new int[]{-1,1};
        assertThat(fourSum2.fourSumCountWith2Sums(A1, B1, C1, D1)).isEqualTo(6);
        int[] A2 = new int[]{-1, 0, 1};
        int[] B2 = new int[]{-1, 0, 1};
        int[] C2 = new int[]{0, 0, 1};
        int[] D2 = new int[]{-1, 1, 1};
        assertThat(fourSum2.fourSumCountWith2Sums(A2, B2, C2, D2)).isEqualTo(17);
    }

    @Test
    public void testWithSorting() {
        int[] A = new int[]{1,2};
        int[] B = new int[]{-2,-1};
        int[] C = new int[]{-1,2};
        int[] D = new int[]{0,2};
        int[] D5 = new int[]{0,2,0};
        int[] empty = new int[]{};
        FourSum2 fourSum2 = new FourSum2();
        assertThat(fourSum2.fourSumCountForLoop(A, B, C, D)).isEqualTo(2);
        assertThat(fourSum2.fourSumCountForLoop(empty, B, C, D)).isEqualTo(0);
        assertThat(fourSum2.fourSumCountForLoop(A, empty, C, D)).isEqualTo(0);
        assertThat(fourSum2.fourSumCountForLoop(A, B, empty, D)).isEqualTo(0);
        assertThat(fourSum2.fourSumCountForLoop(A, B, C, empty)).isEqualTo(0);
        assertThat(fourSum2.fourSumCountForLoop(A, B, C, D5)).isEqualTo(3);
        int[] A1 = new int[]{-1,-1};
        int[] B1 = new int[]{-1,1};
        int[] C1 = new int[]{-1,1};
        int[] D1 = new int[]{-1,1};
        assertThat(fourSum2.fourSumCountForLoop(A1, B1, C1, D1)).isEqualTo(6);
        int[] A2 = new int[]{-1, 0, 1};
        int[] B2 = new int[]{-1, 0, 1};
        int[] C2 = new int[]{0, 0, 1};
        int[] D2 = new int[]{-1, 1, 1};
        assertThat(fourSum2.fourSumCountForLoop(A2, B2, C2, D2)).isEqualTo(17);
    }

    @Test
    public void testFourSumCountEfficient() {
        int[] A = new int[]{1,2};
        int[] B = new int[]{-2,-1};
        int[] C = new int[]{-1,2};
        int[] D = new int[]{0,2};
        int[] D5 = new int[]{0,2,0};
        int[] empty = new int[]{};
        FourSum2 fourSum2 = new FourSum2();
        assertThat(fourSum2.fourSumCountEfficient(A, B, C, D)).isEqualTo(2);
        assertThat(fourSum2.fourSumCountEfficient(empty, B, C, D)).isEqualTo(0);
        assertThat(fourSum2.fourSumCountEfficient(A, empty, C, D)).isEqualTo(0);
        assertThat(fourSum2.fourSumCountEfficient(A, B, empty, D)).isEqualTo(0);
        assertThat(fourSum2.fourSumCountEfficient(A, B, C, empty)).isEqualTo(0);
        assertThat(fourSum2.fourSumCountEfficient(A, B, C, D5)).isEqualTo(3);
        int[] A1 = new int[]{-1,-1};
        int[] B1 = new int[]{-1,1};
        int[] C1 = new int[]{-1,1};
        int[] D1 = new int[]{-1,1};
        assertThat(fourSum2.fourSumCountEfficient(A1, B1, C1, D1)).isEqualTo(6);
        int[] A2 = new int[]{-1, 0, 1};
        int[] B2 = new int[]{-1, 0, 1};
        int[] C2 = new int[]{0, 0, 1};
        int[] D2 = new int[]{-1, 1, 1};
        assertThat(fourSum2.fourSumCountEfficient(A2, B2, C2, D2)).isEqualTo(17);
    }
}
