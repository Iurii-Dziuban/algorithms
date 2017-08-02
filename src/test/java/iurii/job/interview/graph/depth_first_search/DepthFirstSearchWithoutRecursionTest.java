package iurii.job.interview.graph.depth_first_search;

import iurii.job.interview.graph.structure.UnorderedGraph;
import org.junit.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 02/08/2017.
 */
public class DepthFirstSearchWithoutRecursionTest {

    @Test
    public void test() {
        UnorderedGraph graph1 = new UnorderedGraph(6);
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(2, 4);
        graph1.addEdge(3, 4);
        graph1.addEdge(3, 5);
        DepthFirstSearchWithoutRecursion depthFirstSearchWithoutRecursion = new DepthFirstSearchWithoutRecursion(graph1, 0);
        Stack<Integer> pathTo1 = depthFirstSearchWithoutRecursion.pathTo(3);

        assertThat(pathTo1.pop()).isEqualTo(0);
        assertThat(pathTo1.pop()).isEqualTo(2);
        assertThat(pathTo1.pop()).isEqualTo(4);
        assertThat(pathTo1.pop()).isEqualTo(3);
        assertThat(depthFirstSearchWithoutRecursion.hasCircle()).isFalse();
    }
}
