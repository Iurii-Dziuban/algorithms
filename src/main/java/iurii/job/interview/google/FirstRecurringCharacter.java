package iurii.job.interview.google;

import java.util.HashSet;
import java.util.Set;

/**
 * Find in the string first recurring character and return it else return null
 * https://www.youtube.com/watch?v=GJdiM-muYqc
 *
 * Similar to {@link TwoPairParticularSum}
 * Similar to {@link iurii.job.interview.leetcode.TwoSum}
 *
 * Time complexity: O(min(N, M))
 * Auxiliary space complexity: O(min(N, M))
 * N - string length
 * M - size of alphabet (number of different characters in the string)
 */
public class FirstRecurringCharacter {

    // set is enough to find the character in case index Map should be used
    public Character firstRecurringCharacter(String s) {
        Set<Character> seenCharacters = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (seenCharacters.contains(c)) {
                return c;
            } else {
                seenCharacters.add(c);
            }
        }
        return null;
    }
}
