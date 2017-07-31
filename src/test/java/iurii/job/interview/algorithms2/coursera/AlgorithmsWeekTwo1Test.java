package iurii.job.interview.algorithms2.coursera;

import iurii.job.interview.graph.structure.UnorderedWeightedGraph;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Clustering with Kruskal
 */
public class AlgorithmsWeekTwo1Test {

    @Test
    public void main() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/main/resources/clustering1.txt"));
        int vertexCount = sc.nextInt();
        UnorderedWeightedGraph graph = new UnorderedWeightedGraph(vertexCount);
        while (sc.hasNextInt()) {
            graph.addEdge(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt());
        }
        sc.close();
        KruskalClustering kruskalClustering = new KruskalClustering(graph, 4);
        assertThat(kruskalClustering.minSpacing()).isEqualTo(106);
    }
}
