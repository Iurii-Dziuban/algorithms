package iurii.job.interview.graph.structure;

import java.util.Comparator;

public class DirectedEdgeComparator implements Comparator<DirectedEdge> {

    @Override
    public int compare(DirectedEdge o1, DirectedEdge o2) {
        if (o1 == null || o2 == null) {
            return -1;
        }
        return o1.getDistance() - o2.getDistance();
    }

} 
