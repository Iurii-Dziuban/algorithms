package iurii.job.interview.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Best approach is to remember in map previous numbers or the supplement and check if the needed already exists
 *
 * Similar to {@link iurii.job.interview.google.TwoPairParticularSum}
 * Similar to  {@link iurii.job.interview.google.FirstRecurringCharacter}
 *
 * HashMap is used to store index as well. HashSet is not enough
 * For parallel solution ConcurrentHashMap can be used.
 *
 * Time complexity: O(N) each element is checked once and Map look up O(1)
 * Auxiliary space complexity: O(N) to store a map
 */
public class TwoSum {

    // ! assuming there is no overflow on target - nums[i]
    public int[] twoSumSaveValueIndex(int[] nums, int target) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            if (valueToIndex.containsKey(target - nums[i])) {
                return new int[] {valueToIndex.get(target - nums[i]), i};
            } else {
                valueToIndex.put(nums[i], i);
            }
        }
        return null;
    }

    // ! assuming there is no overflow on target - nums[i]
    public int[] twoSumSaveSupplementWithValueIndex(int[] nums, int target) {
        Map<Integer, Integer> supplementToValueIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            if (supplementToValueIndex.containsKey(nums[i])) {
                return new int[] {supplementToValueIndex.get(nums[i]), i};
            } else {
                supplementToValueIndex.put(target - nums[i], i);
            }
        }
        return null;
    }

    /**
     * Solution with sorting :
     * Time complexity: O(N log(N)) slower, because of the sorting
     * Auxiliary space complexity: O(1). No auxiliary space needed for the map
     *
     * Note! returns numbers itself, not indexes. Sorting solution does not work for indexes, cause they change
     */
    public int[] twoSumWithSoring(int[] nums, int target) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            if (nums[low] + nums[high] == target) {
                return new int[]{nums[low], nums[high]};
            }
            if (nums[low] + nums[high] < target) {
                low++;
            } else {
                high--;
            }
        }
        return null;
    }

}
