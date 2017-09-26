package iurii.job.interview.codility;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Find an index in an array such that its prefix sum equals its suffix sum.
 * https://codility.com/contests/shortEqui2011/
 * <p>
 * A zero-indexed array A consisting of N integers is given. An equilibrium index of this array is any integer P such that 0 ≤ P < N and the sum of elements of lower indices is equal to the sum of elements of higher indices, i.e.
 A[0] + A[1] + ... + A[P−1] = A[P+1] + ... + A[N−2] + A[N−1].
 Sum of zero elements is assumed to be equal to 0. This can happen if P = 0 or if P = N−1.

 For example, consider the following array A consisting of N = 8 elements:

 A[0] = -1
 A[1] =  3
 A[2] = -4
 A[3] =  5
 A[4] =  1
 A[5] = -6
 A[6] =  2
 A[7] =  1
 P = 1 is an equilibrium index of this array, because:

 A[0] = −1 = A[2] + A[3] + A[4] + A[5] + A[6] + A[7]
 P = 3 is an equilibrium index of this array, because:

 A[0] + A[1] + A[2] = −2 = A[4] + A[5] + A[6] + A[7]
 P = 7 is also an equilibrium index, because:

 A[0] + A[1] + A[2] + A[3] + A[4] + A[5] + A[6] = 0
 and there are no elements with indices greater than 7.

 P = 8 is not an equilibrium index, because it does not fulfill the condition 0 ≤ P < N.

 Complexity:
 expected worst-case time complexity is O(N);
 expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 Elements of input arrays can be modified.
 * <p>
 * Created by iurii.dziuban on 25/09/2017.
 */
public class EquilibriumTest {

    @Test
    public void test1() {
        int solution = new Equilibrium().solution(new int[]{-1, 3, -4, 5, 1, -6, 2, 1});
        assertThat(solution).isEqualTo(1);
    }

    @Test
    public void test2() {
        int solution = new Equilibrium().solution1(new int[]{-1, 3, -4, 5, 1, -6, 2, 1});
        assertThat(solution).isEqualTo(1);
    }

}
