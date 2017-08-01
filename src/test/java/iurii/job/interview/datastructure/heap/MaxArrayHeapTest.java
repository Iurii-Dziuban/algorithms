package iurii.job.interview.datastructure.heap;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 01/08/2017.
 */
public class MaxArrayHeapTest {
    @Test
    public void test() {
        MaxArrayHeap<Integer> maxHeap = new MaxArrayHeap<Integer>(Integer.class);
        assertThat(maxHeap.size()).isEqualTo(0);

        maxHeap.enqueue(3);
        maxHeap.enqueue(2);
        maxHeap.enqueue(4);
        maxHeap.enqueue(1);
        maxHeap.enqueue(5);

        assertThat(maxHeap.peek()).isEqualTo(5);
        assertThat(maxHeap.size()).isEqualTo(5);
        assertThat(maxHeap.dequeue()).isEqualTo(5);
        assertThat(maxHeap.dequeue()).isEqualTo(4);
        assertThat(maxHeap.dequeue()).isEqualTo(3);
        assertThat(maxHeap.dequeue()).isEqualTo(2);
        assertThat(maxHeap.dequeue()).isEqualTo(1);
    }
}
