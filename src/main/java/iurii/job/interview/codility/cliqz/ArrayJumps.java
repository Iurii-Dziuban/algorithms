package iurii.job.interview.codility.cliqz;

import java.util.HashSet;
import java.util.Set;

/**
 *
 *  https://codility.com/honeypot/Burda-Cliqz_Programmer/
 *
 * Created by IuriiDziuban on 10/29/17.
 */
public class ArrayJumps {

    public int countJumps(int[] A) {
        if (A == null) {
            return -1;
        }
        Set<Integer> indexes = new HashSet<>();
        int i = 0;
        int steps = 0;
        indexes.add(0);
        while (i < A.length) {
            i += A[i];
            steps++;
            if (indexes.contains(i)) {
                return -1;
            } else {
                indexes.add(i);
            }
        }
        return steps;
    }
}
