package iurii.job.interview.concurrency;

import org.junit.Test;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class CyclicBarrierTest {

    // java.util.concurrent.CountDownLatch.class does not support reset to initial value.
    // await is not working if the value already reached zero
    @Test
    public void shouldReset() throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        AtomicInteger value = new AtomicInteger(0);
        Runnable runnable = () -> {
            try {
                cyclicBarrier.await();
                value.incrementAndGet();
                cyclicBarrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        assertThat(value.get()).isEqualTo(2);
        cyclicBarrier.reset();
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);
        thread3.start();
        thread4.start();
        thread3.join();
        thread4.join();
        assertThat(value.get()).isEqualTo(4);
    }

    // Runnable is executed at the barrier before all threads are released. CountDownLatch does not support it
    @Test
    public void shouldExecuteRunnableBefore() throws InterruptedException {
        AtomicInteger value = new AtomicInteger(0);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, value::incrementAndGet);
        Runnable runnable = () -> {
            try {
                cyclicBarrier.await();
                value.incrementAndGet();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        assertThat(value.get()).isEqualTo(3);
    }
}
