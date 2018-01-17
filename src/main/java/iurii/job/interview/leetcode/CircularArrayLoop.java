package iurii.job.interview.leetcode;

/**
 * 457. Circular Array Loop https://leetcode.com/problems/circular-array-loop/description/
 *
 * https://www.youtube.com/watch?v=VX2oZkDJeGA
 *
 * Similar to {@link iurii.job.interview.codility.cliqz.ArrayJumps}
 * Created by iurii.dziuban on 22/12/2017.
 *
 * Time complexity: O(n) at most two times one element to find a cycle
 * Auxiliary space complexity: O(1) for pointers
 */
public class CircularArrayLoop {

    /**
     * In place algorithm to find cycles in array based on:
     * 1) Forward/backward loop starting from any index of array
     * 2) Array contains delta to compute next index.
     * 3) forward - after last element comes first / backward - after first comes last. Circle based
     * 4) Circle is only if there are more than one element in the circle
     */
    public boolean circularArrayLoopLeetcode(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int pointer = i;
            int pointer2x = i;
            while (isStillSameDirection(nums, pointer2x)) {
                pointer = getNext(pointer, nums);
                pointer2x = getNext(pointer2x, nums);
                pointer2x = getNext(pointer2x, nums);
                if (pointer == pointer2x) {
                    if (getNext(pointer, nums) == pointer) {
                        break;
                    } else {
                        return true;
                    }
                }
            }
            int index = i;
            int val = nums[index];
            while (nums[index] * val > 0) {
                int next = getNext(index, nums);
                nums[index] = 0;
                index = next;
            }
        }
        return false;
    }

    private boolean isStillSameDirection(int[] nums, int pointer2x) {
        return nums[pointer2x] * nums[getNext(pointer2x, nums)] > 0
                && nums[pointer2x] * nums[getNext(getNext(pointer2x, nums), nums)] > 0;
    }

    private int getNext(int i, int[] nums) {
        int next = i + nums[i];
        int remainder = next % nums.length;
        return next > 0 ? remainder : nums.length - 1 + remainder;
    }

    /**
     * 1) element at each index point to other element or outside
     * 2) One element in loop is a circle
     * 3) Outside array is away from circle
     */
    public boolean circularArrayLoopWithOutbound(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int pointer = i;
            int pointer2x = i;
            while(isInArray(nums, pointer2x) && isInArray(nums, nums[pointer2x])) {
                pointer = nums[pointer];
                pointer2x = nums[nums[pointer2x]];
                if (pointer == pointer2x) {
                   return true;
                }
            }
            pointer = i;
            while (isInArray(nums, pointer)) {
                int curPointer = pointer;
                pointer = nums[pointer];
                nums[curPointer] = -1;
            }
        }
        return false;
    }

    private boolean isInArray(int[] nums, int index) {
        return nums[index] >= 0 && nums[index] < nums.length;
    }
}
