package iurii.job.interview._unionfind.quickunion;

import iurii.job.interview._unionfind.quickfind.QuickFind;

import java.util.ArrayList;
import java.util.List;

/**
 * Better than {@link QuickFind}
 * + O(log(n)) time to find
 * - O(log(n)) time to union
 * Union is optimal. Fat trees not allowed.
 * + Trying to make flat tree on find
 * - Extra memory
 */
public class QuickUnionWeighted {

    private final int[] vertices;
    private final int[] weight;

    public QuickUnionWeighted(int size) {
        vertices = new int[size];
        weight = new int[size];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = i;
            weight[i] = 1;
        }
    }

    public boolean find(int i, int j) {
        List<Integer> pathI = new ArrayList<Integer>();
        List<Integer> pathJ = new ArrayList<Integer>();
        int rootI = root(i, pathI);
        for (int k = 0; k < pathI.size(); k++) {
            vertices[pathI.get(k)] = rootI;
        }
        int rootJ = root(j, pathJ);
        for (int k = 0; k < pathJ.size(); k++) {
            vertices[pathJ.get(k)] = rootJ;
        }
        return rootI == rootJ;
    }

    public void union(int i, int j) {
        int rootI = root(i);
        int rootJ = root(j);
        if (rootI != rootJ) {
            if (weight[rootI] < weight[rootJ]) {
                vertices[rootI] = rootJ;
                weight[rootI] = Math.max(weight[rootI] - 1, rootJ) + 1;
            } else {
                vertices[rootJ] = rootI;
                weight[rootJ] = Math.max(weight[rootJ] - 1, rootI) + 1;
            }
        }
    }

    private int root(int i, List<Integer> path) {
        int index = i;
        while (vertices[index] != index) {
            index = vertices[index];
            path.add(index);
        }
        return index;
    }

    private int root(int i) {
        int index = i;
        while (vertices[index] != index) {
            index = vertices[index];
        }
        return index;
    }
}
