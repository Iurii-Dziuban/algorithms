package iurii.job.interview.codility;

/**
 *
 Write a function:

 class Solution { public int solution(int[] A); }
 that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

 For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

 For another example, given A = [1, 2, 3], the function should return 4.

 Given A = [−1, −3], the function should return 1.

 Assume that:

 N is an integer within the range [1..100,000];
 each element of array A is an integer within the range [−1,000,000..1,000,000].
 Complexity:

 expected worst-case time complexity is O(N);
 expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 Elements of input arrays can be modified.
 *
 * https://codility.com/programmers/lessons/4-counting_elements/missing_integer/
 *
 * https://stackoverflow.com/questions/25002381/missing-integer-variation-on-solution-needed
 *
 * Created by iurii.dziuban on 29/09/2017.
 *
 */
public class MissingInteger {

    // based on pigeon hole principle there will be one of 1..100001 is absent and it will be an answer.
    // so it is enough to have only an array of 0..100000, so size 100001.
    // Non positive and values more than 100001
    public int solution(int[] A) {
        boolean[] present = new boolean[100001];

        for (int value : A) {
            if (value <= present.length && value > 0) {
                present[value - 1] = true;
            }
        }
        int i = 0;
        while (present[i]) {
            i++;
        }
        return i + 1;
    }

}
