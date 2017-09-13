package iurii.job.interview.datastructure.stack.linkedlist;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;

public class ConcurrentStack<T> {

    private AtomicReference<Node<T>> head = new AtomicReference<>();

    public void push(T element) {
        Node<T> newHead = new Node<T>(element);
        Node<T> oldHead;
        do {
            oldHead = head.get();
            newHead.next = oldHead;
        } while (!head.compareAndSet(oldHead, newHead));
    }

    public T pop() {
        Node<T> newHead;
        Node<T> oldHead;
        do {
            oldHead = head.get();
            if (oldHead == null) {
                throw new NoSuchElementException();
            }
            newHead = oldHead.next;
        } while (!head.compareAndSet(oldHead, newHead));
        return oldHead.getElement();
    }

    private static final class Node<T> {
        private Node<T> next;
        private final T element;

        public Node(T element) {
            this.element = element;
            this.next = next;
        }

        public T getElement() {
            return element;
        }
    }
}
