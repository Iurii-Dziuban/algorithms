package iurii.job.interview.sorting.insertion;

import iurii.job.interview.sorting.Utilities;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created by iurii.dziuban on 01/08/2017.
 */
public class InsertSortTest {
    @Test
    public void test() {
        InsertSort insertSort = new InsertSort();
        int[] sorted = insertSort.sort(new int[]{9, 3, 6, 1, 4, 2, 5, 7, 8});
        Utilities.println(sorted);
        Assertions.assertThat(sorted).containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }
}
