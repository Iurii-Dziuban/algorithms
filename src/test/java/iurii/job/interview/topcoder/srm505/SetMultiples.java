package iurii.job.interview.topcoder.srm505;

/**
 * Problem Statement
 * ����
 * Suppose that S1 and S2 are sets of integer numbers.
 * Let's call S2 a multiple of S1 if for each integer x from S1 there exist an integer y from S2
 * such that y is an integer multiple of x, i.e., y = k * x, where k is an integer.
 * You are given longs A, B, C, D. Consider a set S consisting of integers x such that A <= x <= B or C <= x <= D.
 * Return the number of elements in the smallest subset of S that is a multiple of S.
 * Definition
 * ����
 * Class:
 * SetMultiples
 * Method:
 * smallestSubset
 * Parameters:
 * long, long, long, long
 * Returns:
 * long
 * Method signature:
 * long smallestSubset(long A, long B, long C, long D)
 * (be sure your method is public)
 * Limits
 * ����
 * Time limit (s):
 * 2.000
 * Memory limit (MB):
 * 64
 * Notes
 * -
 * Since S is a subset of S and S is a multiple of S, the answer exists for any test case.
 * Constraints
 * -
 * A will be between 1 and 10,000,000,000, inclusive.
 * -
 * B will be between A and 10,000,000,000, inclusive.
 * -
 * C will be between B + 1 and 10,000,000,000, inclusive.
 * -
 * D will be between C and 10,000,000,000, inclusive.
 * Examples
 * 0)
 * <p>
 * ����
 * 1
 * 1
 * 2
 * 2
 * Returns: 1
 * Here S = {1, 2}. The subset {2} is a multiple of S because 2 is a multiple of both 1 and 2.
 * 1)
 * <p>
 * ����
 * 1
 * 2
 * 3
 * 4
 * Returns: 2
 * This time, S = {1, 2, 3, 4}. The subset {3, 4} is a multiple of S because 4 is a multiple of 1, 2 and 4, and 3 is a multiple of 3.
 * 2)
 * <p>
 * ����
 * 2
 * 3
 * 5
 * 7
 * Returns: 3
 * S = {2, 3, 5, 6, 7}. The solution is {5, 6, 7}.
 * 3)
 * <p>
 * ����
 * 1
 * 10
 * 100
 * 1000
 * Returns: 500
 * <p>
 * 4)
 * <p>
 * ����
 * 1000000000
 * 2000000000
 * 9000000000
 * 10000000000
 * Returns: 1254365078
 */
public class SetMultiples {

    public static void main(String[] args) {
        System.out.println(new SetMultiples().smallestSubset(1000000000L, 2000000000L, 9000000000L, 10000000000L));
        System.out.println(new SetMultiples().smallestSubset(10, 19, 90, 99));
    }

    public long smallestSubset(long A, long B, long C, long D) {
        A = B / 2 + 1 > A ? B / 2 + 1 : A;
        C = D / 2 + 1 > C ? D / 2 + 1 : C;
        long result = D - C + 1;
        long max = D / A;
        long min = divRound(C, B);
        if (max == min) {
            long minValue = between(A, B, divRound(C, min));
            long maxValue = between(A, B, D / min);
            return result + B - A - (maxValue - minValue);
        } else {
            for (long i = min; i < max; i++) {
                long prevMaxBound = D / (i + 1);
                long curMinBound = divRound(C, i);
                if (curMinBound - prevMaxBound > 0) {
                    result += curMinBound - prevMaxBound - 1;
                }
                i++;
            }
            return result;
        }
    }

    private long between(long A, long B, long C) {
        if (C < A) {
            return A;
        }
        if (C > B) {
            return B;
        }
        return C;
    }

    private long divRound(long a, long b) {
        return (a % b == 0) ? a / b : a / b + 1;
    }
}
