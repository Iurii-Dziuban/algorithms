package iurii.job.interview.graph.shortest_path;

import iurii.job.interview.graph.structure.DirectedEdge;
import iurii.job.interview.graph.structure.OrderedWeightedGraph;
import org.junit.Test;

import java.util.Stack;

/**
 * Created by iurii.dziuban on 02/08/2017.
 */
public class DejkstraTest {

    @Test
    public void test() {
        OrderedWeightedGraph graph2 = new OrderedWeightedGraph(3);
        graph2.addEdge(0, 1, 3);
        graph2.addEdge(0, 2, 2);
        graph2.addEdge(1, 2, -2);

        Dejkstra dejkstra2 = new Dejkstra(graph2, 0);
        Stack<DirectedEdge> pathTo2 = dejkstra2.pathTo(2);
        while (!pathTo2.isEmpty()) {
            System.out.println(pathTo2.pop());
        }
        System.out.println();
    }
}
