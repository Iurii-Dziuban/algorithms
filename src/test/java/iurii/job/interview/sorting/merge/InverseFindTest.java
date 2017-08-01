package iurii.job.interview.sorting.merge;

import iurii.job.interview.sorting.Utilities;
import iurii.job.interview.utils.pair.Pair;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 01/08/2017.
 */
public class InverseFindTest {
    @Test
    public void test() {
        InverseFind inverseFind = new InverseFind();
        int[] array = inverseFind.mergeSort(new int[]{3, 1, 2, 4, 7, 6});
        Utilities.println(array);
        Utilities.println(inverseFind.list);
        assertThat(array).containsExactly(1,2,3,4,6,7);
        assertThat(inverseFind.list).containsExactly(new Pair(3, 1), new Pair(3, 2), new Pair(7, 6));
    }
}
