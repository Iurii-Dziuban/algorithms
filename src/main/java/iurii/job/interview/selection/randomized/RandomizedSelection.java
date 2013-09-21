package iurii.job.interview.selection.randomized;

import java.util.Random;

/**
 * @author Jacky
 *
 */
public class RandomizedSelection {
	
	public static int select(int[] array, int index) {
	    return select(array, 0, array.length-1, index);	
	}
	
	private static int select(int[] array, int start, int end, int index) {
		if (start > end) {
			return -1;
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
		// random pivot
		Random rand = new Random();
		int pivotIndex = rand.nextInt(end - start+1) + start;
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
		// final swap
		array[start] = array[i-1];
		array[i-1] = pivot;
		return i-1;
	}

}
