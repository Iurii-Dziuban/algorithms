package iurii.job.interview.sorting;

import java.util.List;

public final class Utilities {

    public static void println(int[] array) {
        for (int anArray : array) {
            System.out.print(anArray + " ");
        }
        System.out.println();
    }

    public static void println(List<?> list) {
        for (Object aList : list) {
            System.out.print(aList + " ");
        }
        System.out.println();
    }

    public static void println(int[][] matrix) {
        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                System.out.print(anAMatrix + " ");
            }
            System.out.println();
        }
    }
}
