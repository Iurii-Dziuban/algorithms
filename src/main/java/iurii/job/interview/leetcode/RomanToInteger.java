package iurii.job.interview.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer https://leetcode.com/problems/roman-to-integer/description/
 * <p>
 * https://www.geeksforgeeks.org/converting-roman-numerals-decimal-lying-1-3999/
 * <p>
 *
 * Idea similar to reverse {@link IntegerToRoman}
 *
 * Dynamic algorithm can be used with array O(N) and without array O(1) extra space
 *
 * Time complexity: O(N) where N is the length of the roman string
 * Auxiliary Space complexity: O(1) constant length to store result and mapping for symbols
 */
public class RomanToInteger {

    private final static Map<String, Integer> stringMap = new HashMap<>();

    static {
        stringMap.put("M", 1000);
        stringMap.put("CM", 900);
        stringMap.put("D", 500);
        stringMap.put("CD", 400);
        stringMap.put("C", 100);
        stringMap.put("XC", 90);
        stringMap.put("L", 50);
        stringMap.put("XL", 40);
        stringMap.put("X", 10);
        stringMap.put("IX", 9);
        stringMap.put("V", 5);
        stringMap.put("IV", 4);
        stringMap.put("I", 1);
    }

    public int romanToIntWithSubstring(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer value = null;
            if (i + 2 <= s.length()) {
                String twoChars = s.substring(i, i + 2);
                value = stringMap.get(twoChars);
                if (value != null) {
                    result += value;
                    i++;
                }
            }
            if (value == null) {
                result += stringMap.get(s.substring(i, i + 1));
            }
        }
        return result;
    }

    public int romanToIntDynamicArray(String s) {
        int result = 0;
        int[] num = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            num[i] = charMap.get(s.charAt(i));
        }
        for (int j = 0; j < num.length - 1; j++) {
            if (num[j] < num[j + 1]) {
                result -= num[j];
            } else {
                result += num[j];
            }
        }
        return result + num[num.length - 1];
    }

    private final static Map<Character, Integer> charMap = new HashMap<>();

    static {
        charMap.put('M', 1000);
        charMap.put('D', 500);
        charMap.put('C', 100);
        charMap.put('L', 50);
        charMap.put('X', 10);
        charMap.put('V', 5);
        charMap.put('I', 1);
    }

    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = charMap.get(s.charAt(i));
            if (i + 1 < s.length()) {
                int nextValue = charMap.get(s.charAt(i + 1));
                if (nextValue > value) {
                    result += nextValue - value;
                    i++;
                } else {
                    result += value;
                }
            } else {
                result += value;
            }
        }
        return result;
    }

    public int romanToIntBasedOnPrev(String s) {
        int result = 0;
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = charMap.get(s.charAt(i));
            if (prev < value) {
                result -= 2 * prev;
            }
            result += value;
            prev = value;
        }
        return result;
    }
}
