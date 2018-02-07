package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestCommonPrefixTest {
    @Test
    public void testByString() {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        assertThat(longestCommonPrefix.longestCommonPrefixByWord(new String[]{})).isEqualTo("");
        assertThat(longestCommonPrefix.longestCommonPrefixByWord(new String[]{"aa", "ab", "ac"})).isEqualTo("a");
        assertThat(longestCommonPrefix.longestCommonPrefixByWord(new String[]{"aab", "aabc", "aabd"})).isEqualTo("aab");
    }

    @Test
    public void testByChar() {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        assertThat(longestCommonPrefix.longestCommonPrefixByChars(new String[]{})).isEqualTo("");
        assertThat(longestCommonPrefix.longestCommonPrefixByChars(new String[]{"aa", "ab", "ac"})).isEqualTo("a");
        assertThat(longestCommonPrefix.longestCommonPrefixByChars(new String[]{"aab", "aabc", "aabd"})).isEqualTo("aab");
    }
}
