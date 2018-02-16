package iurii.job.interview.sorting.quick;

import java.util.Stack;

/**
 * Quick sort implementation with extra memory space(log n) & with random pivot.
 */
public class QuickSortWithoutRecursion extends QuickSort {

    public int[] sort(int[] array) {
        return sort(array, 0, array.length - 1);
    }

    private int[] sort(int[] array, int low, int high) {
        Stack<LowHigh> stack = new Stack<LowHigh>();
        stack.push(new LowHigh(low, high));
        while (!stack.isEmpty()) {
            LowHigh element = stack.pop();
            int curLow = element.getLow();
            int curHigh = element.getHigh();
            if (curLow >= curHigh) {
                continue;
            }
            int pivot = pivot(array, curLow, curHigh);
            stack.push(new LowHigh(curLow, pivot - 1));
            stack.push(new LowHigh(pivot + 1, curHigh));
        }
        return array;
    }

    private static class LowHigh {
        private final int low;
        private final int high;

        public LowHigh(int low, int high) {
            this.low = low;
            this.high = high;
        }

        public int getLow() {
            return low;
        }

        public int getHigh() {
            return high;
        }

    }
}
