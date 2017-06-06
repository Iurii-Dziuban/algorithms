package iurii.job.interview.sorting.merge;

import java.util.Arrays;

/**
 * MergeSort algorithm. Recursive algorithm: divide into 2 halves sort each
 * and then merge 2 sorted halves into result array.
 *
 * @author Jacky
 */
public class MergeSort {

    public static int[] mergesort(int[] array) {
        int dividePointer = array.length / 2;
        if (dividePointer > 0) {
            int[] firstHalf = mergesort(Arrays.copyOfRange(array, 0, dividePointer));
            int[] secondHalf = mergesort(Arrays.copyOfRange(array, dividePointer, array.length));
            return merge(firstHalf, secondHalf);
        } else {
            return array;
        }
    }

    public static int[] mergesort(int[] array, int start, int end) {
        int dividePointer = (end + start) / 2;
        if (dividePointer > 0) {
            int[] firstHalf = mergesort(Arrays.copyOfRange(array, start, dividePointer));
            int[] secondHalf = mergesort(Arrays.copyOfRange(array, dividePointer, end));
            return merge(firstHalf, secondHalf);
        } else {
            return array;
        }
    }

    public static int[] merge(int[] firstHalf, int[] secondHalf) {
        int totalLength = firstHalf.length + secondHalf.length;
        int[] result = new int[totalLength];
        int i = 0;
        int j = 0;
        for (int index = 0; index < totalLength; index++) {
            if (i == firstHalf.length || j < secondHalf.length && firstHalf[i] > secondHalf[j]) {
                result[index] = secondHalf[j++];
            } else {
                result[index] = firstHalf[i++];
            }
        }
        return result;
    }


}
