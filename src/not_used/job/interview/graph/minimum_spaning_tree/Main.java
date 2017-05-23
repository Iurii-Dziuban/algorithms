package iurii.job.interview.graph.minimum_spaning_tree;

import java.util.List;

import iurii.job.interview.graph.structure.DirectedEdge;
import iurii.job.interview.graph.structure.UnorderedWeightedGraph;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        UnorderedWeightedGraph graph = new UnorderedWeightedGraph(5);
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 4, 1);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 1, 2);
        graph.addEdge(3, 2, 3);
        graph.addEdge(3, 0, 4);
        graph.addEdge(4, 3, 2);
        Kruskal kruskal = new Kruskal(graph);
        List<DirectedEdge> minimumSpaningTree = kruskal.minimumSpaningTree();
        for (DirectedEdge edge :minimumSpaningTree) {
            System.out.println(edge);
        }
        System.out.println();
        
        Prima prima = new Prima(graph);
        List<DirectedEdge> minimumSpaningTreeP = prima.minimumSpaningTree();
        for (DirectedEdge edge :minimumSpaningTreeP) {
            System.out.println(edge);
        }

    }

}
