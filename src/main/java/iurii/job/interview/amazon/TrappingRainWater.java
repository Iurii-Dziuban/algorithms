package iurii.job.interview.amazon;

/**
 * Amazon, Google and CRX Markets
 *
 * similar to {@link TrappingRainWater}
 * similar to {@link iurii.job.interview.leetcode.ContainerWithMostWater
 * }
 * <p>
 * There is an array of integers that represents landscape.
 * If there was a rain on this landscape, calculate how much water will remain inside
 * <p>
 * Example [2, 0, 0, 3] - 4 is the answer because wall on the left = 2, right = 3.
 * 2 units of water will remain on 1 position as well as on the second position. Sum up = 4.
 * <p>
 * http://www.geeksforgeeks.org/trapping-rain-water/
 * <p>
 * https://stackoverflow.com/questions/24414700/water-collected-between-towers
 * <p>
 * https://www.youtube.com/watch?v=UzeL2GcLx3Y
 *
 * Time Complexity: O(n)
 * Auxiliary Space: O(1)
 *
 * Created by iurii.dziuban on 06/11/2017.
 */
public class TrappingRainWater {

    /**
     * @param landscape input array representing landscape
     * @return number of water units inside the landscape
     */
    public long findWater(int[] landscape) {
        // check null
        if (landscape == null) {
            throw new IllegalArgumentException("Landscape should not be null");
        }
        // initialize output
        long result = 0;

        // maximum element on left and right
        long left_max = Integer.MIN_VALUE, right_max = Integer.MIN_VALUE;

        // indices to traverse the landscape
        int lowerIndex = 0;
        int higherIndex = landscape.length - 1;

        while (lowerIndex <= higherIndex) {
            if (landscape[lowerIndex] < landscape[higherIndex]) {
                if (landscape[lowerIndex] > left_max) {
                    // update left maximum
                    left_max = landscape[lowerIndex];
                } else {
                    // water on current element = smaller max (left) - current
                    result += left_max - landscape[lowerIndex];
                }
                lowerIndex++;
            } else {
                if (landscape[higherIndex] > right_max) {
                    // update right maximum
                    right_max = landscape[higherIndex];
                } else {
                    // water on current element = smaller max (right) - current
                    result += right_max - landscape[higherIndex];
                }
                higherIndex--;
            }
        }
        return result;
    }
}
