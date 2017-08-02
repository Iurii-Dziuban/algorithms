package iurii.job.interview.graph.depth_first_search;

import iurii.job.interview.graph.structure.OrderedGraph;
import org.junit.Test;

import java.util.Stack;

/**
 * Created by iurii.dziuban on 02/08/2017.
 */
public class TopologicalOrderTest {
    @Test
    public void test() {
        OrderedGraph og = new OrderedGraph(7);
        og.addEdge(0, 1);
        og.addEdge(0, 2);
        og.addEdge(0, 5);
        og.addEdge(1, 4);
        og.addEdge(3, 2);
        og.addEdge(3, 4);
        og.addEdge(3, 5);
        og.addEdge(3, 6);
        og.addEdge(5, 2);
        og.addEdge(6, 0);
        og.addEdge(6, 4);

        TopologicalOrder topologicalOrder = new TopologicalOrder(og);
        Stack<Integer> order = topologicalOrder.topologicalOrder();
        while (!order.isEmpty()) {
            System.out.println(order.pop());
        }
        System.out.println();
    }
}
