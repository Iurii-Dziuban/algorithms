package iurii.job.interview.selection.deterministic;

import iurii.job.interview.sorting.merge.MergeSort;

public class DeterministicSelection {
    public int select(int[] array, int index) {
        return select(array, 0, array.length - 1, index);
    }

    private int select(int[] array, int low, int high, int index) {
        if (high - low < 10) {
            int[] sortedArray = new MergeSort().mergeSort(array, low, high);
            for (int i = 0; i < sortedArray.length; i++) {
                array[low + i] = sortedArray[i];
            }
            return array[index];
        }
        int pivot = pivot(array, low, high);
        return pivot == index
                ? array[index]
                : pivot < index ?
                 select(array, pivot + 1, high, index) :
                 select(array, low, pivot - 1, index);
    }

    private int pivot(int[] array, int low, int high) {
        // deterministic pivot
        int count = high - low / 5;
        for (int i = 0; i < count - 1; i++) {
            int start1 = low + 5 * i;
            int end1 = low + 5 * (i + 1);
            int[] sortedArray = new MergeSort().mergeSort(array, start1, end1);
            for (int j = 0; j < sortedArray.length; j++) {
                array[start1 + j] = sortedArray[j];
            }
        }

        int start1 = low + 5 * (count - 1);
        int[] sortedArray = new MergeSort().mergeSort(array, start1, high);
        for (int j = 0; j < sortedArray.length; j++) {
            array[start1 + j] = sortedArray[j];
        }
        int[] medians = new int[count];
        for (int i = 0; i < medians.length; i++) {
            medians[i] = array[low + 2 + 5 * i];
        }
        int pivot = medians[count / 2];
        int pivotIndex = low + 2 + 5 * count / 2;
        // swap first
        int swapFirst = array[low];
        array[low] = array[pivotIndex];
        array[pivotIndex] = swapFirst;
        int index = low + 1;
        // swap for <p & >p border
        for (int j = low + 1; j <= high; j++) {
            if (array[j] < pivot) {
                int swap = array[index];
                array[index++] = array[j];
                array[j] = swap;
            }
        }
        // final swap
        array[low] = array[index - 1];
        array[index - 1] = pivot;
        return index - 1;
    }
}
