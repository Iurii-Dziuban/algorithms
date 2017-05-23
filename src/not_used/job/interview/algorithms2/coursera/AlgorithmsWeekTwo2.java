package iurii.job.interview.algorithms2.coursera;

import iurii.job.interview.graph.structure.UnorderedWeightedGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clustering with Hamming code
 */
public class AlgorithmsWeekTwo2 {

    /**
     * @param args
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
    	Scanner sc = new Scanner(new File("clustering_big.txt"));
        int vertexCount = sc.nextInt();
        int bitCount = sc.nextInt();
        UnorderedWeightedGraph graph = new UnorderedWeightedGraph(vertexCount);
        List<Integer> codedValues = new ArrayList<Integer>();
        while (sc.hasNextInt()) {
        	int value = 0;
        	for (int i = 0; i < bitCount; i++) {
				value = value << 1;
				value += sc.nextInt();
			}
        	codedValues.add(value);
        }
        sc.close();
        System.out.println("Values added");
        for (int i = 0; i < codedValues.size()-1; i++) {
			for (int j = i + 1; j < codedValues.size(); j++) {
				int distance = Integer.bitCount(codedValues.get(i) ^ codedValues.get(j));
				if (distance < 3) {
					graph.addEdge(i, j, distance);
				}
			}
			System.out.println(i + " vertex is done");
		}
        KruskalClustering2 kruskalClustering = new KruskalClustering2(graph);
        System.out.println(kruskalClustering.clusterNumber());
    }
}
