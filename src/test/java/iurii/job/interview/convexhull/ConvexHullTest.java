package iurii.job.interview.convexhull;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class ConvexHullTest {

    @Test
    public void main() {
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

        assertThat(convexHull).hasSize(5);
        Point2D point1 = convexHull.pop();
        assertThat(point1.x).isEqualTo(6);
        assertThat(point1.y).isEqualTo(0);

        Point2D point2 = convexHull.pop();
        assertThat(point2.x).isEqualTo(5);
        assertThat(point2.y).isEqualTo(2);

        Point2D point3 = convexHull.pop();
        assertThat(point3.x).isEqualTo(3);
        assertThat(point3.y).isEqualTo(3);

        Point2D point4 = convexHull.pop();
        assertThat(point4.x).isEqualTo(1);
        assertThat(point4.y).isEqualTo(2);

        Point2D point5 = convexHull.pop();
        assertThat(point5.x).isEqualTo(0);
        assertThat(point5.y).isEqualTo(0);
    }
}
