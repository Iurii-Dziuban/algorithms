package iurii.job.interview.selection.deterministic;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 01/08/2017.
 */
public class DeterministicSelectionTest {
    @Test
    public void test() {
        assertThat(new DeterministicSelection().select(new int[]{9, 6, 1, 4, 5, 7, 8}, 4)).isEqualTo(7);

        // fix
        //assertThat(new DeterministicSelection().select(new int[]{9, 6, 1, 4, 5, 7, 8, 0, 2, 3, 10, 11}, 4)).isEqualTo(5);
    }
}
