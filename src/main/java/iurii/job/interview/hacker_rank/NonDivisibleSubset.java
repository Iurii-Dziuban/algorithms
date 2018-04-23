package iurii.job.interview.hacker_rank;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given a set of distinct integers, print the size of a maximal subset of S
 * where the sum of any 2 numbers in S' is not evenly divisible by .
 *
 * https://www.hackerrank.com/challenges/non-divisible-subset/problem
 *
 * https://www.geeksforgeeks.org/subset-no-pair-sum-divisible-k/
 *
 * Time complexity: O(N + k) - N - number of elements in the Set, k - divisor
 * Auxiliary space complexity: O(k) to store frequencies of reminders for k
 */
public class NonDivisibleSubset {

    public int nonDivisibleSubset(int k, int[] S) {
        int[] reminder = new int[k];
        for (int value : S) {
            reminder[value % k]++;
        }
        if ( k % 2 == 0) {
            reminder[k / 2] = Math.min(reminder[k / 2], 1);
        }
        int res = Math.min(reminder[0], 1);
        for(int i = 1; i <= k/2; i++) {
            res += Math.max(reminder[i], reminder[k - i]);
        }
        return res;
    }

    public int nonDivisibleSubsetWithStreams(int k, int[] S) {
        Map<Integer, Long> frequencyCounting = Arrays.stream(S).parallel().map(value -> value % k).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        if (k % 2 == 0) {
            frequencyCounting.put(k / 2, Math.min(frequencyCounting.getOrDefault(k/2, 0L), 1L));
        }
        long res = Math.min(frequencyCounting.getOrDefault(0, 0L), 1L);
        for(int i = 1; i <= k/2; i++) {
            res += Math.max(frequencyCounting.getOrDefault(i, 0L),
                    frequencyCounting.getOrDefault(k - i, 0L));
        }
        return (int) res;
    }
}
