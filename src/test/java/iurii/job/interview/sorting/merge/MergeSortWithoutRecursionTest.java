package iurii.job.interview.sorting.merge;

import iurii.job.interview.sorting.Utilities;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 01/08/2017.
 */
public class MergeSortWithoutRecursionTest {
    @Test
    public void test() {
        MergeSortWithoutRecursion mergeSortWithoutRecursion = new MergeSortWithoutRecursion();
        int[] array = mergeSortWithoutRecursion.mergeSort(new int[]{9, 3, 6, 1, 4, 2, 5, 7, 8});
        Utilities.println(array);
        int[] array1 = mergeSortWithoutRecursion.sortWithoutExtra(new int[]{9, 3, 6, 1, 4, 2, 5, 7, 8});
        Utilities.println(array1);
        int[] array2 = mergeSortWithoutRecursion.sort(new int[]{9, 3, 6, 1, 4, 2, 5, 7, 8});
        Utilities.println(array2);

        assertThat(array).containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(array1).containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(array2).containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }
}
