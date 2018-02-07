package iurii.job.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum https://leetcode.com/problems/3sum/description/
 * <p>
 * https://www.geeksforgeeks.org/find-triplets-array-whose-sum-equal-zero/
 * and more general
 * https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
 * <p>
 * Idea is similar to {@link TwoSum}
 * <p>
 * Time complexity : O(N^2)
 * Auxiliary space complexity : O(1) using sorted array
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            int target = -nums[i];
            int low = i + 1;
            int high = nums.length - 1;
            // skipping duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (low < high) {
                if (nums[low] + nums[high] == target) {
                    List<Integer> result = Arrays.asList(nums[i], nums[low], nums[high]);
                    results.add(result);
                    int lowValue = nums[low];
                    int highValue = nums[high];
                    // skipping duplicates
                    while (low < high && nums[++low] == lowValue);
                    while (low < high && nums[--high] == highValue);
                } else {
                    if (nums[low] + nums[high] > target) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return results;
    }
}
