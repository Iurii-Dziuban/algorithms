package iurii.job.interview.convexhull;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Solution for convexhull problem in geometry
 */
public class ConvexHull {
	
	public static Stack<Point2D> convexHull(List<Point2D> points) {
		Stack<Point2D> solution = new Stack<Point2D>();
		Point2D[] pointsArray = new Point2D[points.size()];
		MergeSortByY.mergesort(points.toArray(pointsArray));
		Point2D point0 = pointsArray[0];
		Point2D[] pointsArrayExcept0 = Arrays.copyOfRange(pointsArray, 1, points.size());
		for (int i = 0; i < pointsArrayExcept0.length; i++) {
			pointsArrayExcept0[i].angleTo(point0);
		}
		solution.add(point0);
		MergeSortByPolarAngle.mergesort(pointsArrayExcept0);
		solution.add(pointsArrayExcept0[0]);
		for (int i = 1; i < pointsArrayExcept0.length; i++) {
			Point2D top = solution.pop();
			while (isCounterClockWise(pointsArrayExcept0[i], top, solution.peek()) <= 0) {
				top = solution.pop();
			}
			solution.add(top);
			solution.add(pointsArrayExcept0[i]);
		}
		return solution;
	}
	
	public static int isCounterClockWise(Point2D a, Point2D b, Point2D c) {
		int area = (b.x - a.x)*(c.y-a.y) - (b.y - a.y)*(c.x-a.x);
		if (area > 0) {
			return 1;
		} else if (area < 0) {
			return -1;
		}
		return 0;
	}
}
