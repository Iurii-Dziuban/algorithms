package iurii.job.interview.sorting.merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * MergeSort algorithm. Without recursion. Main idea two start from 1 element in each group
 * and merge each two groups. Size of group after iterations doubles. 
 * Division is list of boundaries of groups 
 */
public class MergeSortWithoutRecursion {
	
	public static int[] mergesort(int[] array) {
		List<Integer> division = new ArrayList<Integer>();
		int step = 1;
		fullDivision(array, division, step);
		while (division.size() > 2) {
		    for (int i = 0; i < division.size() - 2; i = i + 2) {
                int[] left = Arrays.copyOfRange(array, division.get(i), division.get(i+1));
                int[] right = Arrays.copyOfRange(array, division.get(i+1), division.get(i+2));
                int[] merge = merge(left, right);
                for (int j = 0; j < merge.length; j++) {
                    array[division.get(i) + j] = merge[j];
                }
            }
		    division.clear();
		    step *= 2;
            fullDivision(array, division, step);
		}
		return array;
	}

    private static void fullDivision(int[] array, List<Integer> division, int step) {
        for (int i = 0; i <= array.length; i = i + step) {
            division.add(i);
            if ((i+step) > array.length && i != array.length) {
                division.add(array.length);
            }
        }
    }
	
	private static int[] merge(int[] firstHalf, int[] secondHalf) {
		int totalLength = firstHalf.length + secondHalf.length;
		int[] result = new int[totalLength];
		int i = 0;
		int j = 0;
		for (int index = 0; index < totalLength; index++) {
			if (i == firstHalf.length ||(j < secondHalf.length && firstHalf[i] > secondHalf[j])) {
				result[index] = secondHalf[j++];
			} else {
				result[index] = firstHalf[i++];
			}
		}
		return result;
	}
	
	public static int[] sort(int[] array) {
        List<Integer> division = new ArrayList<Integer>();
        int step = 1;
        fullDivision(array, division, step);
        while (division.size() > 2) {
            for (int i = 0; i < division.size() - 2; i = i+2) {
                merge(array,division.get(i), division.get(i+1), division.get(i+2) );
            }
            division.clear();
            step *= 2;
            fullDivision(array, division, step);
        }
        return array;
    }
	
	
	public static int[] sortWithoutExtra(int[] array) {
        int step = 1;
        while (step < array.length + 1) {
            int index = 0;
            boolean isEnd = false;
            while (!isEnd) {
                int[] division = new int[3];
                for (int i = 0; i < division.length; i++) {
                    if ((index + i) * step > array.length) {
                        if (i != 2){
                            isEnd = true;
                        }
                        division[i] = array.length;
                    } else {
                        division[i] = (index + i) * step;
                    }
                }
                if (!isEnd) {
                    merge(array,division[0], division[1], division[2]); 
                }
                index += 2;
            }
            step *= 2;
        }
        return array;
    }
	
	private static void merge(int[] array, int start, int middle, int end) {
        int totalLength = end - start;
        int[] result = new int[totalLength];
        int i = 0;
        int j = 0;
        for (int index = 0; index < totalLength; index++) {
            if (i == middle - start ||(j < end - middle && array[i+start] > array[middle + j])) {
                result[index] = array[middle + j++];
            } else {
                result[index] = array[start + i++];
            }
        }
        for (int index = 0; index < result.length; index++) {
            array[start + index] = result[index];
        }
    }
	
	
}
