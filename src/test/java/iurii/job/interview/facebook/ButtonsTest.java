package iurii.job.interview.facebook;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IuriiDziuban on 10/22/17.
 */
public class ButtonsTest {

    @Test
    public void test() {
        Buttons buttons = new Buttons();
        assertThat(buttons.calculate(1)).isEqualTo(2);
        assertThat(buttons.calculate(2)).isEqualTo(5);
        assertThat(buttons.calculate(3)).isEqualTo(10);
    }
}
