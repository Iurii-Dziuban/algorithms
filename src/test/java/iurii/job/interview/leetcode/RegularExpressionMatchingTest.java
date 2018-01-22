package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RegularExpressionMatchingTest {

    @Test
    public void testRecursive() {
        assertThat(new RegularExpressionMatching().isMatchRecursive("", "")).isTrue();
        assertThat(new RegularExpressionMatching().isMatchRecursive("", ".*")).isTrue();
        assertThat(new RegularExpressionMatching().isMatchRecursive("aa", "a")).isFalse();
        assertThat(new RegularExpressionMatching().isMatchRecursive("ab", "a.")).isTrue();
        assertThat(new RegularExpressionMatching().isMatchRecursive("aa", "aa")).isTrue();
        assertThat(new RegularExpressionMatching().isMatchRecursive("aaa", "aa")).isFalse();
        assertThat(new RegularExpressionMatching().isMatchRecursive("aaa", "a*b")).isFalse();
        assertThat(new RegularExpressionMatching().isMatchRecursive("aaa", "aaa.")).isFalse();
        assertThat(new RegularExpressionMatching().isMatchRecursive("aa", "a*")).isTrue();
        assertThat(new RegularExpressionMatching().isMatchRecursive("aa", ".*")).isTrue();
        assertThat(new RegularExpressionMatching().isMatchRecursive("ab", ".*")).isTrue();
        assertThat(new RegularExpressionMatching().isMatchRecursive("aab", "c*a*b")).isTrue();
    }

    @Test
    public void testBottomUpDynamicProgramming() {
        assertThat(new RegularExpressionMatching().isMatchBottomUp("", "")).isTrue();
        assertThat(new RegularExpressionMatching().isMatchBottomUp("", ".*")).isTrue();
        assertThat(new RegularExpressionMatching().isMatchBottomUp("aa", "a")).isFalse();
        assertThat(new RegularExpressionMatching().isMatchBottomUp("ab", "a.")).isTrue();
        assertThat(new RegularExpressionMatching().isMatchBottomUp("aa", "aa")).isTrue();
        assertThat(new RegularExpressionMatching().isMatchBottomUp("aaa", "aa")).isFalse();
        assertThat(new RegularExpressionMatching().isMatchBottomUp("aaa", "a*b")).isFalse();
        assertThat(new RegularExpressionMatching().isMatchBottomUp("aaa", "aaa.")).isFalse();
        assertThat(new RegularExpressionMatching().isMatchBottomUp("aa", "a*")).isTrue();
        assertThat(new RegularExpressionMatching().isMatchBottomUp("aa", ".*")).isTrue();
        assertThat(new RegularExpressionMatching().isMatchBottomUp("ab", ".*")).isTrue();
        assertThat(new RegularExpressionMatching().isMatchBottomUp("aab", "c*a*b")).isTrue();
    }

    @Test
    public void testTopDownDynamicProgramming() {
        assertThat(new RegularExpressionMatching().isMatchTopDown("", "")).isTrue();
        assertThat(new RegularExpressionMatching().isMatchTopDown("", ".*")).isTrue();
        assertThat(new RegularExpressionMatching().isMatchTopDown("aa", "a")).isFalse();
        assertThat(new RegularExpressionMatching().isMatchTopDown("ab", "a.")).isTrue();
        assertThat(new RegularExpressionMatching().isMatchTopDown("aa", "aa")).isTrue();
        assertThat(new RegularExpressionMatching().isMatchTopDown("aaa", "aa")).isFalse();
        assertThat(new RegularExpressionMatching().isMatchTopDown("aaa", "a*b")).isFalse();
        assertThat(new RegularExpressionMatching().isMatchTopDown("aaa", "aaa.")).isFalse();
        assertThat(new RegularExpressionMatching().isMatchTopDown("aa", "a*")).isTrue();
        assertThat(new RegularExpressionMatching().isMatchTopDown("aa", ".*")).isTrue();
        assertThat(new RegularExpressionMatching().isMatchTopDown("aaa", "a*")).isTrue();
        assertThat(new RegularExpressionMatching().isMatchTopDown("ab", ".*")).isTrue();
        assertThat(new RegularExpressionMatching().isMatchTopDown("aab", "c*a*b")).isTrue();
    }
}
