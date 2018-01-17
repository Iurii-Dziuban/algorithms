package iurii.job.interview.leetcode;

import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 658. Find K Closest Elements https://leetcode.com/problems/find-k-closest-elements/description/
 *
 * Similar to {@link iurii.job.interview.amazon.KClosestPoints}
 *
 * TODO! Use two pointers from left and right until k elements found instead of PriorityQueue
 * Time complexity: O(N) linear for two pointers
 * Auxiliary space complexity: O(K) - two pointers + List to store k result elements
 */
public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
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

        @Override
        public boolean equals(Object o) {
            if (o instanceof Pair) {
                Pair oPair = (Pair) o;
                return value == oPair.value;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return value;
        }
    }
}
