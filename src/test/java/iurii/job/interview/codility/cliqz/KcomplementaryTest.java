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
    }
}
