package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestCommonPrefixTest {
    @Test
    public void test() {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        assertThat(longestCommonPrefix.longestCommonPrefix(new String[]{})).isEqualTo("");
        assertThat(longestCommonPrefix.longestCommonPrefix(new String[]{"aa", "ab", "ac"})).isEqualTo("a");
        assertThat(longestCommonPrefix.longestCommonPrefix(new String[]{"aab", "aabc", "aabd"})).isEqualTo("aab");
    }
}
