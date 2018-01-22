package iurii.job.interview.leetcode;

/**
 * 11. Container With Most Water https://leetcode.com/problems/container-with-most-water/description/
 *
 * https://www.geeksforgeeks.org/container-with-most-water/
 *
 * https://leetcode.com/articles/container-most-water/
 *
 * similar to {@link iurii.job.interview.amazon.TrappingRainWater}
 * similar to {@link TrappingRainWater}
 * but there was a landscape and here are the bars and container is done with left-right borders and 0
 *
 * Time Complexity: O(n) - go through each bar once
 * Auxiliary Space: O(1) - two pointers for current left-right, two pointers for current highest left and right and maxArea
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int lo = 0;
        int hi = height.length - 1;
        int max = 0;
        while (lo < hi) {
            max = Math.max(Math.min(height[hi], height[lo]) * (hi - lo) , max);
            if (height[lo] >= height[hi]) {
                hi--;
            } else {
                lo++;
            }
        }
        return max;
    }
}
