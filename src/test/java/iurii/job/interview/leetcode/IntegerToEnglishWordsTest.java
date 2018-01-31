package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegerToEnglishWordsTest {

    @Test
    public void test() {
        IntegerToEnglishWords integerToEnglishWords = new IntegerToEnglishWords();
        assertThat(integerToEnglishWords.numberToWords(0)).isEqualTo("Zero");
        assertThat(integerToEnglishWords.numberToWords(2_147_483_647)).isEqualTo(
            "Two Billion One Hundred Forty Seven Million Four Hundred Eighty Three Thousand Six Hundred Forty Seven");
        assertThat(integerToEnglishWords.numberToWords(1_115_413_610)).isEqualTo(
                "One Billion One Hundred Fifteen Million Four Hundred Thirteen Thousand Six Hundred Ten");
        assertThat(integerToEnglishWords.numberToWords(120_417_700)).isEqualTo(
                "One Hundred Twenty Million Four Hundred Seventeen Thousand Seven Hundred");
        assertThat(integerToEnglishWords.numberToWords(30_500_711)).isEqualTo(
                "Thirty Million Five Hundred Thousand Seven Hundred Eleven");
        assertThat(integerToEnglishWords.numberToWords(1_819_799)).isEqualTo(
                "One Million Eight Hundred Nineteen Thousand Seven Hundred Ninety Nine");
        assertThat(integerToEnglishWords.numberToWords(812_321)).isEqualTo(
                "Eight Hundred Twelve Thousand Three Hundred Twenty One");
        assertThat(integerToEnglishWords.numberToWords(46_300)).isEqualTo(
                "Forty Six Thousand Three Hundred");
        assertThat(integerToEnglishWords.numberToWords(8_050)).isEqualTo(
                "Eight Thousand Fifty");
    }
}
