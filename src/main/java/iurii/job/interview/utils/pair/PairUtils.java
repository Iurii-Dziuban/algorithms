package iurii.job.interview.utils.pair;

import java.util.List;

/**
 * Created by iurii.dziuban on 06/06/2017.
 */
public class PairUtils {

    public static int findMin(List<Pair> pairs) {
        int min = Integer.MAX_VALUE;
        for (Pair p : pairs) {
            min = min > p.getFirst() ? p.getFirst() : min;
        }
        return  min;
    }

    public static int findMax(List<Pair> pairs) {
        int max = 0;
        for (Pair p : pairs) {
            max = max < p.getSecond() ? p.getSecond() : max;
        }
        return  max;
    }
}
