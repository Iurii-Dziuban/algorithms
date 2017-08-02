package iurii.job.interview.datastructure.queue.linkedlist;

import org.junit.Test;

import java.util.NoSuchElementException;

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

}
