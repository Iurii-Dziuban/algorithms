package iurii.job.interview.selection.randomized;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 01/08/2017.
 */
public class RandomizedSelectionTest {
    @Test
    public void test() {
        assertThat(new RandomizedSelection().select(new int[]{9, 6, 1, 4, 5, 7, 8}, 4)).isEqualTo(7);
    }
}
