package iurii.job.interview.codility.cliqz;

import java.util.Arrays;

/**
 * https://codility.com/honeypot/Burda-Cliqz_Programmer/
 * Created by IuriiDziuban on 10/29/17.
 */
public class Kcomplementary {

    public int solution(int K, int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int kcount = 0;
        int left = 0;
        int right = A.length - 1;
        while (right >=0 && left < A.length) {
            if (A[left] + A[right] == K) {
                kcount++;
                if (left + 1 < A.length && A[left + 1] == A[left]) {
                    left++;
                } else {
                    right--;
                }
            } else {
                if (A[left] + A[right] > K){
                    right--;
                } else {
                    left++;
                }
            }
        }
        return kcount;
    }
}
