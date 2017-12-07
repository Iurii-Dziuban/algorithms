package iurii.job.interview.facebook;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

/**
 * Facebook question:
 * Having K sorted asc lists, up to N elements in each list, K << N,
 * Create iterator with hasNext and next methods returning the smallest element left from all lists
 * <p>
 * https://stackoverflow.com/questions/46900859/given-k-sorted-lists-of-up-to-n-elements-in-each-list-return-a-sorted-iterator
 * <p>
 * Similar to http://www.geeksforgeeks.org/find-smallest-range-containing-elements-from-k-lists/ ( https://www.careercup.com/question?id=16759664)
 * Created by iurii.dziuban on 04/12/2017.
 */
public interface MinIteratorOfSortedAscendingLists<E> extends Iterator<E> {

    /**
     * Brute force way. First solution that comes to mind
     * K lists
     * N - maximum number of the elements in the list
     * <p>
     * No pre processing.
     * next O(K) scan potentially all K lists
     * hasNext (O(K)) time - potentially scan all K lists
     * <p>
     * auxiliary space O(K) for pointers
     */
    class BruteForceListsIterator implements MinIteratorOfSortedAscendingLists<Integer> {

        private final List<List<Integer>> lists;
        private final int[] pointers;

        public BruteForceListsIterator(List<List<Integer>> lists) {
            pointers = new int[lists.size()];
            this.lists = lists;
        }

        @Override
        public boolean hasNext() {
            for (int i = 0; i < lists.size(); i++) {
                if (lists.get(i).size() > pointers[i]) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                int index = 0;
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < lists.size(); i++) {
                    if (lists.get(i).size() > pointers[i]) {
                        if (lists.get(i).get(pointers[i]) < min) {
                            min = lists.get(i).get(pointers[i]);
                            index = i;
                        }
                    }
                }
                pointers[index]++;
                return min;
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    // -------------------------- Pre processing based  Priority Queue solution --------------------
    /**
     * Priority queue way - Successive two-way merges as pre processing
     * K lists
     * N - maximum number of the elements in the list
     * <p>
     * Pre processing all lists into queue. N*K ln (N*K)
     * By default priorityQueue sorts ascending and minHeap with duplicates.
     * next O(1) to get first element from the queue
     * hasNext (O(1)) time - check priority queue is empty
     * <p>
     * auxiliary space O(K*N) for priority queue storage
     */
    class PreProcessingListsIterator implements MinIteratorOfSortedAscendingLists<Integer> {

        private final PriorityQueue<Integer> queue;

        public PreProcessingListsIterator(List<List<Integer>> lists) {
            queue = new PriorityQueue<>();
            for (List<Integer> list : lists) {
                for (int element : list) {
                    queue.add(element);
                }
            }
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                return queue.poll();
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    //--------------------------- Priority Queue based and pointers -------------------------------

    /**
     * Priority queue way
     * K lists
     * N - maximum number of the elements in the list
     * <p>
     * Processing takes first element from each list into the queue. O(K) + O(ln(K))
     * <p>
     * By default priorityQueue sorts ascending and minHeap with duplicates.
     * <p>
     * next O(K) + O (ln (K)) to get first element from the queue and take next element from the list,
     * which contained taken element or leave it if the list contains no more elements left
     * <p>
     * hasNext (O(1)) time - check priority queue is empty
     * <p>
     * auxiliary space O(K) for priority queue storage and O(K) for pointers
     */
    class MixedListsIterator implements MinIteratorOfSortedAscendingLists<Integer> {

        private final List<List<Integer>> lists;
        private final PriorityQueue<Integer> queue;
        private final int[] pointers;

        public MixedListsIterator(List<List<Integer>> lists) {
            this.lists = lists;
            pointers = new int[lists.size()];
            queue = new PriorityQueue<>(lists.size());
            for (int i = 0; i < lists.size(); i++) {
                if (lists.get(i).size() > pointers[i]) {
                    queue.add(lists.get(i).get(pointers[i]));
                }
            }
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                Integer nextElement = queue.poll();
                for (int i = 0; i < lists.size(); i++) {
                    if (lists.get(i).size() > pointers[i] &&
                            nextElement.equals(lists.get(i).get(pointers[i]))) {
                        if (lists.get(i).size() > pointers[i] + 1) {
                            queue.add(lists.get(i).get(++pointers[i]));
                        }
                        return nextElement;
                    }
                }
            }
            throw new NoSuchElementException();
        }
    }


    // ------------------------------ Priority Queue Iterator Based ------------------------------------------
    /**
     * Priority queue way, iterator based (best solution so far !)
     * K lists
     * N - maximum number of the elements in the list
     * <p>
     * Processing takes iterator from each list into the queue, based on first element comparison.
     * O(K) + O(ln(K))
     * <p>
     * PriorityQueue sorts iterators ascending based on next element in the iterator
     * <p>
     * next O(1) + O (ln (K)) to get first iterator with min element from the queue
     * and put if iterator contains more elements put iterator back to the queue based on next element value
     *
     * <p>
     * hasNext (O(1)) time - check priority queue is empty
     * <p>
     * auxiliary space O(K) for priority queue storage for iterators
     */
    class IteratorBasedListsIterator<E> implements MinIteratorOfSortedAscendingLists<E> {

        private final PriorityQueue<PeekableIterator<E>> queue;

        public IteratorBasedListsIterator(List<List<E>> lists, Comparator<E> comparator) {
            queue = new PriorityQueue<>(lists.size(), new IteratorComparator<>(comparator));
            for (List<E> list : lists) {
                if (list.iterator().hasNext()) {
                    queue.add(new PeekableIterator<>(list.iterator()));
                }
            }
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public E next() {
            if (hasNext()) {
                PeekableIterator<E> iterator = queue.poll();
                E result = iterator.next();
                if (iterator.hasNext()) {
                    queue.add(iterator);
                }
                return result;
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    // Peekable Iterator is an iterator that lets us peek at the next item
    // without consuming it.
    class PeekableIterator<E> implements Iterator<E> {
        private final Iterator<E> iterator;
        private E current;
        private boolean hasCurrent;

        public PeekableIterator(Iterator<E> iterator) {
            this.iterator = iterator;
            hasCurrent = false;
            if (iterator.hasNext()) {
                current = iterator.next();
                hasCurrent = true;
            }
        }

        public E getCurrent() {
            return current;
        }

        @Override
        public boolean hasNext() {
            return hasCurrent;
        }

        @Override
        public E next() {
            E result = current;
            if (iterator.hasNext()) {
                hasCurrent = true;
                current = iterator.next();
            } else {
                hasCurrent = false;
                current = null;
            }
            return result;
        }
    }

    // IteratorComparator lets us compare the next items for two PeekableIterator instances.
    class IteratorComparator<E> implements Comparator<PeekableIterator<E>> {
        private final Comparator<E> comparator;

        public IteratorComparator(Comparator<E> comparator) {
            this.comparator = comparator;
        }

        public int compare(PeekableIterator<E> t1, PeekableIterator<E> t2) {
            return comparator.compare(t1.getCurrent(), t2.getCurrent());
        }
    }

    // integer comparator
    class NonNullIntegerComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }
}