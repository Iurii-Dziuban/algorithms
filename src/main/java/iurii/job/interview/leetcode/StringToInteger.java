package iurii.job.interview.leetcode;

/**
 * 8. String to Integer (atoi) https://leetcode.com/problems/string-to-integer-atoi/description/
 *
 * Time complexity: O(N) where N string length
 * Auxiliary space complexity: O(1) for result
 */
public class StringToInteger {

    public int myAtoi(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }

        int i = 0;
        // trim white spaces
        while(i < str.length() && str.charAt(i) == ' ') {
            i++;
        }

        int sign = 1;

        // check negative or positive

        if (i < str.length()) {
            if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                sign = str.charAt(i) == '+' ? 1 : -1;
                i++;
            }
        } else {
            return 0;
        }
        int value = 0;

        // calculate value
        while (str.length() > i) {
            int digit = str.charAt(i) - '0';
            if(digit < 0 || digit > 9) break;
            if (Integer.MAX_VALUE / 10 < value || (Integer.MAX_VALUE / 10 == value && Integer.MAX_VALUE % 10 < digit)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            value = value * 10 + digit;
            i++;
        }

        return value * sign;
    }
}
