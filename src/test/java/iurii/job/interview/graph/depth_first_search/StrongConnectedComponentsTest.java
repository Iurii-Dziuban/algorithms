package iurii.job.interview.graph.depth_first_search;

import iurii.job.interview.graph.structure.OrderedGraph;
import org.junit.Test;

/**
 * Created by iurii.dziuban on 02/08/2017.
 */
public class StrongConnectedComponentsTest {

    @Test
    public void test() {
        // strong components {1}, {0,2,3,4,5} {6,8} {7} {9,10,11,12}
        OrderedGraph ogSC = new OrderedGraph(13);
        ogSC.addEdge(0, 1);
        ogSC.addEdge(0, 5);
        ogSC.addEdge(2, 0);
        ogSC.addEdge(2, 3);
        ogSC.addEdge(3, 2);
        ogSC.addEdge(3, 5);
        ogSC.addEdge(4, 2);
        ogSC.addEdge(4, 3);
        ogSC.addEdge(5, 4);
        ogSC.addEdge(6, 0);
        ogSC.addEdge(6, 4);
        ogSC.addEdge(6, 8);
        ogSC.addEdge(6, 9);
        ogSC.addEdge(7, 6);
        ogSC.addEdge(7, 9);
        ogSC.addEdge(8, 6);
        ogSC.addEdge(9, 10);
        ogSC.addEdge(9, 11);
        ogSC.addEdge(10, 12);
        ogSC.addEdge(11, 4);
        ogSC.addEdge(11, 12);
        ogSC.addEdge(12, 9);

        StrongConnectedComponents scc = new StrongConnectedComponents(ogSC);
        for (int i = 0; i < ogSC.verticesCount(); i++) {
            System.out.print(scc.groupNumber(i) + " ");
        }
    }
}
