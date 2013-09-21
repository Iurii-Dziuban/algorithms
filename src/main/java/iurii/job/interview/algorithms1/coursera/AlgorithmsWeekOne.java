package iurii.job.interview.algorithms1.coursera;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlgorithmsWeekOne {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/main/resources/IntegerArray.txt"));
		List<Integer> array = new ArrayList<Integer>();
		while (sc.hasNextInt()) {
			array.add(sc.nextInt());
		}
		sc.close();
		int[] intArray = new int[array.size()];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = array.get(i);
		}
		InverseFind.mergesort(intArray);
		System.out.println(InverseFind.count);
		
	}

}
