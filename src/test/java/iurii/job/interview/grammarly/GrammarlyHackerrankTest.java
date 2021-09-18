package iurii.job.interview.grammarly;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class GrammarlyHackerrankTest {

    @Test
    public void reductionCost() {
        assertThat(GrammarlyHackerrank.reductionCost(
                Arrays.asList(1,2,3,4))
        ).isEqualTo(19);

        assertThat(GrammarlyHackerrank.reductionCost(
                Arrays.asList(1,2,3,4,5))
        ).isEqualTo(33);

        assertThat(GrammarlyHackerrank.reductionCost(
                Arrays.asList(1,2,3,4,5,6))
        ).isEqualTo(51);
    }

    @Test
    public void scatterPalindrome() {
        assertThat(GrammarlyHackerrank.scatterPalindrome(
                Arrays.asList("abc", "bbrrg"))
        ).isEqualTo(Arrays.asList(3, 12));
    }
}