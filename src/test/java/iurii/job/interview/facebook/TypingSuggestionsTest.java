package iurii.job.interview.facebook;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 07/11/2017.
 */
public class TypingSuggestionsTest {

    @Test
    public void test() {
        assertThat(new TypingSuggestions().getNearbyWords("gi")).containsExactlyInAnyOrder("go", "hi");
        assertThat(new TypingSuggestions().getNearbyWords("")).isEmpty();
        assertThat(new TypingSuggestions().getNearbyWords(null)).isEmpty();
    }
}
