package iurii.job.interview.datastructure.stack.linkedlist;

import org.junit.Test;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import static org.assertj.core.api.Assertions.assertThat;

public class ConcurrentStackTest {

    private static final int THREAD_COUNT = 10;

    @Test
    public void test() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(THREAD_COUNT);
        ConcurrentStack<Integer> stack = new ConcurrentStack<>();
        ThreadWithLatch[] threads = new ThreadWithLatch[THREAD_COUNT];
        Thread[] realThreads = new Thread[THREAD_COUNT];
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < threads.length; i++) {
            threads[i] = new ThreadWithLatch(latch, i, stack);
            Thread thread = new Thread(threads[i]);
            realThreads[i] = thread;
            thread.start();
            set.add(i);
        }
        for(Thread thread : realThreads) {
            thread.join();
        }
        for(int i = 0; i < THREAD_COUNT; i++) {
            set.remove(stack.pop());
        }
        assertThat(set).isEmpty();
    }

    @Test(expected = NoSuchElementException.class)
    public void popNullTest() {
        ConcurrentStack<Integer> stack = new ConcurrentStack<Integer>();
        stack.pop();
    }


    private class ThreadWithLatch implements Runnable {

        private final CountDownLatch latch;
        private final int value;
        private final ConcurrentStack<Integer> stack;

        public ThreadWithLatch(CountDownLatch latch, int value, ConcurrentStack<Integer> stack) {
            this.latch = latch;
            this.value = value;
            this.stack = stack;
        }

        public void run() {
            try {
                latch.countDown();
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stack.push(value);
        }
    }
}
