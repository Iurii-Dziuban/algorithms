package iurii.job.interview.leetcode;

/**
 * 10. Regular Expression Matching https://leetcode.com/problems/regular-expression-matching/description/
 * <p>
 * https://leetcode.com/articles/regular-expression-matching/
 * <p>
 * https://www.geeksforgeeks.org/wildcard-pattern-matching/
 * https://www.geeksforgeeks.org/wildcard-character-matching/
 */
public class RegularExpressionMatching {

    /**
     * Naive approach with potential of 2^N checks
     * Time complexity: O(2^N)
     * Auxiliary space: here strings are copied but index can be passed along, but still O(2^N) are possible
     */
    public boolean isMatchRecursive(String text, String pattern) {
        // pattern empty, text empty - fine
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }
        // match first symbol of text with first symbol of pattern
        boolean first_match = !text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.');

        // check for the star
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            // either try to decrease  pattern by 2 and text same or decrease text by one and same pattern (check first character match)
            return (isMatchRecursive(text, pattern.substring(2)) ||
                    (first_match && isMatchRecursive(text.substring(1), pattern)));
        } else {
            // no star next - decrease both by 1
            return first_match && isMatchRecursive(text.substring(1), pattern.substring(1));
        }
    }


    /**
     * Dynamic programming Bottom Up Approach without recursion
     * T - length of text
     * P - length of pattern
     * Time complexity: O(T*P)
     * Auxiliary space complexity: O(T*P)
     */
    public boolean isMatchBottomUp(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                boolean first_match = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
                } else {
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }


    enum Result {
        TRUE, FALSE
    }

    Result[][] memo;

    /**
     * Dynamic programming Top Down Approach similar to recursive but with memoization
     */
    public boolean isMatchTopDown(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    private boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()) {
            ans = i == text.length();
        } else {
            boolean first_match = (i < text.length() &&
                    (pattern.charAt(j) == text.charAt(i) ||
                            pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                ans = (dp(i, j + 2, text, pattern) ||
                        first_match && dp(i + 1, j, text, pattern));
            } else {
                ans = first_match && dp(i + 1, j + 1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
}
