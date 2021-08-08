package iurii.job.interview.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
    Task that was given on Google Phone interview:

    There are two strings with same size.
    containing lower case latin (a-z)

    For one string we can do an operation to change all x characters into y at the same time:
    example:

    abca a->d
    dbcd c->e
    dbed b->c
    dced

    Check if we can get from string a using some amount of operation to get string b
    Example:
       abca
       dcga
    Answer : false

    Example:
       aaaa
       aaab
    Answer : false

    all same letter occurrences on the same positions.
    lengths of two strings should be the same.

    Leetcode example : https://leetcode.com/discuss/interview-question/340493/Google-or-Onsite-or-String-Conversion

    Take care of homomorphic /isomorphic changes.

    Leetcode : https://leetcode.com/problems/string-transforms-into-another-string/
*/
public class GooglePhoneCall {

    /**
     * Collect all the indexes of occurred letter
     *
     *     Map<Character, Set<Integer>>
     *     a -> 0, 3
     *     b -> 1
     *     c -> 2
     *
     *     Then go through the keySet of Map and for each value in set check same letter in the resulting string

     *     Map solution is nice, but what if we have all 26 characters from a to z
     *     and second string just shifted by 1 position?
     *
     *     abc...z
     *     zabc...y
     *
     *     we can not transform first string into second cause will get into collapsing...
     *     Can we use intermediate operations - yes.
     *     There should be additional check if there is no cycle
     *
     *     This is kind of graph cycle problem.
     * Time complexity : O(N)
     * Memory Complexity : O(N) - because tracking all the cases.
     * @param a first string
     * @param b second string
     * @return true if it is possible to change a to b
     */
    // first attempt
    // no need to have Map<Character, Set<Integer>> it is enough to have Map<Character, Character>
    // and check if already exists mapping is same.
    // what if all characters are used? -> even if mapping is correct there will be a cycle - not solved here.
    public boolean canTransformNotBest(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        Map<Character, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char character = a.charAt(i);
            if (map.get(character) == null) {
                Set<Integer> indexes = new HashSet<>();
                indexes.add(i);
                map.put(character, indexes);
            } else {
                map.get(character).add(i);
            }
        }
        for (Set<Integer> indexesSet : map.values()) {
            Character firstChar = null;
            for (int index : indexesSet) {
                if (firstChar == null) {
                    firstChar = b.charAt(index);
                } else {
                    if (firstChar != b.charAt(index)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    /**
     * Space Complexity - O(1) = 26 * 1 (number of letters) for Map key-value
     * Time Complexity - O(N) - to check the whole string
     *
     * Note! Not proper solution what is there is a cycle
     * and can we use temporal `letter` to avoid cycles?
     *
     * @param a - start string
     * @param b - end string
     * @return true if possible to convert a -> b
     */
    public boolean canTransformBetter(String a, String b) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char aChar = a.charAt(i);
            if (map.get(aChar) == null) {
                map.put(aChar, b.charAt(i));
            } else {
                char bChar = map.get(aChar);
                if (bChar != b.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Proper Leetcode Solution
     * Leetcode : https://leetcode.com/problems/string-transforms-into-another-string/
     *
     * Checks if there is a cycle and uses spare temporal `letter` to temporal conversion
     * by set.size() < 26
     *
     * if all the characters are used from second word (set.size() == 26):
     * 1. there is no spare letter for conversion
     * 2. if str1 != str2 - there will be a cycle.
     *
     * If there is a spare letter it is always possible to break a cycle.
     *
     * But if two same letters in first string correspond to two  different letters in second string
     * conversion is not possible. This is invariant that does not change.
     *
     * This is a shortcut cycle check solution here.
     * In general, it is better to go via each letter (26 total) and go via mapping and see there is no  cycle.
     *
     * @param str1 first string
     * @param str2 second string
     * @return true if possible to convert str1 -> str2
     */
    public boolean canConvert(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        if (str1.equals(str2)) {
            return true;
        }
        int length = str1.length();
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if (map.containsKey(c1) && map.get(c1) != c2) {
                return false;
            } else {
                map.put(c1,c2);
                set.add(c2);
            }
        }
        // set.size < 26 - there is at least one letter not used in s2 to be used for cycle/temp conversion.
        return set.size() < 26;
    }
}
