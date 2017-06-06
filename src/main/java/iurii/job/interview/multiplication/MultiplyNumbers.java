package iurii.job.interview.multiplication;

/**
 * Karatsuba algorithm
 * X=a*10^(n/2)+b
 * Y=c*10^(n/2)+d
 * X*Y = 10^(n) * ac + 10^(n/2)*((a+b)(c+d)-ac-bd) + bd
 *
 * @author Jacky
 *         works with numbers with equal length equal to 2^n
 */
public class MultiplyNumbers {

    public static int multiply(int x, int y) {
        int xLength = String.valueOf(x).length();
        int yLength = String.valueOf(y).length();
        if (xLength / 2 == 0 && yLength / 2 == 0) {
            return x * y;
        } else {
            int tenInX = tenIn(xLength / 2);
            int tenInY = tenIn(yLength / 2);
            int a = x / tenInX;
            int b = x % tenInX;
            int c = y / tenInY;
            int d = y % tenInY;
            int multiplyAC = multiply(a, c);
            int multiplyBD = multiply(b, d);
            int tenIn2 = tenIn(xLength / 2 + yLength / 2);
            return tenIn2 * multiplyAC + tenInX * (multiply(a + b, c + d) - multiplyAC - multiplyBD) + multiplyBD;
        }
    }

    private static int tenIn(int number) {
        int res = 1;
        for (int i = 0; i < number; i++) {
            res *= 10;
        }
        return res;
    }
}
