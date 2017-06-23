package iurii.job.interview.stack;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 22/06/2017.
 */
public class LargestRectangleInHistogramTest {

    private LargestRectangleInHistogram service = new LargestRectangleInHistogram();

    @Test
    public void testPositive() {
        int largestRectangleSquareInHistogram = service.findLargestRectangleInHistogram(
                new int[]{1, 3, 2, 1, 2});

        assertThat(largestRectangleSquareInHistogram).isEqualTo(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNull() {
        service.findLargestRectangleInHistogram(null);
    }

    @Test
    public void testEmpty() {
        assertThat(service.findLargestRectangleInHistogram(new int[]{})).isEqualTo(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeNotPossible() {
        service.findLargestRectangleInHistogram(new int[]{1,2,-4,3});
    }

    @Test
    public void testZeroInMiddle() {
        int largestRectangleSquareInHistogram = service.findLargestRectangleInHistogram(
                new int[]{1, 3, 2, 0, 2});

        assertThat(largestRectangleSquareInHistogram).isEqualTo(4);
    }

    @Test
    public void testNegative() {
        int largestRectangleSquareInHistogram = service.findLargestRectangleInHistogramNegativesArePossible(
                new int[]{-1, -3, -2, -1, -2});

        assertThat(largestRectangleSquareInHistogram).isEqualTo(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeNull() {
        service.findLargestRectangleInHistogramNegativesArePossible(null);
    }

    @Test
    public void testEmptyNegative() {
        assertThat(service.findLargestRectangleInHistogramNegativesArePossible(new int[]{})).isEqualTo(0);
    }

    @Test
    public void testNegativeIsBigger() {
        assertThat(service.findLargestRectangleInHistogramNegativesArePossible(new int[]{1,2,-4,3})).isEqualTo(4);
    }

    @Test
    public void testZeroInMiddleNegative() {
        int largestRectangleSquareInHistogram = service.findLargestRectangleInHistogramNegativesArePossible(
                new int[]{1, -3, -2, 0, 2});

        assertThat(largestRectangleSquareInHistogram).isEqualTo(4);
    }
}
