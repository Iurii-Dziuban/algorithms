package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LetterCombinationsOfAPhoneNumberTest {

    @Test
    public void test() {
        assertThat(new LetterCombinationsOfAPhoneNumber().letterCombinations("23"))
                .containsExactlyInAnyOrder("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        assertThat(new LetterCombinationsOfAPhoneNumber().letterCombinations("")).isEmpty();

        assertThat(new LetterCombinationsOfAPhoneNumber().letterCombinations("65"))
                .containsExactlyInAnyOrder("mj", "nj", "oj", "mk", "nk", "ok", "ml", "nl", "ol");
    }
}
