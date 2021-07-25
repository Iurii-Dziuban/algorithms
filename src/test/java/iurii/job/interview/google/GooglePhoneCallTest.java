package iurii.job.interview.google;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GooglePhoneCallTest {

    @Test
    public void testCanTransform() {
        GooglePhoneCall googlePhoneCall = new GooglePhoneCall();

        // when / then
        assertThat(googlePhoneCall.canTransformNotBest("abca", "dced")).isTrue();
        assertThat(googlePhoneCall.canTransformBetter("abca", "dced")).isTrue();
        assertThat(googlePhoneCall.canConvert("abca", "dced")).isTrue();

        assertThat(googlePhoneCall.canTransformNotBest("abca", "dcga")).isFalse();
        assertThat(googlePhoneCall.canTransformBetter("abca", "dcga")).isFalse();
        assertThat(googlePhoneCall.canConvert("abca", "dcga")).isFalse();

        assertThat(googlePhoneCall.canTransformNotBest("aaaa", "aaab")).isFalse();
        assertThat(googlePhoneCall.canTransformBetter("aaaa", "aaab")).isFalse();
        assertThat(googlePhoneCall.canConvert("aaaa", "aaab")).isFalse();

        assertThat(googlePhoneCall.canTransformNotBest("abcd", "bcda")).isTrue();
        assertThat(googlePhoneCall.canTransformBetter("abcd", "bcda")).isTrue();
        assertThat(googlePhoneCall.canConvert("abcd", "bcda")).isTrue();

        assertThat(googlePhoneCall.canTransformNotBest("abcdefghijklmnopqrstuvwxyz", "bcdefghijklmnopqrstuvwxyza")).isTrue();
        assertThat(googlePhoneCall.canTransformBetter("abcdefghijklmnopqrstuvwxyz", "bcdefghijklmnopqrstuvwxyza")).isTrue();
        assertThat(googlePhoneCall.canConvert("abcdefghijklmnopqrstuvwxyz", "bcdefghijklmnopqrstuvwxyza")).isFalse();
    }

}