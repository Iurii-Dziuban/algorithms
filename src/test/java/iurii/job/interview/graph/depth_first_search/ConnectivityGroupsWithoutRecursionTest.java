package iurii.job.interview.graph.depth_first_search;

import iurii.job.interview.graph.structure.UnorderedGraph;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 02/08/2017.
 */
public class ConnectivityGroupsWithoutRecursionTest {

    @Test
    public void test() {
        UnorderedGraph graph2 = new UnorderedGraph(13);
        graph2.addEdge(0, 1);
        graph2.addEdge(0, 2);
        graph2.addEdge(0, 5);
        graph2.addEdge(0, 6);
        graph2.addEdge(3, 4);
        graph2.addEdge(3, 5);
        graph2.addEdge(4, 5);
        graph2.addEdge(4, 6);
        graph2.addEdge(7, 8);
        graph2.addEdge(9, 10);
        graph2.addEdge(9, 11);
        graph2.addEdge(9, 12);
        graph2.addEdge(11, 12);


        ConnectivityGroupsWithoutRecursion cg1 = new ConnectivityGroupsWithoutRecursion(graph2);
        assertThat(cg1.connected(0, 3)).isTrue();
        assertThat(cg1.connected(0, 7)).isFalse();
        assertThat(cg1.connected(8, 7)).isTrue();
        assertThat(cg1.connected(8, 9)).isFalse();
        assertThat(cg1.connected(11, 10)).isTrue();
        assertThat(cg1.connected(11, 5)).isFalse();
    }
}
