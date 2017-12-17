package iurii.job.interview.booking_com.initial;

import iurii.job.interview.amazon.ProcessorsForTasks;
import iurii.job.interview.utils.pair.Pair;

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

    private ProcessorsForTasks processorsForTasks = new ProcessorsForTasks();

    public int findNeededNumberOfEmployers(int x, List<Pair> pairs) {
        int additionalNumber = processorsForTasks.findTotalNumberOfProcessorsNeededWithTimeline(pairs) - x;
        return additionalNumber >= 0 ? additionalNumber : 0;
    }
}
