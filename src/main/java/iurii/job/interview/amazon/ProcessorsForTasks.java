package iurii.job.interview.amazon;

import iurii.job.interview.utils.Pair;
import iurii.job.interview.utils.PairUtils;

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
 * NOTE!!!! Same task as booking.com CustomerServiceCapacity . difference in naming, solution the same
 * Created by iurii.dziuban on 06/06/2017.
 */
public class ProcessorsForTasks {

    public int findTotalNumberOfProcessorsNeeded(List<Pair> pairs) {
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
}
