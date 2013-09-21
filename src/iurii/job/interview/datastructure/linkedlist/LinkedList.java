package iurii.job.interview.datastructure.linkedlist;

import java.util.NoSuchElementException;

public class LinkedList<T> {
	
	private Node<T> head;
	private Node<T> tail;
	
	public void push(T element) {
		if (head == null) {
			tail = new Node<T>(element, null, null); 
			head = tail;
			return;
		}
		if (head.element == tail.element) {
			head = new Node<T>(element, tail, null);
			tail.prev = head;
		} else {
			Node<T> newHead = new Node<T>(element, head, null);
			head.prev = newHead;
			head = newHead;
		}
	}
	
	public T removeFirst() {
		return pop();
	}
	
	public T removeLast() {
		if (tail == null) {
			throw new NoSuchElementException();
		}
	    T element = tail.element;
	    tail = tail.prev;
	    
	    if (tail == null) {
	    	head = null;
	    } else {
	    	tail.next = null;
	    }
		return element;	
	}
	
	public void addFirst(T element) {
		push(element);
	}
	
	public void addLast(T element) {
		if (head == null) {
			tail = new Node<T>(element, null, null); 
			head = tail;
			return;
		}
		if (head.element == tail.element) {
			tail = new Node<T>(element, null, head);
			head.next = tail;
		} else {
			Node<T> newTail = new Node<T>(element, null, tail);
			tail.next = newTail;
			tail = newTail;
		}
	}

	public T getFirst() {
		if (head == null) {
			throw new NoSuchElementException("List is empty");
		}
		return head.element;
	}
	
	public T getLast() {
		if (tail == null) {
			throw new NoSuchElementException("List is empty");
		}
		return tail.element;
	}
	
	public T pop() {
		if (head == null) {
			throw new NoSuchElementException();
		}
	    T element = head.element;
	    head = head.next;
	    if (head == null) {
	    	tail = null;
	    } else {
	    	head.prev = null;
	    }
		return element;	
	}
	
	
	private static final class Node<T> {
		Node<T> next;
		Node<T> prev;
		T element;

		public Node(T element, Node<T> next, Node<T> prev) {
			this.element = element;
			this.next =  next;
			this.prev =  prev;
		}
	}
}
