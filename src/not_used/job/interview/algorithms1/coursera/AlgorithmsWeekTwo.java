package iurii.job.interview.algorithms1.coursera;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlgorithmsWeekTwo {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("QuickSort.txt"));
		List<Integer> array = new ArrayList<Integer>();
		while (sc.hasNextInt()) {
			array.add(sc.nextInt());
		}
		sc.close();
		int[] intArray = new int[array.size()];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = array.get(i);
		}
		QuickSortFirstPivot.sort(intArray);
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = array.get(i);
		}
		QuickSortLastPivot.sort(intArray);
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = array.get(i);
		}
		QuickSortMedianPivot.sort(intArray);
		System.out.println(QuickSortFirstPivot.comparisonNumber);
		System.out.println(QuickSortLastPivot.comparisonNumber);
		System.out.println(QuickSortMedianPivot.comparisonNumber);
	}

}
