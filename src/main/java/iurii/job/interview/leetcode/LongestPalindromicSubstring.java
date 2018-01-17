package iurii.job.interview.leetcode;

/**
 * 5. Longest Palindromic Substring https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/ for dynamic programming solution
 * https://www.geeksforgeeks.org/longest-palindromic-substring-set-2/
 *
 * Time complexity: O(N^2) test each character to be a center of palindromic substring
 * Auxiliary space: O(1) for startIndex and maxLength
 */
public class LongestPalindromicSubstring {
    // O(n) Manacher`s algorithm to check (https://en.wikipedia.org/wiki/Longest_palindromic_substring)

    private int start;
    private int maxLength;

    public String longestPalindrome(String s) {
        start = 0;
        maxLength = 1;
        // One by one consider every character as center
        // point of even and length palindromes. Skip s.charAt(0) cause it is a base case
        for (int i = 1; i < s.length(); i++) {
            // Find the longest even length palindrome with
            // center points as i-1 and i.
            findLengthExpandFromCenterAtIndexI(s, i - 1, i);

            // Find the longest odd length palindrome with
            // center point as i
            findLengthExpandFromCenterAtIndexI(s, i - 1, i + 1);
        }
        return s.substring(start, start + maxLength);
    }

    private void findLengthExpandFromCenterAtIndexI(String s, int low, int high) {
        while (low >= 0 && high < s.length()
                && s.charAt(low) == s.charAt(high)) {
            low--;
            high++;
        }
        if (high - low - 1 > maxLength) {
            maxLength = high - low - 1;
            start = low + 1;
        }
    }
}
