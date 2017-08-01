package iurii.job.interview.graph.structure;

import java.util.List;

/**
 * Graph representation using Adjacency List.
 * It is better than (Adjacency Matrix and List of edges)
 */
public class OrderedGraph extends UnorderedGraph {

    public OrderedGraph(int v) {
        super(v);
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public int edgeCount() {
        int edgeCount = 0;
        for (List<Integer> anAdj : adj) {
            edgeCount += anAdj.size();
        }
        return edgeCount;
    }

    public OrderedGraph reverse() {
        OrderedGraph og = new OrderedGraph(verticesCount());
        for (int i = 0; i < verticesCount(); i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                og.addEdge(adj[i].get(j), i);
            }
        }
        return og;
    }
}
