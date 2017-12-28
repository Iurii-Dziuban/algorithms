package iurii.job.interview.topcoder.srm503;

/**
 * Created by iurii.dziuban on 28/12/2017.
 */
public class PowerCalculator {

    public double power(int a, int power) {
        double result = 1;
        while (power != 0) {
            if ((power & 1) == 1) {
                result *= a;
            }
            a *= a;
            power = power >> 1;
        }
        return result;
    }

    public double powerRecursive(int a, int power) {
        if (power == 0) {
            return 1;
        }
        if (power < 0) {
            return 1 / powerRecursive(a, - power);
        }
        if (power / 2 == 0) {
            double value = powerRecursive(a, power / 2);
            return value * value;
        } else {
            return a * powerRecursive(a,power - 1);
        }
    }
}
