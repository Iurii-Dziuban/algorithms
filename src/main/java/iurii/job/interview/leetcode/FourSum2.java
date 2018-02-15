package iurii.job.interview.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 454. 4Sum II https://leetcode.com/problems/4sum-ii/description/
 *
 * ideas is similar to {@link FourSum}
 *
 * Time complexity : O(N^2)
 * Auxiliary space complexity : O(N^2) to store map of 2sum of two arrays
 *
 * N is the longest length of the arrays
 */
public class FourSum2 {

    public int fourSumCountEfficient(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        int target = 0;
        Map<Integer, Integer> sumCD = new HashMap<>();
        for (int c : C) {
            for (int d : D) {
                int key = c + d;
                sumCD.put(key, sumCD.getOrDefault(key, 0) + 1);
            }
        }
        for (int a : A) {
            for (int b : B) {
                count += sumCD.getOrDefault(target - a - b, 0);
            }
        }
        return count;
    }

    public int fourSumCountForLoop(int[] A, int[] B, int[] C, int[] D) {
        if (A.length == 0 || B.length == 0 || C.length == 0 || D.length ==0) {
            return 0;
        }
        int count = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);
        int target = 0;
        for (long a : A) {
            if (a + B[0] + C[0] + D[0] > target) break;
            if (a + B[B.length - 1] + C[C.length - 1] + D[D.length - 1] < target) continue;
            for (int b : B) {
                if (a + b + C[0] + D[0] > target) break;
                if (a + b + C[C.length - 1] + D[D.length - 1] < target) continue;
                int low = 0, high = D.length - 1;
                while (low < C.length && high >= 0) {
                    long sum = a + b + C[low] + D[high];
                    if (sum == target) {
                        int curLow = low;
                        while (curLow < C.length && C[curLow] == C[low]) {
                            int curHigh = high;
                            while (curHigh >=0 && D[high] == D[curHigh]) {
                                count++;
                                curHigh--;
                            }
                            curLow++;
                        }
                        low = curLow;
                    } else if (sum < target) low++;
                    else high--;
                }
            }
        }
        return count;
    }

    public int fourSumCountWith2Sums(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        long[] sumAB = new long[A.length * B.length];
        long[] sumCD = new long[C.length * D.length];
        for (int k = 0, i = 0; i < A.length; i++) {
            for (int b : B) {
                sumAB[k++] = A[i] + b;
            }
        }
        for (int k = 0, i = 0; i < C.length; i++) {
            for (int d : D) {
                sumCD[k++] = C[i] + d;
            }
        }
        Arrays.sort(sumAB);
        Arrays.sort(sumCD);
        int target = 0;
        int i = 0;
        int j = sumCD.length - 1;
        while (i < sumAB.length && j >= 0) {
            long sum = sumAB[i] + sumCD[j];
            if (sum == target) {
                int curI = i;
                while (curI < sumAB.length && sumAB[curI] == sumAB[i]) {
                    int curJ = j;
                    while (curJ >=0 && sumCD[j] == sumCD[curJ]) {
                        count++;
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
        return count;
    }

}
