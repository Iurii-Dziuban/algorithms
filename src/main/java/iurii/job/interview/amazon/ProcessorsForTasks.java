package iurii.job.interview.amazon;

import iurii.job.interview.utils.pair.Pair;
import iurii.job.interview.utils.pair.PairUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * There are series of task times to be executed in epoch integer (integer pairs)
 * Find minimum number of processors so that all tasks will be executed at needed time.
 * <p>
 * Input:
 * - Number of data points in the data set N
 * - N lines of pairs of timestamp (as integer point in time: started, ended)
 * <p>
 * Output
 * - integer, representing the number of processors needed to process the tasks
 * <p>
 * Example:
 * 1
 * 3
 * 1481122000 1481122020
 * 1481122000 1481122040
 * 1481122030 1481122035
 * <p>
 * Answer 1
 * <p>
 * NOTE!!!!
 * 1) Same task as booking.com CustomerServiceCapacity. Difference in naming, solution the same
 * 2) Same task as booking.com FindMaxGuestDayService. Difference in naming input data
 *
 * Suggestions when each solution to use:
 * 1) Timeline if timeline is relatively smaller than number of time series.
 * 2) Sorting solution if timeline is relatively bigger than number of time series
 *
 * Created by iurii.dziuban on 06/06/2017.
 */
public class ProcessorsForTasks {

    /** Solution based on timeline  O(n + timeline)
     *  Adding or extracting 1 at the specific time point on timeline
     */
    public int findTotalNumberOfProcessorsNeededWithTimeline(List<Pair> pairs) {
        int min = PairUtils.findMin(pairs);
        int max = PairUtils.findMax(pairs);
        int[] timeline = new int[max - min + 1];
        for (Pair pair : pairs) {
            timeline[pair.getFirst() - min]++;
            timeline[pair.getSecond() - min]--;
        }
        int curNumberOfProcessors = 0;
        int needed = 0;
        for (int value : timeline) {
            curNumberOfProcessors += value;
            if (curNumberOfProcessors > needed) {
                needed = curNumberOfProcessors;
            }
        }
        return needed;
    }

    /** Solution based on sorting O(n log n)
     *  By sorting ins and outs in the order they happen (based on Math.abs logic)
     */
    public int findTotalNumberOfProcessorsNeededWithSorting(List<Pair> pairs) {
        ArrayList<Integer> positiveInsAndNegativeOuts = new ArrayList<>();
        for(Pair pair : pairs) {
            positiveInsAndNegativeOuts.add(pair.getFirst());
            positiveInsAndNegativeOuts.add(- pair.getSecond());
        }
        int maxNumber = 0;
        int currentNumberOfProcessors = 0;
        positiveInsAndNegativeOuts.sort(new ChecksComparator());
        for(int value : positiveInsAndNegativeOuts) {
            currentNumberOfProcessors += value > 0 ? 1 : - 1;
            if (currentNumberOfProcessors > maxNumber) {
                maxNumber = currentNumberOfProcessors;
            }
        }
        return maxNumber;
    }

    public static class ChecksComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            int difference = Math.abs(o1) - Math.abs(o2);
            if (difference == 0) {
                return o2 - o1;
            }
            return difference;
        }
    }
}
