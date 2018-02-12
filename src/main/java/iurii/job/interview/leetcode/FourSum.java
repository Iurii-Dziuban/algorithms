package iurii.job.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 18. 4Sum https://leetcode.com/problems/4sum/description/
 * <p>
 * https://www.geeksforgeeks.org/find-four-numbers-with-sum-equal-to-given-sum/
 * <p>
 * https://www.geeksforgeeks.org/find-four-elements-that-sum-to-a-given-value-set-2/
 * <p>
 * Time complexity : O(N^2*log(N))
 * Auxiliary space complexity : O(N^2) for the 2Sum array
 */
public class FourSum {

    public List<List<Integer>> fourSumWith2Sums(int[] nums, int target) {
        Set<List<Integer>> results = new HashSet<>();
        int size = nums.length * (nums.length - 1) / 2;
        Pair[] pairs = new Pair[size];
        for (int k = 0, i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                pairs[k++] = new Pair(i, j, nums[i] + nums[j]);
            }
        }
        Arrays.sort(pairs);
        int i = 0;
        int j = size - 1;
        while (i < j) {
            int sum = pairs[i].getSum() + pairs[j].getSum();
            if (sum == target) {
                if (areUnique(pairs[i], pairs[j])) {
                    results.add(getSolution(nums, pairs[i], pairs[j]));
                }
                int curI = i;
                while (pairs[curI].compareTo(pairs[i]) == 0 && curI < j) {
                    int curJ = j;
                    while (curJ > curI && pairs[j].compareTo(pairs[curJ]) == 0) {
                        if (areUnique(pairs[curI], pairs[curJ])) {
                            results.add(getSolution(nums, pairs[curI], pairs[curJ]));
                        }
                        curJ--;
                    }
                    curI++;
                }
                i = curI;
            } else {
                if (sum < target) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        ArrayList<List<Integer>> lists = new ArrayList<>(results);
        lists.sort((list1, list2) -> {
            int minSize = Math.min(list1.size(), list2.size());
            int res = 0;
            for (int index = 0; index < minSize; index++) {
                res = Integer.compare(list1.get(index), list2.get(index));
                if (res != 0) {
                    break;
                }
            }
            return res;
        });
        return lists;
    }

    private List<Integer> getSolution(int[] nums, Pair pair, Pair pair1) {
        List<Integer> solution = Arrays.asList(nums[pair.getFirstIndex()], nums[pair.getSecondIndex()],
                nums[pair1.getFirstIndex()], nums[pair1.getSecondIndex()]);
        solution.sort(Integer::compare);
        return solution;
    }

    private static boolean areUnique(Pair one, Pair two) {
        return (one.getFirstIndex() != two.getFirstIndex())
                && (one.getFirstIndex() != two.getSecondIndex())
                && (one.getSecondIndex() != two.getFirstIndex())
                && (one.getSecondIndex() != two.getSecondIndex());
    }

    private static class Pair implements Comparable<Pair> {
        private final int firstIndex;
        private final int secondIndex;
        private final int sum;

        int getFirstIndex() {
            return firstIndex;
        }

        int getSecondIndex() {
            return secondIndex;
        }

        public int getSum() {
            return sum;
        }

        private Pair(int firstIndex, int secondIndex, int sum) {
            this.firstIndex = firstIndex;
            this.secondIndex = secondIndex;
            this.sum = sum;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(sum, o.sum);
        }
    }

    //o(n^3) showed better results on the test cases. Looks like constant in bigO notation matters for test cases
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if (nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if (nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) continue;
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int low = j + 1, high = n - 1;
                while (low < high) {
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if (sum < target) low++;
                    else high--;
                }
            }
        }
        return result;
    }
}
