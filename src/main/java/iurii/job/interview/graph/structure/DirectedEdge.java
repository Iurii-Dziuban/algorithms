package iurii.job.interview.graph.structure;

public class DirectedEdge implements Comparable<DirectedEdge> {
    private final int from;
    private final int to;
    private final int weight;
    private int distance;

    public DirectedEdge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
        this.distance = weight;
    }

    public int from() {
        return from;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int to() {
        return to;
    }

    public int weight() {
        return weight;
    }

    public String toString() {
        return from + " -> " + to + " weight = " + weight;
    }

    @Override
    public int compareTo(DirectedEdge o) {
        if (this == null || o == null) {
            return -1;
        }
        return weight - o.weight;
    }
}
