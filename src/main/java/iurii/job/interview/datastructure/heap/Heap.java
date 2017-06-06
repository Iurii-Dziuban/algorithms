package iurii.job.interview.datastructure.heap;

/**
 * Heap implementation
 *
 * @param <T> - elements type
 * @author Jacky
 */
public interface Heap<T> {
    void enqueue(T element);

    T dequeue();

    int size();

    T peek();
}
