package iurii.job.interview.codility.cliqz;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IuriiDziuban on 10/29/17.
 */
public class KcomplementaryTest {

    @Test
    public void test() {
        assertThat(new Kcomplementary().solution(6, new int[]{1, 8, -3, 0, 1, 3, -2, 4, 5})).isEqualTo(7);
        assertThat(new Kcomplementary().solution(2, new int[]{1, 1, 5, 0})).isEqualTo(4);
        assertThat(new Kcomplementary().solution(2, new int[]{1, 1, 1, 5, 0})).isEqualTo(9);
        assertThat(new Kcomplementary().solution(0, new int[]{-2147483647, 2147483647})).isEqualTo(2);
        assertThat(new Kcomplementary().solution(-2147483647, new int[]{-2147483647, 0})).isEqualTo(2);
        assertThat(new Kcomplementary().solution(-2147483647, new int[]{-2147483647, 0, 3})).isEqualTo(2);
    }
}
