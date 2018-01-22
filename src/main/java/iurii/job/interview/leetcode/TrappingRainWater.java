package iurii.job.interview.leetcode;

/**
 * 42. Trapping Rain Water https://leetcode.com/problems/trapping-rain-water/description/
 *
 * http://www.geeksforgeeks.org/trapping-rain-water/
 *
 * similar to {@link iurii.job.interview.amazon.TrappingRainWater}
 * similar to {@link ContainerWithMostWater}
 *
 * Time Complexity: O(n)
 * Auxiliary Space: O(1)
 *
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        int result = 0, maxLeft = 0, maxRight = 0, leftIndex = 0, rightIndex = height.length - 1;

        while (leftIndex < rightIndex) {
            if (height[leftIndex] < height[rightIndex]) {
                if (height[leftIndex] > maxLeft) {
                    maxLeft = height[leftIndex];
                } else {
                    result += maxLeft - height[leftIndex];
                }
                leftIndex++;
            } else {
                if (height[rightIndex] > maxRight) {
                    maxRight = height[rightIndex];
                } else {
                    result += maxRight - height[rightIndex];
                }
                rightIndex--;
            }
        }
        return result;
    }
}
