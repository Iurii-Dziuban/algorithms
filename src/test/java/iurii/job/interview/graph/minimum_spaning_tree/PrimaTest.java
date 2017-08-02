package iurii.job.interview.graph.minimum_spaning_tree;

import iurii.job.interview.graph.structure.DirectedEdge;
import iurii.job.interview.graph.structure.UnorderedWeightedGraph;
import org.junit.Test;

import java.util.List;

/**
 * Created by iurii.dziuban on 02/08/2017.
 */
public class PrimaTest {

    @Test
    public void test() {
        UnorderedWeightedGraph graph = new UnorderedWeightedGraph(5);
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 4, 1);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 1, 2);
        graph.addEdge(3, 2, 3);
        graph.addEdge(3, 0, 4);
        graph.addEdge(4, 3, 2);

        Prima prima = new Prima(graph);
        List<DirectedEdge> minimumSpaningTreeP = prima.minimumSpaningTree();
        for (DirectedEdge edge : minimumSpaningTreeP) {
            System.out.println(edge);
        }
    }
}
