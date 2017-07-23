package iurii.job.interview.google;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 14/06/2017.
 */
public class TwoPairParticularSumTest {

    private TwoPairParticularSum service = new TwoPairParticularSum();

    @Test
    public void testNumbersNull() {
        assertThat(service.basicSolutionIsPairExistsElementsSorted(null, 9)).isFalse();
        assertThat(service.enhancedSolutionWithSetIsPairExists(null, 3)).isFalse();
        assertThat(service.parallelSolutionOnChunkIsPairExists(null, 1, ConcurrentHashMap.newKeySet())).isFalse();
    }

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
        assertThat(service.enhancedSolutionWithSetIsPairExists(new int[] {}, 8)).isFalse();
        assertThat(service.enhancedSolutionWithSetIsPairExists(new int[] {1}, 8)).isFalse();
        assertThat(service.enhancedSolutionWithSetIsPairExists(new int[] {2,6}, 8)).isTrue();
        assertThat(service.enhancedSolutionWithSetIsPairExists(new int[] {1,2,3,4,9}, 8)).isFalse();
        assertThat(service.enhancedSolutionWithSetIsPairExists(new int[] {1,2,3,4,4}, 8)).isTrue();
    }

    @Test
    public void testParallelSolution() {
        assertThat(service.parallelSolutionOnChunkIsPairExists(new int[] {}, 8,
                ConcurrentHashMap.newKeySet())).isFalse();
        assertThat(service.parallelSolutionOnChunkIsPairExists(new int[] {1}, 8,
                ConcurrentHashMap.newKeySet())).isFalse();
        assertThat(service.parallelSolutionOnChunkIsPairExists(new int[] {2,6}, 8,
                ConcurrentHashMap.newKeySet())).isTrue();
        assertThat(service.parallelSolutionOnChunkIsPairExists(new int[] {1,2,3,4,9}, 8,
                ConcurrentHashMap.newKeySet())).isFalse();
        assertThat(service.parallelSolutionOnChunkIsPairExists(new int[] {1,2,3,4,4}, 8,
                ConcurrentHashMap.newKeySet())).isTrue();
    }
}
