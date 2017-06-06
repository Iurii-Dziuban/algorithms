package iurii.job.interview.sorting.quick;

import java.util.Random;
import java.util.Stack;

/**
 * Quick sort implementation with extra memory space(log n) & with random pivot.
 */
public class QuickSortWithoutRecursion {

    public static int[] sort(int[] array) {
        return sort(array, 0, array.length - 1);
    }

    private static int[] sort(int[] array, int start, int end) {
        Stack<StartEnd> stack = new Stack<StartEnd>();
        stack.push(new StartEnd(start, end));
        while (!stack.isEmpty()) {
            StartEnd element = stack.pop();
            int curStart = element.getStart();
            int curEnd = element.getEnd();
            if (curStart >= curEnd) {
                continue;
            }
            int pivot = pivot(array, curStart, curEnd);
            stack.push(new StartEnd(curStart, pivot - 1));
            stack.push(new StartEnd(pivot + 1, curEnd));
        }
        return array;
    }

    private static int pivot(int[] array, int start, int end) {
        // random pivot
        Random rand = new Random();
        int pivotIndex = rand.nextInt(end - start + 1) + start;
        int pivot = array[pivotIndex];
        // swap first
        int swapFirst = array[start];
        array[start] = array[pivotIndex];
        array[pivotIndex] = swapFirst;
        int i = start + 1;
        // swap for <p & >p border
        for (int j = start + 1; j <= end; j++) {
            if (array[j] < pivot) {
                int swap = array[i];
                array[i] = array[j];
                array[j] = swap;
                i++;
            }
        }
        // final swap
        array[start] = array[i - 1];
        array[i - 1] = pivot;
        return i - 1;
    }

    private static class StartEnd {
        private final int start;
        private final int end;

        public StartEnd(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

    }

}
