package iurii.job.interview.graph.depth_first_search;

import java.util.Iterator;
import java.util.Stack;

import iurii.job.interview.graph.structure.OrderedGraph;
import iurii.job.interview.graph.structure.UnorderedGraph;

/**
 * Directed graph. Similar to Connectivity groups in Unordered graph.
 */
public class StrongConnectedComponents {
    private int[] connectivityGroups;
    private boolean[] marked;

    public StrongConnectedComponents(OrderedGraph graph) {
        OrderedGraph reverse = graph.reverse();
        TopologicalOrder tp = new TopologicalOrder(reverse);
        marked = new boolean[graph.verticesCount()];
        connectivityGroups = new int[graph.verticesCount()];
        for (int i = 0; i < connectivityGroups.length; i++) {
            connectivityGroups[i] = Integer.MAX_VALUE;
        }
        Stack<Integer> topologicalOrder = tp.topologicalOrder();
        int index = 0;
        while (!topologicalOrder.isEmpty()) {
            int v = topologicalOrder.pop();
            if (!marked[v]) {
                dfs(graph, v, index++);
            }
        }
    }

    private void dfs(UnorderedGraph graph, int source, int index) {
        Stack<Integer> elements = new Stack<Integer>();
        elements.push(source);
        while (!elements.isEmpty()) {
            int element = elements.pop();
            connectivityGroups[element] = index;
            marked[element] = true;
            Iterator<Integer> iterator = graph.adj(element).iterator();
            while (iterator.hasNext()) {
                int w = iterator.next();
                if (!marked[w]) {
                    elements.push(w);
                }
            }
        }
    }

    public int groupNumber(int v) {
        return connectivityGroups[v];
    }

    public boolean connected(int v, int w) {
        return connectivityGroups[v] == connectivityGroups[w];
    }

}
