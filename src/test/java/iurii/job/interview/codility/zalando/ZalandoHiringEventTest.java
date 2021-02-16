package iurii.job.interview.codility.zalando;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ZalandoHiringEventTest {

    private final ZalandoHiringEvent z = new ZalandoHiringEvent();

    /**
     * Example test:   [1, -2, -3, 5]
     * OK
     * Returned value: 1
     *
     * Example test:   [1, 2, 3, -5]
     * OK
     * Returned value: -1
     *
     * Example test:   [1, 2, 0, -5]
     * OK
     * Returned value: 0
     */
    @Test
    public void solution1() {
        // when / then
        assertThat(z.solution1(new int[] {1, -2, -3, 5})).isEqualTo(1);
        assertThat(z.solution1(new int[] {1, 2, 3, -5})).isEqualTo(-1);
        assertThat(z.solution1(new int[] {1, 2, 0, -5})).isZero();
    }


    /**
     * Example test:   ([1, 1, 3, 3, 3, 4, 5, 5, 5, 5], 2)
     * Returned value: 5
     *
     * Your test case: [[1, 1, 3, 3, 3, 4, 5, 5, 5, 5], 10]
     * Returned value: 10
     *
     * Your test case: [[1, 1, 3, 3, 3, 4, 5, 5, 5, 5], 0]
     * Returned value: 4
     *
     * Your test case: [[1, 1, 3, 3, 3, 4, 5, 5, 5, 5], 9]
     * Returned value: 10
     *
     * Your test case: [[1, 1, 3, 3, 3, 4, 5, 5, 5, 5], 8]
     * Returned value: 10
     *
     * Your test case: [[1, 1, 3, 3, 3, 4, 5, 5, 5, 5], 7]
     * Returned value: 9
     *
     * Your test case: [[1, 1, 3, 3, 3, 4, 5, 5, 5, 5], 6]
     * Returned value: 8
     *
     * Your test case: [[1, 1, 3, 3, 3, 4, 5, 5, 5, 5], 5]
     * Returned value: 8
     *
     * Your test case: [[1, 1, 3, 3, 3, 4, 5, 5, 5, 5], 4]
     * Returned value: 7
     *
     * Your test case: [[1, 1, 3, 3, 3, 4, 5, 5, 5, 5], 3]
     * Returned value: 6
     *
     * Your test case: [[1, 1, 3, 3, 3, 4, 5, 5, 5, 5], 1]
     * Returned value: 4
     */
    @Test
    public void solutionAfter() {
        // given
        int[] nails = new int[]{1, 1, 3, 3, 3, 4, 5, 5, 5, 5};

        // when / then
        assertThat(z.solutionAfter(nails, 10)).isEqualTo(10);
        assertThat(z.solutionAfter(nails, 9)).isEqualTo(10);
        assertThat(z.solutionAfter(nails, 8)).isEqualTo(10);
        assertThat(z.solutionAfter(nails, 7)).isEqualTo(9);
        assertThat(z.solutionAfter(nails, 6)).isEqualTo(8);
        assertThat(z.solutionAfter(nails, 5)).isEqualTo(8);
        assertThat(z.solutionAfter(nails, 4)).isEqualTo(7);
        assertThat(z.solutionAfter(nails, 3)).isEqualTo(6);
        assertThat(z.solutionAfter(nails, 2)).isEqualTo(5);
        assertThat(z.solutionAfter(nails, 1)).isEqualTo(4);
        assertThat(z.solutionAfter(nails, 0)).isEqualTo(4);
    }
}