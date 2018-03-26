package iurii.job.interview.facebook;

/**
 * You have two arrays.
 * [1,2,3,4,5]
 * [3,5,3]
 * Replace continuous sub-array with whole replacement array, so that "disruption" is the smallest possible
 * (Sum of the differences of original values with values that replace them)
 *
 * With naive approach:
 * Time complexity: O(N*K) where N and K are lengths of the arrays correspondingly
 * Auxiliary space complexity: O(1) - sums and indexes
 * https://www.youtube.com/watch?v=1wMBw38rAlw
 */
public class LeastDisruptiveSubrange {

    // naive approach
    public int findLeastDisruptiveSubrangeIndex(int[] original, int[] replacement) {
        int smallestIndex = -1;
        long smallestDistanceSum = Long.MAX_VALUE;
        for (int i = 0; i <= original.length - replacement.length; i++) {
            long distanceSum = 0;
            for (int j = 0; j < replacement.length; j++) {
                distanceSum += Math.abs(original[i + j] - replacement[j]);
            }
            if (distanceSum < smallestDistanceSum) {
                smallestDistanceSum = distanceSum;
                smallestIndex = i;
            }
        }
        return  smallestIndex;
    }
}
