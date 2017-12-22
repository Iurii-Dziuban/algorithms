package iurii.job.interview.codility.cliqz;

import java.util.HashMap;
import java.util.Map;

/**
 * https://codility.com/honeypot/Burda-Cliqz_Programmer/
 *
 * Solution:
 * https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 *
 * Created by IuriiDziuban on 10/29/17.
 */
public class Fibonacci {

    private Map<Integer, Integer> calculatedValues = new HashMap<>();
    // Returns n'th fibonacci number using
    // table f[]
    public int fibonacciLeast6Digits(int n) {
        // Base cases
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            calculatedValues.putIfAbsent(n, 1);
            return 1;
        }

        // If fib(n) is already computed
        if (calculatedValues.get(n) != null) {
            return calculatedValues.get(n);
        }

        int k = (n & 1) == 1 ? (int) ((n + 1L) / 2) : n / 2;

        // Applying above formula [Note value n & 1 is 1 if n is odd, else 0]
        long fibK = (long) fibonacciLeast6Digits(k);
        long fibK_1 = (long) fibonacciLeast6Digits(k - 1);
        int res;
        if ((n & 1) == 1) {
            res = (int)((fibK * fibK + fibK_1 * fibK_1) % 1000000);
        } else {
            res = (int)(((2L * fibK_1 + fibK) * fibK) % 1000000);
        }
        calculatedValues.put(n, res);
        return res;
    }
}
