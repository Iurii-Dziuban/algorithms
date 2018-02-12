package iurii.job.interview.codility.onpex;

/**
 *
 * There is list of coins either head or tail (0 or 1)
 * You need to flip one coin, so that number of
 * two adjacent coins that are the same (heads or tails) will be maximum
 * return maximum number of adjacent coins after the flip
 *
 * Solution was provided. Fix the solution by changing maximum 3 lines.
 *
 * http://ruslanledesma.com/2016/02/14/adjacent-coins.html
 *
 * http://www.javaprogrammingforums.com/whats-wrong-my-code/32601-logic-find-adjacency-numbers-0-1-array.html
 *
 * https://www.reddit.com/r/coding/comments/56jr67/programming_problem_adjacent_coins/
 *
 * https://rsdn.org/forum/alg/6603461.all
 *
 * Correct solution is provided. Comments indicate what was incorrect value of the line.
 *
 * Time complexity: O(N) , N - number f coins
 * Auxiliary space complexity: O(1)
 */
public class AdjacentCoinProblem {

    public int solution(int[] A) {
        int n = A.length;
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] == A[i + 1])
                result = result + 1;
        }
        int r = -1; // before change int r = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            if (i > 0) {
                if (A[i - 1] != A[i])
                    count = count + 1;
                else
                    count = count - 1;
            }
            if (i < n - 1) {
                if (A[i + 1] != A[i])
                    count = count + 1;
                else
                    count = count - 1;
            }
            r = Math.max(r, count);
        }
        return n == 1 ? 0 : result + r; // before change: return result + r;
    }
}
