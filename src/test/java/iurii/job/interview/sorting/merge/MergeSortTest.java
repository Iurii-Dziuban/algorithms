package iurii.job.interview.sorting.merge;

import iurii.job.interview.sorting.Utilities;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 01/08/2017.
 */
public class MergeSortTest {

    @Test
    public void test() {
        MergeSort mergeSort = new MergeSort();
        int[] mergedArray = mergeSort.merge(new int[]{2, 3}, new int[]{1, 4, 5});
        Utilities.println(mergedArray);
        int[] array = mergeSort.mergeSort(new int[]{3, 1, 2});
        int[] array1 = mergeSort.mergeSort(new int[]{3, 1, 2}, 0, 3);
        int[] array2 = mergeSort.mergeSort(new int[]{3, 1, 2}, 0, 1);
        Utilities.println(array);
        assertThat(mergedArray).containsExactly(1, 2, 3, 4, 5);
        assertThat(array).containsExactly(1, 2, 3);
        assertThat(array1).containsExactly(1, 2, 3);
        assertThat(array2).containsExactly(3, 1, 2);
    }
}
