package iurii.job.interview.graph.structure;

import java.util.List;

public interface EdgeWeightedGraph {
    
    void addEdge(int v, int w, int weight);
    
    Iterable<DirectedEdge> adj(int v);
    
    List<DirectedEdge> edges();
    
    int verticesCount();
    
    int edgeCount();
}
