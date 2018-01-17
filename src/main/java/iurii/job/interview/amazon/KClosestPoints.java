package iurii.job.interview.amazon;

import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Find k closest points to origin (0, 0)
 * https://www.youtube.com/watch?v=eaYX0Ee0Kcg
 *
 * Similar to {@link iurii.job.interview.leetcode.FindKClosestElements}
 */
public class KClosestPoints {

    public List<Point> kClosestPoints(List<Point> points, Point point, int number) {
        PriorityQueue<Point> priorityQueue = new PriorityQueue<>();
        points.forEach(p -> {
            p.distance = (point.x - p.x) * (point.x - p.x) +
                         (point.y - p.y) * (point.y - p.y);
            priorityQueue.add(p);
        });
        return Stream.generate(priorityQueue::poll)
                .limit(number).collect(Collectors.toList());
    }

    public static class Point implements Comparable<Point> {
        int x;
        int y;
        double distance;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return Double.compare(distance, o.distance);
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Point) {
                Point oPoint = (Point) o;
                return x == oPoint.x && y == oPoint.y;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return x + y;
        }
    }
}
