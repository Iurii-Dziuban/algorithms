package iurii.job.interview.facebook;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IuriiDziuban on 10/22/17.
 */
public class IceCapsMeltingTest {

    @Test
    public void test() {
        IceCapsMelting iceCapsMelting = new IceCapsMelting();
        assertThat(iceCapsMelting.maxDifference(new int[]{26, 52, 23, 30, 28, 50, 13, 10, 25})).isEqualTo(27);
        assertThat(iceCapsMelting.maxDifference(new int[]{10, 20, 30, 40, 50})).isEqualTo(40);
        assertThat(iceCapsMelting.maxDifference(new int[]{23, 55, 67, 22, 40, 65, 44, 20})).isEqualTo(44);
    }
}
