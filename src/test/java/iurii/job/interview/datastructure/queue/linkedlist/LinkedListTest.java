package iurii.job.interview.datastructure.queue.linkedlist;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListTest {

    @Test
    public void main() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.enqueue(1);
        list.enqueue(4);
        list.enqueue(3);
        list.enqueue(2);

        assertThat(list.dequeue()).isEqualTo(1);
        assertThat(list.dequeue()).isEqualTo(4);
        assertThat(list.dequeue()).isEqualTo(3);
        assertThat(list.dequeue()).isEqualTo(2);
        list.enqueue(2);
        list.enqueue(1);
        assertThat(list.dequeue()).isEqualTo(2);
        assertThat(list.dequeue()).isEqualTo(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void dequeueNoElement() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.dequeue();
    }

    // Priority Queue. Iterator. iterator does not provide guarantees for any particular order. How to solve it?
    // based on https://dzone.com/articles/maintaining-priorityqueue-order-with-java-streams

    @Test
    public void fixIteratorOrderOnPriorityQueue() {
        // comparable
        PriorityQueue<String> queueComparable = new PriorityQueue<>();
        queueComparable.addAll(Arrays.asList("1", "333", "22", "55555", "4444"));
        List<String> sortedComparable = asStream(queueComparable).collect(Collectors.toList());

        assertThat(sortedComparable).containsExactly("1", "22", "333", "4444", "55555");
        assertThat(queueComparable).isNotEmpty();

        // comparator
        PriorityQueue<String> queueComparator = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        queueComparator.addAll(Arrays.asList("1", "333", "22", "55555", "4444"));
        List<String> sortedComparator = asStream(queueComparator).collect(Collectors.toList());

        assertThat(sortedComparator).containsExactly("1", "22", "333", "4444", "55555");
        assertThat(queueComparator).isNotEmpty();

        // draining the queue
        PriorityQueue<String> queueToBeDrained = new PriorityQueue<>();
        queueToBeDrained.addAll(Arrays.asList("1", "333", "22", "55555", "4444"));
        List<String> sortedDrainedQueue = Stream.generate(queueToBeDrained::poll)
                .limit(queueToBeDrained.size())
                .collect(Collectors.toList());
        assertThat(sortedDrainedQueue)
                .containsExactly("1", "22", "333", "4444", "55555");
        assertThat(queueToBeDrained).isEmpty();
    }

    private static <T> Stream<T> asStream(PriorityQueue<T> queue) {
        Objects.requireNonNull(queue);
        Comparator<? super T> comparator = queue.comparator();
        return comparator != null
                ? queue.stream().sorted(comparator)
                : queue.stream().sorted();
    }

}
