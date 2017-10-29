package iurii.job.interview.codility.cliqz;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IuriiDziuban on 10/29/17.
 */
public class ArrayJumpsTest {

    @Test
    public void test() {
        assertThat(new ArrayJumps().countJumps(new int[]{1, 1, -1, 1})).isEqualTo(-1);
        assertThat(new ArrayJumps().countJumps(new int[]{2, 3, -1, 1, 3})).isEqualTo(4);
    }
}
