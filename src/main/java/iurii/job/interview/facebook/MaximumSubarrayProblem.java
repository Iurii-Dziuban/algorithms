package iurii.job.interview.facebook;

/**
 * Find maximum sum of continuous elements (sub array) in array
 * http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 *
 * https://www.glassdoor.com/Interview
 * /Find-an-algorithm-to-find-the-largest-sum-subarray-in-an-array-of-integers-Better-than-O-n-2-QTN_153517.htm
 *
 * https://www.glassdoor.com/Interview/Kadane-s-algorithm-QTN_2308244.htm
 *
 * https://www.youtube.com/watch?v=86CQq3pKSUw
 *
 * Kadane`s algorithm:
 * Basic idea:
 * On each step calculate maximum sub array with current element as an ending element
 * at each position maximum sum is max sub array sum at previous element + cur element or just current element.
 * Can be proofed by math induction on each step
 *
 * Other implementations:
 * Brute force: with O(n^2) all sub arrays with O(N) memory
 * Dynamic programming: O(n) with memoization O(N) memory
 * Kadane`s algorithm: O(n) with O(1) memory
 * Created by iurii.dziuban on 15/12/2017.
 */
public class MaximumSubarrayProblem {

    public long kadaneOn(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        long maxSum = array[0];
        long curSum = array[0];

        for (int i = 1; i < array.length; i++) {
            curSum = Math.max(curSum + array[i], array[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }

    public long dynamicOn(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        long[] solution = new long[array.length];
        solution[0] = array[0];

        for(int i = 1; i < solution.length; i++) {
            solution[i] =  Math.max(solution[i-1] + array[i], array[i]);
        }
        long result = solution[0];
        for (int i = 1; i < solution.length; i++) {
            result = Math.max(result, solution[i]);
        }
        return result;
    }
}
