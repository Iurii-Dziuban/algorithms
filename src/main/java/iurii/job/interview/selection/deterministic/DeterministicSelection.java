package iurii.job.interview.selection.deterministic;

import iurii.job.interview.sorting.merge.MergeSort;


public class DeterministicSelection {
	public static int select(int[] array, int index) {
	    return select(array, 0, array.length-1, index);	
	}
	
	private static int select(int[] array, int start, int end, int index) {
		if (end-start<10) {
			int[] sortedArray = MergeSort.mergesort(array, start, end);
			for (int i = 0; i < sortedArray.length; i++) {
				array[start+i] = sortedArray[i];
			}
			return array[index];
		}
		int pivot = pivot(array, start, end);
		if (pivot == index) {
			return array[index];
		} else {
			if (pivot<index) {
				return select(array, pivot+1, end, index);	
			} else {
				return select(array, start, pivot-1, index);	
			}
		}
	}

	private static int pivot(int[] array, int start, int end) {
		// deterministic pivot
		int count = end - start / 5;
		for (int i = 0; i < count-1; i++) {
			int start1 = start + 5*i;
			int end1 = start + 5*(i+1);
			int[] sortedArray = MergeSort.mergesort(array, start1, end1);
			for (int j = 0; j < sortedArray.length; j++) {
				array[start1+j] = sortedArray[j];
			}
		}
		
		int start1 = start + 5*(count-1);
		int end1 = end;
		int[] sortedArray = MergeSort.mergesort(array, start1, end1);
		for (int j = 0; j < sortedArray.length; j++) {
			array[start1+j] = sortedArray[j];
		}
		int[] medians = new int[count];
		for (int i = 0; i < medians.length; i++) {
			medians[i] = array[start + 2 + 5*i];
		}
		int pivot = medians[count/2];
		int pivotIndex = start+2+5*count/2;
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
		// final swap
		array[start] = array[i-1];
		array[i-1] = pivot;
		return i-1;
	}
}
