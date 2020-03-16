package iurii.job.interview.topcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Anagrams {

    public static void main(String[] args) {
        System.out.println(isAnagram("hellome", "meelloh"));
        System.out.println(isAnagram("hellome", "metello"));

    }

    private static boolean isAnagram(String standard, String test) {
        Objects.requireNonNull(standard);
        Objects.requireNonNull(test);
        if (standard.length() != test.length()) {
            return false;
        }
        // count characters in characterToCountMap
        Map<Character, Integer> characterToCountMap = new HashMap<>();
        for (int i = 0; i < standard.length(); i++) {
            char curChar = standard.charAt(i);
            characterToCountMap.merge(curChar, 1, (oldValue, newValue) -> oldValue + newValue);
        }
        // decrease count of equal characters in characterToCountMap
        for (int i = 0; i < test.length(); i++) {
            char curChar = test.charAt(i);
            if (!characterToCountMap.containsKey(curChar)) {
                return false;
            }
            int count = characterToCountMap.get(curChar);
            if (count == 1) {
                characterToCountMap.remove(curChar);
            } else {
                characterToCountMap.put(curChar, count - 1);
            }
        }
        return characterToCountMap.isEmpty();
    }

}
