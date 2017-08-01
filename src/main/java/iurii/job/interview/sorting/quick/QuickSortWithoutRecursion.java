package iurii.job.interview.sorting.quick;

import java.util.Stack;

/**
 * Quick sort implementation with extra memory space(log n) & with random pivot.
 */
public class QuickSortWithoutRecursion extends QuickSort {

    public int[] sort(int[] array) {
        return sort(array, 0, array.length - 1);
    }

    private int[] sort(int[] array, int start, int end) {
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
