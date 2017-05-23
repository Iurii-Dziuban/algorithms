package iurii.job.interview.datastructure.heap;

/**
 * Heap implementation
 * @author Jacky
 *
 * @param <T> - elements type
 */
public interface Heap<T> {
    void enqueue(T element);
    T dequeue();
    int size();
    T peek();
}
