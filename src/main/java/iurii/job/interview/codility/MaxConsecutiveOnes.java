package iurii.job.interview.codility;

/**
 * http://www.geeksforgeeks.org/length-longest-consecutive-1s-binary-representation/
 * Created by iurii.dziuban on 29/09/2017.
 */
// Java program to find length of the longest
// consecutive 1s in binary reprsentation of
// a number.
public class MaxConsecutiveOnes {
    public int maxConsecutiveOnes(int x) {
        int count = 0;
        // Count the number of iterations to
        // reach x = 0.
        while (x != 0) {
            // This operation reduces length
            // of every sequence of 1s by one.
            x = (x & (x << 1));
            count++;
        }
        return count;
    }
}
