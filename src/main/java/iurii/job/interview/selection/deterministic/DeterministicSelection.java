package iurii.job.interview.selection.deterministic;

import iurii.job.interview.sorting.merge.MergeSort;

public class DeterministicSelection {
    public int select(int[] array, int index) {
        return select(array, 0, array.length - 1, index);
    }

    private int select(int[] array, int start, int end, int index) {
        if (end - start < 10) {
            int[] sortedArray = new MergeSort().mergeSort(array, start, end);
            for (int i = 0; i < sortedArray.length; i++) {
                array[start + i] = sortedArray[i];
            }
            return array[index];
        }
        int pivot = pivot(array, start, end);
        return pivot == index
                ? array[index]
                : pivot < index ?
                 select(array, pivot + 1, end, index) :
                 select(array, start, pivot - 1, index);
    }

    private int pivot(int[] array, int start, int end) {
        // deterministic pivot
        int count = end - start / 5;
        for (int i = 0; i < count - 1; i++) {
            int start1 = start + 5 * i;
            int end1 = start + 5 * (i + 1);
            int[] sortedArray = new MergeSort().mergeSort(array, start1, end1);
            for (int j = 0; j < sortedArray.length; j++) {
                array[start1 + j] = sortedArray[j];
            }
        }

        int start1 = start + 5 * (count - 1);
        int[] sortedArray = new MergeSort().mergeSort(array, start1, end);
        for (int j = 0; j < sortedArray.length; j++) {
            array[start1 + j] = sortedArray[j];
        }
        int[] medians = new int[count];
        for (int i = 0; i < medians.length; i++) {
            medians[i] = array[start + 2 + 5 * i];
        }
        int pivot = medians[count / 2];
        int pivotIndex = start + 2 + 5 * count / 2;
        // swap first
        int swapFirst = array[start];
        array[start] = array[pivotIndex];
        array[pivotIndex] = swapFirst;
        int index = start + 1;
        // swap for <p & >p border
        for (int j = start + 1; j <= end; j++) {
            if (array[j] < pivot) {
                int swap = array[index];
                array[index++] = array[j];
                array[j] = swap;
            }
        }
        // final swap
        array[start] = array[index - 1];
        array[index - 1] = pivot;
        return index - 1;
    }
}
