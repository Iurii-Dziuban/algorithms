package iurii.job.interview.facebook;

/**
 *
 * There is a sequence of temperatures for global warming:
 * 26,52,23,30,28,50,13,10,25
 *
 * Find two consecutive temperatures first < second, which difference second - first is the maximum
 * from all the pairs in the array. If not existing return 0.
 *
 * Basic naive brute force approach is O(N^2). Provide solution in O(N)
 *
 * In the example above, the greatest difference is between 50 - 23 = 27
 *
 * Glider is used for verification https://glider.ai
 *
 * Created by IuriiDziuban on 10/22/17.
 */
public class IceCapsMelting {

    public int maxDifference(int[] a) {
        if (a == null || a.length <= 1) {
            return 0;
        }
        int maxDifference = 0;
        int min = a[0];
        for(int value : a) {
            if (value < min) {
                min = value;
            } else {
                if (value - min > maxDifference) {
                    maxDifference = value - min;
                }
            }
        }
        return maxDifference;
    }
}
