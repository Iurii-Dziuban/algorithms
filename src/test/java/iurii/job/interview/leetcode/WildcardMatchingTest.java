package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WildcardMatchingTest {

    @Test
    public void testBottomUpDynamicProgramming() {
        assertThat(new WildcardMatching().isMatchBottomUp("", "")).isTrue();
        assertThat(new WildcardMatching().isMatchBottomUp("", "*")).isTrue();
        assertThat(new WildcardMatching().isMatchBottomUp("aa", "a")).isFalse();
        assertThat(new WildcardMatching().isMatchBottomUp("ab", "a?")).isTrue();
        assertThat(new WildcardMatching().isMatchBottomUp("aa", "aa")).isTrue();
        assertThat(new WildcardMatching().isMatchBottomUp("aaa", "aa")).isFalse();
        assertThat(new WildcardMatching().isMatchBottomUp("aaa", "a*b")).isFalse();
        assertThat(new WildcardMatching().isMatchBottomUp("aaa", "aaa?")).isFalse();
        assertThat(new WildcardMatching().isMatchBottomUp("aa", "a*")).isTrue();
        assertThat(new WildcardMatching().isMatchBottomUp("aa", "?*")).isTrue();
        assertThat(new WildcardMatching().isMatchBottomUp("ab", "?*")).isTrue();
        assertThat(new WildcardMatching().isMatchBottomUp("aab", "c*a*b")).isFalse();
        assertThat(new WildcardMatching().isMatchBottomUp("aab", "*a*b")).isTrue();
    }

    @Test
    public void testisMatch() {
        assertThat(new WildcardMatching().isMatch("aa", "a")).isFalse();
        assertThat(new WildcardMatching().isMatch("ab", "a?")).isTrue();
        assertThat(new WildcardMatching().isMatch("aa", "aa")).isTrue();
        assertThat(new WildcardMatching().isMatch("aaa", "aa")).isFalse();
        assertThat(new WildcardMatching().isMatch("aaa", "a*b")).isFalse();
        assertThat(new WildcardMatching().isMatch("aaa", "aaa?")).isFalse();
        assertThat(new WildcardMatching().isMatch("aa", "a*")).isTrue();
        assertThat(new WildcardMatching().isMatch("aa", "?*")).isTrue();
        assertThat(new WildcardMatching().isMatch("ab", "?*")).isTrue();
        assertThat(new WildcardMatching().isMatch("aab", "c*a*b")).isFalse();
        assertThat(new WildcardMatching().isMatch("aab", "*a*b")).isTrue();
        assertThat(new WildcardMatching().isMatch("", "*")).isTrue();
        assertThat(new WildcardMatching().isMatch("", "")).isTrue();
        assertThat(new WildcardMatching().isMatch("", "*")).isTrue();
    }
}
