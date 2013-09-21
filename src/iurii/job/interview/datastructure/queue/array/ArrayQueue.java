package iurii.job.interview.datastructure.queue.array;

import java.lang.reflect.Array;
public class ArrayQueue<T extends Comparable<T>> {
	
	private static final int MIN_QUEUE_SIZE = 1;
	
	private T[] queue;
	private Class<T> clazz;
	private int N = -1 ;
	
	public ArrayQueue(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	@SuppressWarnings("unchecked")
	public void push(T element) {
		if (queue == null || queue.length == 0) {
			queue = (T[]) Array.newInstance(clazz, MIN_QUEUE_SIZE);
		}
		if (queue[queue.length - 1] != null) {
			T[] newQueue = (T[]) Array.newInstance(clazz, 2*(N+1));
			for (int i = 0; i < queue.length; i++) {
				newQueue[i] = queue[i];
			}
			queue = newQueue;
		}
		queue[++N] = element;
	}
	
	public T pop() {
		int index = 0;
		for (int i = 1; i < N+1; i++) {
			if (queue[index].compareTo(queue[i]) < 0) {
				index = i;
			}
		}
		T popElement = queue[index];
		queue[index] = queue[N];
		queue[N--] = null;
		if (queue.length / 4 > N) {
			@SuppressWarnings("unchecked")
			T[] newQueue = (T[]) Array.newInstance(clazz, queue.length/2);
			for (int i = 0; i < newQueue.length; i++) {
				newQueue[i] = queue[i];
			}
			queue = newQueue;
		}
		return popElement;	
	}
}
