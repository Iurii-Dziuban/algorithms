package iurii.job.interview.datastructure.linkedlist;


import org.junit.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListTest {

    @Test
    public void test() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addFirst(1);
        list.push(2);
        list.push(3);
        list.addLast(4);

        assertThat(list.getFirst()).isEqualTo(3);
        assertThat(list.getLast()).isEqualTo(4);

        assertThat(list.pop()).isEqualTo(3);
        assertThat(list.pop()).isEqualTo(2);
        assertThat(list.pop()).isEqualTo(1);
        assertThat(list.pop()).isEqualTo(4);
        list.push(1);
        list.push(2);
        assertThat(list.pop()).isEqualTo(2);
        assertThat(list.removeFirst()).isEqualTo(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void testPopNoHead() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.pop();
    }

    @Test(expected = NoSuchElementException.class)
    public void testLastNoHead() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.getLast();
    }

    @Test(expected = NoSuchElementException.class)
    public void testFirstNoHead() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.getFirst();
    }

    @Test
    public void testAddLast() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addLast(2);
        list.addLast(1);
        list.addLast(3);

        assertThat(list.removeLast()).isEqualTo(3);
        assertThat(list.removeLast()).isEqualTo(1);
        assertThat(list.removeLast()).isEqualTo(2);
    }

    @Test
    public void testAddFirst() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addFirst(2);

        assertThat(list.pop()).isEqualTo(2);
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveLast() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.removeLast();
    }

}
