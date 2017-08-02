package iurii.job.interview.graph.depth_first_search;

import iurii.job.interview.graph.structure.UnorderedGraph;
import org.junit.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 02/08/2017.
 */
public class DepthFirstSearchTest {

    @Test
    public void test() {
        UnorderedGraph graph = new UnorderedGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, 0);
        Stack<Integer> pathTo = depthFirstSearch.pathTo(3);

        assertThat(pathTo.pop()).isEqualTo(0);
        assertThat(pathTo.pop()).isEqualTo(2);
        assertThat(pathTo.pop()).isEqualTo(4);
        assertThat(pathTo.pop()).isEqualTo(3);

        assertThat(depthFirstSearch.hasCircle()).isFalse();
    }
}
