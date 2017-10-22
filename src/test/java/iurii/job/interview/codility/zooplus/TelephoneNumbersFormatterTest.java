package iurii.job.interview.codility.zooplus;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IuriiDziuban on 10/22/17.
 */
public class TelephoneNumbersFormatterTest {

    @Test
    public void test() {
        TelephoneNumbersFormatter telephoneNumbersFormatter = new TelephoneNumbersFormatter();
        assertThat(telephoneNumbersFormatter.format("00-44  48 5555 8361")).isEqualTo("004-448-555-583-61");
        assertThat(telephoneNumbersFormatter.format("0 - 22 1985--324")).isEqualTo("022-198-53-24");
        assertThat(telephoneNumbersFormatter.format("555372654")).isEqualTo("555-372-654");
        assertThat(telephoneNumbersFormatter.format("333")).isEqualTo("333");
        assertThat(telephoneNumbersFormatter.format("22")).isEqualTo("22");
        assertThat(telephoneNumbersFormatter.format("1")).isEqualTo("1");
    }
}
