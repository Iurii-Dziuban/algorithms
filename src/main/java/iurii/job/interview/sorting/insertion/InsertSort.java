package iurii.job.interview.sorting.insertion;

import java.util.Arrays;

public class InsertSort {

    public int[] oneFunctionInsertionSort(int[] array) {
        int[] res = Arrays.copyOf(array, array.length);
        for (int i = 1; i < res.length; i++) {
            int cur = res[i];
            int curPos = i;
            while (curPos > 0 && cur < res[curPos - 1]) {
                res[curPos] = res[curPos - 1];
                curPos--;
            }
            res[curPos] = cur;
        }
        return res;
    }

    public int[] insertionSort(int[] array) {
        int[] res = Arrays.copyOf(array, array.length);
        for (int i = 1; i < array.length; i++) {
            insert(res, i - 1, array[i]);
        }
        return res;
    }

    // insert next value into sorted till rightIndex (including) array
    private void insert(int[] array, int rightIndex, int value) {
        int i;
        for (i = rightIndex; i >= 0 && array[i] > value; i--) {
            array[i + 1] = array [i];
        }
        array[i + 1] = value;
    }
}
