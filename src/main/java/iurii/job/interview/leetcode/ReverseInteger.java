package iurii.job.interview.leetcode;

/**
 * 7. Reverse Integer https://leetcode.com/problems/reverse-integer/description/
 *
 * Time complexity: O(N) - N length of integer
 * Auxiliary space complexity: O(1) - result long value
 *
 * Similar to {@link StringToInteger}
 */
public class ReverseInteger {

    public int reverse(int x) {
        int sign = x > 0 ? 1 : -1;
        long res = 0;
        x = Math.abs(x);
        while (x != 0) {
            long value = 10L * res + x % 10;
            if (value > Integer.MAX_VALUE) {
                return 0;
            }
            res = value;
            x /= 10;
        }
        res *= sign;
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) res;
    }
}
