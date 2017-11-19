package iurii.job.interview.concurrency;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class CountDownLatchTest {

    // java.util.concurrent.CyclicBarrier does not support decrease in other threads. Can do countdown to negative number
    @Test
    public void shouldCountDownInMainThread() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        AtomicInteger value = new AtomicInteger(0);
        Runnable runnable = () -> {
            try {
                countDownLatch.await();
                value.incrementAndGet();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        assertThat(value.get()).isEqualTo(0);
        countDownLatch.countDown();
        countDownLatch.countDown();
        countDownLatch.countDown();
        thread1.join();
        thread2.join();
        assertThat(value.get()).isEqualTo(2);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);
        thread3.start();
        thread4.start();
        thread3.join();
        thread4.join();
        assertThat(value.get()).isEqualTo(4);
    }
}
