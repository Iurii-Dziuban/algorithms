package iurii.job.interview.greedyscheduling;

import java.util.Random;

/**
 * Quick sort implementation with extra memory space(log n) & with random findPivot.
 */
public class QuickSort {

    public Task[] sort(Task[] array) {
        return sort(array, 0, array.length - 1);
    }

    private Task[] sort(Task[] array, int start, int end) {
        if (start > end) {
            return array;
        }
        int pivot = findPivot(array, start, end);
        sort(array, start, pivot - 1);
        sort(array, pivot + 1, end);
        return array;
    }

    private int findPivot(Task[] array, int start, int end) {
        // random findPivot
        Random rand = new Random();
        int pivotIndex = rand.nextInt(end - start + 1) + start;
        Task pivot = array[pivotIndex];
        // swap first
        Task swapFirst = array[start];
        array[start] = array[pivotIndex];
        array[pivotIndex] = swapFirst;
        int i = start + 1;
        // swap for <p & >p border
        for (int j = start + 1; j <= end; j++) {
            if (array[j].getWeight() > pivot.getWeight()) {
                Task swap = array[i];
                array[i] = array[j];
                array[j] = swap;
                i++;
            }
        }
        // final swap
        array[start] = array[i - 1];
        array[i - 1] = pivot;
        return i - 1;
    }

}
