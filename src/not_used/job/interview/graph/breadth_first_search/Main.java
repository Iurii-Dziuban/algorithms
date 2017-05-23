package iurii.job.interview.graph.breadth_first_search;

import java.util.Stack;

import iurii.job.interview.graph.structure.UnorderedGraph;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        UnorderedGraph graph = new UnorderedGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 0);
        Stack<Integer> pathTo = bfs.pathTo(5);
        while (!pathTo.isEmpty()) {
            System.out.println(pathTo.pop() + " ");
        }
        
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
    }

}
