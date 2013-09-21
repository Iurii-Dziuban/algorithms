package iurii.job.interview.sorting.selection;

import java.util.Arrays;

public class SelectionSort {
	public static int[] sort(int[] array) {
		int[] res = Arrays.copyOf(array, array.length);
		for (int i = 0; i < res.length - 1; i++) {
			int min = Integer.MAX_VALUE;
			int pos = 0;
			for (int j = i; j < res.length; j++) {
				if (res[j]<min) {
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
}
