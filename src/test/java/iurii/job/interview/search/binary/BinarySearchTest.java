package iurii.job.interview.search.binary;

import iurii.job.interview.sorting.insertion.InsertSort;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 31/07/2017.
 */
public class BinarySearchTest {
    @Test
    public void test() {
        InsertSort insertSort = new InsertSort();
        BinarySearch binarySearch = new BinarySearch();
        assertThat(binarySearch.binarySearch(insertSort.sort(new int[]{9, 3, 6, 1, 4, 2, 5, 7, 8}), 4)).isEqualTo(4);
        assertThat(binarySearch.binarySearch(insertSort.sort(new int[]{9, 3, 6, 1, 4, 2, 5, 7, 8}), 10)).isNull();
    }
}
