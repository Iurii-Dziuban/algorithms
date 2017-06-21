package iurii.job.interview.amazon;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IuriiDziuban on 6/15/17.
 */
public class CountNegativeIntegersInRowColumnWiseSortedMatrixTest {

    private CountNegativeIntegersInRowColumnWiseSortedMatrix service = new CountNegativeIntegersInRowColumnWiseSortedMatrix();
    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void test() {
        int[][] matrix = {
                new int[]{-3, -2, -1, 1},
                new int[]{-2, 2, 3, 4},
                new int[]{4, 5, 7, 8}
        };
        assertThat(service.count(matrix)).isEqualTo(4);
    }

    @Test
    public void testMatrixIsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("matrix should not be null");

        service.count(null);
    }

    @Test
    public void testMatrixIsEmpty() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("matrix should not be empty");

        service.count(new int[][]{});
    }
}
