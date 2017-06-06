package iurii.job.interview.algorithms2.coursera;

import iurii.job.interview._unionfind.quickunion.QuickUnion;
import iurii.job.interview.graph.structure.DirectedEdge;
import iurii.job.interview.graph.structure.UnorderedWeightedGraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalClustering {

    private final List<DirectedEdge> minimumSpaningTree = new ArrayList<DirectedEdge>();
    private final int minSpacing;

    public KruskalClustering(UnorderedWeightedGraph graph, int finalClusterCount) {
        int clusterNumber = graph.verticesCount();
        List<DirectedEdge> edges = graph.edges();
        Collections.sort(edges);
        QuickUnion qu = new QuickUnion(graph.verticesCount());
        int index = 0;
        while (finalClusterCount != clusterNumber) {
            if (!qu.find(edges.get(index).from(), edges.get(index).to())) {
                minimumSpaningTree.add(edges.get(index));
                qu.union(edges.get(index).from(), edges.get(index).to());
                clusterNumber--;
            }
            index++;
        }
        while (qu.find(edges.get(index).from(), edges.get(index).to())) {
            index++;
        }
        minSpacing = edges.get(index).getDistance();
    }

    public List<DirectedEdge> minimumSpaningTree() {
        return minimumSpaningTree;
    }

    public int minSpacing() {
        return minSpacing;
    }

}
