package iurii.job.interview.flow;

import java.util.Random;

public class BipartiteMatching {

    public static void main(String[] args) {

        // read in bipartite network with 2N vertices and E edges
        // we assume the vertices on one side of the bipartition
        // are named 0 to N-1 and on the other side are N to 2N-1.
        int N = Integer.parseInt(args[0]);
        int E = Integer.parseInt(args[1]);
        int s = 2 * N, t = 2 * N + 1;
        FlowNetwork G = new FlowNetwork(2 * N + 2);
        Random random = new Random();
        for (int i = 0; i < E; i++) {
            int v = random.nextInt(N);
            int w = random.nextInt(N) + N;
            G.addEdge(new FlowEdge(v, w, Double.POSITIVE_INFINITY));
            //StdOut.println(v + "-" + w);
        }
        for (int i = 0; i < N; i++) {
            G.addEdge(new FlowEdge(s, i, 1.0));
            G.addEdge(new FlowEdge(i + N, t, 1.0));
        }


        // compute maximum flow and minimum cut
        FordFulkerson maxflow = new FordFulkerson(G, s, t);
        //StdOut.println();
        maxflow.value();
        //StdOut.println("Size of maximum matching = " + (int) maxflow.value());
        for (int v = 0; v < N; v++) {
            for (FlowEdge e : G.adj(v)) {
                if (e.from() == v && e.flow() > 0) {
                    System.out.println(e);
                    //StdOut.println(e.from() + "-" + e.to());
                }
            }
        }
    }

}
