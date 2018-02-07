package iurii.job.interview.leetcode;

/**
 * 14. Longest Common Prefix https://leetcode.com/problems/longest-common-prefix/description/
 *
 * https://leetcode.com/articles/longest-common-prefix/
 *
 * https://www.geeksforgeeks.org/longest-common-prefix-set-1-word-by-word-matching/
 * https://www.geeksforgeeks.org/longest-common-prefix-set-2-character-by-character-matching/
 * https://www.geeksforgeeks.org/longest-common-prefix-set-3-divide-and-conquer/
 * https://www.geeksforgeeks.org/longest-common-prefix-set-4-binary-search/
 * https://www.geeksforgeeks.org/longest-common-prefix-set-5-using-trie/
 *
 * Time complexity : O(N * M) , N - number of strings and M longest string length
 * Auxiliary space : O(M)
 *
 * Important Note: other solutions do not provide better, but even worse bigO Time/space complexity
 */
public class LongestCommonPrefix {

    public String longestCommonPrefixByWord(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String one = strs[i];
            int smallerLength = Math.min(prefix.length(), one.length());
            int curLength = 0;
            for (int k = 0; k < smallerLength; k++) {
                if (prefix.charAt(k) == one.charAt(k)) {
                    curLength++;
                } else {
                    break;
                }
            }
            if (curLength < prefix.length()) {
                prefix = prefix.substring(0, curLength);
            }
        }
        return prefix;
    }

    public String longestCommonPrefixByChars(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (String s : strs) {
            if (s.length() < prefix.length()) {
                prefix = s;
            }
        }
        int i = 0;
        while (i < prefix.length()) {
            for (String s : strs) {
                if (s.charAt(i) != prefix.charAt(i)) {
                    return prefix.substring(0, i);
                }
            }
            i++;
        }
        return prefix;
    }
}
