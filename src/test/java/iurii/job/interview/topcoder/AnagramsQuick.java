package iurii.job.interview.topcoder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.workinestonia.com/challenge/tests/
 * Test assignment : https://testyourself.helmes.ee/
 *
 * Hints for solution: http://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/
 *
 * Created by iurii.dziuban on 06/11/2017.
 */
public class AnagramsQuick {

    public List<String> findAnagramsQuickly(String pathToFile, String word) {
        long startTime = System.nanoTime();
        List<String> result = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(pathToFile), "Cp1252");
            char[] wordChars = word.toLowerCase().toCharArray();
            Map<Character, Integer> countMap = new HashMap<>();
            for(char character : wordChars) {
                countMap.put(character,countMap.getOrDefault(character, 0) + 1);
            }

            while (sc.hasNextLine()) {
                String curWord = sc.nextLine();
                if (curWord.length() == word.length()) {
                    if (isAnagram(curWord, new HashMap<>(countMap))) {
                        result.add(curWord);
                    }
                }
            }
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        System.out.println("Nano seconds taken:" + (System.nanoTime() - startTime));
        return result;
    }

    private boolean isAnagram(String curWord, Map<Character, Integer> countMap) {
        char[] curWordChars = curWord.toLowerCase().toCharArray();
        for(char character : curWordChars) {
            Integer value = countMap.get(character);
            if (value != null && value != 0) {
                if (value == 1) {
                    countMap.remove(character);
                } else {
                    countMap.put(character, value - 1);
                }
            } else {
                return false;
            }
        }
        return countMap.isEmpty();
    }
}
