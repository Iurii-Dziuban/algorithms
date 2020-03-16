package iurii.job.interview.graph.shortest_path;

import iurii.job.interview.graph.structure.DirectedEdge;
import iurii.job.interview.graph.structure.OrderedWeightedGraph;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by iurii.dziuban on 02/08/2017.
 */
public class DejkstraTest {

    @Test
    public void test() {
        OrderedWeightedGraph graph2 = new OrderedWeightedGraph(3);
        graph2.addEdge(0, 1, 3);
        graph2.addEdge(0, 2, 2);
        graph2.addEdge(1, 2, -2);

        Dejkstra dejkstra2 = new Dejkstra(graph2, 0);
        Stack<DirectedEdge> pathTo2 = dejkstra2.pathTo(2);
        while (!pathTo2.isEmpty()) {
            System.out.println(pathTo2.pop());
        }
        System.out.println();
    }

    @Test
    public void test1() {
        System.out.println(new DejkstraTest().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numberToFrequencey = new HashMap<>();
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        for (int number : nums) {
            numberToFrequencey.put(number, numberToFrequencey.getOrDefault(number, 0) + 1);
        }
        for (int num : numberToFrequencey.keySet()) {
            if (priorityQueue.size() < k || priorityQueue.peek().frequency < numberToFrequencey.get(num)) {
                if (priorityQueue.size() == k) {
                    priorityQueue.remove();
                }
                priorityQueue.add(new Pair(num, numberToFrequencey.get(num)));
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while (priorityQueue.size() > 0) {
            res.addFirst(priorityQueue.poll().number);
        }

        String[] array = new String[1];
        Arrays.stream(array).collect(Collectors.joining(" "));
        return res;
    }

    static class Pair implements Comparable<Pair> {
        int number;
        int frequency;

        public Pair(int number, int frequency) {
            this.number = number;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Pair other) {
            if (other.frequency != frequency) {
                return -other.frequency + frequency;
            } else {
                return -other.number + number;
            }
        }
    }
}
