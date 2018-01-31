package iurii.job.interview.leetcode;

import java.util.Arrays;

/**
 * 238. Product of Array Except Self https://leetcode.com/problems/product-of-array-except-self/description/
 *
 * https://www.geeksforgeeks.org/a-product-array-puzzle/
 * https://www.geeksforgeeks.org/product-array-puzzle-set-2-o1-space/
 *
 * Time complexity: O(N)
 * Auxiliary space: O(N) to store the result
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] numbers = new int[nums.length];
        int curNumber = 1;
        for(int i = 0; i < nums.length; i++) {
            numbers[i] = curNumber;
            curNumber *= nums[i];
        }
        curNumber = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            numbers[i] *= curNumber;
            curNumber *= nums[i];
        }
        return numbers;
    }

    /**
     * Based on epsilon precision and Log properties. Covered zeros and negative values
     * Time complexity: O(N)
     * Auxiliary space: O(1) to store the precision, if there is zero, multiplication if zero exists,
     * negative count, sum of logs
     */
    public int[] productExceptSelfWithLog(int[] nums) {
        // epsilon value to maintain precision
        final double EPS = 1e-3;

        int zeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIndex = i;
            }
        }
        if (zeroIndex != -1) {
            int multiplied = 1;
            for (int i = 0; i < nums.length; i++) {
                if (i != zeroIndex) {
                    multiplied *= nums[i];
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (i != zeroIndex) {
                    nums[i] = 0;
                } else {
                    nums[i] = multiplied;
                }
            }
            return nums;
        }

        long negativeCount = Arrays.stream(nums).filter(num -> num < 0).count();
        double sum = 0;
        for(int number : nums){
            sum += Math.log10(Math.abs(number));
        }
        for(int i = 0; i < nums.length; i++) {
            int left = (int) (negativeCount % 2);
            if (nums[i] < 0 && left == 1 || nums[i] > 0 && left == 0) {
                nums[i] = (int) (EPS + Math.pow(10.00, sum - Math.log10(Math.abs(nums[i]))));
            } else {
                nums[i] = -(int) (EPS + Math.pow(10.00, sum - Math.log10(Math.abs(nums[i]))));
            }
        }
        return nums;
    }

}
