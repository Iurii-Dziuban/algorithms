package iurii.job.interview.sorting;

import java.util.List;

public final class Utilities {
   private Utilities() {}
   
   public static void println(int[] array) {
	   for (int i = 0; i < array.length; i++) {
		   System.out.print(array[i]+ " ");
	   }
	   System.out.println();
   }
   public static void println(List<?> list) {
	   for (int i = 0; i < list.size(); i++) {
		   System.out.print(list.get(i)+ " ");
	   }
	   System.out.println();
   }
   
  public static void println(int[][] matrix) {
	  for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
  } 
}
