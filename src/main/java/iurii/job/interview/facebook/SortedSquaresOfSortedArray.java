package iurii.job.interview.facebook;

/**
 * https://www.careercup.com/question?id=5754478975254528
 * Created by IuriiDziuban on 10/22/17.
 */
public class SortedSquaresOfSortedArray {

    public int[] squareAndSort(int[] a) {
        int index = 0;
        for (int element : a) {
            if (element < 0) {
                index++;
            }
        }
        // revert negative
        int ind = index;
        int middle = index / 2;
        int i = 0;
        index--;
        while (index > middle) {
            int value = a[index];
            a[index] = a[i];
            a[i] = value;
            i++;
            index--;
        }

        // square

        for(i = 0; i < a.length ;i++) {
            a[i] = a[i] * a[i];
        }

        // merge
        int in = 0;
        int j = ind;
        int[] b = new int[a.length];
        for (i = 0; i < b.length; i++) {
            if (in < ind) {
                if (j < a.length) {
                    if (a[j] > a[in]) {
                        b[i] = a[in++];
                    } else {
                        b[i] = a[j++];
                    }
                } else {
                    b[i] = a[in++];
                }
            } else {
                b[i] = a[j++];
            }
        }
        return b;
    }
}
