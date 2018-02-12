package iurii.job.interview.codility.onpex;

/**
 * Find the left most index of B integer that contains A as a substring
 *
 * As two integers are non negative, convert both to string
 * and the string "indexOf" method for the String will return
 * the left most index of first occurrence or -1 if B does not contain A.
 *
 * That is the solution, that is needed
 *
 * https://app.codility.com/test/RRN4CG-W83/
 *
 * Time complexity: O(N * M) to find the index
 * Auxiliary space complexity : O(N + M) to store string representation of numbers
 * N, M - lengths of the integer numbers
 */
public class IntegerPositionInOtherInteger {

    public int solution(int A, int B) {
        String aString = String.valueOf(A);
        String bString = String.valueOf(B);
        return bString.indexOf(aString);
    }
}
