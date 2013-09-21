package iurii.job.interview.graph.minimum_spaning_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import iurii.job.interview._unionfind.quickunion.QuickUnion;
import iurii.job.interview.graph.structure.DirectedEdge;
import iurii.job.interview.graph.structure.UnorderedWeightedGraph;

public class Kruskal {
    
    private final List<DirectedEdge> minimumSpaningTree = new ArrayList<DirectedEdge>();
    
    public Kruskal (UnorderedWeightedGraph graph) {
        List<DirectedEdge> edges = graph.edges();
        Collections.sort(edges);
        int edgesNumber = graph.verticesCount() - 1;
        QuickUnion qu = new QuickUnion(graph.verticesCount());
        int index = 0;
        while (minimumSpaningTree.size() != edgesNumber) {
            if (!qu.find(edges.get(index).from(), edges.get(index).to())) {
                minimumSpaningTree.add(edges.get(index));
                qu.union(edges.get(index).from(), edges.get(index).to());
            }
            index++;
        }
    }
    
    public List<DirectedEdge> minimumSpaningTree() {
        return minimumSpaningTree;
    }
    
}
