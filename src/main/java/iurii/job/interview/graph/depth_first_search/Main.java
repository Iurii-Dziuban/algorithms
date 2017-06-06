package iurii.job.interview.graph.depth_first_search;

import iurii.job.interview.graph.breadth_first_search.ConnectivityGroups;
import iurii.job.interview.graph.structure.OrderedGraph;
import iurii.job.interview.graph.structure.UnorderedGraph;

import java.util.Stack;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        UnorderedGraph graph = new UnorderedGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        //graph.addEdge(0, 5);
        //graph.addEdge(1, 2);
        //graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, 0);
        Stack<Integer> pathTo = depthFirstSearch.pathTo(3);
        while (!pathTo.isEmpty()) {
            System.out.println(pathTo.pop() + " ");
        }
        System.out.println(depthFirstSearch.hasCircle());
        System.out.println();

        UnorderedGraph graph1 = new UnorderedGraph(6);
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        //graph.addEdge(0, 5);
        //graph.addEdge(1, 2);
        //graph.addEdge(2, 3);
        graph1.addEdge(2, 4);
        graph1.addEdge(3, 4);
        graph1.addEdge(3, 5);
        DepthFirstSearchWithoutRecursion depthFirstSearchWithoutRecursion = new DepthFirstSearchWithoutRecursion(graph1, 0);
        Stack<Integer> pathTo1 = depthFirstSearchWithoutRecursion.pathTo(3);
        while (!pathTo1.isEmpty()) {
            System.out.println(pathTo1.pop() + " ");
        }
        System.out.println(depthFirstSearchWithoutRecursion.hasCircle());
        System.out.println();

        UnorderedGraph graph2 = new UnorderedGraph(13);
        graph2.addEdge(0, 1);
        graph2.addEdge(0, 2);
        graph2.addEdge(0, 5);
        graph2.addEdge(0, 6);
        graph2.addEdge(3, 4);
        graph2.addEdge(3, 5);
        graph2.addEdge(4, 5);
        graph2.addEdge(4, 6);
        graph2.addEdge(7, 8);
        graph2.addEdge(9, 10);
        graph2.addEdge(9, 11);
        graph2.addEdge(9, 12);
        graph2.addEdge(11, 12);

        ConnectivityGroups cg = new ConnectivityGroups(graph2);
        System.out.println(cg.connected(0, 3));
        System.out.println(cg.connected(0, 7));
        System.out.println(cg.connected(8, 7));
        System.out.println(cg.connected(8, 9));
        System.out.println(cg.connected(11, 10));
        System.out.println(cg.connected(11, 5));
        System.out.println();

        ConnectivityGroupsWithoutRecursion cg1 = new ConnectivityGroupsWithoutRecursion(graph2);
        System.out.println(cg1.connected(0, 3));
        System.out.println(cg1.connected(0, 7));
        System.out.println(cg1.connected(8, 7));
        System.out.println(cg1.connected(8, 9));
        System.out.println(cg1.connected(11, 10));
        System.out.println(cg1.connected(11, 5));

        System.out.println();

        OrderedGraph og = new OrderedGraph(7);
        og.addEdge(0, 1);
        og.addEdge(0, 2);
        og.addEdge(0, 5);
        og.addEdge(1, 4);
        og.addEdge(3, 2);
        og.addEdge(3, 4);
        og.addEdge(3, 5);
        og.addEdge(3, 6);
        og.addEdge(5, 2);
        og.addEdge(6, 0);
        og.addEdge(6, 4);

        TopologicalOrder topologicalOrder = new TopologicalOrder(og);
        Stack<Integer> order = topologicalOrder.topologicalOrder();
        while (!order.isEmpty()) {
            System.out.println(order.pop());
        }
        System.out.println();
        // strong components {1}, {0,2,3,4,5} {6,8} {7} {9,10,11,12}
        OrderedGraph ogSC = new OrderedGraph(13);
        ogSC.addEdge(0, 1);
        ogSC.addEdge(0, 5);
        ogSC.addEdge(2, 0);
        ogSC.addEdge(2, 3);
        ogSC.addEdge(3, 2);
        ogSC.addEdge(3, 5);
        ogSC.addEdge(4, 2);
        ogSC.addEdge(4, 3);
        ogSC.addEdge(5, 4);
        ogSC.addEdge(6, 0);
        ogSC.addEdge(6, 4);
        ogSC.addEdge(6, 8);
        ogSC.addEdge(6, 9);
        ogSC.addEdge(7, 6);
        ogSC.addEdge(7, 9);
        ogSC.addEdge(8, 6);
        ogSC.addEdge(9, 10);
        ogSC.addEdge(9, 11);
        ogSC.addEdge(10, 12);
        ogSC.addEdge(11, 4);
        ogSC.addEdge(11, 12);
        ogSC.addEdge(12, 9);

        StrongConnectedComponents scc = new StrongConnectedComponents(ogSC);
        for (int i = 0; i < ogSC.verticesCount(); i++) {
            System.out.print(scc.groupNumber(i) + " ");
        }
        System.out.println();
    }

}
