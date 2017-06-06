package iurii.job.interview.graph.depth_first_search;

import iurii.job.interview.graph.structure.UnorderedGraph;

import java.util.Iterator;
import java.util.Stack;

/**
 * DepthFirstSearch with circle dependences
 *
 * @author Jacky
 */
public class DepthFirstSearchWithoutRecursion {

    private final int source;
    private final boolean[] marked;
    private final int[] edgeTo;
    private boolean hasCircle;

    public DepthFirstSearchWithoutRecursion(UnorderedGraph graph, int source) {
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
        Stack<Integer> elements = new Stack<Integer>();
        elements.push(source);
        while (!elements.isEmpty()) {
            int element = elements.pop();
            marked[element] = true;
            Iterator<Integer> iterator = graph.adj(element).iterator();
            while (iterator.hasNext()) {
                int w = iterator.next();
                if (!marked[w]) {
                    edgeTo[w] = element;
                    elements.push(w);
                } else {
                    if (edgeTo[element] != w) {
                        hasCircle = true;
                    }
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
