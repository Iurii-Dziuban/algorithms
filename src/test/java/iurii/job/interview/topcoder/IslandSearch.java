package iurii.job.interview.topcoder;

import iurii.job.interview.utils.pair.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Input quadratic matrix size matrix with 0/1 elements split by space. Find
 * number and sizes of islands of ones in the matrix. (Island - ones that has
 * border up, down left, right (south-west, south-east, north-west, north-east))
 * ones elements together border elements in the matrix do not have neighbor
 * from their side or sides Example [1 0 0 0 1] [1 1 0 1 0] [0 0 0 0 0] [1 0 1 1
 * 1] [1 0 1 1 1]
 * <p>
 * Result: 4 islands with 3,2,2,6 squares
 */
public class IslandSearch {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int arg_index = 1;
        int[][] islandMatrix = new int[n + 2][n + 2];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                islandMatrix[i][j] = Integer.parseInt(args[arg_index++]);
            }
        }

        List<Integer> islandSquare = new ArrayList<Integer>();

        for (int i = 1; i < islandMatrix.length - 1; i++) {
            for (int j = 1; j < islandMatrix.length - 1; j++) {
                int square = expandIslandReturnSquareWithoutRecursionBFS(
                        islandMatrix, i, j);
                if (square != 0) {
                    islandSquare.add(square);
                }
            }
        }

        int islandCount = islandSquare.size();
        System.out.println(islandCount);
        for (int square : islandSquare) {
            System.out.print(square + " ");
        }
        System.out.println();

    }

    private static int expandIslandReturnSquareWithoutRecursionBFS(
            int[][] islandMatrix, int i, int j) {
        if (islandMatrix[i][j] == 0) {
            return 0;
        }
        Queue<Pair> queue = new ArrayDeque<Pair>();
        queue.add(new Pair(i, j));
        int sum = 0;
        while (!queue.isEmpty()) {
            Pair element = queue.poll();
            int curI = element.getFirst();
            int curJ = element.getSecond();
            if (islandMatrix[curI][curJ] != 0) {
                sum += 1;
                islandMatrix[curI][curJ] = 0;
                // up, down left, right
                addToQueueIfIsland(islandMatrix, queue, curI + 1, curJ);
                addToQueueIfIsland(islandMatrix, queue, curI, curJ + 1);
                addToQueueIfIsland(islandMatrix, queue, curI - 1, curJ);
                addToQueueIfIsland(islandMatrix, queue, curI, curJ - 1);
                // south-west, south-east, north-west, north-east
                addToQueueIfIsland(islandMatrix, queue, curI + 1, curJ + 1);
                addToQueueIfIsland(islandMatrix, queue, curI + 1, curJ - 1);
                addToQueueIfIsland(islandMatrix, queue, curI - 1, curJ + 1);
                addToQueueIfIsland(islandMatrix, queue, curI - 1, curJ - 1);
            }
        }
        return sum;
    }

    private static void addToQueueIfIsland(int[][] islandMatrix,
                                           Queue<Pair> queue, int curI, int curJ) {
        if (islandMatrix[curI][curJ] != 0) {
            queue.add(new Pair(curI, curJ));
        }
    }
}
