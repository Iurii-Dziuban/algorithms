package iurii.job.interview.sorting.selection;

import iurii.job.interview.sorting.Utilities;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 01/08/2017.
 */
public class SelectionSortTest {

    @Test
    public void test() {
        int[] sorted = new SelectionSort().sort(new int[]{9, 3, 6, 1, 4, 2, 5, 7, 8});
        Utilities.println(sorted);
        assertThat(sorted).containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9);

    }
}
