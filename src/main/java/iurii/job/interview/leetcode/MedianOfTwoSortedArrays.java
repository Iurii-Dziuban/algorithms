package iurii.job.interview.leetcode;

/**
 * 4. Median of Two Sorted Arrays  https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * Generic algorithm:
 * https://www.geeksforgeeks.org/median-of-two-sorted-arrays-of-different-sizes/
 *
 * Time complexity: O(log(m+n))
 * Space complexity: O(1) for the sliding window
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return nums1.length > nums2.length ? findMedianUtil( nums2, 0, nums2.length, nums1, 0, nums1.length ) : findMedianUtil( nums1, 0, nums1.length, nums2, 0, nums2.length) ;
    }

    private double medianOf2(double a, double b) {
        return (a + b) / 2;
    }

    private double medianOf3(double a, double b, double c) {
        return a + b + c - Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c));
    }

    private double medianOf4(double a, double b, double c, double d) {
        double max = Math.max(a, Math.max(b, Math.max(c, d)));
        double min = Math.min(a, Math.min(b, Math.min(c, d)));
        return (a+b+c+d - max - min) / 2;
    }

    private double medianOfArray(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return -1;
        }
        return n % 2 == 0 ? (arr[n/2 - 1] + arr[n/2])/2.0 : arr[n/2];
    }

    private double findMedianUtil(int[] a, int aStartIndex, int aElementCount, int[] b, int bStartIndex, int bElementCount) {
        if (aElementCount == 0) {
            return medianOfArray(b);
        }
        if (aElementCount == 1) {
            if (bElementCount == 1) {
                return medianOf2(a[aStartIndex], b[bStartIndex]);
            }
            if ((bElementCount & 1) == 1) {
                return medianOf2(b[bStartIndex + bElementCount/2], medianOf3(a[aStartIndex],
                        b[bStartIndex + bElementCount/2-1],
                        b[bStartIndex +bElementCount/2+1]));
            } else {
                return medianOf3(b[bStartIndex + bElementCount/2],
                        b[bStartIndex + bElementCount/2 - 1], a[aStartIndex]);
            }
        }
        if (aElementCount == 2) {
            if (bElementCount == 2) {
                return medianOf4(a[aStartIndex], a[aStartIndex + 1], b[bStartIndex], b[bStartIndex + 1]);
            }
            if ((bElementCount & 1) == 1) {
                return medianOf3(b[bStartIndex + bElementCount/2],
                        Math.max(a[aStartIndex], b[bStartIndex + bElementCount/2 - 1]),
                        Math.min(a[aStartIndex + 1], b[bStartIndex + bElementCount/2 + 1]));
            } else {
                return medianOf4(b[bStartIndex + bElementCount/2 - 1],
                        b[bStartIndex + bElementCount/2],
                        Math.max(a[aStartIndex], b[bStartIndex + bElementCount/2 - 2]),
                        Math.min(a[aStartIndex + 1], b[bStartIndex + bElementCount/2 + 1])
                );
            }
        }
        int idxA = ( aElementCount - 1 ) / 2;
        int idxB = ( bElementCount - 1 ) / 2;
        if (a[aStartIndex + idxA] <= b[bStartIndex + idxB]) {
            return findMedianUtil(a,aStartIndex + idxA,aElementCount / 2 + 1, b, bStartIndex, bElementCount - idxA);
        } else {
            return findMedianUtil(a, aStartIndex, aElementCount / 2 + 1, b, bStartIndex + idxA, bElementCount - idxA);
        }

    }
}
