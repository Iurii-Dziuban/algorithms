package iurii.job.interview.datastructure.linkedlist;

import org.junit.Test;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import static org.assertj.core.api.Assertions.assertThat;

public class ConcurrentLinkedListTest {

    private static final int THREAD_COUNT = 10;

    @Test
    public void test() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(THREAD_COUNT);
        ConcurrentLinkedList<Integer> queue = new ConcurrentLinkedList<>();
        ThreadWithLatch[] threads = new ThreadWithLatch[THREAD_COUNT];
        Thread[] realThreads = new Thread[THREAD_COUNT];
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < threads.length; i++) {
            threads[i] = new ThreadWithLatch(latch, i, queue);
            Thread thread = new Thread(threads[i]);
            realThreads[i] = thread;
            thread.start();
            set.add(i);
        }
        for(Thread thread : realThreads) {
            thread.join();
        }
        for(int i = 0; i < THREAD_COUNT; i++) {
            set.remove(queue.dequeue());
        }
        assertThat(set).isEmpty();
    }

    @Test(expected = NoSuchElementException.class)
    public void popNullTest() {
        ConcurrentLinkedList<Integer> queue = new ConcurrentLinkedList<Integer>();
        queue.dequeue();
    }

    private class ThreadWithLatch implements Runnable {

        private final CountDownLatch latch;
        private final int value;
        private final ConcurrentLinkedList<Integer> queue;

        public ThreadWithLatch(CountDownLatch latch, int value, ConcurrentLinkedList<Integer> queue) {
            this.latch = latch;
            this.value = value;
            this.queue = queue;
        }

        public void run() {
            try {
                latch.countDown();
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            queue.enqueue(value);
        }
    }
}
