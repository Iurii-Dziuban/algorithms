package iurii.job.interview.algorithms1.coursera;

import iurii.job.interview.graph.structure.OrderedWeightedGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AlgorithmsWeekFive {

    /**
     * @param args
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("dijkstraData.txt"));
        OrderedWeightedGraph graph = new OrderedWeightedGraph(200);
        while (sc.hasNext()) {
            String nextLine = sc.nextLine();
            String[] groups = nextLine.split("\t");
            for (int i = 1; i < groups.length; i++) {
                String[] values = groups[i].split(",");
                graph.addEdge(Integer.valueOf(groups[0]) - 1, Integer.valueOf(values[0]) - 1, Integer.valueOf(values[1]));
            }
        }
        sc.close();
        Dejkstra dejkstra = new Dejkstra(graph, 0);
        System.out.print(dejkstra.pathLength(6) + " ");
        System.out.print(dejkstra.pathLength(36) + " ");
        System.out.print(dejkstra.pathLength(58) + " ");
        System.out.print(dejkstra.pathLength(81) + " ");
        System.out.print(dejkstra.pathLength(98) + " ");
        System.out.print(dejkstra.pathLength(114) + " ");
        System.out.print(dejkstra.pathLength(132) + " ");
        System.out.print(dejkstra.pathLength(164) + " ");
        System.out.print(dejkstra.pathLength(187) + " ");
        System.out.print(dejkstra.pathLength(196) + " ");
    }

}
