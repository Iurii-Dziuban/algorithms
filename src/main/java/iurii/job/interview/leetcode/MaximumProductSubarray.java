package iurii.job.interview.leetcode;

/**
 * 152. Maximum Product Subarray  https://leetcode.com/problems/maximum-product-subarray/description/
 *
 * https://www.geeksforgeeks.org/maximum-product-subarray/
 *
 * Idea is similar to {@link MaximumSubarray}
 * Time complexity: O(N)
 * Auxiliary space complexity: O(N) for dynamic programming and O(1) for holding min/max values only
 */
public class MaximumProductSubarray {

    /**
     * My solution
     */
    public int myMaxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int curNeg = -1, curPos = 1, result = nums[0];
        boolean isNegativeNow = false;
        boolean isNegativeSpotted = false;
        for (int num : nums) {
            int nextMax = 0, nextMin = 0;
            if (num == 0) {
                result = Math.max(result, num);
                isNegativeNow = false;
                isNegativeSpotted = false;
            } else {
                isNegativeNow ^= num < 0;
                if (num > 0) {
                    nextMin = curNeg * num;
                    nextMax = curPos * num;
                } else {
                    if (isNegativeNow) {
                        nextMin = curPos * num;
                        if (isNegativeSpotted) {
                            nextMax = curNeg * num;
                        }
                    } else {
                        nextMax = curNeg * num;
                        nextMin = curPos * num;
                    }
                    isNegativeSpotted = true;
                }
            }
            if (nextMax == 0) {
                result = Math.max(num, result);
            } else {
                result = Math.max(nextMax, result);
            }
            curNeg = Math.min(nextMin, -1);
            curPos = Math.max(nextMax, 1);
        }
        return result;
    }

    /**
     * Min/max solution
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = nums[0], iMax = res, iMin = res;

        for(int i=1; i<nums.length; i++) {
            if(nums[i] < 0) {
                int tmp = iMax;
                iMax = iMin;
                iMin = tmp;
            }
            iMax = Math.max(nums[i], iMax * nums[i]);
            iMin = Math.min(nums[i], iMin * nums[i]);
            res = Math.max(res, iMax);
        }
        return res;
    }


    /**
     * Dynamic programming solution
     */
    public int maxProductDynamic(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        for (int i = 1; i < max.length; i++) {
            max[i] = Math.max(nums[i], Math.max(max[i-1] * nums[i], min[i-1] * nums[i]));
            min[i] = Math.min(nums[i], Math.min(max[i-1] * nums[i], min[i-1] * nums[i]));
        }
        int res = max[0];
        for (int aMax : max) {
            res = Math.max(res, aMax);
        }
        return res;

    }
}
