package iurii.job.interview.graph.breadth_first_search;

import iurii.job.interview.graph.structure.UnorderedGraph;
import org.junit.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 02/08/2017.
 */
public class BreadthFirstSearchTest {

    @Test
    public void test() {
        UnorderedGraph graph = new UnorderedGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 0);
        Stack<Integer> pathTo = bfs.pathTo(5);

        assertThat(pathTo.size()).isEqualTo(2);
        assertThat(pathTo.pop()).isEqualTo(0);
        assertThat(pathTo.pop()).isEqualTo(5);
    }
}
