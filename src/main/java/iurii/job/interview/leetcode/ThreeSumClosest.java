package iurii.job.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 16. 3Sum Closest https://leetcode.com/problems/3sum-closest/description/
 * <p>
 * https://www.geeksforgeeks.org/find-triplets-array-whose-sum-equal-zero/
 * and more general
 * https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
 * <p>
 * Modification of {@link ThreeSum}
 * Idea is similar to {@link TwoSum}
 * <p>
 * Time complexity : O(N^2)
 * Auxiliary space complexity : O(1) using sorted array
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int sum = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int low = i + 1;
            int high = nums.length - 1;
            int twoTarget = target - nums[i];
            while (low < high) {
                int threeSum = nums[i] + nums[low] + nums[high];
                if (nums[low] + nums[high] == twoTarget) {
                    return threeSum;
                } else if (twoTarget > nums[low] + nums[high]) {
                    if (Math.abs(sum - target) > Math.abs(twoTarget - nums[low] - nums[high])) {
                        sum = threeSum;
                    }
                    low++;
                    while (low < high && nums[low-1] == nums[low]) {low++;}
                } else {
                    if (Math.abs(sum - target) > Math.abs(twoTarget - nums[low] - nums[high])) {
                        sum = threeSum;
                    }
                    high--;
                    while (low < high && nums[high + 1] == nums[high]) {high--;}
                }
            }
        }
        return sum;
    }
}
