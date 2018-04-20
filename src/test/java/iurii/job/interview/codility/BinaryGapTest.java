package iurii.job.interview.codility;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 23/08/2017.
 */
public class BinaryGapTest {

    @Test
    public void test() {
        BinaryGap binaryGap = new BinaryGap();
        assertThat(binaryGap.findMaxGap(1041)).isEqualTo(5);
        assertThat(binaryGap.findMaxGap(15)).isEqualTo(0);
        assertThat(binaryGap.findMaxGap(10)).isEqualTo(1);
    }

    @Test
    public void collections() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.values();
        map1.keySet();
        map1.isEmpty();
        map1.clear();
        map1.merge("t", 5, (v1, v2) -> v1 +v2);
        System.out.println(map1.get("t"));
        map1.merge("t", 4, (v1, v2) -> v1 +v2);
        System.out.println(map1.get("t"));
        System.out.println(map1.computeIfAbsent("r", k -> 1));
        System.out.println(map1.get("r"));
        map1.put("", 1);
        System.out.println(map1.computeIfPresent("", (k, v) -> v + 1));
        System.out.println(map1.get(""));
        System.out.println(map1.getOrDefault("", 5));
        map1.merge("", 5, (i, j) -> i + j);
        map1.merge("a", 5, (i, j) -> i + j);
        Set<Map.Entry<String, Integer>> entrySet = map1.entrySet();
        System.out.println(map1.compute("", (k,i) -> i + 1));
        System.out.println(map1.get(""));
        System.out.println(map1.get("a"));
        map1.putIfAbsent("d", 8);
        System.out.println(map1.replace("d", 9));
        System.out.println(map1.get("d"));
        map1.containsKey("d");
        map1.containsValue(8);
        map1.remove("d");

        NavigableMap<Integer, Integer> map2 = new TreeMap<>(Comparator.naturalOrder());
        map2.ceilingEntry(1);
        map2.ceilingKey(1);
        map2.floorEntry(1);
        map2.floorKey(1);
        map2.descendingKeySet();
        map2.descendingMap();
        map2.higherEntry(1);
        map2.higherKey(1);
        map2.lowerEntry(1);
        map2.lowerKey(1);
        map2.navigableKeySet();
        map2.firstEntry();
        map2.lastEntry();
        map2.pollFirstEntry();
        map2.pollLastEntry();

        Set<Integer> set = new HashSet<>();
        set.containsAll(new ArrayList<>());
        set.contains(1);
        set.add(1);
        set.size();
        set.clear();
        set.isEmpty();
        set.iterator();
        set.remove(1);
        NavigableSet<Integer> set1 = new TreeSet<>(Comparator.naturalOrder());
        set1.ceiling(1);
        set1.floor(1);
        set1.higher(1);
        set1.lower(1);
        set1.pollFirst();
        set1.pollLast();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        priorityQueue.add(4);
        priorityQueue.add(2);
        priorityQueue.offer(3);

        int a = priorityQueue.peek();
        int b = priorityQueue.poll();
        priorityQueue.remove(1);

        CopyOnWriteArrayList<Integer> copyList = new CopyOnWriteArrayList<>();
        copyList.addIfAbsent(1);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        int index = atomicInteger.getAndAccumulate(1, (i, j) -> (i+j) % 20);
        copyList.set(index, 2);
        copyList.iterator();
    }
}
