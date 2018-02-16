package iurii.job.interview.leetcode;

/**
 * 69. Sqrt(x) https://leetcode.com/problems/sqrtx/description/
 *
 * idea based on binary search
 *
 * Time complexity: O(log(N)) - N value of the number
 * Auxiliary space complexity: O(1) for pointers
 */
public class Sqrt {

    public int mySqrtLibrary(int x) {
        return (int) Math.sqrt(x);
    }

    public int mySqrt(int x) {
        int low = 0, high = x;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (low * low <= x) {
            return low;
        } else {
            return low - 1;
        }
    }
}