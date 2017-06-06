package iurii.job.interview.graph.depth_first_search;

import iurii.job.interview.graph.structure.OrderedGraph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalOrder {
    private final boolean[] marked;
    private final boolean[] topologicalOrderContains;
    private final Stack<Integer> topologicalOrder = new Stack<Integer>();

    public TopologicalOrder(OrderedGraph graph) {
        marked = new boolean[graph.verticesCount()];
        topologicalOrderContains = new boolean[graph.verticesCount()];
        for (int i = 0; i < graph.verticesCount(); i++) {
            dfs(graph, i);
        }
    }

    private void dfs(OrderedGraph graph, int source) {
        LinkedList<Integer> elements = new LinkedList<Integer>();
        elements.push(source);
        while (!elements.isEmpty()) {
            int element = elements.getFirst();
            if (!topologicalOrderContains[element]) {
                marked[element] = true;
                Iterator<Integer> iterator = graph.adj(element).iterator();
                int pushNumber = 0;
                while (iterator.hasNext()) {
                    int w = iterator.next();
                    if (!marked[w]) {
                        elements.push(w);
                        pushNumber++;
                    }
                }
                if (pushNumber == 0) {
                    int elementToAddToStack = elements.pop();
                    marked[elementToAddToStack] = true;
                    topologicalOrder.push(elementToAddToStack);
                    topologicalOrderContains[elementToAddToStack] = true;
                }
            } else {
                elements.pop();
            }
        }
    }


    public Stack<Integer> topologicalOrder() {
        return topologicalOrder;
    }

}
