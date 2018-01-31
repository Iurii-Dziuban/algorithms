package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegerToRomanTest {

    @Test
    public void testWithArrays() {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        assertThat(integerToRoman.intToRomanWithArrays(1)).isEqualTo("I");
        assertThat(integerToRoman.intToRomanWithArrays(2)).isEqualTo("II");
        assertThat(integerToRoman.intToRomanWithArrays(3)).isEqualTo("III");
        assertThat(integerToRoman.intToRomanWithArrays(4)).isEqualTo("IV");
        assertThat(integerToRoman.intToRomanWithArrays(5)).isEqualTo("V");
        assertThat(integerToRoman.intToRomanWithArrays(6)).isEqualTo("VI");
        assertThat(integerToRoman.intToRomanWithArrays(7)).isEqualTo("VII");
        assertThat(integerToRoman.intToRomanWithArrays(8)).isEqualTo("VIII");
        assertThat(integerToRoman.intToRomanWithArrays(9)).isEqualTo("IX");
        assertThat(integerToRoman.intToRomanWithArrays(10)).isEqualTo("X");
        assertThat(integerToRoman.intToRomanWithArrays(11)).isEqualTo("XI");
        assertThat(integerToRoman.intToRomanWithArrays(41)).isEqualTo("XLI");
        assertThat(integerToRoman.intToRomanWithArrays(51)).isEqualTo("LI");
        assertThat(integerToRoman.intToRomanWithArrays(81)).isEqualTo("LXXXI");
        assertThat(integerToRoman.intToRomanWithArrays(91)).isEqualTo("XCI");
        assertThat(integerToRoman.intToRomanWithArrays(103)).isEqualTo("CIII");
        assertThat(integerToRoman.intToRomanWithArrays(142)).isEqualTo("CXLII");
        assertThat(integerToRoman.intToRomanWithArrays(157)).isEqualTo("CLVII");
        assertThat(integerToRoman.intToRomanWithArrays(184)).isEqualTo("CLXXXIV");
        assertThat(integerToRoman.intToRomanWithArrays(414)).isEqualTo("CDXIV");
        assertThat(integerToRoman.intToRomanWithArrays(511)).isEqualTo("DXI");
        assertThat(integerToRoman.intToRomanWithArrays(809)).isEqualTo("DCCCIX");
        assertThat(integerToRoman.intToRomanWithArrays(908)).isEqualTo("CMVIII");
        assertThat(integerToRoman.intToRomanWithArrays(1005)).isEqualTo("MV");
        assertThat(integerToRoman.intToRomanWithArrays(3999)).isEqualTo("MMMCMXCIX");
    }

    @Test
    public void testWithTreeMap() {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        assertThat(integerToRoman.intToRomanWithTreeMap(1)).isEqualTo("I");
        assertThat(integerToRoman.intToRomanWithTreeMap(2)).isEqualTo("II");
        assertThat(integerToRoman.intToRomanWithTreeMap(3)).isEqualTo("III");
        assertThat(integerToRoman.intToRomanWithTreeMap(4)).isEqualTo("IV");
        assertThat(integerToRoman.intToRomanWithTreeMap(5)).isEqualTo("V");
        assertThat(integerToRoman.intToRomanWithTreeMap(6)).isEqualTo("VI");
        assertThat(integerToRoman.intToRomanWithTreeMap(7)).isEqualTo("VII");
        assertThat(integerToRoman.intToRomanWithTreeMap(8)).isEqualTo("VIII");
        assertThat(integerToRoman.intToRomanWithTreeMap(9)).isEqualTo("IX");
        assertThat(integerToRoman.intToRomanWithTreeMap(10)).isEqualTo("X");
        assertThat(integerToRoman.intToRomanWithTreeMap(11)).isEqualTo("XI");
        assertThat(integerToRoman.intToRomanWithTreeMap(41)).isEqualTo("XLI");
        assertThat(integerToRoman.intToRomanWithTreeMap(51)).isEqualTo("LI");
        assertThat(integerToRoman.intToRomanWithTreeMap(81)).isEqualTo("LXXXI");
        assertThat(integerToRoman.intToRomanWithTreeMap(91)).isEqualTo("XCI");
        assertThat(integerToRoman.intToRomanWithTreeMap(103)).isEqualTo("CIII");
        assertThat(integerToRoman.intToRomanWithTreeMap(142)).isEqualTo("CXLII");
        assertThat(integerToRoman.intToRomanWithTreeMap(157)).isEqualTo("CLVII");
        assertThat(integerToRoman.intToRomanWithTreeMap(184)).isEqualTo("CLXXXIV");
        assertThat(integerToRoman.intToRomanWithTreeMap(414)).isEqualTo("CDXIV");
        assertThat(integerToRoman.intToRomanWithTreeMap(511)).isEqualTo("DXI");
        assertThat(integerToRoman.intToRomanWithTreeMap(809)).isEqualTo("DCCCIX");
        assertThat(integerToRoman.intToRomanWithTreeMap(908)).isEqualTo("CMVIII");
        assertThat(integerToRoman.intToRomanWithTreeMap(1005)).isEqualTo("MV");
        assertThat(integerToRoman.intToRomanWithTreeMap(3999)).isEqualTo("MMMCMXCIX");
    }
}
