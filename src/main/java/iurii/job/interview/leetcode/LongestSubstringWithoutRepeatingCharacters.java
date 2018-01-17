package iurii.job.interview.leetcode;

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 *
 * https://leetcode.com/articles/longest-substring-without-repeating-characters/
 *
 * Time complexity O(N)
 * Auxiliary space complexity O(M) for array, O(min(N, M)) for Map
 * N - string length
 * M - alphabet size (number of different characters in the string)
 */
public class LongestSubstringWithoutRepeatingCharacters {

    // assuming that characters are only ASCII we can use an array of boolean exists instead of Map
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        boolean[] charactersSeen = new boolean[256];
        int maxSize = 0;
        while (right < s.length()) {
            char cur = s.charAt(right);
            if (!charactersSeen[cur]) {
                charactersSeen[cur] = true;
                maxSize = Math.max( maxSize, ++right - left);
            } else {
                charactersSeen[s.charAt(left++)] = false;
            }
        }
        return maxSize;
    }

    // assuming that characters are only ASCII we can use an array of integer and use int
    // instead of Map
    public int lengthOfLongestSubstringLeftJump(String s) {
        int left = 0;
        int[] charactersSeenJump = new int[256];
        int maxSize = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (charactersSeenJump[cur] != 0) {
                left = (left > charactersSeenJump[cur]) ? left : charactersSeenJump[cur];
            }
            charactersSeenJump[cur] = i + 1;
            maxSize = Math.max( maxSize, i + 1 - left);
        }
        return maxSize;
    }

}
