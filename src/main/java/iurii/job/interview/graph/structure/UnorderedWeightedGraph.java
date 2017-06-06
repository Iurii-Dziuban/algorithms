package iurii.job.interview.graph.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * Graph representation using Adjacency List.
 * It is better than (Adjacency Matrix and List of edges)
 */
public class UnorderedWeightedGraph implements EdgeWeightedGraph {

    private final int v;
    protected List<DirectedEdge>[] adj;

    @SuppressWarnings("unchecked")
    public UnorderedWeightedGraph(int v) {
        this.v = v;
        adj = (List<DirectedEdge>[]) new ArrayList[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<DirectedEdge>();
        }
    }

    public void addEdge(int v, int w, int weight) {
        adj[v].add(new DirectedEdge(v, w, weight));
        adj[w].add(new DirectedEdge(w, v, weight));
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public int verticesCount() {
        return v;
    }

    public int edgeCount() {
        int edgeCount = 0;
        for (int i = 0; i < adj.length; i++) {
            edgeCount += adj[i].size();
        }
        return edgeCount;
    }

    @Override
    public List<DirectedEdge> edges() {
        List<DirectedEdge> list = new ArrayList<DirectedEdge>();
        for (int i = 0; i < v; i++) {
            list.addAll(adj[i]);
        }
        return list;
    }
}
