package iurii.job.interview.google;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 14/06/2017.
 */
public class TwoPairParticularSumTest {

    private TwoPairParticularSum service = new TwoPairParticularSum();

    @Test
    public void testBasicSolution() {
        assertThat(service.basicSolutionIsPairExistsElementsSorted(new int[] {}, 8)).isFalse();
        assertThat(service.basicSolutionIsPairExistsElementsSorted(new int[] {1}, 8)).isFalse();
        assertThat(service.basicSolutionIsPairExistsElementsSorted(new int[] {2,6}, 8)).isTrue();
        assertThat(service.basicSolutionIsPairExistsElementsSorted(new int[] {1,2,3,4,9}, 8)).isFalse();
        assertThat(service.basicSolutionIsPairExistsElementsSorted(new int[] {1,2,3,4,4}, 8)).isTrue();
    }

    @Test
    public void testEnhancedSolution() {
        assertThat(service.enhancedSolutionIsPairExistsElementsSorted(new int[] {}, 8)).isFalse();
        assertThat(service.enhancedSolutionIsPairExistsElementsSorted(new int[] {1}, 8)).isFalse();
        assertThat(service.enhancedSolutionIsPairExistsElementsSorted(new int[] {2,6}, 8)).isTrue();
        assertThat(service.enhancedSolutionIsPairExistsElementsSorted(new int[] {1,2,3,4,9}, 8)).isFalse();
        assertThat(service.enhancedSolutionIsPairExistsElementsSorted(new int[] {1,2,3,4,4}, 8)).isTrue();
    }

    @Test
    public void testParallelSolution() {
        assertThat(service.parallelSolutionIsPairExistsElementsSorted(new int[] {}, 8)).isFalse();
        assertThat(service.parallelSolutionIsPairExistsElementsSorted(new int[] {1}, 8)).isFalse();
        assertThat(service.parallelSolutionIsPairExistsElementsSorted(new int[] {2,6}, 8)).isTrue();
        assertThat(service.parallelSolutionIsPairExistsElementsSorted(new int[] {1,2,3,4,9}, 8)).isFalse();
        assertThat(service.parallelSolutionIsPairExistsElementsSorted(new int[] {1,2,3,4,4}, 8)).isTrue();
    }
}
