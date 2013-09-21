package iurii.job.interview.algorithms1.coursera;

import java.util.PriorityQueue;
import java.util.Stack;

import iurii.job.interview.graph.structure.DirectedEdge;
import iurii.job.interview.graph.structure.DirectedEdgeComparator;
import iurii.job.interview.graph.structure.OrderedWeightedGraph;

/**
 * @author Jacky
 */
public class Dejkstra {
    private final int[] distTo;
    private final int[] edgeTo;
    private final int source;

    public Dejkstra(OrderedWeightedGraph graph, int source) {
        this.source = source;
        edgeTo = new int[graph.verticesCount()];
        distTo = new int[graph.verticesCount()];
        for (int i = 0; i < graph.verticesCount(); i++) {
            edgeTo[i] = -1;
            distTo[i] = 1000000;
        }
        distTo[source] = 0;
        edgeTo[source] = 0;
        
        PriorityQueue<DirectedEdge> directedEdges = new PriorityQueue<DirectedEdge>(
                10, new DirectedEdgeComparator());
        addEdges(graph, source, directedEdges);
        while (!directedEdges.isEmpty()) {
            DirectedEdge top = directedEdges.remove();
            if (edgeTo[top.to()] == -1) {
                edgeTo[top.to()] = top.from();
                distTo[top.to()] = distTo[top.from()] + top.weight();
                addEdges(graph, top.to(), directedEdges);
            }
        }
    }

    private void addEdges(OrderedWeightedGraph graph,
            int source, PriorityQueue<DirectedEdge> directedEdges) {
        Iterable<DirectedEdge> adj = graph.adj(source);
        for (DirectedEdge edge : adj) {
            edge.setDistance(edge.getDistance() + distTo[source]);
            directedEdges.add(edge);
        }
    }

    public Stack<DirectedEdge> pathTo(int v) {
        int current = v;
        Stack<DirectedEdge> pathTo = new Stack<DirectedEdge>();
        while (current != source) {
            int from = edgeTo[current];
            pathTo.add(new DirectedEdge(from, current, distTo[current]
                    - distTo[from]));
            current = from;
        }
        return pathTo;
    }
    
    public int pathLength(int v) {
        return distTo[v];
    }
}
