package iurii.job.interview.search.binary;

import java.util.Arrays;

public class BinarySearch {
    public static Integer binarySearch(int[] array, int value) {
        Arrays.sort(array);
        if (array[array.length - 1] < value || array[0] > value) {
            return null;
        }
        return search(array, value, array.length - 1, 0);
    }

    private static Integer search(int[] array, int value, int upper, int lower) {
        int middle = lower + (upper - lower) / 2;
        if (upper == lower && array[middle] != value) {
            return null;
        }
        if (array[middle] > value) {
            return search(array, value, middle - 1, lower);
        } else if (array[middle] < value) {
            return search(array, value, upper, middle + 1);
        }
        return array[middle];
    }

}
