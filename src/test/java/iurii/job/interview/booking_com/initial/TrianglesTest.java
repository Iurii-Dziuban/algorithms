package iurii.job.interview.booking_com.initial;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TrianglesTest {

    @Test
    public void test() {
        Triangles triangles = new Triangles();
        assertThat(triangles.triangle(-1, 2, 3)).isEqualTo(0);
        assertThat(triangles.triangle(1, -2, 3)).isEqualTo(0);
        assertThat(triangles.triangle(1, 2, -3)).isEqualTo(0);
        assertThat(triangles.triangle(1, 2, 3)).isEqualTo(0);
        assertThat(triangles.triangle(2, 2, 2)).isEqualTo(1);
        assertThat(triangles.triangle(2, 1, 2)).isEqualTo(2);
    }
}
