package iurii.job.interview.selection.randomized;

import iurii.job.interview.sorting.quick.QuickSort;

/**
 * @author Jacky
 */
public class RandomizedSelection extends QuickSort {

    public int select(int[] array, int index) {
        return select(array, 0, array.length - 1, index);
    }

    private int select(int[] array, int low, int high, int index) {
        if (low > high) {
            return -1;
        }
        int pivot = pivot(array, low, high);
        if (pivot == index) {
            return array[index];
        } else {
            if (pivot < index) {
                return select(array, pivot + 1, high, index);
            } else {
                return select(array, low, pivot - 1, index);
            }
        }
    }
}
