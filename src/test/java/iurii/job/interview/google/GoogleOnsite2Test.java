package iurii.job.interview.google;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.mockito.internal.util.collections.Sets;

public class GoogleOnsite2Test {

    private final GoogleOnsite2 google = new GoogleOnsite2();

    @Test
    public void findAllPossibleMessages() {
        // given
        Set<String> dictionaryWords = Sets.newSet("sweet", "escape", "sw", "ete", "scape");
        String message = "sw  t  scap ";

        // when
        List<String> allPossibleMessages = google.findAllPossibleMessages(message, dictionaryWords);

        //then
        assertThat(allPossibleMessages).containsExactlyInAnyOrder(
            "sweet escape",
            "sw ete scape"
        );
    }
}