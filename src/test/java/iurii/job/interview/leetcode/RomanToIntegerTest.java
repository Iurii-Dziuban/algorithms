package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanToIntegerTest {
    
    @Test
    public void testWithDynamicArray() {
        RomanToInteger romanToInteger = new RomanToInteger();
        assertThat(romanToInteger.romanToIntDynamicArray("I")).isEqualTo(1);
        assertThat(romanToInteger.romanToIntDynamicArray("II")).isEqualTo(2);
        assertThat(romanToInteger.romanToIntDynamicArray("III")).isEqualTo(3);
        assertThat(romanToInteger.romanToIntDynamicArray("IV")).isEqualTo(4);
        assertThat(romanToInteger.romanToIntDynamicArray("V")).isEqualTo(5);
        assertThat(romanToInteger.romanToIntDynamicArray("VI")).isEqualTo(6);
        assertThat(romanToInteger.romanToIntDynamicArray("VII")).isEqualTo(7);
        assertThat(romanToInteger.romanToIntDynamicArray("VIII")).isEqualTo(8);
        assertThat(romanToInteger.romanToIntDynamicArray("IX")).isEqualTo(9);
        assertThat(romanToInteger.romanToIntDynamicArray("X")).isEqualTo(10);
        assertThat(romanToInteger.romanToIntDynamicArray("XI")).isEqualTo(11);
        assertThat(romanToInteger.romanToIntDynamicArray("XLI")).isEqualTo(41);
        assertThat(romanToInteger.romanToIntDynamicArray("LI")).isEqualTo(51);
        assertThat(romanToInteger.romanToIntDynamicArray("LXXXI")).isEqualTo(81);
        assertThat(romanToInteger.romanToIntDynamicArray("XCI")).isEqualTo(91);
        assertThat(romanToInteger.romanToIntDynamicArray("CIII")).isEqualTo(103);
        assertThat(romanToInteger.romanToIntDynamicArray("CXLII")).isEqualTo(142);
        assertThat(romanToInteger.romanToIntDynamicArray("CLVII")).isEqualTo(157);
        assertThat(romanToInteger.romanToIntDynamicArray("CLXXXIV")).isEqualTo(184);
        assertThat(romanToInteger.romanToIntDynamicArray("CDXIV")).isEqualTo(414);
        assertThat(romanToInteger.romanToIntDynamicArray("DXI")).isEqualTo(511);
        assertThat(romanToInteger.romanToIntDynamicArray("DCCCIX")).isEqualTo(809);
        assertThat(romanToInteger.romanToIntDynamicArray("CMVIII")).isEqualTo(908);
        assertThat(romanToInteger.romanToIntDynamicArray("MV")).isEqualTo(1005);
        assertThat(romanToInteger.romanToIntDynamicArray("MMMCMXCIX")).isEqualTo(3999);
    }

    @Test
    public void testWithSubstring() {
        RomanToInteger romanToInteger = new RomanToInteger();
        assertThat(romanToInteger.romanToIntWithSubstring("I")).isEqualTo(1);
        assertThat(romanToInteger.romanToIntWithSubstring("II")).isEqualTo(2);
        assertThat(romanToInteger.romanToIntWithSubstring("III")).isEqualTo(3);
        assertThat(romanToInteger.romanToIntWithSubstring("IV")).isEqualTo(4);
        assertThat(romanToInteger.romanToIntWithSubstring("V")).isEqualTo(5);
        assertThat(romanToInteger.romanToIntWithSubstring("VI")).isEqualTo(6);
        assertThat(romanToInteger.romanToIntWithSubstring("VII")).isEqualTo(7);
        assertThat(romanToInteger.romanToIntWithSubstring("VIII")).isEqualTo(8);
        assertThat(romanToInteger.romanToIntWithSubstring("IX")).isEqualTo(9);
        assertThat(romanToInteger.romanToIntWithSubstring("X")).isEqualTo(10);
        assertThat(romanToInteger.romanToIntWithSubstring("XI")).isEqualTo(11);
        assertThat(romanToInteger.romanToIntWithSubstring("XLI")).isEqualTo(41);
        assertThat(romanToInteger.romanToIntWithSubstring("LI")).isEqualTo(51);
        assertThat(romanToInteger.romanToIntWithSubstring("LXXXI")).isEqualTo(81);
        assertThat(romanToInteger.romanToIntWithSubstring("XCI")).isEqualTo(91);
        assertThat(romanToInteger.romanToIntWithSubstring("CIII")).isEqualTo(103);
        assertThat(romanToInteger.romanToIntWithSubstring("CXLII")).isEqualTo(142);
        assertThat(romanToInteger.romanToIntWithSubstring("CLVII")).isEqualTo(157);
        assertThat(romanToInteger.romanToIntWithSubstring("CLXXXIV")).isEqualTo(184);
        assertThat(romanToInteger.romanToIntWithSubstring("CDXIV")).isEqualTo(414);
        assertThat(romanToInteger.romanToIntWithSubstring("DXI")).isEqualTo(511);
        assertThat(romanToInteger.romanToIntWithSubstring("DCCCIX")).isEqualTo(809);
        assertThat(romanToInteger.romanToIntWithSubstring("CMVIII")).isEqualTo(908);
        assertThat(romanToInteger.romanToIntWithSubstring("MV")).isEqualTo(1005);
        assertThat(romanToInteger.romanToIntWithSubstring("MMMCMXCIX")).isEqualTo(3999);
    }

    @Test
    public void testBasedOnPrev() {
        RomanToInteger romanToInteger = new RomanToInteger();
        assertThat(romanToInteger.romanToIntBasedOnPrev("I")).isEqualTo(1);
        assertThat(romanToInteger.romanToIntBasedOnPrev("II")).isEqualTo(2);
        assertThat(romanToInteger.romanToIntBasedOnPrev("III")).isEqualTo(3);
        assertThat(romanToInteger.romanToIntBasedOnPrev("IV")).isEqualTo(4);
        assertThat(romanToInteger.romanToIntBasedOnPrev("V")).isEqualTo(5);
        assertThat(romanToInteger.romanToIntBasedOnPrev("VI")).isEqualTo(6);
        assertThat(romanToInteger.romanToIntBasedOnPrev("VII")).isEqualTo(7);
        assertThat(romanToInteger.romanToIntBasedOnPrev("VIII")).isEqualTo(8);
        assertThat(romanToInteger.romanToIntBasedOnPrev("IX")).isEqualTo(9);
        assertThat(romanToInteger.romanToIntBasedOnPrev("X")).isEqualTo(10);
        assertThat(romanToInteger.romanToIntBasedOnPrev("XI")).isEqualTo(11);
        assertThat(romanToInteger.romanToIntBasedOnPrev("XLI")).isEqualTo(41);
        assertThat(romanToInteger.romanToIntBasedOnPrev("LI")).isEqualTo(51);
        assertThat(romanToInteger.romanToIntBasedOnPrev("LXXXI")).isEqualTo(81);
        assertThat(romanToInteger.romanToIntBasedOnPrev("XCI")).isEqualTo(91);
        assertThat(romanToInteger.romanToIntBasedOnPrev("CIII")).isEqualTo(103);
        assertThat(romanToInteger.romanToIntBasedOnPrev("CXLII")).isEqualTo(142);
        assertThat(romanToInteger.romanToIntBasedOnPrev("CLVII")).isEqualTo(157);
        assertThat(romanToInteger.romanToIntBasedOnPrev("CLXXXIV")).isEqualTo(184);
        assertThat(romanToInteger.romanToIntBasedOnPrev("CDXIV")).isEqualTo(414);
        assertThat(romanToInteger.romanToIntBasedOnPrev("DXI")).isEqualTo(511);
        assertThat(romanToInteger.romanToIntBasedOnPrev("DCCCIX")).isEqualTo(809);
        assertThat(romanToInteger.romanToIntBasedOnPrev("CMVIII")).isEqualTo(908);
        assertThat(romanToInteger.romanToIntBasedOnPrev("MV")).isEqualTo(1005);
        assertThat(romanToInteger.romanToIntBasedOnPrev("MMMCMXCIX")).isEqualTo(3999);
    }

    @Test
    public void test() {
        RomanToInteger romanToInteger = new RomanToInteger();
        assertThat(romanToInteger.romanToInt("I")).isEqualTo(1);
        assertThat(romanToInteger.romanToInt("II")).isEqualTo(2);
        assertThat(romanToInteger.romanToInt("III")).isEqualTo(3);
        assertThat(romanToInteger.romanToInt("IV")).isEqualTo(4);
        assertThat(romanToInteger.romanToInt("V")).isEqualTo(5);
        assertThat(romanToInteger.romanToInt("VI")).isEqualTo(6);
        assertThat(romanToInteger.romanToInt("VII")).isEqualTo(7);
        assertThat(romanToInteger.romanToInt("VIII")).isEqualTo(8);
        assertThat(romanToInteger.romanToInt("IX")).isEqualTo(9);
        assertThat(romanToInteger.romanToInt("X")).isEqualTo(10);
        assertThat(romanToInteger.romanToInt("XI")).isEqualTo(11);
        assertThat(romanToInteger.romanToInt("XLI")).isEqualTo(41);
        assertThat(romanToInteger.romanToInt("LI")).isEqualTo(51);
        assertThat(romanToInteger.romanToInt("LXXXI")).isEqualTo(81);
        assertThat(romanToInteger.romanToInt("XCI")).isEqualTo(91);
        assertThat(romanToInteger.romanToInt("CIII")).isEqualTo(103);
        assertThat(romanToInteger.romanToInt("CXLII")).isEqualTo(142);
        assertThat(romanToInteger.romanToInt("CLVII")).isEqualTo(157);
        assertThat(romanToInteger.romanToInt("CLXXXIV")).isEqualTo(184);
        assertThat(romanToInteger.romanToInt("CDXIV")).isEqualTo(414);
        assertThat(romanToInteger.romanToInt("DXI")).isEqualTo(511);
        assertThat(romanToInteger.romanToInt("DCCCIX")).isEqualTo(809);
        assertThat(romanToInteger.romanToInt("CMVIII")).isEqualTo(908);
        assertThat(romanToInteger.romanToInt("MV")).isEqualTo(1005);
        assertThat(romanToInteger.romanToInt("MMMCMXCIX")).isEqualTo(3999);
    }
}
