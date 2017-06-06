package iurii.job.interview.datastructure.queue.linkedlist;

import java.util.NoSuchElementException;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public void enqueue(T element) {
        if (head == null) {
            tail = new Node<T>(element, null);
            head = tail;
            return;
        }
        if (head.element == tail.element) {
            head = new Node<T>(element, null);
            tail.prev = head;
        } else {
            Node<T> newHead = new Node<T>(element, null);
            head.prev = newHead;
            head = newHead;
        }
    }

    public T dequeue() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        T element = tail.element;
        tail = tail.prev;

        if (tail == null) {
            head = null;
        }
        return element;
    }


    private static final class Node<T> {
        Node<T> prev;
        T element;

        public Node(T element, Node<T> prev) {
            this.element = element;
            this.prev = prev;
        }
    }
}
