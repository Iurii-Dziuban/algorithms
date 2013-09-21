package iurii.job.interview.datastructure.heap;

import java.lang.reflect.Array;

public class MaxArrayHeap<T extends Comparable<T>> implements Heap<T> {

	private T[] heap;
	private int N = -1;
	private Class<T> clazz;

	public MaxArrayHeap(Class<T> clazz) {
		this.clazz = clazz;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void enqueue(T element) {
		// create new
		if (heap == null || heap.length == 0 || heap[heap.length - 1] != null) {
			T[] newHeap = (T[]) Array.newInstance(clazz, 2 * N + 3);
			int heapSize = heap == null ? 0 : heap.length;
			for (int i = 0; i < heapSize; i++) {
				newHeap[i] = heap[i];
			}
			heap = newHeap;
		}
		heap[++N] = element;
		swim(N);
	}

	@Override
	public T dequeue() {
		T min = heap[0];
		heap[0] = heap[N];
		heap[N] = null;
		sink(0);
		N--;
		if (Math.round(Math.log(heap.length + 1) / Math.log(2)) == 2 + Math
				.round(Math.log(N + 2) / Math.log(2))) {
			@SuppressWarnings("unchecked")
			T[] newHeap = (T[]) Array.newInstance(clazz, N + 1);
			for (int i = 0; i < newHeap.length; i++) {
				newHeap[i] = heap[i];
			}
			heap = newHeap;
		}
		return min;
	}
	
	@Override
    public T peek() {
        return heap[0];
    }

	private void sink(int i) {
		int k = i;
		while (2 * k + 1 < heap.length
				&& (heap[2 * k] != null || heap[2 * k + 1] != null)) {
			int maxChild = greaterChild(k);
			if (maxChild == -1) {
				return;
			}
			T swap = heap[maxChild];
			heap[maxChild] = heap[k];
			heap[k] = swap;
			k = maxChild;
		}
	}

	private int greaterChild(int k) {
		int greater;
		if (heap[2 * k + 1] == null) {
			greater = 2*k;
		} else {
			greater = heap[2 * k].compareTo(heap[2 * k + 1]) < 0 
					? 2 * k + 1
					: 2*k;
		}
		return heap[k].compareTo(heap[greater]) < 0 ? greater : -1;
	}

	private void swim(int i) {
		int k = i;
		boolean isSwimNeeded = true;
		while (isSwimNeeded) {
			isSwimNeeded = false;
			if (heap[k].compareTo(heap[k / 2]) > 0) {
				isSwimNeeded = true;
				T swap = heap[k];
				heap[k] = heap[k / 2];
				heap[k / 2] = swap;
			}
			k /= 2;
		}
	}

    @Override
    public int size() {
        if (heap == null) {
            return 0;
        } else {
            return N+1;
        }
    }
}
