package iurii.job.interview.amazon;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class KClosestPointsTest {

    @Test
    public void test() {
        List<KClosestPoints.Point> actual = new KClosestPoints().kClosestPoints(
                Arrays.asList(new KClosestPoints.Point(-2, -4),
                        new KClosestPoints.Point(0, -2),
                        new KClosestPoints.Point(-1, 0),
                        new KClosestPoints.Point(3, -5),
                        new KClosestPoints.Point(-2, -3),
                        new KClosestPoints.Point(3, 2)
                ), new KClosestPoints.Point(0, 0), 3
        );
        assertThat(actual).containsExactly(new KClosestPoints.Point(-1,0),
                new KClosestPoints.Point(0,-2),
                new KClosestPoints.Point(-2,-3));
    }
}
