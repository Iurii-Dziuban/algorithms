package iurii.job.interview.leetcode;

/**
 * 744. Find Smallest Letter Greater Than Target
 *
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
 * https://leetcode.com/articles/find-smallest-letter-greater-than-target/
 *
 * Idea is similar to {@link FindKClosestElements}
 * Time complexity : O(N) linear search and O(log(N)) binary search
 * Auxiliary space complexity : O(1) store the value
 */
public class FindSmallestLetterGreaterThanTarget {

    /**
     * General solution with linear search in case letters are not sorted
     */
    public char nextGreatestLetterGeneral(char[] letters, char target) {
        if (letters == null || letters.length == 0) {
            return '!' ; // not valid
        }
        Character resHigher = null;
        Character resLower = 'z';
        for (char c : letters) {
            if (c > target && (resHigher == null || c < resHigher)) {
                resHigher = c;
            }
            if (c <= target && c < resLower) {
                resLower = c;
            }
        }
        return resHigher != null ? resHigher : resLower;
    }

    /**
     * Linear search in sorted array
     */
    public char nextGreatestLetterLinearSearchInSorted(char[] letters, char target) {
        if (letters == null || letters.length == 0) {
            return '!' ; // not valid
        }
        for (char c : letters) {
            if (c > target) {
                return c;
            }
        }
        return letters[0];
    }

    /**
     * Binary search in sorted array
     */
    public char nextGreatestLetterBinarySearchInSorted(char[] letters, char target) {
        if (letters == null || letters.length == 0) {
            return '!' ; // not valid
        }
        int low = 0, high = letters.length;
        while (low < high) {
            int mi = low + (high - low) / 2;
            if (letters[mi] <= target) {
                low = mi + 1;
            } else {
                high = mi;
            }
        }
        return letters[low % letters.length];
    }
}
