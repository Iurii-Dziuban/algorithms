package iurii.job.interview.graph.shortest_path;

import iurii.job.interview.graph.structure.DirectedEdge;
import iurii.job.interview.graph.structure.OrderedWeightedGraph;
import org.junit.Test;

import java.util.Stack;

/**
 * Created by iurii.dziuban on 02/08/2017.
 */
public class BellmanFordTest {

    @Test
    public void test() {
        OrderedWeightedGraph graph2 = new OrderedWeightedGraph(3);
        graph2.addEdge(0, 1, 3);
        graph2.addEdge(0, 2, 2);
        graph2.addEdge(1, 2, -2);

        BellmanFord bellmanFord = new BellmanFord(graph2, 0);
        Stack<DirectedEdge> pathTo3 = bellmanFord.pathTo(2);
        while (!pathTo3.isEmpty()) {
            System.out.println(pathTo3.pop());
        }
        System.out.println();
    }
}
