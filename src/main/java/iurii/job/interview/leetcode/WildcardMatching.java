package iurii.job.interview.leetcode;

/**
 * 44. Wildcard Matching https://leetcode.com/problems/wildcard-matching/description/
 *
 * similar to {@link RegularExpressionMatching}
 */
public class WildcardMatching {

    /**
     * Dynamic programming Bottom Up Approach without recursion
     * T - length of text
     * P - length of pattern
     * Time complexity: O(T*P)
     * Auxiliary space complexity: O(T*P)
     */
    public boolean isMatchBottomUp(String text, String pattern) {
        boolean[][] dynamicProgrammingMatrix = new boolean[text.length() + 1][pattern.length() + 1];
        dynamicProgrammingMatrix[text.length()][pattern.length()] = true;

        for (int textIndex = text.length(); textIndex >= 0; textIndex--) {
            for (int patternIndex = pattern.length() - 1; patternIndex >= 0; patternIndex--) {
                boolean first_match = textIndex < text.length() &&
                        (pattern.charAt(patternIndex) == text.charAt(textIndex) || pattern.charAt(patternIndex) == '?');
                if (pattern.charAt(patternIndex) == '*') {
                    dynamicProgrammingMatrix[textIndex][patternIndex] = dynamicProgrammingMatrix[textIndex][patternIndex + 1]
                            || (textIndex < text.length() &&
                            (dynamicProgrammingMatrix[textIndex + 1][patternIndex]
                            || dynamicProgrammingMatrix[textIndex + 1][patternIndex + 1]));
                } else {
                    dynamicProgrammingMatrix[textIndex][patternIndex] = first_match
                            && dynamicProgrammingMatrix[textIndex + 1][patternIndex + 1];
                }
            }
        }
        return dynamicProgrammingMatrix[0][0];
    }

    /**
     * Smarter solution than dynamic programming to store only two pointers in addition
     * T - length of text
     * P - length of pattern
     * Time complexity: O(T*P)
     * Auxiliary space complexity: O(1)
     */
    public boolean isMatch(String text, String pattern) {
        int textMatchIndex = -1;
        int patternStarIndex = -1;
        int patternIndex = 0;
        int textIndex = 0;
        while (textIndex < text.length()) {
            if (patternIndex < pattern.length() && (text.charAt(textIndex) == pattern.charAt(patternIndex)
            || pattern.charAt(patternIndex) == '?')) {
                patternIndex++;
                textIndex++;
            } else if (patternIndex < pattern.length() &&  pattern.charAt(patternIndex) == '*') {
                textMatchIndex = textIndex + 1;
                patternStarIndex = patternIndex;
                patternIndex++;
            } else if (patternStarIndex != -1) {
                textIndex = textMatchIndex++;
                patternIndex = patternStarIndex + 1;
            } else {
                return false;
            }
        }
        while (patternIndex < pattern.length() &&  pattern.charAt(patternIndex) == '*') {
            patternIndex++;
        }
        return patternIndex == pattern.length();
    }

}
