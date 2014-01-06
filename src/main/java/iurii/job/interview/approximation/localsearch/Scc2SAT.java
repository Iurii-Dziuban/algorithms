package iurii.job.interview.approximation.localsearch;

import iurii.job.interview.graph.depth_first_search.TopologicalOrder;
import iurii.job.interview.graph.structure.OrderedGraph;
import iurii.job.interview.graph.structure.UnorderedGraph;

import java.util.Iterator;
import java.util.Stack;

/**
 * 1) Create the inference graph G such that for each variable xi in the 2-SAT instance, xi and ~xi are vertices of the inference graph. xi and ~xi are complements of each other.
 * 2) For each clause (u OR v), add the edges ~u -> v and ~v -> u to the inference graph G.
 * 3) Process the strongly connected components S of G in reverse topological order as follows: If S is marked, do nothing. If S = ~S (i.e., a variable and its complement belong to the same SCC), then stop, the instance is unsatisfiable. Otherwise, mark S true and ~S false.
 * 4) We get a satisfying assignment by assigning to each variable the truth value of the component containing it.
 *
 */
public class Scc2SAT {
    
    private int[] connectivityGroups;
    private boolean[] marked;
    //added
    private boolean[] solution;
    private boolean isSolutionExists = true;

    public Scc2SAT(OrderedGraph graph) {
        OrderedGraph reverse = graph.reverse();
        TopologicalOrder tp = new TopologicalOrder(reverse);
        marked = new boolean[graph.verticesCount()];
        solution = new boolean[graph.verticesCount()/2];
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
                // added
                if (!isSolutionExists) {
                    return;
                }
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
            // added
            boolean isNotElement = element >= graph.verticesCount() / 2;
            int elementIndex = isNotElement ? graph.verticesCount() - 1 - element : element;
            solution[elementIndex] = !isNotElement;
            // end added
            while (iterator.hasNext()) {
                int w = iterator.next();
                if (!marked[w]) {
                    elements.push(w);
                    // added
                    if (connectivityGroups[graph.verticesCount()-1-w] == index) {
                        isSolutionExists = false;
                        return;
                    }
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
    
    //added
    public String getResult() {
        return isSolutionExists ? "satisfiable" : "unsatisfiable";
    }

}
