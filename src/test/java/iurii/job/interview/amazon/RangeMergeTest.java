package iurii.job.interview.amazon;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

/**
 *
 * Created by iurii.dziuban on 06/11/2017.
 */
public class RangeMergeTest {

    @Test
    public void test() {
        assertThat(new RangeMerge().encodeRanges(null)).isEmpty();
        assertThat(new RangeMerge().encodeRanges(new int[]{})).isEmpty();
        assertThat(new RangeMerge().encodeRanges(new int[]{1})).containsExactly(entry(1,1));
        assertThat(new RangeMerge().encodeRanges(new int[]{1,2,2,3,5,8,9,11,12}))
                .containsExactly(entry(1,3), entry(5,5), entry(8,9), entry(11,12));
    }
}
