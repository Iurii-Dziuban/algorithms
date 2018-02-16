package iurii.job.interview.sorting.quick;

import java.util.Random;

/**
 * Quick sort implementation with extra memory space(log n) & with random pivot.
 */
public class QuickSort {

    public int[] sort(int[] array) {
        return sort(array, 0, array.length - 1);
    }

    private int[] sort(int[] array, int low, int high) {
        if (low > high) {
            return array;
        }
        int pivot = pivot(array, low, high);
        sort(array, low, pivot - 1);
        sort(array, pivot + 1, high);
        return array;
    }

    protected int pivot(int[] array, int low, int high) {
        // random pivot
        Random rand = new Random();
        int pivotIndex = rand.nextInt(high - low + 1) + low;
        int pivot = array[pivotIndex];
        // swap first
        int swapFirst = array[low];
        array[low] = array[pivotIndex];
        array[pivotIndex] = swapFirst;
        int i = low + 1;
        // swap for <p & >p border
        for (int j = low + 1; j <= high; j++) {
            if (array[j] < pivot) {
                int swap = array[i];
                array[i] = array[j];
                i++;
                array[j] = swap;
            }
        }
        // final swap
        array[low] = array[i - 1];
        array[i - 1] = pivot;
        return i - 1;
    }

}
