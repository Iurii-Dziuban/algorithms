package iurii.job.interview.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 658. Find K Closest Elements https://leetcode.com/problems/find-k-closest-elements/description/
 *
 * https://leetcode.com/articles/find-k-closest-elements/
 *
 * https://www.geeksforgeeks.org/find-k-closest-elements-given-value/
 *
 * Similar to {@link iurii.job.interview.amazon.KClosestPoints} but array already sorted
 *
 * But in case already sorted array, no need to use PriorityQueue for sorting,
 * just use two pointers
 *
 * Time complexity: O(log(N) + k) logarithmic for two pointers search
 * Auxiliary space complexity: O(K) - two pointers + List to store k result elements
 */
public class FindKClosestElements {

    /**
     * For not sorted case Priority queue can be used
     * Time complexity: O((N-k)*log(k))
     * Auxiliary space complexity: O(k) - priority queue length
     * ! Note in java default priority queue is unbounded.
     * ! But bounded queue (only k elements) can be implemented or used from different libraries
     */
    public List<Integer> findClosestElementsWithPriorityQueue(int[] arr, int k, int x) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        for(int el : arr) {
            Pair pair = new Pair(el);
            pair.distance = Math.abs(el - x);
            priorityQueue.add(pair);
        }
        return Stream.generate(priorityQueue::poll)
                .limit(k).mapToInt(pair -> pair.value).sorted().boxed().collect(Collectors.toList());
    }

    public static class Pair implements Comparable<Pair> {
        int value;
        int distance;

        Pair(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            int compare = Integer.compare(distance, o.distance);
            return (compare == 0) ? Integer.compare(value, o.value) : compare;
        }
    }

    /**
     * For sorted array case two pointers with binary search can be used to find the window of k elements
     *
     * Time complexity: O(log(n) + k) - binary search + taking k found elements
     * Auxiliary space complexity: O(k) - two pointers + list of k elements
     */
    public List<Integer> findClosestElementsSortedWithTwoPointers(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0 || k <= 0) {
            return result;
        }
        int low = 0;
        int high = arr.length - k;
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (x - arr[middle] > arr[middle + k] - x) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        for(int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    /**
     * Solution with sorting with comparator and extracting first k values and sorting them
     *
     * Time complexity: O(n*log(n) + k*log(k)) sorting
     * Auxiliary space complexity: O(1) in place sorting and k elements from list view
     *
     * Solution can be used for not sorted array as well
     */
    public List<Integer> findClosestElementsWithSortingList(List<Integer> arr, int k, int x) {
        if (arr == null || arr.size() == 0 || k <= 0) {
            return new ArrayList<>();
        }
        arr.sort(Comparator.comparingInt(a -> Math.abs(a - x)));
        arr = arr.subList(0, k);
        Collections.sort(arr);
        return arr;
    }
}
