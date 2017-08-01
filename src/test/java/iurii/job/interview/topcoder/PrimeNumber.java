package iurii.job.interview.topcoder;

public class PrimeNumber {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isPrime(95));
    }

    private static int isPrime(int n) {
        int sqrtN = (int) Math.round(Math.sqrt(n));
        if (n % 2 == 0) {
            return 2;
        }
        for (int i = 3; i < sqrtN; i = i + 2) {
            if (n % i == 0) {
                return i;
            }
        }
        return -1;
    }

}
