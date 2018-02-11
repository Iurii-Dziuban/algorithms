package iurii.job.interview.codility.onpex;

import java.util.Arrays;

/**
 * The idea to the solution is to sort the array first
 *
 * Do iteration and remember first index of the next element which is greater
 * than first element (next element = first + 1) in sequence.
 * And when current sequence is over, start from the remembered index
 * or continue from current if there was no element.
 *
 * For example: 0,0,1,1,5
 * We start first sequence from beginning with element 0,
 * we found two zeros and next element is by 1 greater than 0, remember index (index = 2)
 * and continue this sequence, cause 1 difference is allowed.
 * When we come to element 5 the length of the sequence is 4 (0,0,1,1)
 * and we start from index 2 that we remembered.
 * When we come to 5, (1,1) sequence has only two elements, which is smaller than found 4 elements.
 * there was no element 2, which is greater than 1 by 1, so we continue with element 5
 *
 * each element will be checked at most 2 times, so the algorithm is still O(N)
 *
 * Algorithm is "in place" without additional O(N) space needed
 *
 * Time complexity: O(N*log(N)) where N number of
 * Auxiliary space complexity: O(1) in the solution, allowed generally O(N)
 *
 * Note: in case if it was required that max difference between elements in the sequence
 * is not 1, but different number, for instance 5 ->
 * This algorithm can be modified not to use extra space,
 * but each element can be checked at most 6 times (in comparison to our solution 2 times)
 *
 * Other way is to have map with key as a starting number in sequence and
 * add count to each key than we check current element, if it is not greater more than k
 * from start element. startElement >= current - k condition.
 * But it will require extra space anyway
 */
public class LongestSubarrayDifferenceMaxOne {

    public int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        Arrays.sort(A);
        int maxCountInSequence = 0;
        int savedIndexToStart = -1;
        int currentStartValue = A[0];
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            long currentValue = A[i];
            if (currentValue - currentStartValue <= 1) {
                count++;
                if (currentValue > currentStartValue
                        && currentValue - currentStartValue <= 1
                        && savedIndexToStart == -1) {
                    savedIndexToStart = i;
                }
            } else {
                maxCountInSequence = Math.max(maxCountInSequence, count);
                if (savedIndexToStart != -1) {
                    i = savedIndexToStart;
                    savedIndexToStart = -1;
                }
                count = 1;
                currentStartValue = A[i];
            }
        }
        maxCountInSequence = Math.max(maxCountInSequence, count);
        return maxCountInSequence;
    }

}
