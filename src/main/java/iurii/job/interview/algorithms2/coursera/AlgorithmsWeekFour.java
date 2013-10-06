package iurii.job.interview.algorithms2.coursera;

import iurii.job.interview.graph.structure.OrderedWeightedGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AlgorithmsWeekFour {

	public static void main(String[] args) throws FileNotFoundException {
		String[] files = { "src/main/resources/g1.txt",
				           "src/main/resources/g2.txt",
				           "src/main/resources/g3.txt"};
		for (String file : files) {
			Scanner sc = new Scanner(new File(file));
			int vertexCount = sc.nextInt();
			int edgeCount = sc.nextInt();
			OrderedWeightedGraph graph = new OrderedWeightedGraph(vertexCount);
			for (int i = 0; i < edgeCount; i++) {
				graph.addEdge(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt());
			}
			sc.close();
			List<Integer> minDistances = new ArrayList<Integer>(vertexCount);
			boolean hasNegativeCycle = false;
			for (int i = 0; i < vertexCount; i++) {
				//System.out.println("i= " + i );
				BellmanFord bellmanFord = new BellmanFord(graph, i);
				if (bellmanFord.minDistance() == null) {
					hasNegativeCycle = true;
					break;
				} else {
					minDistances.add(bellmanFord.minDistance());
				}
			}
			if (hasNegativeCycle) {
				System.out.println("NULL");
			} else {
				System.out.println(Collections.min(minDistances));
			}
		}
	}
}
