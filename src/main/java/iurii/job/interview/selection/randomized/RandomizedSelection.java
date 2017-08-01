package iurii.job.interview.selection.randomized;

import iurii.job.interview.sorting.quick.QuickSort;

/**
 * @author Jacky
 */
public class RandomizedSelection extends QuickSort {

    public int select(int[] array, int index) {
        return select(array, 0, array.length - 1, index);
    }

    private int select(int[] array, int start, int end, int index) {
        if (start > end) {
            return -1;
        }
        int pivot = pivot(array, start, end);
        if (pivot == index) {
            return array[index];
        } else {
            if (pivot < index) {
                return select(array, pivot + 1, end, index);
            } else {
                return select(array, start, pivot - 1, index);
            }
        }
    }
}
