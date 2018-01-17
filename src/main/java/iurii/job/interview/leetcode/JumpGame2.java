package iurii.job.interview.leetcode;

/**
 * 45. Jump Game / Tower Hopper problem / Minimum number of jumps to reach end
 * (TowerHopperProblem)
 *
 * http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 * https://leetcode.com/problems/jump-game-ii/description/
 *
 * https://www.youtube.com/watch?v=kHWy5nEfRIQ
 * https://stackoverflow.com/questions/27858356/how-to-find-minimum-number-of-jumps-to-reach-the-end-of-the-array-in-on-time
 *
 * There are 3 solutions:
 * 1) Brute force : to check each variant
 * 2) Dynamic programing: based on memorization of min steps to reach end. From left/right of array.
 * 3) Greedy: to step on the element that given better next range of possible hops
 *
 * Asked in: Adobe,Amazon,Housing.com, Moonfrog Labs,Walmart
 *
 * Time complexity: O(N) at most once each element
 * Auxiliary space complexity: O(1) in greedy case O(N) in case of dynamic programing to store results
 * Created by iurii.dziuban on 18/12/2017.
 */
public class JumpGame2 {

    /**
     * Non null, possible negative, possible not reachable out of the highest index of array
     */
    public int greedyJumpsOutOfMaxIndex(int[] array) {
        long endOfCurJump = 0;
        long maxReachFromCurrent = Long.MIN_VALUE; // not to have overflow
        int jumps = 0;
        for(int i = 0; i < array.length; i++) {
            if (maxReachFromCurrent > array.length - 1) {
                return jumps;
            }
            maxReachFromCurrent = Math.max(maxReachFromCurrent, i + array[i]);
            if (maxReachFromCurrent <= i) {
                return -1;
            }
            if (endOfCurJump == i) {
                jumps++;
                endOfCurJump = maxReachFromCurrent;
            }
        }
        return jumps;
    }

    // leetcode: not null, not negative, reachable till the last element
    public int greedyJumpsToLastElement(int[] array) {
        long endOfCurJump = 0;
        long maxReachFromCurrent = 0; // not to have overflow
        int jumps = 0;
        for(int i = 0; i < array.length - 1; i++) {
            maxReachFromCurrent = Math.max(maxReachFromCurrent, array[i] + i);
            if (maxReachFromCurrent >= array.length - 1) {
                return jumps + 1;
            }
            if (endOfCurJump == i) {
                jumps++;
                endOfCurJump = maxReachFromCurrent;
            }
        }
        return jumps;
    }
}
