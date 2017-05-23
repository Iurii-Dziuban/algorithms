package iurii.job.interview.algorithms2.coursera;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import iurii.job.interview._unionfind.quickunion.QuickUnion;
import iurii.job.interview.graph.structure.DirectedEdge;
import iurii.job.interview.graph.structure.UnorderedWeightedGraph;

public class KruskalClustering2 {
    
    private final List<DirectedEdge> minimumSpaningTree = new ArrayList<DirectedEdge>();
    private int clusterNumber;
    
    public KruskalClustering2 (UnorderedWeightedGraph graph) {
        clusterNumber = graph.verticesCount();
    	List<DirectedEdge> edges = graph.edges();
        Collections.sort(edges);
        QuickUnion qu = new QuickUnion(graph.verticesCount());
        int index = 0;
        while (index < edges.size()) {
            if (!qu.find(edges.get(index).from(), edges.get(index).to())) {
                minimumSpaningTree.add(edges.get(index));
                qu.union(edges.get(index).from(), edges.get(index).to());
                clusterNumber--;
            }
            index++;
        }
    }
    
    public List<DirectedEdge> minimumSpaningTree() {
        return minimumSpaningTree;
    }
    
    public int clusterNumber() {
    	return clusterNumber;
    }
    
}
