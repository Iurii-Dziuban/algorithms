package iurii.job.interview.datastructure.heap;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 01/08/2017.
 */
public class MinArrayHeapTest {
    @Test
    public void test() {
        MinArrayHeap<Integer> minHeap = new MinArrayHeap<Integer>(Integer.class);
        assertThat(minHeap.size()).isEqualTo(0);
        minHeap.enqueue(3);
        minHeap.enqueue(2);
        minHeap.enqueue(4);
        minHeap.enqueue(1);
        minHeap.enqueue(5);

        assertThat(minHeap.peek()).isEqualTo(1);
        assertThat(minHeap.size()).isEqualTo(5);
        assertThat(minHeap.dequeue()).isEqualTo(1);
        assertThat(minHeap.dequeue()).isEqualTo(2);
        assertThat(minHeap.dequeue()).isEqualTo(3);
        assertThat(minHeap.dequeue()).isEqualTo(4);
        assertThat(minHeap.dequeue()).isEqualTo(5);
    }
}
