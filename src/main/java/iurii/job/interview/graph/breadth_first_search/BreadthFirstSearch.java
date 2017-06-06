package iurii.job.interview.graph.breadth_first_search;

import iurii.job.interview.graph.structure.UnorderedGraph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Jacky
 */
public class BreadthFirstSearch {
    private final int source;
    private final boolean[] marked;
    private final int[] edgeTo;

    public BreadthFirstSearch(UnorderedGraph graph, int source) {
        this.source = source;
        marked = new boolean[graph.verticesCount()];
        edgeTo = new int[graph.verticesCount()];
        for (int i = 0; i < graph.verticesCount(); i++) {
            edgeTo[i] = -1;
            marked[i] = false;
        }
        edgeTo[source] = source;
        bfs(graph, source);
    }

    private void bfs(UnorderedGraph graph, int source) {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            marked[v] = true;
            Iterable<Integer> adj = graph.adj(v);
            for (int w : adj) {
                if (!marked[w]) {
                    edgeTo[w] = source;
                    queue.add(w);
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

}
