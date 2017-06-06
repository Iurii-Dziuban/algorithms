package iurii.job.interview._unionfind.quickunion;

import iurii.job.interview._unionfind.quickfind.QuickFind;

/**
 * Better than {@link QuickFind}
 * + O(log(n)) time to find
 * - O(log(n)) time to union
 * Union is not optimal - fat trees
 */
public class QuickUnion {

    private final int[] vertices;

    public QuickUnion(int size) {
        vertices = new int[size];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = i;
        }
    }

    public boolean find(int i, int j) {
        return root(vertices[i]) == root(vertices[j]);
    }

    public void union(int i, int j) {
        int rootI = root(vertices[i]);
        int rootJ = root(vertices[j]);
        if (rootI == rootJ) {
            return;
        } else {
            // otfonarya
            vertices[rootJ] = rootI;
        }
    }

    private int root(int i) {
        int index = i;
        while (vertices[index] != index) {
            index = vertices[index];
        }
        return index;
    }
}
