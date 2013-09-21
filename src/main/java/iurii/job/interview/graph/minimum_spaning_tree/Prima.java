package iurii.job.interview.graph.minimum_spaning_tree;

import iurii.job.interview.graph.structure.DirectedEdge;
import iurii.job.interview.graph.structure.DirectedEdgeComparator;
import iurii.job.interview.graph.structure.UnorderedWeightedGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prima {
    
    private final List<DirectedEdge> minimumSpaningTree = new ArrayList<DirectedEdge>();
    private final boolean[] connected;
    
    public Prima(UnorderedWeightedGraph graph) {
        PriorityQueue<DirectedEdge> queue = new PriorityQueue<DirectedEdge>(10, new DirectedEdgeComparator());
        int edgesNumber = graph.verticesCount() - 1;
        connected = new boolean[graph.verticesCount()];
        for (DirectedEdge edge : graph.adj(0)) {
            queue.add(edge);
        }
        while (minimumSpaningTree.size() != edgesNumber) {
            DirectedEdge edge = queue.poll();
            if (!connected[edge.from()] || !connected[edge.to()]) {
                minimumSpaningTree.add(edge);
                connected[edge.from()] = true;
                connected[edge.to()] = true;
                Iterable<DirectedEdge> adj = graph.adj(edge.to());
                for (DirectedEdge adjEdge : adj) {
                    queue.add(adjEdge);    
                }
            }
        }
    }
    
    public List<DirectedEdge> minimumSpaningTree() {
        return minimumSpaningTree;
    }
}
