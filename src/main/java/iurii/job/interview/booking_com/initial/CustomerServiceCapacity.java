package iurii.job.interview.booking_com.initial;

import iurii.job.interview.amazon.ProcessorsForTasks;
import iurii.job.interview.utils.pair.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * At booking.com our customer service team is an important contributor to customer satisfaction.
 * During busy times, however, there might be more calls to customer service
 * than the number of customer service executives can manage.
 * Fortunately, we record data on that. We have collected information about all phone calls to our call centres for the past year.
 *
 * Given that our current number of customer care agents is X. Determine how many more people we would need to hire,
 * to make sure that our customers would not have to wait during peak hours
 * (we do not have more telephone calls than customer executives at a time)
 *
 * Input:
 * - Current number of customer executives X
 * - Number of data points in the data set N
 * - N lines of pairs of timestamp (as integer point in time: started, ended)
 *
 * Output
 * - integer, representing the number of additional customer service executives that we would need to hire,
 * to cover the call volume during peak times. If the current coverage is sufficient print 0;
 *
 * Example:
 * 1
 * 3
 * 1481122000 1481122020
 * 1481122000 1481122040
 * 1481122030 1481122035
 *
 * Answer 1
 *
 * similar to {@link ProcessorsForTasks}
 * Created by iurii.dziuban on 06/06/2017.
 */
public class CustomerServiceCapacity {

    public int howManyAgentsToAdd(int noOfCurrentAgents, int[][] callsTimes) {
        List<Integer> positiveInsAndNegativeOuts = new ArrayList<>();
        for(int[] callTime : callsTimes) {
            positiveInsAndNegativeOuts.add(callTime[0]);
            positiveInsAndNegativeOuts.add(-callTime[1]);
        }
        int maxNumber = 0;
        int currentNumberOfAgents = 0;
        positiveInsAndNegativeOuts.sort(new ChecksComparator());
        for(int value : positiveInsAndNegativeOuts) {
            currentNumberOfAgents += value > 0 ? 1 : - 1;
            if (currentNumberOfAgents > maxNumber) {
                maxNumber = currentNumberOfAgents;
            }
        }
        int additionalAgentsCount = maxNumber - noOfCurrentAgents;
        return additionalAgentsCount >= 0 ? additionalAgentsCount : 0;
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

    private ProcessorsForTasks processorsForTasks = new ProcessorsForTasks();

    public int findNeededNumberOfEmployers(int x, List<Pair> pairs) {
        int additionalNumber = processorsForTasks.findTotalNumberOfProcessorsNeededWithTimeline(pairs) - x;
        return additionalNumber >= 0 ? additionalNumber : 0;
    }
}
