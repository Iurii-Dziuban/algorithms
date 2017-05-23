package iurii.job.interview.flow;

import java.util.ArrayDeque;
import java.util.Queue;

public class FordFulkerson {
    private boolean[] marked;     // marked[v] = true iff s->v path in residual graph
    private FlowEdge[] edgeTo;    // edgeTo[v] = last edge on shortest residual s->v path
    private double value;         // current value of max flow
  
    // max flow in flow network G from s to t
    public FordFulkerson(FlowNetwork G, int s, int t) {
        if (s < 0 || s >= G.V()) {
            throw new IndexOutOfBoundsException("Source s is invalid: " + s);
        }
        if (t < 0 || t >= G.V()) {
            throw new IndexOutOfBoundsException("Sink t is invalid: " + t);
        }
        if (s == t) {
            throw new IllegalArgumentException("Source equals sink");
        }
        value = excess(G, t);
        if (!isFeasible(G, s, t)) {
            throw new IllegalArgumentException("Initial flow is infeasible");
        }

        // while there exists an augmenting path, use it
        while (hasAugmentingPath(G, s, t)) {

            // compute bottleneck capacity
            double bottle = Double.POSITIVE_INFINITY;
            for (int v = t; v != s; v = edgeTo[v].other(v)) {
                bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));
            }

            // augment flow
            for (int v = t; v != s; v = edgeTo[v].other(v)) {
                edgeTo[v].addResidualFlowTo(v, bottle); 
            }

            value += bottle;
        }

        // check optimality conditions
        assert check(G, s, t);
    }

    // return value of max flow
    public double value()  {
        return value;
    }

    // is v in the s side of the min s-t cut?
    public boolean inCut(int v)  {
        return marked[v];
    }


    // is there an augmenting path? 
    // if so, upon termination edgeTo[] will contain a parent-link representation of such a path
    private boolean hasAugmentingPath(FlowNetwork G, int s, int t) {
        edgeTo = new FlowEdge[G.V()];
        marked = new boolean[G.V()];

        // breadth-first search
        Queue<Integer> q = new ArrayDeque<Integer>();
        q.add(s);
        marked[s] = true;
        while (!q.isEmpty()) {
            int v = q.poll();

            for (FlowEdge e : G.adj(v)) {
                int w = e.other(v);

                // if residual capacity from v to w
                if (e.residualCapacityTo(w) > 0) {
                    if (!marked[w]) {
                        edgeTo[w] = e;
                        marked[w] = true;
                        q.add(w);
                    }
                }
            }
        }

        // is there an augmenting path?
        return marked[t];
    }



    // return excess flow at vertex v
    private double excess(FlowNetwork G, int v) {
        double excess = 0.0;
        for (FlowEdge e : G.adj(v)) {
            if (v == e.from()) excess -= e.flow();
            else               excess += e.flow();
        }
        return excess;
    }

    // return excess flow at vertex v
    private boolean isFeasible(FlowNetwork G, int s, int t) {
        double EPSILON = 1E-11;

        // check that capacity constraints are satisfied
        for (int v = 0; v < G.V(); v++) {
            for (FlowEdge e : G.adj(v)) {
                if (e.flow() < -EPSILON || e.flow() > e.capacity() + EPSILON) {
                    System.err.println("Edge does not satisfy capacity constraints: " + e);
                    return false;
                }
            }
        }

        // check that net flow into a vertex equals zero, except at source and sink
        if (Math.abs(value + excess(G, s)) > EPSILON) {
            System.err.println("Excess at source = " + excess(G, s));
            System.err.println("Max flow         = " + value);
            return false;
        }
        if (Math.abs(value - excess(G, t)) > EPSILON) {
            System.err.println("Excess at sink   = " + excess(G, t));
            System.err.println("Max flow         = " + value);
            return false;
        }
        for (int v = 0; v < G.V(); v++) {
            if (v == s || v == t) continue;
            else if (Math.abs(excess(G, v)) > EPSILON) {
                System.err.println("Net flow out of " + v + " doesn't equal zero");
                return false;
            }
        }
        return true;
    }



    // check optimality conditions
    private boolean check(FlowNetwork G, int s, int t) {

        // check that flow is feasible
        if (!isFeasible(G, s, t)) {
            System.err.println("Flow is infeasible");
            return false;
        }

        // check that s is on the source side of min cut and that t is not on source side
        if (!inCut(s)) {
            System.err.println("source " + s + " is not on source side of min cut");
            return false;
        }
        if (inCut(t)) {
            System.err.println("sink " + t + " is on source side of min cut");
            return false;
        }

        // check that value of min cut = value of max flow
        double mincutValue = 0.0;
        for (int v = 0; v < G.V(); v++) {
            for (FlowEdge e : G.adj(v)) {
                if ((v == e.from()) && inCut(e.from()) && !inCut(e.to()))
                    mincutValue += e.capacity();
            }
        }

        double EPSILON = 1E-11;
        if (Math.abs(mincutValue - value) > EPSILON) {
            System.err.println("Max flow value = " + value + ", min cut value = " + mincutValue);
            return false;
        }

        return true;
    }


    // test client that creates random network, solves max flow, and prints results
    /*public static void main(String[] args) {

        // create flow network with V vertices and E edges
        int V = Integer.parseInt(args[0]);
        int E = Integer.parseInt(args[1]);
        int s = 0, t = V-1;
        FlowNetwork G = new FlowNetwork(V, E);

        //compute maximum flow and minimum cut
        FordFulkerson maxflow = new FordFulkerson(G, s, t);
    }*/

}