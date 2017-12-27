package iurii.job.interview.sorting.selection;

import java.util.Arrays;

public class SelectionSort {

    public int[] sortOneFunction(int[] array) {
        int[] res = Arrays.copyOf(array, array.length);
        for (int i = 0; i < res.length - 1; i++) {
            int min = Integer.MAX_VALUE;
            int pos = 0;
            for (int j = i; j < res.length; j++) {
                if (res[j] < min) {
                    min = res[j];
                    pos = j;
                }
            }
            int swap = res[i];
            res[i] = min;
            res[pos] = swap;
        }
        return res;
    }

    public int[] sort(int[] array) {
        int[] res = Arrays.copyOf(array, array.length);
        for(int i = 0; i < array.length - 1; i++) {
            int minIndex = findIndexOfMin(res, i);
            swap(res, i, minIndex);
        }
        return res;
    }

    private int findIndexOfMin(int[] array, int startIndex) {
        int minValue = array[startIndex];
        int minIndex = startIndex;
        for (int i = minIndex + 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    // swap elements at indexes
    private void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
