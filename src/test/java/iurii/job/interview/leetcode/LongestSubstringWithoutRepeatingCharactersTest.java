package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    public void testOnBooleanArray() {
        LongestSubstringWithoutRepeatingCharacters instance = new LongestSubstringWithoutRepeatingCharacters();

        assertThat(instance.lengthOfLongestSubstring("abba")).isEqualTo(2);
        assertThat(instance.lengthOfLongestSubstring("abcabcbb")).isEqualTo(3);
        assertThat(instance.lengthOfLongestSubstring("bbbbbbb")).isEqualTo(1);
        assertThat(instance.lengthOfLongestSubstring("pwwkew")).isEqualTo(3);
    }

    @Test
    public void testOnIntNextStepArray() {
        LongestSubstringWithoutRepeatingCharacters instance = new LongestSubstringWithoutRepeatingCharacters();

        assertThat(instance.lengthOfLongestSubstringLeftJump("abba")).isEqualTo(2);
        assertThat(instance.lengthOfLongestSubstringLeftJump("abcabcbb")).isEqualTo(3);
        assertThat(instance.lengthOfLongestSubstringLeftJump("bbbbbbb")).isEqualTo(1);
        assertThat(instance.lengthOfLongestSubstringLeftJump("pwwkew")).isEqualTo(3);
    }
}
