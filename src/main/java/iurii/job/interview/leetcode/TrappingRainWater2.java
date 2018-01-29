package iurii.job.interview.leetcode;

import java.util.PriorityQueue;

/**
 * 407. Trapping Rain Water II https://leetcode.com/problems/trapping-rain-water-ii/description/
 *
 * http://shirleyisnotageek.blogspot.de/2016/11/trapping-rain-water-ii.html
 *
 * https://stackoverflow.com/questions/21818044/the-maximum-volume-of-trapped-rain-water-in-3d
 *
 * Time complexity: O(N*M*log(N*M)) n,m - height and width of the landscape
 * (logarithm is added for priorityQueue insert operations)
 * Auxiliary space: O(N*M) to store priority queue and visited map
 *
 *
 */
public class TrappingRainWater2 {
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<Cell> queue = new PriorityQueue<>();
        if (heightMap == null || heightMap.length == 0 || heightMap[0] == null || heightMap[0].length == 0) {
            return 0;
        }
        int lastRow = heightMap.length - 1;
        int lastColumn = heightMap[0].length - 1;
        boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];
        for (int j = 0; j <= lastColumn; j++) {
            queue.add(new Cell(0, j, heightMap[0][j]));
            queue.add(new Cell(lastRow, j, heightMap[lastRow][j]));
            visited[0][j] = visited[lastRow][j] = true;
        }
        for (int i = 1; i < lastRow; i++) {
            queue.add(new Cell(i, 0, heightMap[i][0]));
            queue.add(new Cell(i, lastColumn, heightMap[i][lastColumn]));
            visited[i][0] = visited[i][lastColumn] = true;
        }
        int[] xStep = new int[]{0,0,-1,1};
        int[] yStep = new int[]{-1,1, 0, 0};
        int sum = 0;
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            visited[cell.x][cell.y] = true;
            for (int i = 0; i < xStep.length; i++) {
                int nextX = cell.x + xStep[i];
                int nextY = cell.y + yStep[i];
                if (nextX >= 0 && nextX <= lastRow && nextY >= 0 && nextY <= lastColumn && !visited[nextX][nextY]) {
                    queue.add(new Cell(nextX, nextY, Math.max(heightMap[nextX][nextY], cell.height)));
                    sum += Math.max(0, cell.height - heightMap[nextX][nextY]);
                    visited[nextX][nextY] = true;
                }
            }
        }
        return sum;
    }

    private static class Cell implements Comparable<Cell> {
        private final int x;
        private final int y;
        private final int height;

        private Cell(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }

        @Override
        public int compareTo(Cell o) {
            return height - o.height;
        }
    }
}
