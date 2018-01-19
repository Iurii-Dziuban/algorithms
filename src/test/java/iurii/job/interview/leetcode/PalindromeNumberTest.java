package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PalindromeNumberTest {

    @Test
    public void testRecursive() {
        assertThat(new PalindromeNumber().isPalindromeRecursive(121)).isTrue();
        assertThat(new PalindromeNumber().isPalindromeRecursive(1234321)).isTrue();
        assertThat(new PalindromeNumber().isPalindromeRecursive(12344321)).isTrue();
        assertThat(new PalindromeNumber().isPalindromeRecursive(12345321)).isFalse();
        assertThat(new PalindromeNumber().isPalindromeRecursive(-1234321)).isFalse();
    }

    @Test
    public void testIterative() {
        assertThat(new PalindromeNumber().isPalindromeIterative(121)).isTrue();
        assertThat(new PalindromeNumber().isPalindromeIterative(1234321)).isTrue();
        assertThat(new PalindromeNumber().isPalindromeIterative(12344321)).isTrue();
        assertThat(new PalindromeNumber().isPalindromeIterative(12345321)).isFalse();
        assertThat(new PalindromeNumber().isPalindromeIterative(-1234321)).isFalse();
    }
}
