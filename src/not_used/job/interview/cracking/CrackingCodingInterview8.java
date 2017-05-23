package iurii.job.interview.cracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * Recursion
 * 
 * @author Iurii
 */
public class CrackingCodingInterview8 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(findFibonacci(3));
        System.out.println(findFibonacci(4));
        System.out.println(findFibonacci(5));
        System.out.println();
        System.out.println(pathsNumber(2));
        System.out.println(pathsNumber(3));

        System.out.println(allSubsets(Arrays.asList(0, 1, 2, 3)));
        System.out.println(allSubsets2(Arrays.asList(0, 1, 2, 3)));
    }

    /**
     * 8.1 Write N-th Fibonacci Number
     */
    public static int findFibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int prev = 1;
        int cur = 1;
        for (int i = 0; i < n - 2; i++) {
            cur = cur + prev;
            prev = cur - prev;
        }
        return cur;
    }

    /**
     * 8.2 NxN you in the upper left corner and can move only by right or down.
     * How many paths to NxN
     */
    public static int pathsNumber(int n) {
        int pathsNumber = 0;
        Queue<Pair> queue = new ArrayDeque<Pair>();
        queue.add(new Pair(1, 1));
        while (!queue.isEmpty()) {
            Pair curPosition = queue.poll();
            if (curPosition.x == n || curPosition.y == n) {
                pathsNumber++;
                continue;
            }
            if (curPosition.x != n) {
                queue.add(new Pair(curPosition.x + 1, curPosition.y));
            }
            if (curPosition.y != n) {
                queue.add(new Pair(curPosition.x, curPosition.y + 1));
            }
        }
        return pathsNumber;
    }

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }

    /**
     * 8.3 Return all SubSetsOf a set. Here comparison is used to prevent
     * combinations such as {1,2} {2,1} to be different
     */
    public static List<List<Integer>> allSubsets(List<Integer> source) {
        List<List<Integer>> subSets = new ArrayList<List<Integer>>();
        Queue<List<Integer>> queue = new ArrayDeque<List<Integer>>();
        // indexes
        for (int i = 0; i < source.size(); i++) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(i);
            queue.add(list);
        }
        while (!queue.isEmpty()) {
            List<Integer> el = queue.poll();
            subSets.add(el);
            for (int i = 0; i < source.size(); i++) {
                List<Integer> copyEl = new ArrayList<Integer>();
                copyEl.addAll(el);
                boolean shouldElementBeAdded = true;
                for (int j = 0; j < el.size(); j++) {
                    if (i <= el.get(j)) {
                        shouldElementBeAdded = false;
                    }
                }
                if (shouldElementBeAdded) {
                    copyEl.add(i);
                    queue.add(copyEl);
                }
            }
        }
        subSets.add(new ArrayList<Integer>());
        return subSets;
    }

    // The optimal solution that is based on yes/no (present)all possible values
    // 2^n

    public static List<List<Integer>> allSubsets2(List<Integer> source) {
        List<List<Integer>> subSets = new ArrayList<List<Integer>>();
        int max = 1 << source.size();
        for (int i = 0; i < max; i++) {
            List<Integer> subset = new ArrayList<Integer>();
            int k = 1;
            for (int j = 0; j < source.size(); j++) {
                if ((k & i) != 0) {
                    subset.add(source.get(j));
                }
                k = k << 1;
            }
            subSets.add(subset);
        }
        return subSets;
    }

    /**
     * 8.4 Find all permutations of the string.
     * Solution is the following: extract one character. 
     * Permute the rest. insert character into each position of permuted rest.
     */
    public static List<String> allPermutations(String string) {
       List<String> allPermutations = new ArrayList<String>();
       
       return allPermutations;
    }

}
