package iurii.job.interview.graph.depth_first_search;

import java.util.Iterator;
import java.util.Stack;

import iurii.job.interview.graph.structure.UnorderedGraph;

/**
 * DepthFirstSearch with circle dependences
 * 
 * @author Jacky
 * 
 */
public class DepthFirstSearch {

    private final int source;
    private final boolean[] marked;
    private final int[] edgeTo;
    private boolean hasCircle;

    public DepthFirstSearch(UnorderedGraph graph, int source) {
        this.source = source;
        marked = new boolean[graph.verticesCount()];
        edgeTo = new int[graph.verticesCount()];
        for (int i = 0; i < graph.verticesCount(); i++) {
            edgeTo[i] = -1;
            marked[i] = false;
        }
        edgeTo[source] = source;
        dfs(graph, source);
    }

    private void dfs(UnorderedGraph graph, int source) {
        marked[source] = true;
        Iterator<Integer> iterator = graph.adj(source).iterator();
        while (iterator.hasNext()) {
            int w = iterator.next();
            if (!marked[w]) {
                edgeTo[w] = source;
                dfs(graph, w);
            } else {
                if (edgeTo[source] != w) {
                    hasCircle = true;
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Stack<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> pathTo = new Stack<Integer>();
        int current = v;
        while (current != source) {
            pathTo.push(current);
            current = edgeTo[current];
        }
        pathTo.push(source);
        return pathTo;
    }

    public boolean hasCircle() {
        return hasCircle;
    }
}
