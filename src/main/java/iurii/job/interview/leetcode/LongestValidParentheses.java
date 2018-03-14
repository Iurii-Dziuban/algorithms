package iurii.job.interview.leetcode;

/**
 * 32. Longest Valid Parentheses https://leetcode.com/problems/longest-valid-parentheses/description/
 *
 * Ideas are here https://leetcode.com/articles/longest-valid-parentheses/
 *
 * Brute force, dynamic programming, stack and two pointers
 *
 * Time complexity: O(N)
 * Auxiliary space complexity: O(N) with stack and O(1) with two pointers
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength, left + right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength, left + right);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxLength;
    }
}
