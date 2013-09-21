package iurii.job.interview.datastructure.stack.array;

import java.lang.reflect.Array;


public class Stack<T> {
	private static final int MIN_STACK_SIZE = 1;
	private T[] stack;
	private Class<T> clazz;
	private int N = -1 ;
	
	public Stack(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	@SuppressWarnings("unchecked")
	public void push(T element) {
		if (stack == null || stack.length == 0) {
			stack = (T[]) Array.newInstance(clazz, MIN_STACK_SIZE);
		}
		if (stack[stack.length - 1] != null) {
			T[] newQueue = (T[]) Array.newInstance(clazz, 2*(N+1));
			for (int i = 0; i < stack.length; i++) {
				newQueue[i] = stack[i];
			}
			stack = newQueue;
		}
		stack[++N] = element;
	}
	
	public T pop() {
		T popElement = stack[N];
		stack[N--] = null;
		if (stack.length/4 > N) {
			@SuppressWarnings("unchecked")
			T[] newQueue = (T[]) Array.newInstance(clazz, stack.length/2);
			for (int i = 0; i < newQueue.length; i++) {
				newQueue[i] = stack[i];
			}
			stack = newQueue;
		}
		return popElement;	
	}
}
