package iurii.job.interview.algorithms2.coursera;

import iurii.job.interview.graph.structure.DirectedEdge;
import iurii.job.interview.graph.structure.DirectedEdgeComparator;
import iurii.job.interview.graph.structure.OrderedWeightedGraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class BellmanFord {
    private final int[] distTo;
    private final int[] edgeTo;
    private boolean isNegativeCycle = false;

    public BellmanFord(OrderedWeightedGraph graph, int source) {
        edgeTo = new int[graph.verticesCount()];
        distTo = new int[graph.verticesCount()];
        for (int i = 0; i < graph.verticesCount(); i++) {
            edgeTo[i] = -1;
            distTo[i] = Integer.MAX_VALUE;
        }
        distTo[source] = 0;
        edgeTo[source] = 0;
        PriorityQueue<DirectedEdge> prevDirectedEdges = new PriorityQueue<DirectedEdge>(
                10, new DirectedEdgeComparator());
        addEdges(graph, source, prevDirectedEdges);
        for (int i = 0; i < graph.verticesCount() - 1; i++) {
            PriorityQueue<DirectedEdge> nextDirectedEdges = new PriorityQueue<DirectedEdge>(
                    10, new DirectedEdgeComparator());
            //System.out.println("vertex" + i);
            while (!prevDirectedEdges.isEmpty()) {
                DirectedEdge top = prevDirectedEdges.poll();
                if (edgeTo[top.to()] == -1 || distTo[top.from()] + top.weight() < distTo[top.to()]) {
                    edgeTo[top.to()] = top.from();
                    distTo[top.to()] = distTo[top.from()] + top.weight();
                    addEdges(graph, top.to(), nextDirectedEdges);
                }
            }
            prevDirectedEdges = nextDirectedEdges;
        }
        // cycle check
        while (!prevDirectedEdges.isEmpty()) {
            DirectedEdge top = prevDirectedEdges.poll();
            if (edgeTo[top.to()] == -1 || distTo[top.from()] + top.weight() < distTo[top.to()]) {
                isNegativeCycle = true;
                break;
            }
        }
    }

    private void addEdges(OrderedWeightedGraph graph, int source,
                          PriorityQueue<DirectedEdge> directedEdges) {
        Iterable<DirectedEdge> adj = graph.adj(source);
        for (DirectedEdge edge : adj) {
            directedEdges.add(edge);
        }
    }

    public Integer minDistance() {
        if (isNegativeCycle) {
            return null;
        } else {
            List<Integer> distances = new ArrayList<Integer>();
            for (int i = 0; i < distTo.length; i++) {
                distances.add(distTo[i]);
            }
            return Collections.min(distances);
        }
    }

}
