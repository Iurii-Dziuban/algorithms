package iurii.job.interview.convexhull;

import java.util.Arrays;

public class MergeSortByPolarAngle {

    public static Point2D[] mergesort(Point2D[] array) {
        int dividePointer = array.length / 2;
        if (dividePointer > 0) {
            Point2D[] firstHalf = mergesort(Arrays.copyOfRange(array, 0, dividePointer));
            Point2D[] secondHalf = mergesort(Arrays.copyOfRange(array, dividePointer, array.length));
            return merge(firstHalf, secondHalf);
        } else {
            return array;
        }
    }

    public static Point2D[] mergesort(Point2D[] array, int low, int high) {
        int dividePointer = (high + low) / 2;
        if (dividePointer > 0) {
            Point2D[] firstHalf = mergesort(Arrays.copyOfRange(array, low, dividePointer));
            Point2D[] secondHalf = mergesort(Arrays.copyOfRange(array, dividePointer, high));
            return merge(firstHalf, secondHalf);
        } else {
            return array;
        }
    }

    public static Point2D[] merge(Point2D[] firstHalf, Point2D[] secondHalf) {
        int totalLength = firstHalf.length + secondHalf.length;
        Point2D[] result = new Point2D[totalLength];
        int i = 0;
        int j = 0;
        for (int index = 0; index < totalLength; index++) {
            if (i == firstHalf.length || j < secondHalf.length && firstHalf[i].polarAngle > secondHalf[j].polarAngle) {
                result[index] = secondHalf[j++];
            } else {
                result[index] = firstHalf[i++];
            }
        }
        return result;
    }
}
