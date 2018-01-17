package iurii.job.interview.leetcode;

/**
 * 6. ZigZag Conversion https://leetcode.com/problems/zigzag-conversion/description/
 *
 * Time complexity: O(N) - all characters
 * Auxiliary space complexity O(N) result
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int period = 2 * (numRows - 1);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int j = i;
            while (j < s.length()) {
                result.append(s.charAt(j));
                int index = j + 2 * (numRows - 1 - i);
                if (i != 0 &&  i!= numRows - 1 && index < s.length()) {
                    result.append(s.charAt(index));
                }
                j += period;
            }
        }
        return result.toString();
    }
}
