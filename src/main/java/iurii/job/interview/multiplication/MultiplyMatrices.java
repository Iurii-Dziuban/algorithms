package iurii.job.interview.multiplication;

/**
 * Matrices multiplication (Strassen`s subcubic)
 * X =(A B)   Y= (E F)
 * (C D)      (G H)
 * <p>
 * X*Y = (AE+BG AF+BH )
 * (CE+DG CF+DH )
 * Works only for quadratic matrices with number of elements in a row 2^(k)
 *
 * @author Jacky
 */
public class MultiplyMatrices {

    public static int[][] multiply(int[][] first, int[][] second) {
        if (first.length == 1 && second.length == 1) {
            return new int[][]{{first[0][0] * second[0][0]}};
        } else {
            int[][] first1 = new int[first.length / 2][first.length / 2];
            int[][] first2 = new int[first.length / 2][first.length / 2];
            int[][] first3 = new int[first.length / 2][first.length / 2];
            int[][] first4 = new int[first.length / 2][first.length / 2];
            int[][] second1 = new int[first.length / 2][first.length / 2];
            int[][] second2 = new int[first.length / 2][first.length / 2];
            int[][] second3 = new int[first.length / 2][first.length / 2];
            int[][] second4 = new int[first.length / 2][first.length / 2];
            for (int i = 0; i < first.length; i++) {
                for (int j = 0; j < first.length; j++) {
                    if (i < first.length / 2 && j < first.length / 2) {
                        first1[i][j] = first[i][j];
                    }
                    if (i < first.length / 2 && j >= first.length / 2) {
                        first2[i][j - first.length / 2] = first[i][j];
                    }
                    if (i >= first.length / 2 && j < first.length / 2) {
                        first3[i - first.length / 2][j] = first[i][j];
                    }
                    if (i >= first.length / 2 && j >= first.length / 2) {
                        first4[i - first.length / 2][j - first.length / 2] = first[i][j];
                    }
                }
            }
            for (int i = 0; i < second.length; i++) {
                for (int j = 0; j < second.length; j++) {
                    if (i < second.length / 2 && j < second.length / 2) {
                        second1[i][j] = second[i][j];
                    }
                    if (i < second.length / 2 && j >= second.length / 2) {
                        second2[i][j - second.length / 2] = second[i][j];
                    }
                    if (i >= second.length / 2 && j < second.length / 2) {
                        second3[i - second.length / 2][j] = second[i][j];
                    }
                    if (i >= second.length / 2 && j >= second.length / 2) {
                        second4[i - second.length / 2][j - second.length / 2] = second[i][j];
                    }
                }
            }
            int[][] m1 = multiply(add(first1, first4, true), add(second1, second4, true));
            int[][] m2 = multiply(add(first3, first4, true), second1);
            int[][] m3 = multiply(first1, add(second2, second4, false));
            int[][] m4 = multiply(first4, add(second3, second1, false));
            int[][] m5 = multiply(add(first1, first2, true), second4);
            int[][] m6 = multiply(add(first3, first1, false), add(second1, second2, true));
            int[][] m7 = multiply(add(first2, first4, false), add(second3, second4, true));

            int[][] res1 = add(add(m1, m4, true), add(m7, m5, false), true);
            int[][] res2 = add(m3, m5, true);
            int[][] res3 = add(m2, m4, true);
            int[][] res4 = add(add(m3, m6, true), add(m1, m2, false), true);

            int[][] res = new int[first.length][first.length];
            for (int i = 0; i < first.length; i++) {
                for (int j = 0; j < first.length; j++) {
                    if (i < res.length / 2 && j < res.length / 2) {
                        res[i][j] = res1[i][j];
                    }
                    if (i < res.length / 2 && j >= res.length / 2) {
                        res[i][j] = res2[i][j - res.length / 2];
                    }
                    if (i >= res.length / 2 && j < res.length / 2) {
                        res[i][j] = res3[i - res.length / 2][j];
                    }
                    if (i >= res.length / 2 && j >= res.length / 2) {
                        res[i][j] = res4[i - res.length / 2][j - res.length / 2];
                    }
                }
            }
            return res;
        }
    }

    public static int[][] add(int[][] matrix1, int[][] matrix2, boolean withPlus) {
        int[][] matrix = new int[matrix2.length][matrix2.length];
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2.length; j++) {
                if (withPlus) {
                    matrix[i][j] = matrix1[i][j] + matrix2[i][j];
                } else {
                    matrix[i][j] = matrix1[i][j] - matrix2[i][j];
                }
            }
        }
        return matrix;
    }

    public static int[][] bruteforce(int[][] first, int[][] second) {
        int[][] result = new int[first.length][second[0].length];
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second[0].length; j++) {
                result[i][j] = 0;
                for (int j2 = 0; j2 < first[i].length; j2++) {
                    result[i][j] += first[i][j2] * second[j2][j];
                }
            }
        }
        return result;
    }
}
