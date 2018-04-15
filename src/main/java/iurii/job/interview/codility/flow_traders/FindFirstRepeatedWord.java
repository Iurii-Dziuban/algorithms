package iurii.job.interview.codility.flow_traders;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstRepeatedWord {

    public String firstRepeatedWordStream(String s) {
        String[] words = s.split("[:;\\-.,\\t\\s]+");
        Map<String, Long> wordsCount = Arrays.stream(words).collect(
                Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        return wordsCount.entrySet().stream()
                .filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).findFirst().orElse(null);
    }

    public String firstRepeatedWordNonStream(String s) {
        String[] words = s.split("[:;\\-.,\\t\\s]+");
        Set<String> seenWords = new HashSet<>();
        for(String word : words) {
            if(seenWords.contains(word)) {
                return word;
            } else {
                seenWords.add(word);
            }
        }
        return null;
    }
}
