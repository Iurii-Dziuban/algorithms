package iurii.job.interview.leetcode;

/**
 * 755. Pour Water https://leetcode.com/problems/pour-water/description/
 *
 * http://zxi.mytechroad.com/blog/simulation/leetcode-755-pour-water/
 *
 * <p>
 * We are given an elevation map, heights[i] representing the height of the terrain at that index.
 * The width at each index is 1. After V units of water fall at index K, how much water is at each index?
 * <p>
 * Water first drops at index K and rests on top of the highest terrain or water at that index.
 * Then, it flows according to the following rules:
 * - If the droplet would eventually fall by woving left, then move left.
 * - Otherwise, if the droplet would eventually fail by moving right, then move right
 * - Otherwise stay at its current position
 * <p>
 * idea : simulation
 * <p>
 * Time complexity: O(n * V)
 * Auxiliary space complexity: O(1)
 */
public class PourWater {
    public int[] pourWater(int[] heights, int V, int K) {
        while (V-- > 0) {
            drop(heights, K);
        }
        return heights;
    }

    private void drop(int[] heights, int K) {
        int index = K;
        for (int d = -1; d <= 1; d += 2) {
            int i = K + d;
            while (i >= 0 && i < heights.length && heights[i] <= heights[i - d]) {
                if (heights[i] < heights[index]) {
                    index = i;
                }
                i += d;
            }
            if (index != K) {
                break;
            }
        }
        heights[index]++;
    }
}
