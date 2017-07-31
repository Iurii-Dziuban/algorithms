package iurii.job.interview.algorithms1.coursera;

import iurii.job.interview.algorithms2.coursera.BellmanFord;
import iurii.job.interview.graph.structure.OrderedWeightedGraph;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class AlgorithmsWeekFiveTest {

    @Test
    public void main() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/main/resources/dijkstraData.txt"), "UTF-8");
        OrderedWeightedGraph graph = new OrderedWeightedGraph(200);
        while (sc.hasNext()) {
            String nextLine = sc.nextLine();
            String[] groups = nextLine.split("\t");
            for (int i = 1; i < groups.length; i++) {
                String[] values = groups[i].split(",");
                graph.addEdge(Integer.parseInt(groups[0]) - 1,
                        Integer.parseInt(values[0]) - 1, Integer.parseInt(values[1]));
            }
        }
        sc.close();
        Dejkstra dejkstra = new Dejkstra(graph, 0);
        assertThat(dejkstra.pathLength(6)).isEqualTo(2599);
        assertThat(dejkstra.pathLength(36)).isEqualTo(2610);
        assertThat(dejkstra.pathLength(58)).isEqualTo(2947);
        assertThat(dejkstra.pathLength(81)).isEqualTo(2052);
        assertThat(dejkstra.pathLength(98)).isEqualTo(2367);
        assertThat(dejkstra.pathLength(114)).isEqualTo(2399);
        assertThat(dejkstra.pathLength(132)).isEqualTo(2029);
        assertThat(dejkstra.pathLength(164)).isEqualTo(2442);
        assertThat(dejkstra.pathLength(187)).isEqualTo(2505);
        assertThat(dejkstra.pathLength(196)).isEqualTo(3068);
    }

    @Test
    public void bellmanFord() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/main/resources/dijkstraData.txt"), "UTF-8");
        OrderedWeightedGraph graph = new OrderedWeightedGraph(200);
        while (sc.hasNext()) {
            String nextLine = sc.nextLine();
            String[] groups = nextLine.split("\t");
            for (int i = 1; i < groups.length; i++) {
                String[] values = groups[i].split(",");
                graph.addEdge(Integer.parseInt(groups[0]) - 1,
                        Integer.parseInt(values[0]) - 1, Integer.parseInt(values[1]));
            }
        }
        sc.close();

        BellmanFord bellmanFord = new BellmanFord(graph, 145);
        assertThat(bellmanFord.minDistance()).isEqualTo(0);
    }

}
