package iurii.job.interview.algorithms1.coursera;

/**
 * Quick sort implementation with extra memory space(log n) & with random pivot.
 */
public class QuickSortMedianPivot {
	
	public static long comparisonNumber = 0;
	
	public static int[] sort(int[] array) {
		return sort(array, 0, array.length-1);
	}
	
	private static int[] sort(int[] array, int start, int end) {
		if (start >= end) {
			return array;
		}
		int pivot = pivot(array, start, end);
		sort(array, start, pivot-1);
		sort(array, pivot+1, end);
		return array;
	}

	private static int pivot(int[] array, int start, int end) {
		// first pivot
		int pivotIndex = -1;
		int medianIndex = (end+start) / 2;
		if (array[medianIndex] > array[start] && array[medianIndex] < array[end] ||
				array[medianIndex] > array[end] && array[medianIndex] < array[start]) {
			pivotIndex = medianIndex;
		} else if (array[start] > array[medianIndex] && array[start] < array[end] ||
				array[start] > array[end] && array[start] < array[medianIndex]) {
			pivotIndex = start;
		} else {
			pivotIndex = end;
		}
		int pivot = array[pivotIndex];
		// swap first
		int swapFirst = array[start];
		array[start] = array[pivotIndex];
		array[pivotIndex] = swapFirst;
		int i = start + 1;
		// swap for <p & >p border
		for (int j = start + 1; j <= end; j++) {
		    if (array[j] <  pivot) {
		        int swap = array[i];
		    	array[i] = array[j];
		    	array[j] = swap;
		    	i++;
		    }
		}
		comparisonNumber+=end-start;
		// final swap
		array[start] = array[i-1];
		array[i-1] = pivot;
		return i-1;
	}

}
