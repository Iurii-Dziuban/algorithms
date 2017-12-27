package iurii.job.interview.search.binary;

import iurii.job.interview.sorting.insertion.InsertSort;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 31/07/2017.
 */
public class BinarySearchTest {

    @Test
    public void testRecursiveOnOneFunctionInsertionSort() {
        InsertSort insertSort = new InsertSort();
        BinarySearch binarySearch = new BinarySearch();
        assertThat(binarySearch.recursiveBinarySearchValue(insertSort.oneFunctionInsertionSort(new int[]{9, 3, 6, 1, 4, 2, 5, 7, 8}), 4)).isEqualTo(4);
        assertThat(binarySearch.recursiveBinarySearchValue(insertSort.oneFunctionInsertionSort(new int[]{9, 3, 6, 1, 4, 2, 5, 7, 8}), 10)).isNull();
    }

    @Test
    public void testRecursiveOnInsertionSort() {
        InsertSort insertSort = new InsertSort();
        BinarySearch binarySearch = new BinarySearch();
        assertThat(binarySearch.recursiveBinarySearchValue(insertSort.insertionSort(new int[]{9, 3, 6, 1, 4, 2, 5, 7, 8}), 4)).isEqualTo(4);
        assertThat(binarySearch.recursiveBinarySearchValue(insertSort.insertionSort(new int[]{9, 3, 6, 1, 4, 2, 5, 7, 8}), 10)).isNull();
    }

    @Test
    public void testIterativeSearchIndexOnSortedArray() {
        BinarySearch binarySearch = new BinarySearch();
        assertThat(binarySearch.iterativeBinarySearchIndex(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 1)).isEqualTo(0);
        assertThat(binarySearch.iterativeBinarySearchIndex(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 10)).isEqualTo(-1);
    }
}
