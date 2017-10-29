package iurii.job.interview.facebook;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IuriiDziuban on 10/22/17.
 */
public class SortedSquaresOfSortedArrayTest {

    @Test
    public void test() {
        SortedSquaresOfSortedArray sortedSquaresOfSortedArray = new SortedSquaresOfSortedArray();
        assertThat(sortedSquaresOfSortedArray.squareAndSort(new int[]{1, 2, 3, 4})).containsExactly(1, 4, 9, 16);
        assertThat(sortedSquaresOfSortedArray.squareAndSort(new int[]{-1, -3, 2, 4})).containsExactly(1, 4, 9, 16);
        assertThat(sortedSquaresOfSortedArray.squareAndSort(new int[]{-1, -3, 4})).containsExactly(1, 9, 16);
        assertThat(sortedSquaresOfSortedArray.squareAndSort(new int[]{-1, 2, 4})).containsExactly(1, 4, 16);
    }
}
