package iurii.job.interview.graph.shortest_path;

import iurii.job.interview.graph.structure.DirectedEdge;
import iurii.job.interview.graph.structure.OrderedWeightedGraph;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        OrderedWeightedGraph graph = new OrderedWeightedGraph(3);
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        Dejkstra dejkstra = new Dejkstra(graph, 0);
        Stack<DirectedEdge> pathTo = dejkstra.pathTo(2);
        while (!pathTo.isEmpty()) {
            System.out.println(pathTo.pop());
        }
        System.out.println();

        OrderedWeightedGraph graph2 = new OrderedWeightedGraph(3);
        graph2.addEdge(0, 1, 3);
        graph2.addEdge(0, 2, 2);
        graph2.addEdge(1, 2, -2);

        Dejkstra dejkstra2 = new Dejkstra(graph2, 0);
        Stack<DirectedEdge> pathTo2 = dejkstra2.pathTo(2);
        while (!pathTo2.isEmpty()) {
            System.out.println(pathTo2.pop());
        }
        System.out.println();

        BellmanFord bellmanFord = new BellmanFord(graph2, 0);
        Stack<DirectedEdge> pathTo3 = bellmanFord.pathTo(2);
        while (!pathTo3.isEmpty()) {
            System.out.println(pathTo3.pop());
        }
        System.out.println();
    }

}
