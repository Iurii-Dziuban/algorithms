package iurii.job.interview.topcoder.srm491;

/**
 * Problem Statement
 * ����
 * Fox Jiro likes dice. He wants to make his own dice. Each die he wants to make is a cube. Each of the 6 faces has an integer between 1 and N, inclusive. No two faces have same number. Also the following condition must be satisfied: for all faces, the sum of the numbers on opposite faces must be equal and the sum must be greater than or equal to K.
 * <p>
 * He realized that there are many ways to make such dice. He wants to know how many ways there are. Please help Jiro to make a program that is given two integers N and K and returns the number of different dice satisfying the condition mentioned above.
 * <p>
 * Two dice are considered the same if you can rotate one to form the other.
 * Definition
 * ����
 * Class:
 * FoxMakingDiceEasy
 * Method:
 * theCount
 * Parameters:
 * int, int
 * Returns:
 * int
 * Method signature:
 * int theCount(int N, int K)
 * (be sure your method is public)
 * Limits
 * ����
 * Time limit (s):
 * 2.000
 * Memory limit (MB):
 * 64
 * Notes
 * -
 * The answer will always fit in a signed 32-bit integer.
 * Constraints
 * -
 * N will be between 1 and 50, inclusive.
 * -
 * K will be between 1 and 100, inclusive.
 * Examples
 * 0)
 * <p>
 * ����
 * 6
 * 7
 * Returns: 2
 * You can make normal dice. There are two ways to arrange the numbers.
 * 1)
 * <p>
 * ����
 * 5
 * 7
 * Returns: 0
 * You cannot make 6 sided dice with 5 numbers.
 * 2)
 * <p>
 * ����
 * 50
 * 1
 * Returns: 105800
 * <p>
 * 3)
 * <p>
 * ����
 * 31
 * 46
 * Returns: 504
 * <p>
 * 4)
 * <p>
 * ����
 * 10
 * 10
 * Returns: 48
 */
public class FoxMakingDiceEasy {
    public int theCount(int N, int K) {
        boolean[][] variants = new boolean[N][N];
        int count = 0;
        int[] sum = new int[2 * N - 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i + j + 2 < K) {
                    continue;
                }
                if (!variants[i][j] && !variants[j][i] && i != j) {
                    variants[i][j] = variants[j][i] = true;
                    sum[i + j]++;
                }
            }
        }
        if (K <= 2) {
            K = 2;
        }
        for (int i = K; i < 2 * N - 1; i++) {
            count += countVariants(sum[i - 2]);
        }
        return count;
    }

    private int countVariants(int howMany) {
        int count = 3;
        if (count > howMany) {
            return 0;
        } else {
            return howMany * (howMany - 1) * (howMany - 2) / 6;
        }
    }
}
