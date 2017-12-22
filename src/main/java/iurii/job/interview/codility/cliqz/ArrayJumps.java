package iurii.job.interview.codility.cliqz;

/**
 *
 *  https://codility.com/honeypot/Burda-Cliqz_Programmer/
 *
 * Similar to {@link iurii.job.interview.leetcode.CircularArrayLoop}
 *
 * Created by IuriiDziuban on 10/29/17.
 */
public class ArrayJumps {

    public int countJumps(int[] A) {
        // edge cases
        if (A == null || A.length == 0) {
            return -1;
        }
        boolean[] hasBeen = new boolean[A.length];
        // only because next address can potentially overflow with int
        long index = 0;
        int steps = 0;
        while (index < A.length && index >= 0) {
            steps++;
            int curIndex = (int) index;
            if (hasBeen[curIndex]) {
                return -1;
            } else {
                hasBeen[curIndex] = true;
            }
            index += A[curIndex];
        }
        return steps;
    }
}
