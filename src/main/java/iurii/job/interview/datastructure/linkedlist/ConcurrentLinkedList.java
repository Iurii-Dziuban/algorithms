package iurii.job.interview.datastructure.linkedlist;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Based on https://www.ibm.com/developerworks/library/j-jtp04186/index.html
 *
 * More:
 * Created by iurii.dziuban on 13/09/2017.
 */
public class ConcurrentLinkedList<T> {

    // dummy reference for algorithm correctness (head always points to null/dummy node)
    private final Node<T> dummy = new Node<>(null, new AtomicReference<>(null));
    private AtomicReference<Node<T>> head = new AtomicReference<>(dummy);
    private AtomicReference<Node<T>> tail = new AtomicReference<>(dummy);

    // Threads helping each other
    public boolean enqueue(T element) {
        Node<T> newNode = new Node<T>(element, new AtomicReference<>(null));
        while(true) {
            Node<T> currentTail = tail.get();
            Node<T> tailNext = currentTail.next.get();
            if (currentTail == tail.get()) {
                if (tailNext != null) {
                    // threads helping to move tail to each other
                    tail.compareAndSet(currentTail, tailNext);
                } else {
                    if (currentTail.next.compareAndSet(null, newNode)) {
                        // no need to retry if fails - other thread will complete it.
                        tail.compareAndSet(currentTail, newNode);
                        return true;
                    }
                }
            }
        }
    }

    public T dequeue() {
        Node<T> newNext;
        Node<T> oldNext;
        do {
            oldNext = head.get().next.get();
            if (oldNext == null) {
                throw new NoSuchElementException();
            }
            newNext = oldNext.next.get();
        } while (!head.get().next.compareAndSet(oldNext, newNext));
        return oldNext.element;
    }

    private static final class Node<T> {
        AtomicReference<Node<T>> next;
        T element;

        public Node(T element, AtomicReference<Node<T>> next) {
            this.element = element;
            this.next = next;
        }
    }
}
