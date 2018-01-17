package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestPalindromicSubstringTest {
    @Test
    public void test() {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        assertThat(longestPalindromicSubstring.longestPalindrome("babad")).isEqualTo("bab");
        assertThat(longestPalindromicSubstring.longestPalindrome("cbbd")).isEqualTo("bb");
    }
}
