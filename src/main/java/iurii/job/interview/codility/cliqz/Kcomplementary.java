package iurii.job.interview.codility.cliqz;

import java.util.Arrays;

/**
 * https://codility.com/honeypot/Burda-Cliqz_Programmer/
 * Created by IuriiDziuban on 10/29/17.
 */
public class Kcomplementary {

    public int solution(int K, int[] A) {
        // write your code in Java SE 8
        // sorting
        Arrays.sort(A);
        // count can be really big
        int sameIndexCount = 0;
        // equal index count
        for(long value : A){
            if (2 * value == K){
                sameIndexCount++;
            }
        }
        int kcount = 0;
        // two pointers - from left and right
        int left = 0;
        int right = A.length - 1;
        while (right > left) {
            long sum = (long) A[left] + A[right];
            if (sum == K) {
                if (A[left] == A[right]) {
                    long count = right - left + 1;
                    kcount += (count - 1) * count / 2;
                    left = right;
                } else {
                    int leftDuplicateCount = 1;
                    while (left + 1 <= right && A[left + 1] == A[left]) {
                        leftDuplicateCount++;
                        left++;
                    }
                    left--;
                    int rightDuplicateCount = 1;
                    while (right - 1 >= left && A[right - 1] == A[right]) {
                        rightDuplicateCount++;
                        right--;
                    }
                    right--;
                    kcount +=leftDuplicateCount * rightDuplicateCount;
                }
            } else {
                if (sum > K){
                    right--;
                } else {
                    left++;
                }
            }
        }
        return kcount * 2 + sameIndexCount;
    }
}
