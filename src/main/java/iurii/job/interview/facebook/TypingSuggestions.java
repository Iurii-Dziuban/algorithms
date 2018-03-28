package iurii.job.interview.facebook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * When typing on touch screen, occasionally the wrong key is registered
 *
 * For example "Hello", a "G" might be registered instead of "H"
 *
 * Write a function that given a string, returns all nearby words
 *
 * https://www.facebook.com/Engineering/videos/10152735777427200/
 *
 * Similar to AllSubsetsOfASet https://www.youtube.com/watch?v=bGC2fNALbNU
 *
 * Time complexity: O(n^k) where n - length and k -
 * Auxiliary space complexity:
 * Created by iurii.dziuban on 07/11/2017.
 */
public class TypingSuggestions {

    private Map<String, Set<String>> nearbyMap = new HashMap<>();
    private Set<String> words = new HashSet<>();

    {
        nearbyMap.put("g", new HashSet<String>(){{this.add("g"); this.add("h"); this.add("f");}});
        nearbyMap.put("i", new HashSet<String>(){{this.add("i"); this.add("o"); this.add("k");}});
        words.add("go");
        words.add("hi");
    }

    public Set<String> getNearbyWords(String word) {
        if (word == null) {
            return new HashSet<>();
        }
        String[] letters = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            letters[i] = Character.toString(word.charAt(i));
        }
        Set<String> possibleWords = nearbyPermutations(letters, 0);
        return possibleWords.stream().filter(this::isWord).collect(Collectors.toSet());
    }

    private Set<String> nearbyPermutations(String[] letters, int index) {
        if (index >= letters.length) {
            return new HashSet<String>() {{add("");}};
        }
        Set<String> subWords = nearbyPermutations(letters, index + 1);
        Set<String> nearbyChars = getNearbyChars(letters[index]);
        Set<String> permutations = new HashSet<>();
        for(String character : nearbyChars) {
            for(String subWord : subWords) {
                permutations.add(character + subWord);
            }
        }
        return  permutations;
    }

    // helper functions

    private Set<String> getNearbyChars(String character) {
        return nearbyMap.get(character);
    }

    private boolean isWord(String word) {
        return words.contains(word);
    }
}
