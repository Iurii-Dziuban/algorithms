package iurii.job.interview.leetcode;

import java.util.TreeMap;

/**
 * 12. Integer to Roman https://leetcode.com/problems/integer-to-roman/description/
 *
 * https://stackoverflow.com/questions/12967896/converting-integers-to-roman-numerals-java
 */
public class IntegerToRoman {

    private final static TreeMap<Integer, String> map = new TreeMap<>();

    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public String intToRomanWithTreeMap(int number) {
        StringBuilder result = new StringBuilder();
        while (number != 0) {
            int value =  map.floorKey(number);
            result.append(map.get(value));
            number -= value;
        }
        return result.toString();
    }

    public String intToRomanWithArrays(int number) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[number / 1000] + C[(number % 1000) / 100] + X[(number % 100) / 10] + I[number % 10];
    }
}
