package iurii.job.interview.topcoder.srm491;

/**
 * Problem Statement
 * ����
 * We say that two integer numbers differ from each other by one digit,
 * when in their decimal notation, possibly with leading zeros,
 * they will differ in exactly one position. For example numbers 128 and 28 differ by one digit:
 * 128
 * 028
 * But numbers 2047 and 40 differ by two digits:
 * 2047
 * 0040
 * Given the number N, find and return the smallest possible non-negative number M,
 * such that number N and M differ from each other by exactly one digit.
 * Definition
 * ����
 * Class:
 * OneDigitDifference
 * Method:
 * getSmallest
 * Parameters:
 * int
 * Returns:
 * int
 * Method signature:
 * int getSmallest(int N)
 * (be sure your method is public)
 * Limits
 * ����
 * Time limit (s):
 * 2.000
 * Memory limit (MB):
 * 64
 * Constraints
 * -
 * N will be between 0 and 2,000,000,000, inclusive.
 * Examples
 * 0)
 * <p>
 * ����
 * 9
 * Returns: 0
 * 0 is the smallest non-negative number and differs by only one digit.
 * 1)
 * <p>
 * ����
 * 0
 * Returns: 1
 * The result number is not always smaller than N.
 * 2)
 * <p>
 * ����
 * 900000123
 * Returns: 123
 * Leading zeros in the result are okay:
 * 900000123
 * 000000123
 * 3)
 * <p>
 * ����
 * 30000
 * Returns: 0
 * Leading zeros are okay also with 0 as a result:
 * 30000
 * 00000
 * 4)
 * <p>
 * ����
 * 47
 * Returns: 7
 * <p>
 * 5)
 * <p>
 * ����
 * 1907654321
 * Returns: 907654321
 */
public class OneDigitDifference {
    public int getSmallest(int N) {
        if (N == 0) {
            return 1;
        }
        if (N < 10) {
            return 0;
        }
        String value = String.valueOf(N);
        return Integer.parseInt(value.substring(1));
    }
}
