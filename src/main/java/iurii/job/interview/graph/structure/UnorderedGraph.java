package iurii.job.interview.graph.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * Graph representation using Adjacency List.
 * It is better than (Adjacency Matrix and List of edges)
 */
public class UnorderedGraph implements Graph {

    private final int v;
    protected List<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public UnorderedGraph(int v) {
        this.v = v;
        adj = (List<Integer>[]) new ArrayList[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public List<Integer> adj(int v) {
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
        return edgeCount / 2;
    }

    public List<Integer> edges(int v) {
        return adj[v];
    }

    public synchronized List<DirectedEdge> edges() {
        List<DirectedEdge> list = new ArrayList<DirectedEdge>();
        for (int i = 0; i < verticesCount(); i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                list.add(new DirectedEdge(i, adj[i].get(j), 0));
            }
        }
        return list;
    }
}
