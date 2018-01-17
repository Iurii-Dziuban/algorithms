package iurii.job.interview.generic.java8;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class ConcurrencyChapter7Test {

    // All operations on the value are atomic (not separable / done in transaction)
    // There are two types first get and then apply operation (update/set/add/more complex) and vice versa (apply, then get)
    // There are basically AtomicInteger, AtomicBoolean, AtomicLong, AtomicReference types respectively
    // and all combinations of them for Array and Assertion
    @Test
    public void testAtomic() {
        AtomicInteger atomicInteger = new AtomicInteger(10);

        Assertions.assertThat(atomicInteger.decrementAndGet()).isEqualTo(9); // first decrement and then get
        Assertions.assertThat(atomicInteger.getAndDecrement()).isEqualTo(9); // first get and then decrement
        Assertions.assertThat(atomicInteger.incrementAndGet()).isEqualTo(9); // first increment and then get
        Assertions.assertThat(atomicInteger.getAndIncrement()).isEqualTo(9); // first get and then increment
        Assertions.assertThat(atomicInteger.get()).isEqualTo(10); // just get
        atomicInteger.set(12); // just set
        Assertions.assertThat(atomicInteger.getAndSet(11)).isEqualTo(12); // first get and then set
        Assertions.assertThat(atomicInteger.floatValue()).isEqualTo(11); // is equal
        Assertions.assertThat(atomicInteger.accumulateAndGet(50, (x, y) -> 2 * x + y)).isEqualTo(72);
        // IntBinaryOperator (x, y) -> z . Two times value inside 11 + supplied 50
        atomicInteger.set(5);
        Assertions.assertThat(atomicInteger.updateAndGet(x -> x * 3)).isEqualTo(15);
        // IntUnaryOperator x -> y . Three times value inside 5
        Assertions.assertThat(atomicInteger.addAndGet(6)).isEqualTo(21); // add and get

        atomicInteger.set(5); // initialize
        Assertions.assertThat(atomicInteger.compareAndSet(6, 10)).isFalse(); // will not update 6 != 5
        Assertions.assertThat(atomicInteger.compareAndSet(5, 11)).isTrue(); // will update case prev is 5
        Assertions.assertThat(atomicInteger.weakCompareAndSet(11, 12)).isTrue();
        // ! implementation is same as compareAndSet
        atomicInteger.lazySet(10);
        Assertions.assertThat(atomicInteger.get()).isEqualTo(10);

        AtomicBoolean atomicBoolean = new AtomicBoolean(); // default value=false, getAndSet, [weak]compareAndSet/ [lazy]set
        Assertions.assertThat(atomicBoolean.get()).isFalse();

        AtomicLong atomicLong = new AtomicLong(); // default value=0
        //

        AtomicReference<String> reference = new AtomicReference<>("hello");
    }


    @Test
    public void testCyclicBarrier() {
        final CyclicBarrier cb = new CyclicBarrier(2,()-> System.out.
                println("Clean!"));// u1
        ExecutorService service = Executors.newScheduledThreadPool(2);
        IntStream.iterate(1, i -> i + 1) // u2
                .limit(12)
                .forEach(i-> service.submit( // u3
                        ()-> await(cb, i))); // u4
        service.shutdown();
    }

    private static void await(CyclicBarrier cb, int i) {
        try {
            System.out.println(String.format("%d : %d", Thread.currentThread().getId(), i));
            cb.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            // Handle exception
        }
    }
}
