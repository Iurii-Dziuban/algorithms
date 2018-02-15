package iurii.job.interview.leetcode;

/**
 * 69. Sqrt(x) https://leetcode.com/problems/sqrtx/description/
 *
 * binary search
 *
 * Time complexity: O(log(N))
 * Auxiliary space complexity: O(1) for pointers
 */
public class Sqrt {

    public int mySqrtLibrary(int x) {
        return (int) Math.sqrt(x);
    }

    public int mySqrt(int x) {
        long start = 0, end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (end * end <= x) {
            return (int) end;
        } else {
            return (int) start;
        }
    }
}
