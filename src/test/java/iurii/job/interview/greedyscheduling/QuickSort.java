package iurii.job.interview.greedyscheduling;

import java.util.Random;

/**
 * Quick sort implementation with extra memory space(log n) & with random findPivot.
 */
public class QuickSort {

    public Task[] sort(Task[] array) {
        return sort(array, 0, array.length - 1);
    }

    private Task[] sort(Task[] array, int low, int high) {
        if (low > high) {
            return array;
        }
        int pivot = findPivot(array, low, high);
        sort(array, low, pivot - 1);
        sort(array, pivot + 1, high);
        return array;
    }

    private int findPivot(Task[] array, int low, int high) {
        // random findPivot
        Random rand = new Random();
        int pivotIndex = rand.nextInt(high - low + 1) + low;
        Task pivot = array[pivotIndex];
        // swap first
        Task swapFirst = array[low];
        array[low] = array[pivotIndex];
        array[pivotIndex] = swapFirst;
        int i = low + 1;
        // swap for <p & >p border
        for (int j = low + 1; j <= high; j++) {
            if (array[j].getWeight() > pivot.getWeight()) {
                Task swap = array[i];
                array[i] = array[j];
                array[j] = swap;
                i++;
            }
        }
        // final swap
        array[low] = array[i - 1];
        array[i - 1] = pivot;
        return i - 1;
    }

}
