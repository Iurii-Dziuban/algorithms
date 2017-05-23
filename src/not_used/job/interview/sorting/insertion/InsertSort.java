package iurii.job.interview.sorting.insertion;

import java.util.Arrays;

public class InsertSort {
	public static int[] sort(int[] array) {
		int[] res = Arrays.copyOf(array, array.length);
		for (int i = 1; i < res.length; i++) {
		    int cur = res[i];
		    int curPos = i;
			while (curPos > 0 && cur < res[curPos-1]) {
			    res[curPos]= res[curPos-1];
				curPos--;	
			}
			res[curPos] = cur;
		}
		return res;
	}
}
