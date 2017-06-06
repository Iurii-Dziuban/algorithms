package iurii.job.interview.topcoder.srm503;
/**
 * SRM 503/603
 * Problem Statement
 * ����
 * NOTE: This problem statement contains images that may not display properly if viewed outside of the applet.
 * Toastman is going to create several eye-popping slices of toast out of several types of bread.
 * Each type of bread has a positive number X (not necessarily integer) such that
 * if a slice of bread of that type is toasted for less than X minutes,
 * it becomes under toasted and if it is toasted for more than X minutes,
 * it becomes over toasted. A slice of bread that is toasted for exactly X minutes becomes an eye-popping slice of toast.
 * Note that the number X for different types of bread may be different,
 * but such numbers will be the same for every slice of bread of a particular bread type.
 * Toastman has toasted several slices of bread with the hope of creating an eye-popping slice of toast from several types of bread.
 * Unfortunately he didn't know the exact value of X for any type of bread so all the slices of bread
 * that he toasted became either under toasted or over toasted. You are given int[]s undertoasted
 * and overtoasted denoting the slices of toast that were under toasted and over toasted, respectively.
 * Each element will be an integer denoting the number of minutes that the corresponding slice of bread was toasted.
 * Toastman does not have a very good memory (his brain is made out of bread!).
 * Although he forgot which type of bread was used for each slice of toast,
 * he thinks that the following condition was satisfied:
 * Each type of bread was used for at least one under toasted slice of toast and at least one over toasted slice of toast.
 * Return the minumum number of types of bread that could statisfy this condition.
 * If the condition can not be satisified return -1.
 * <p>
 * Constraints
 * -
 * undertoasted will contain between 1 and 50 elements, inclusive.
 * -
 * Each element of undertoasted will be between 1 and 1,000,000, inclusive.
 * -
 * All the elements of undertoasted will be distinct.
 * -
 * overtoasted will contain between 1 and 50 elements, inclusive.
 * -
 * Each element of overtoasted will be between 1 and 1,000,000, inclusive.
 * -
 * All the elements of overtoasted will be distinct.
 * -
 * overtoasted and undertoasted will not have an element in common.
 * <p>
 * 1)
 * <p>
 * ����
 * {5}
 * {4}
 * Returns: -1
 * <p>
 * 2)
 * <p>
 * ����
 * {1,2,3}
 * {5,6,7}
 * Returns: 1
 * <p>
 * 3)
 * <p>
 * ����
 * {1,3,5}
 * {2,4,6}
 * Returns: 2
 */

import java.util.Arrays;

public class ToastXToast {

    public static void main(String[] args) {
        System.out.println(new ToastXToast().bake(new int[]{1, 3, 5}, new int[]{2, 4, 6}));
    }

    public int bake(int[] undertoasted, int[] overtoasted) {
        Arrays.sort(undertoasted);
        Arrays.sort(overtoasted);
        reverse(undertoasted);
        reverse(overtoasted);
        int uIndex = 0;
        int oIndex = 0;
        if (undertoasted[0] > overtoasted[0]) {
            return -1;
        }
        int groupsCount = 1;
        boolean maybeWillFail = false;
        while (uIndex < undertoasted.length && oIndex < overtoasted.length) {
            if (overtoasted[oIndex] > undertoasted[uIndex]) {
                oIndex++;
                maybeWillFail = false;
            } else {
                if (maybeWillFail) {
                    return -1;
                }
                maybeWillFail = true;
                uIndex++;
                groupsCount++;
            }
        }
        if (maybeWillFail) {
            return -1;
        }
        return groupsCount;
    }

    private static void reverse(int[] b) {
        int left = 0; // index of leftmost element
        int right = b.length - 1; // index of rightmost element

        while (left < right) {
            // exchange the left and right elements
            int temp = b[left];
            b[left] = b[right];
            b[right] = temp;

            // move the bounds toward the center
            left++;
            right--;
        }
    }// endmethod reverse
}
