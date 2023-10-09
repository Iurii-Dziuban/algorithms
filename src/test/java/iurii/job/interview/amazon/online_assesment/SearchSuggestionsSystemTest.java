package iurii.job.interview.amazon.online_assesment;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchSuggestionsSystemTest {

    @Test
    public void searchSuggestionsTrieAndDfs() {
        SearchSuggestionsSystem searchSuggestionsSystem = new SearchSuggestionsSystem();
        String[] products1 = new String[] {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord1 = "mouse";

        List<List<String>> answer1 = searchSuggestionsSystem.searchSuggestionsTrieAndDfs(products1, searchWord1);
        List<List<String>> expected1 = new ArrayList<>();
        expected1.add(Arrays.asList("mobile", "moneypot", "monitor"));
        expected1.add(Arrays.asList("mouse", "mousepad"));
        expected1.add(Arrays.asList("mouse", "mousepad"));
        expected1.add(Arrays.asList("mouse", "mousepad"));

        assertThat(answer1).isEqualTo(expected1);

        String[] products2 = new String[] {"havana"};
        String searchWord2 = "havana";

        List<List<String>> answer2 = searchSuggestionsSystem.searchSuggestionsTrieAndDfs(products2, searchWord2);
        List<List<String>> expected2 = new ArrayList<>();
        expected2.add(Arrays.asList("havana"));
        expected2.add(Arrays.asList("havana"));
        expected2.add(Arrays.asList("havana"));
        expected2.add(Arrays.asList("havana"));
        expected2.add(Arrays.asList("havana"));

        assertThat(answer2).isEqualTo(expected2);

        List<List<String>> answerBinarySearch1 = searchSuggestionsSystem.searchSuggestionsWithBinarySearch(products1, searchWord1);
        assertThat(answerBinarySearch1).isEqualTo(expected1);

    }
}