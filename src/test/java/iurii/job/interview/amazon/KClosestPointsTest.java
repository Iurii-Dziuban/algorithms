package iurii.job.interview.amazon;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class KClosestPointsTest {

    @Test
    public void test() {
        KClosestPoints.Point point1 = new KClosestPoints.Point(-2, -4);
        KClosestPoints.Point point2 = new KClosestPoints.Point(0, -2);
        KClosestPoints.Point point3 = new KClosestPoints.Point(-1, 0);
        KClosestPoints.Point point4 = new KClosestPoints.Point(3, -5);
        KClosestPoints.Point point5 = new KClosestPoints.Point(-2, -3);
        KClosestPoints.Point point6 = new KClosestPoints.Point(3, 2);
        KClosestPoints.Point targetPoint = new KClosestPoints.Point(0, 0);
        List<KClosestPoints.Point> actual = new KClosestPoints().kClosestPoints(
                Arrays.asList(point1,
                        point2,
                        point3,
                        point4,
                        point5,
                        point6
                ), targetPoint, 3
        );
        assertThat(actual).containsExactly(point3,
                point2,
                point5);
    }
}
