package iurii.job.interview.google;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Example of Mock interview for Google
 *
 * There is an array of numbers. Find a pair of numbers (or just if this pair exists)
 * in the array that sum up to particular sum
 *
 * Example:
 * [1,2,3,4,4] sum =8 {4,4} pair exists and sum up to 8
 *
 * Additional clarification:
 * 0) What should be return: true/false exists or not. A pair of the first match, all pairs? For simplicity true/false and just mention what can be used to extend the result.
 * 1) Numbers are integers, no float numbers. Can be positive or negative, zero
 * 2) Duplicates are possible
 * 3) Edge cases: array is null or empty. Only one element. Overflow on sum or minus is rather not possible.
 * 4) Basic solution: values are sorted. Enhanced: values are not sorted. Parallel: values are not sorted array is two big and should be split into chunks which are processed in parallel.
 *
 * Basic solution for sorted array two have two pointers in the array in the beginning to the first and last elements, check their sum with required sum and depending on what is bigger to move one of the pointers until they meet. Solution is linear.
 *
 * Enhanced: is to use data structure Set and to put supplementary numbers of which are processed and to look up if the supplement already in the set. Time is linear, look up in the hash set is O(1)
 *
 * Parallel: There is no implementation of ConcurrentHashSet in java.
 *   As it is pointed out on https://stackoverflow.com/questions/6992608/why-there-is-no-concurrenthashset-against-concurrenthashmap
 *   It can be created using guava or Collections.synchronizedSet() but it won`t give the best performance as the one derived from ConcurrentHashMap
 *   ConcurrentHashMap.newKeySet()
 *
 * Created by iurii.dziuban on 14/06/2017.
 */
public class TwoPairParticularSum {

    public boolean basicSolutionIsPairExistsElementsSorted(int[] numbers, int sum) {
        // preconditions
        if (numbers == null) {
            return false;
        }
        // solution
        int lowPointer = 0;
        int highPointer = numbers.length - 1;
        while (highPointer > lowPointer) {
            int pairSum = numbers[lowPointer] + numbers[highPointer];
            if (pairSum == sum) {
                return true;
            }
            if (pairSum > sum) {
                highPointer--;
            } else {
                lowPointer++;
            }
        }
        return false;
    }

    public boolean enhancedSolutionWithSetIsPairExists(int[] numbers, int sum) {
        // preconditions
        if (numbers == null) {
            return false;
        }
        Set<Integer> complements = new HashSet<>();
        for (int number : numbers) {
            if (complements.contains(number)) {
                return true;
            }
            complements.add(sum - number);
        }
        return false;
    }

    // Set should be passed concurrent "ConcurrentHashMap.newKeySet()"
    public boolean parallelSolutionOnChunkIsPairExists(int[] chunk, int sum, Set<Integer> complements) {
        // preconditions
        if (chunk == null) {
            return false;
        }
        // use Threads and run on chunks. Concurrent Hash Set should be one for all threads
        for (int number : chunk) {
            if (complements.contains(number)) {
                return true;
            }
            complements.add(sum - number);
        }
        return false;
    }

}
