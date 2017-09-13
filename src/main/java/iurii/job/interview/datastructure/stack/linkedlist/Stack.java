package iurii.job.interview.datastructure.stack.linkedlist;

import java.util.NoSuchElementException;

public class Stack<T> {

    private Node<T> head;

    public void push(T element) {
        head = new Node<T>(element, head);
    }

    public T pop() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T element = head.getElement();
        head = head.getNext();
        return element;
    }

    private static final class Node<T> {
        private final Node<T> next;
        private final T element;

        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }

        public Node<T> getNext() {
            return next;
        }

        public T getElement() {
            return element;
        }
    }
}
