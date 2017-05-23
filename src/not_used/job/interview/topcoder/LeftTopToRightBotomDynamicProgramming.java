package iurii.job.interview.topcoder;

import java.util.Iterator;
import java.util.LinkedList;

public class LeftTopToRightBotomDynamicProgramming {

	/**
	 * Find maximum path. Using dynamic programming.
	 * Main idea of dynamic programming is to use recurrence functions.
	 * It is described using states where next state depends on some previous states.
	 */
	public static void main(String[] args) {
		int[][] matrix = {{1,1,1,1,1},
				          {2,3,4,1,2},
                    	  {2,3,4,1,1},
                    	  {2,3,4,3,1},
                    	  {2,3,4,1,2}};
		int[][] maxStatesMatrix = findMaxPath(matrix);
		int[][] minStatesMatrix = findMinPath(matrix);
		System.out.println("maxPath = " + maxStatesMatrix[matrix.length-1][matrix[0].length-1]);
		System.out.println("minPath = " + minStatesMatrix[matrix.length-1][matrix[0].length-1]);
		Iterator<Point> maxPath = path(matrix, maxStatesMatrix).iterator();
		Iterator<Point> minPath = path(matrix, minStatesMatrix).iterator();
		System.out.println("maxPath");
		while(maxPath.hasNext()) {
			System.out.print(maxPath.next());
		}
		System.out.println();
		System.out.println("minPath");
		while(minPath.hasNext()) {
			System.out.print(minPath.next());
		}
		System.out.println();
		
	}

	private static int[][] findMaxPath(int[][] matrix) {
		int[][] statesMatrix = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < statesMatrix.length; i++) {
			for (int j = 0; j < statesMatrix[i].length; j++) {
				statesMatrix[i][j] = Integer.MIN_VALUE;
			}
		}
		for (int i = 0; i < statesMatrix.length; i++) {
			for (int j = 0; j < statesMatrix.length; j++) {
				int maxForState = matrix[i][j];
				int top = Integer.MIN_VALUE;
				int left = Integer.MIN_VALUE;
				if (j-1 >= 0) {
					left = statesMatrix[i][j-1];
				}
				if (i-1 >= 0) {
					top = statesMatrix[i-1][j];
				}
				
				if (top < left) {
					maxForState+=left;
				}
				
				if (left < top) {
					maxForState+=top;
				}
				
				if (top == left && top != Integer.MIN_VALUE) {
					maxForState+=left;
				}
				
				statesMatrix[i][j] = maxForState;
			}
		}
		return statesMatrix;
	}
	
	private static int[][] findMinPath(int[][] matrix) {
		int[][] statesMatrix = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < statesMatrix.length; i++) {
			for (int j = 0; j < statesMatrix[i].length; j++) {
				statesMatrix[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < statesMatrix.length; i++) {
			for (int j = 0; j < statesMatrix.length; j++) {
				int minForState = matrix[i][j];
				int top = Integer.MAX_VALUE;
				int left = Integer.MAX_VALUE;
				if (j-1 >= 0) {
					left = statesMatrix[i][j-1];
				}
				if (i-1 >= 0) {
					top = statesMatrix[i-1][j];
				}
				
				if (top < left) {
					minForState+=top;
				}
				
				if (left < top) {
					minForState+=left;
				}
				
				if (top == left && top != Integer.MAX_VALUE) {
					minForState+=left;
				}
				
				statesMatrix[i][j] = minForState;
			}
		}
		return statesMatrix;
	}
	
	private static LinkedList<Point> path(int[][] matrix, int[][] states) {
		LinkedList<Point> linkedList = new LinkedList<Point>();
		int n = matrix.length;
		int m = matrix[n-1].length;
		linkedList.addFirst(new Point(n-1, m-1));
		int i = n-1; 
	    int j = m-1;
		while (i!=0 || j!=0) {
			if (j-1>=0 && (states[i][j] - matrix[i][j] == states[i][j-1])) {
				linkedList.addFirst(new Point(i, j-1));
				j--;
			} else {
				linkedList.addFirst(new Point(i-1, j));
				i--;
			}
		}
		return linkedList;
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
