package iurii.job.interview.convexhull;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Point2D> list = new ArrayList<Point2D>();
        list.add(new Point2D(0, 0));
        list.add(new Point2D(1, 2));
        list.add(new Point2D(2, 1));
        list.add(new Point2D(3, 1));
        list.add(new Point2D(4, 1));
        list.add(new Point2D(3, 3));
        list.add(new Point2D(3, 2));
        list.add(new Point2D(5, 2));
        list.add(new Point2D(6, 0));
        Stack<Point2D> convexHull = ConvexHull.convexHull(list);
        while (!convexHull.empty()) {
            System.out.println(convexHull.pop());
        }

    }

}
