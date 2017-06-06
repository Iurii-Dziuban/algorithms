package iurii.job.interview;

import iurii.job.interview.closest_pair.ClosestPair;
import iurii.job.interview.multiplication.MultiplyMatrices;
import iurii.job.interview.multiplication.MultiplyNumbers;
import iurii.job.interview.search.binary.BinarySearch;
import iurii.job.interview.selection.deterministic.DeterministicSelection;
import iurii.job.interview.selection.randomized.RandomizedSelection;
import iurii.job.interview.sorting.Utilities;
import iurii.job.interview.sorting.bubble.BubbleSort;
import iurii.job.interview.sorting.insertion.InsertSort;
import iurii.job.interview.sorting.merge.InverseFind;
import iurii.job.interview.sorting.merge.MergeSort;
import iurii.job.interview.sorting.merge.MergeSortWithoutRecursion;
import iurii.job.interview.sorting.quick.QuickSort;
import iurii.job.interview.sorting.quick.QuickSortWithoutRecursion;
import iurii.job.interview.sorting.selection.SelectionSort;

public class Main {
    // https://class.coursera.org/algo2-2012-001/lecture/preview

    /**
     * @param args
     */
    public static void main(String[] args) {
        Utilities.println(MergeSort.merge(new int[]{2, 3}, new int[]{1, 4, 5}));
        Utilities.println(MergeSort.mergesort(new int[]{3, 1, 2}));
        Utilities.println(InverseFind.mergesort(new int[]{3, 1, 2, 4, 7, 6}));
        Utilities.println(InverseFind.list);
        int[][] res = MultiplyMatrices.bruteforce(new int[][]{{1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}, {4, 5, 6, 7}}, new int[][]{{1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}, {4, 5, 6, 7}});
        Utilities.println(res);
        int[][] res2 = MultiplyMatrices.multiply(new int[][]{{1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}, {4, 5, 6, 7}}, new int[][]{{1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}, {4, 5, 6, 7}});
        Utilities.println(res2);
        System.out.println(MultiplyNumbers.multiply(1234, 5678));
        System.out.println(1234 * 5678);

        ClosestPair.Pair[] pairs = new ClosestPair.Pair[]{new ClosestPair.Pair(0, 0), new ClosestPair.Pair(0, 5), new ClosestPair.Pair(2, 0), new ClosestPair.Pair(5, 0), new ClosestPair.Pair(5, 5), new ClosestPair.Pair(3, 5), new ClosestPair.Pair(100, 100), new ClosestPair.Pair(3, 1)};

        ClosestPair.Pair[] brute = ClosestPair.shortestBruteForce(pairs);
        System.out.println(brute[0]);
        System.out.println(brute[1]);
        ClosestPair.Pair[] nlogn = ClosestPair.closestPair(pairs);
        System.out.println(nlogn[0]);
        System.out.println(nlogn[1]);

        Utilities.println(SelectionSort.sort(new int[]{9, 3, 6, 1, 4, 2, 5, 7, 8}));
        Utilities.println(InsertSort.sort(new int[]{9, 3, 6, 1, 4, 2, 5, 7, 8}));
        Utilities.println(BubbleSort.sort(new int[]{9, 3, 6, 1, 4, 2, 5, 7, 8}));
        System.out.println(BinarySearch.binarySearch(InsertSort.sort(new int[]{9, 3, 6, 1, 4, 2, 5, 7, 8}), 4));

        Utilities.println(QuickSort.sort(new int[]{9, 3, 6, 1, 4, 2, 5, 7, 8}));
        System.out.println(RandomizedSelection.select(new int[]{9, 6, 1, 4, 5, 7, 8}, 4));
        System.out.println(DeterministicSelection.select(new int[]{9, 6, 1, 4, 5, 7, 8}, 4));

        Utilities.println(QuickSortWithoutRecursion.sort(new int[]{9, 3, 6, 1, 4, 2, 5, 7, 8}));
        Utilities.println(MergeSortWithoutRecursion.mergesort(new int[]{9, 3, 6, 1, 4, 2, 5, 7, 8}));
        Utilities.println(MergeSortWithoutRecursion.sortWithoutExtra(new int[]{9, 3, 6, 1, 4, 2, 5, 7, 8}));
    }

}
