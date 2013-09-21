package iurii.job.interview.graph.shortest_path;

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
            distTo[i] = Integer.MAX_VALUE;
        }
        distTo[source] = 0;
        
        PriorityQueue<DirectedEdge> directedEdges = new PriorityQueue<DirectedEdge>(
                10, new DirectedEdgeComparator());
        addEdges(graph, source, directedEdges);
        int edgeCount = 0;
        while (!directedEdges.isEmpty() || edgeCount != graph.verticesCount() - 1) {
            DirectedEdge top = directedEdges.poll();
            if (edgeTo[top.to()] == -1) {
                edgeTo[top.to()] = top.from();
                distTo[top.to()] = distTo[top.from()] + top.weight();
                addEdges(graph, top.to(), directedEdges);
                edgeCount++;
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
}
