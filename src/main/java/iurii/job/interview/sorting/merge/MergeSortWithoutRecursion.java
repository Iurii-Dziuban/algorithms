package iurii.job.interview.sorting.merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * MergeSort algorithm. Without recursion. Main idea two start from 1 element in each group
 * and merge each two groups. Size of group after iterations doubles.
 * Division is list of boundaries of groups
 */
public class MergeSortWithoutRecursion extends MergeSort {

    @Override
    public int[] mergeSort(int[] array) {
        List<Integer> division = new ArrayList<Integer>();
        int step = 1;
        fullDivision(array, division, step);
        while (division.size() > 2) {
            for (int i = 0; i < division.size() - 2; i = i + 2) {
                int[] left = Arrays.copyOfRange(array, division.get(i), division.get(i + 1));
                int[] right = Arrays.copyOfRange(array, division.get(i + 1), division.get(i + 2));
                int[] merge = merge(left, right);
                System.arraycopy(merge, 0, array, division.get(i), merge.length);
            }
            division.clear();
            step *= 2;
            fullDivision(array, division, step);
        }
        return array;
    }

    private void fullDivision(int[] array, List<Integer> division, int step) {
        for (int i = 0; i <= array.length; i = i + step) {
            division.add(i);
            if ((i + step) > array.length && i != array.length) {
                division.add(array.length);
            }
        }
    }

    public int[] sort(int[] array) {
        List<Integer> division = new ArrayList<Integer>();
        int step = 1;
        fullDivision(array, division, step);
        while (division.size() > 2) {
            for (int i = 0; i < division.size() - 2; i = i + 2) {
                merge(array, division.get(i), division.get(i + 1), division.get(i + 2));
            }
            division.clear();
            step *= 2;
            fullDivision(array, division, step);
        }
        return array;
    }


    public int[] sortWithoutExtra(int[] array) {
        int step = 1;
        while (step < array.length + 1) {
            int index = 0;
            boolean isEnd = false;
            while (!isEnd) {
                int[] division = new int[3];
                for (int i = 0; i < division.length; i++) {
                    if ((index + i) * step > array.length) {
                        if (i != 2) {
                            isEnd = true;
                        }
                        division[i] = array.length;
                    } else {
                        division[i] = (index + i) * step;
                    }
                }
                if (!isEnd) {
                    merge(array, division[0], division[1], division[2]);
                }
                index += 2;
            }
            step *= 2;
        }
        return array;
    }

    private void merge(int[] array, int low, int middle, int high) {
        int totalLength = high - low;
        int[] result = new int[totalLength];
        int i = 0;
        int j = 0;
        for (int index = 0; index < totalLength; index++) {
            if (i == middle - low || j < high - middle && array[i + low] > array[middle + j]) {
                result[index] = array[middle + j++];
            } else {
                result[index] = array[low + i++];
            }
        }
        System.arraycopy(result, 0, array, low, result.length);
    }


}
