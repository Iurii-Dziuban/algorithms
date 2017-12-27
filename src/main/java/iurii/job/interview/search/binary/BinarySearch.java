package iurii.job.interview.search.binary;

import java.util.Arrays;

public class BinarySearch {

    public Integer recursiveBinarySearchValue(int[] array, int value) {
        Arrays.sort(array);
        if (array[array.length - 1] < value || array[0] > value) {
            return null;
        }
        return recursiveSearchValue(array, value, array.length - 1, 0);
    }

    private Integer recursiveSearchValue(int[] array, int value, int upper, int lower) {
        int middle = lower + (upper - lower) / 2;
        if (upper == lower && array[middle] != value) {
            return null;
        }
        if (array[middle] > value) {
            return recursiveSearchValue(array, value, middle - 1, lower);
        } else if (array[middle] < value) {
            return recursiveSearchValue(array, value, upper, middle + 1);
        }
        return array[middle];
    }

    public Integer iterativeBinarySearchIndex(int[] array, int value) {
        Arrays.sort(array);
        int minIndex = 0;
        int maxIndex = array.length - 1;
        while (minIndex <= maxIndex) {
            int guess = minIndex + (maxIndex - minIndex) / 2; // not to have overflow
            if (array[guess] == value) {
                return guess;
            }
            if(array[guess] < value) {
                minIndex = guess + 1;
            } else {
                maxIndex = guess - 1;
            }
        }
        return -1;
    }

}
