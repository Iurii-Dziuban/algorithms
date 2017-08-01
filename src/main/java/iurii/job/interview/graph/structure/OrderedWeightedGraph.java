package iurii.job.interview.graph.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Graph representation using Adjacency List.
 * It is better than (Adjacency Matrix and List of edges)
 */
public class OrderedWeightedGraph implements EdgeWeightedGraph {

    private final int v;
    protected List<DirectedEdge>[] adj;

    @SuppressWarnings("unchecked")
    public OrderedWeightedGraph(int v) {
        this.v = v;
        adj = (List<DirectedEdge>[]) new ArrayList[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w, int weight) {
        adj[v].add(new DirectedEdge(v, w, weight));
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public int verticesCount() {
        return v;
    }

    public int edgeCount() {
        return Stream.of(adj).map(List::size).reduce(0, Integer::sum);
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
