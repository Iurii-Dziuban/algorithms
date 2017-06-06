package iurii.job.interview.graph.structure;

public interface Graph {

    void addEdge(int v, int w);

    Iterable<Integer> adj(int v);

    int verticesCount();

    int edgeCount();

}
