package iurii.job.interview.amazon;

/**
 * There is a matrix each row and each column is sorted ascending.
 * Count the number of negative numbers
 *
 *  https://www.youtube.com/watch?v=5dJSZLmDsxk
 *
 * Example
 * -3, -2, -1, 1
 * -2, 2, 3, 4
 *  4, 5, 7, 8
 * Answer: 4 (-3, -2, -2, -1)
 *
 * Solutions:
 * 1) Brute force: iterate through all the matrix and count: n * m complexity
 * 2) We can start from the right top corner and search first negative number to the left
 * (all over numbers will be negative as well because row is sorted) when number of negative elements in a row found,
 * we move to the next row without changing the current column (can be possible because columns are sorted as well)
 *
 * Time complexity will be O(n + m) (number of rows + number of columns)
 * Auxiliary space O(1) for count
 * Created by IuriiDziuban on 6/15/17.
 */
public class CountNegativeIntegersInRowColumnWiseSortedMatrix {

    public int count(int[][] matrix) {
        // preconditions: should have at least have one element
        if (matrix == null) {
            throw new IllegalArgumentException("matrix should not be null");
        }
        int height = matrix.length;
        if (height == 0) {
            throw new IllegalArgumentException("matrix should not be empty");
        }
        // initial values
        int width = matrix[0].length;
        int i = 0;
        int j = width - 1;
        int negativeCount = 0;
        // solution
        while (i < height && j >= 0) {
            if (matrix[i][j] >= 0) {
                j--;
            } else {
                negativeCount += j + 1;
                i++;
            }
        }
        return negativeCount;
    }
}
