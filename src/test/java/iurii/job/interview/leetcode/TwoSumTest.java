package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoSumTest {

    private final TwoSum twoSum = new TwoSum();
    private final int[] nums = new int[]{2, 7, 11, 15};
    @Test
    public void testExists() {
        int target =  9;
        assertThat(twoSum.twoSumSaveValueIndex(nums, target)).containsExactly(0,1);
        assertThat(twoSum.twoSumSaveSupplementWithValueIndex(nums, target)).containsExactly(0,1);
        assertThat(twoSum.twoSumWithSoring(nums, target)).containsExactly(2,7);
    }

    @Test
    public void testNotExists() {
        int target =  8;
        assertThat(twoSum.twoSumSaveValueIndex(nums, target)).isNull();
        assertThat(twoSum.twoSumSaveSupplementWithValueIndex(nums, target)).isNull();
        assertThat(twoSum.twoSumWithSoring(nums, target)).isNull();
    }
}
