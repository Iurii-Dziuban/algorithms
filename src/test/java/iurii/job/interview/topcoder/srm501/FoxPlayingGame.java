package iurii.job.interview.topcoder.srm501;

/**
 * Problem Statement
 * ����
 * Fox Ciel was very bored, so she invented a single player game. The rules of the game are:
 * <p>
 * You start with 0 points.
 * You make exactly nA+nB moves.
 * You have two types of moves available. These are called move A and move B.
 * Exactly nA times you will make move A. Exactly nB times you will make move B.
 * The moves can be in any order.
 * The moves affect your score in the following ways:
 * Each time you make move A, you add scoreA to your score.
 * Each time you make move B, you multiply your score by scoreB.
 * You are given int nA, int nB, int paramA and int paramB.
 * Calculate scoreA and scoreB as follows ("/" denotes exact division, without any rounding):
 * scoreA = paramA/1000.0
 * scoreB = paramB/1000.0
 * Return the maximum possible score after nA+nB moves.
 * Definition
 * ����
 * Class:
 * FoxPlayingGame
 * Method:
 * theMax
 * Parameters:
 * int, int, int, int
 * Returns:
 * double
 * Method signature:
 * double theMax(int nA, int nB, int paramA, int paramB)
 * (be sure your method is public)
 * Limits
 * ����
 * Time limit (s):
 * 2.000
 * Memory limit (MB):
 * 64
 * Notes
 * -
 * The returned value must have an absolute or relative error less than 1e-9.
 * Constraints
 * -
 * nA will be between 0 and 50, inclusive.
 * -
 * nB will be between 0 and 50, inclusive.
 * -
 * paramA will be between -10000 and 10000, inclusive.
 * -
 * paramB will be between -2000 and 2000, inclusive.
 * Examples
 * 0)
 * <p>
 * ����
 * 5
 * 4
 * 3000
 * 2000
 * Returns: 240.0
 * scoreA = 3000/1000 = 3 scoreB = 2000/1000 = 2  The optimal order of operations is: (3 + 3 + 3 + 3 + 3) * 2 * 2 * 2 * 2 = 240
 * 1)
 * <p>
 * ����
 * 3
 * 3
 * 2000
 * 100
 * Returns: 6.0
 * scoreA = 2000/1000 = 2 scoreB = 100/1000 = 0.1  Multiplying the score by scoreB decreases its absolute value, so it's better to do all multiplications before additions. Thus, the optimal order of operations is: 0 * 0.1 * 0.1 * 0.1 + 2 + 2 + 2 = 6
 * 2)
 * <p>
 * ����
 * 4
 * 3
 * -2000
 * 2000
 * Returns: -8.0
 * Multiplying the score by scoreB increases its absolute value, but given that scoreA is negative, the overall score will be negative as well, so it's better to do multiplications before additions again to keep the absolute value small.
 * 3)
 * <p>
 * ����
 * 5
 * 5
 * 2000
 * -2000
 * Returns: 160.0
 * Multiplication increases the absolute value of the score, but if you do all 5 multiplications after additions, you'll end up with negative score. Thus, the optimal order of operations is: (0 * (-2) + 2 + 2 + 2 + 2 + 2) * (-2) * (-2) * (-2) * (-2) = 160
 * 4)
 * <p>
 * ����
 * 50
 * 50
 * 10000
 * 2000
 * Returns: 5.62949953421312E17
 * <p>
 * 5)
 * <p>
 * ����
 * 41
 * 34
 * 9876
 * -1234
 * Returns: 515323.9982341775
 */
public class FoxPlayingGame {
    public double theMax(int nA, int nB, int paramA, int paramB) {
        double scoreA = paramA / 1000.0;
        double scoreB = paramB / 1000.0;
        return max(new double[]{
                scoreA * nA,
                scoreA * nA * pow(scoreB, nB),
                scoreA * nA * pow(scoreB, Math.max(nB - 1, 0)),
                scoreA * nA * scoreB
        });
    }

    public double max(double[] values) {
        double max = values[0];
        for (double value : values) {
            if (max < value) {
                max = value;
            }
        }
        return max;
    }

    public double pow(double a, int n) {
        double res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res *= a;
            }
            a *= a;
            n = n >> 1;
        }
        return res;
    }
}
