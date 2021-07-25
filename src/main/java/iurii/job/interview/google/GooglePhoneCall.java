package iurii.job.interview.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GooglePhoneCall {

    /*
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

    Collect all the indexes of occurred letter

    Map<Character, Set<Integer>>
    a -> 0, 3
    b -> 1
    c -> 2

    Then go through the keySet of Map and for each value in set check same letter in the resulting string

    Time complexity : O(N)
    Memory Complexity : O(N) - because tracking all of the cases.


    Map solution is nice, but what if we have all 26 characters from a to z
    and second string just shifted by 1 position?

    abc...z
    zabc...y

    we can not transform first string into second cause will get into collapsing...
    Can we use intermediate operations - yes.
    There should be additional check if there is no cycle

    Leetcode example : https://leetcode.com/discuss/interview-question/340493/Google-or-Onsite-or-String-Conversion

    Take care of homomorphic /isomorphic changes.

    Leetcode : https://leetcode.com/problems/string-transforms-into-another-string/
*/

    // first attempt
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
     * Note! Not proper solution
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

    // Proper Leetcode Solution
    // Leetcode : https://leetcode.com/problems/string-transforms-into-another-string/
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
