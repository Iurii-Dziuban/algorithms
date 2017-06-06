package iurii.job.interview._unionfind.quickfind;

import java.util.HashSet;
import java.util.Set;

/**
 * Easy O(n) implementation using array - values in array are group index
 * + constant time to find
 * - O(n) time to union
 */
public class QuickFind {

    private final int[] vertices;

    public QuickFind(int size) {
        vertices = new int[size];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = i;
        }
    }

    public boolean find(int i, int j) {
        return vertices[i] == vertices[j];
    }

    public void union(int i, int j) {
        int valueTochange = vertices[i];
        if (valueTochange == vertices[j]) {
            throw new IllegalStateException();
            //return;
        }
        for (int index = 0; index < vertices.length; index++) {
            if (vertices[index] == valueTochange) {
                vertices[index] = vertices[j];
            }
        }
    }

    public int different() {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < vertices.length; i++) {
            set.add(vertices[i]);
        }
        return set.size();
    }

}
