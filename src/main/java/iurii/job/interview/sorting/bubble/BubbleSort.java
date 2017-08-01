package iurii.job.interview.sorting.bubble;

public class BubbleSort {

    public int[] sort(int[] array) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int swap = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = swap;
                    flag = true;
                }
            }
        }
        return array;
    }

}
