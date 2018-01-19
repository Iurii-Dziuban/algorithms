package iurii.job.interview.leetcode;

/**
 * 9. Palindrome Number .  https://leetcode.com/problems/palindrome-number/description/
 *
 * https://www.geeksforgeeks.org/check-if-a-number-is-palindrome/
 *
 * Just reversing integer can give overflow issue.
 * Recursively going bottom to first digit and saving the original value
 * and then going top by throwing away last digit of original value and comparing it with last digit in the recursive call
 *
 * https://leetcode.com/articles/palindrome-number/
 *
 * Time complexity: O(N) - N -length of the number
 * Auxiliary space complexity: O(1) - one reference value
 */
public class PalindromeNumber {

    private static class WrapInt {
        int value;
        public WrapInt (int value) {
            this.value = value;
        }
    }

    public boolean isPalindromeRecursive(int x) {
        return x >= 0 && isPalindromeRecursive(x, new WrapInt(x));
    }

    private boolean isPalindromeRecursive(int value, WrapInt reference) {
        if (value == 0) {
            return true;
        } else {
            boolean palindrome = isPalindromeRecursive(value / 10, reference);
            int lastDigit = reference.value % 10;
            reference.value /= 10;
            return palindrome && value % 10 == lastDigit;
        }
    }

    public boolean isPalindromeIterative(int x) {
        if (x < 0) {
            return false;
        }
        int reverseInt = 0;
        while (x > reverseInt) {
            reverseInt = reverseInt * 10 + x % 10;
            x /= 10;
        }
        return x == reverseInt || reverseInt / 10 == x;
    }
}
