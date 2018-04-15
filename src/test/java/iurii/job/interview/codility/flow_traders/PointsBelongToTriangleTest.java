package iurii.job.interview.codility.flow_traders;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointsBelongToTriangleTest {

    @Test
    public void test() {
        PointsBelongToTriangle pointsBelongToTriangle = new PointsBelongToTriangle();
        assertThat(pointsBelongToTriangle
                .pointsBelongToTriangle(0,0, 2,0,4,0,2,0, 4, 0)).isEqualTo(0);
        assertThat(pointsBelongToTriangle
                .pointsBelongToTriangle(3,1, 7,1,5,5,3,1, 0, 0)).isEqualTo(1);
        assertThat(pointsBelongToTriangle
                .pointsBelongToTriangle(3,1, 7,1,5,5,1,1, 4, 3)).isEqualTo(2);
        assertThat(pointsBelongToTriangle
                .pointsBelongToTriangle(3,1, 7,1,5,5,5,2, 6, 3)).isEqualTo(3);
        assertThat(pointsBelongToTriangle
                .pointsBelongToTriangle(3,1, 7,1,5,5,1,1, 2, 2)).isEqualTo(4);
    }
}
