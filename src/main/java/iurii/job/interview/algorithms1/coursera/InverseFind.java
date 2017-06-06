package iurii.job.interview.algorithms1.coursera;

import iurii.job.interview.utils.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Finds pairs of values that are out of order in array
 * For example 3,1,2,4,5,7,6 Answer: (3,1) (3,2) (7,6)
 * @author Jacky
 */
public class InverseFind {
	
	public static long count = 0;
	public static List<Pair> list = new ArrayList<Pair>();
	
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
	
	public static int[] merge(int[] firstHalf, int[] secondHalf) {
		int totalLength = firstHalf.length + secondHalf.length;
		int[] result = new int[totalLength];
		int i = 0;
		int j = 0;
		for (int index = 0; index < totalLength; index++) {
			if (i == firstHalf.length || j < secondHalf.length && firstHalf[i] > secondHalf[j]) {
				for (int k = i; k < firstHalf.length; k++) {
					//TODO removed only for AlgorithmsWeekOneToAvoidOutOfMemory
					//list.add(new Pair(firstHalf[k], secondHalf[j]));
					count++;
				}
				result[index] = secondHalf[j++];
			} else {
				result[index] = firstHalf[i++];
			}
		}
		return result;
	}
	
}
