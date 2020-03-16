package iurii.job.interview.codility.sixt;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Write a function  boolean isAnagram(String lhs, String rhs).
 * An anagram is direct word switch or word play,
 * the result of rearranging the letters of a word or phrase to produce a new word or phrase,
 * using all the original letters exactly once;
 * for example, the word ‘anagram' can be rearranged into ‘nagaram’.
 */
public class Anagram {

    /**
     * One of the easiest solutions is to sort both strings and when check
     * two sorted strings to be equal.
     * Time complexity: O(NlogN) where N is the length of the string NlogN for sorting ex. MergeSort,
     *     because in case QuickSort worst case can be O(N^2)
     * Auxiliary space complexity: O(N) to store sorted strings
     *
     * Better solution could be with using character counting, using HashMap.
     * (Or if we know character set even array can be used)
     * and checking that characters are the same in both strings.
     * Time complexity: O(N) adding and looking up character in HashMap O(1) and needed N times for each character
     * Auxiliary space complexity: O(N) to store the HashMap
     * Solution is below
     */
    public boolean isAnagram(String lhs, String rhs) {
        Objects.requireNonNull(lhs);
        Objects.requireNonNull(rhs);
        if (lhs.length() != rhs.length()) {
            return false;
        }
        // count characters in characterToCountMap
        Map<Character, Integer> characterToCountMap = new HashMap<>();
        for (int i = 0; i < lhs.length(); i++) {
            char curChar = lhs.charAt(i);
            characterToCountMap.merge(curChar, 1, (oldValue, newValue) -> oldValue + newValue);
        }
        // decrease count of equal characters in characterToCountMap
        for (int i = 0; i < rhs.length(); i++) {
            char curChar = rhs.charAt(i);
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
