package iurii.job.interview.leetcode;

/**
 * Jump Game / Tower Hopper problem / Minimum number of jumps to reach end
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
 * Asked in: Adobe,Amazon,Housing.com,Moonfrog Labs,Walmart
 *
 * Created by iurii.dziuban on 18/12/2017.
 */
public class JumpGame2 {

    public int greedyJumpsOutOfMaxIndex(int[] array) {
        if (array == null) {
            return 0;
        }
        long step = 1;
        long maxReachFromCurrent = 0; // not to have overflow
        int jumps = 0;
        for(int i = 0; i < array.length; i++) {
            if (maxReachFromCurrent > array.length - 1) {
                return jumps;
            }
            maxReachFromCurrent = Math.max(maxReachFromCurrent, i + array[i]);
            step--;
            if (step == 0) {
                jumps++;
                if (i >= maxReachFromCurrent) {
                    return -1;
                }
                step = maxReachFromCurrent - i;
            }
        }
        return jumps;
    }

    // leetcode
    public int greedyJumpsToLastElement(int[] array) {
        if (array == null) {
            return 0;
        }
        long step = 1;
        long maxReachFromCurrent = 0; // not to have overflow
        int jumps = -1;
        for(int i = 0; i < array.length; i++) {
            maxReachFromCurrent = Math.max(maxReachFromCurrent, i + array[i]);
            step--;
            if (step == 0) {
                jumps++;
                if ( i != array.length - 1) {
                    if (i >= maxReachFromCurrent) {
                        return -1;
                    }
                    step = maxReachFromCurrent - i;
                }
            }
        }
        return step == 0 ? jumps : jumps + 1;
    }
}
