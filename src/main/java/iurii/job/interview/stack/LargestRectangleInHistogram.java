package iurii.job.interview.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * https://www.youtube.com/watch?v=VNbkzsnllsU&t=179s
 *
 * http://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-set-1/
 * 
 * There is a histogram:
 * 1 3 2 1 2
 *
 * Answer : 5 = 1 * (5-0) = 5
 *
 * Find the largest rectangle in it that covers histogram
 *
 * Array should not contain negative values
 *
 * Possible enhancement to have both (negative and positive) and track moving from one side to another and clear stacks
 *
 * Solution is to use two stacks to store greatest Y (heights) in the stack and their X (positions) in the second stack
 * So if Y is bigger than previous and meaningful (not equal 0, cause 0 will not gave us solution) just add to the stack
 * if less than pop up position and height and
 * check possible rectangle until height is less in the stack when current height
 *
 * Time complexity O(N) for traversal and stack pop/push
 * Auxiliary space O(N) for stacks
 * Created by iurii.dziuban on 14/06/2017.
 */
public class LargestRectangleInHistogram {

    public int findLargestRectangleInHistogram(int[] heights) {
        if (heights == null) {
            throw new IllegalArgumentException("array should not be null");
        }
        // check negative heights
        if (Arrays.stream(heights).anyMatch(value -> value < 0)) {
            throw new IllegalArgumentException("array should not contain negative heights");
        }
        // adding 0 in the end to handle end in the cycle (not after)
        heights = Arrays.copyOf(heights, heights.length + 1);
        Stack<Integer> positionsStack = new Stack<>();
        Stack<Integer> heightsStack = new Stack<>();
        int index = 0;
        int maxSquare = 0;
        for (int value : heights) {
            if (value > 0 && (heightsStack.isEmpty() || heightsStack.peek() < value)) {
                heightsStack.add(value);
                positionsStack.add(index);
            } else {
                Integer lastHeight = null;
                Integer lastPosition = null;
                while (!heightsStack.isEmpty() && heightsStack.peek() > value) {
                    lastHeight = heightsStack.pop();
                    lastPosition = positionsStack.pop();
                    // height before current
                    int rectangleSquare = lastHeight * (index - lastPosition);
                    if (maxSquare < rectangleSquare) {
                        maxSquare = rectangleSquare;
                    }
                }
                // adding new previous max possible height and start position
                if (lastHeight != null) {
                    heightsStack.add(value);
                    positionsStack.add(lastPosition);
                }
            }
            index++;
        }
        return maxSquare;
    }

    /**
     * Improvement to have negative values as well.
     * However rectangle is calculated between OX and heights,
     * so it is located either in negative area or positive
     *
     * Idea is simple to use absolute values and clear stacks when changing the sign
     * (but calculate possible squares when clearing)
     */
    public int findLargestRectangleInHistogramNegativesArePossible(int[] values) {
        if (values == null) {
            throw new IllegalArgumentException("array should not be null");
        }
        // adding 0 in the end to handle end in the cycle (not after)
        values = Arrays.copyOf(values, values.length + 1);
        Stack<Integer> positions = new Stack<>();
        Stack<Integer> heights = new Stack<>();
        int index = 0;
        int maxSquare = 0;
        int currentSign = 0;
        for (int value : values) {
            // check all clear stack if sign is changed
            if (value * currentSign < 0) {
                while (!heights.isEmpty()) {
                    int rectangleSquare = Math.abs(heights.pop()) * (index - positions.pop());
                    if (maxSquare < rectangleSquare) {
                        maxSquare = rectangleSquare;
                    }
                }
                heights.clear();
                positions.clear();
            }
            if (value != 0 && (heights.isEmpty() || Math.abs(heights.peek()) < Math.abs(value))) {
                // adding new value and putting sign
                heights.add(value);
                positions.add(index);
                currentSign = value > 0 ? 1 : -1;
            } else {
                Integer lastHeight = null;
                Integer lastPosition = null;
                while (!heights.isEmpty() && Math.abs(heights.peek()) > Math.abs(value)) {
                    lastHeight = heights.pop();
                    lastPosition = positions.pop();
                    // height before current
                    int rectangleSquare = Math.abs(lastHeight) * (index - lastPosition);
                    if (maxSquare < rectangleSquare) {
                        maxSquare = rectangleSquare;
                    }
                }
                // adding new previous max possible height and start position
                if (lastHeight != null) {
                    heights.add(value);
                    positions.add(lastPosition);
                }
            }
            index++;
        }
        return maxSquare;
    }
}
