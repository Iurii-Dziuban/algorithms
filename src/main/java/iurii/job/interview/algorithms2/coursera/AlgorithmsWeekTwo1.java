package iurii.job.interview.algorithms2.coursera;

import iurii.job.interview.graph.structure.UnorderedWeightedGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Clustering with Kruskal
 */
public class AlgorithmsWeekTwo1 {

    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/main/resources/clustering1.txt"));
        int vertexCount = sc.nextInt();
        UnorderedWeightedGraph graph = new UnorderedWeightedGraph(vertexCount);
        while (sc.hasNextInt()) {
            graph.addEdge(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt());
        }
        sc.close();
        KruskalClustering kruskalClustering = new KruskalClustering(graph, 4);
        System.out.println(kruskalClustering.minSpacing());
    }
}
