package iurii.job.interview.topcoder;

import java.util.Iterator;
import java.util.LinkedList;

public class LeftTopToRightBotom {

	/**
	 * TODO this is not optimal solution - using depth-first search and search for minimal path
	 * Use {@link LeftTopToRightBotomDynamicProgramming} with dynamic programming as optimal
	 */
	public static void main(String[] args) {
		int[][] matrix = {{1,1,1,1,1},
				          {2,3,4,1,2},
                    	  {2,3,4,1,1},
                    	  {2,3,4,3,1},
                    	  {2,3,4,1,2}};
		LinkedList<Point> minimalPathCoordinates = new LinkedList<Point>();
		int minimalPath = minimalPath(matrix, 0, 0, minimalPathCoordinates);
		System.out.println(minimalPath);
		Iterator<Point> iterator = minimalPathCoordinates.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next());
		}
		System.out.println();
	}
	
	private static int minimalPath(int[][] matrix,int i,int j, LinkedList<Point> stack) {
		int n = matrix.length;
		int path = 0;
		LinkedList<Point> myStack = new LinkedList<Point>();
		
		if ((i == n-1) && (j==n-1)) {
			myStack.add(new Point(n-1, n-1));
			stack.addAll(myStack);
			return matrix[n-1][n-1];
		}
		
		LinkedList<Point> linkedList1 = new LinkedList<Point>();
		LinkedList<Point> linkedList2 = new LinkedList<Point>();
		linkedList1.add(new Point(i, j));
		linkedList2.add(new Point(i, j));
		
		int path1 = Integer.MAX_VALUE;
		int path2 = Integer.MAX_VALUE;
		if (i<n-1) {
			path1 = minimalPath(matrix, i+1, j, linkedList1);
		}
		if (j<n-1) {
			path2 = minimalPath(matrix, i, j+1, linkedList2);
		}
		
		if (path1 > path2) {
			path = path2;
			stack.addAll(linkedList2);
		} else {
			path = path1;
			stack.addAll(linkedList1);
		}
		return matrix[i][j] + path;
	} 
	
	private static class Point {
		private int x;
		private int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public String toString() {
			return "["+x+";"+y+"]";
		}

	}

}
