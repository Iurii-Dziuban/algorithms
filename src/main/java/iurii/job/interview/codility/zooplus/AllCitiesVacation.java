package iurii.job.interview.codility.zooplus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *  Min sub array with all unique values
 *
 *  https://codility.com/public-link/zooplus-AG-Java-Engineering-2016/
 *
 *  Time complexity: O(N)
 *  Auxiliary space: O(N)
 *
 *  Similar to https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
 *
 * Created by IuriiDziuban on 10/22/17.
 */
public class AllCitiesVacation {

    public int findMinDaysToVisitAllCities(int[] A) {
        Set<Integer> range = new HashSet<>();
        for(int value : A) {
            range.add(value);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int j = 0;
        int minLength = A.length;
        for(int i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i],1);
            } else {
                map.put(A[i], map.get(A[i]) + 1);
            }
            if (map.size() == range.size()) {
                while (j < i) {
                    if (map.get(A[j]) > 1) {
                        map.put(A[j], map.get(A[j]) - 1);
                        j++;
                    } else {
                        break;
                    }
                }
                if (minLength > i - j + 1) {
                    minLength = i - j + 1;
                }
            }
        }
        return minLength;

    }
}
