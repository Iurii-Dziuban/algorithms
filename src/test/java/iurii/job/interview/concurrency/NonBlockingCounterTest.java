package iurii.job.interview.concurrency;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 14/09/2017.
 */
public class NonBlockingCounterTest {
    private static final int THREAD_COUNT = 10;

    @Test
    public void test() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(THREAD_COUNT);
        NonBlockingCounter counter = new NonBlockingCounter(-1);
        ThreadWithLatch[] threads = new ThreadWithLatch[THREAD_COUNT];
        Thread[] realThreads = new Thread[THREAD_COUNT];
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < threads.length; i++) {
            threads[i] = new ThreadWithLatch(latch, counter);
            Thread thread = new Thread(threads[i]);
            realThreads[i] = thread;
            thread.start();
            set.add(i);
        }
        for(Thread thread : realThreads) {
            thread.join();
        }
        for(int i = 0; i < THREAD_COUNT; i++) {
            set.remove(threads[i].value);
        }
        assertThat(set).isEmpty();
    }

    private class ThreadWithLatch implements Runnable {

        private final CountDownLatch latch;
        private int value;
        private final NonBlockingCounter counter;

        public ThreadWithLatch(CountDownLatch latch, NonBlockingCounter counter) {
            this.latch = latch;
            this.counter = counter;
        }

        public void run() {
            try {
                latch.countDown();
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.value = counter.increment();
        }
    }
}
