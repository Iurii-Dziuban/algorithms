package iurii.job.interview.hacker_rank;

/**
 * Lilah has a string s of lowercase English letters that she repeated infinitely many times.
 Given an integer n find and print the number of letter 'a' in the first n letters of Lilah's infinite string.
 For example, if the string s=abcac and n=10, the substring we consider is abcacabcac, the first 10 characters
 of her infinite string. There are  occurrences of a in the substring.
 * https://www.hackerrank.com/challenges/repeated-string/problem
 *
 * Time complexity:
 * Auxiliary space complexity:
 */
public class RepeatedString {

    public long repeatedString(String s, long n) {
        long count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                count += n / s.length() + (n % s.length() > i ? 1 : 0);
            }
        }
        return count;
    }
}
