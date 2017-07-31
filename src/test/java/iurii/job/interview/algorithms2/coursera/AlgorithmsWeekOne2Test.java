package iurii.job.interview.algorithms2.coursera;

import iurii.job.interview.graph.structure.DirectedEdge;
import iurii.job.interview.graph.structure.UnorderedWeightedGraph;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Prims algorithm
 */
public class AlgorithmsWeekOne2Test {


    @Test
    public void main() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/main/resources/edges_prims_minimum_spanning tree.txt"));
        int nodesCount = sc.nextInt();
        int edgesCount = sc.nextInt();
        UnorderedWeightedGraph graph = new UnorderedWeightedGraph(nodesCount);
        for (int i = 0; i < edgesCount; i++) {
            graph.addEdge(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt());
        }
        sc.close();
        Prima prima = new Prima(graph);
        List<DirectedEdge> minimumSpaningTree = prima.minimumSpaningTree();
        long cost = 0;
        for (DirectedEdge edge : minimumSpaningTree) {
            cost += edge.weight();
        }
        assertThat(cost).isEqualTo(-3612829);
    }

}
