package iurii.job.interview.algorithms1.coursera;

import iurii.job.interview.graph.depth_first_search.StrongConnectedComponents;
import iurii.job.interview.graph.structure.OrderedGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class AlgorithmsWeekFour {

    private static final int VERTICES_COUNT = 875714;

    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/main/resources/SCC.txt"));
        OrderedGraph graph = new OrderedGraph(VERTICES_COUNT);
        while (sc.hasNext()) {
            int v = sc.nextInt() - 1;
            int w = sc.nextInt() - 1;
            graph.addEdge(v, w);
        }
        sc.close();
        StrongConnectedComponents scc = new StrongConnectedComponents(graph);
        Map<Integer, List<Integer>> groupVertexMap = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < VERTICES_COUNT; i++) {
            int group = scc.groupNumber(i);
            List<Integer> list = groupVertexMap.get(group);
            if (list == null) {
                groupVertexMap.put(group, new ArrayList<Integer>());
            }
            list = groupVertexMap.get(group);
            list.add(i);
        }
        Set<Entry<Integer, List<Integer>>> entrySet = groupVertexMap.entrySet();
        List<Integer> sizes = new ArrayList<Integer>();
        for (Entry<Integer, List<Integer>> entry : entrySet) {
            sizes.add(entry.getValue().size());
        }
        Collections.sort(sizes);
        System.out.println(sizes.get(sizes.size() - 1));
        System.out.println(sizes.get(sizes.size() - 2));
        System.out.println(sizes.get(sizes.size() - 3));
        System.out.println(sizes.get(sizes.size() - 4));
        System.out.println(sizes.get(sizes.size() - 5));
    }

}
