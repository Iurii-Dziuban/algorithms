package iurii.job.interview.generic.effective_java;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicLong;

public class ConcurrencyTest {

    private volatile int volatileValue = 5;

    @Test
    public void test() {
        // synchronization is not only about mutual exclusion and state transition from one consistent state to another
        // but also one thread`s changes making visible to other threads
        // Language specification guarantees reading and writing variable atomic if not double or long
        // even if threads modify the variable concurrently and without synchronization
        // Synchronization is required for reliable communication between threads as well as for mutual exclusion
        // This is guaranteed by the part of specification called memory model (happens-before)
        // some old java methods on Thread are not safe, cause can cause data corruption (ex. Thread.stop())

        boolean stopRequested = false;
        int i = 0;

        while(!stopRequested) {
            i++;
            // not part of example
            stopRequested = true;
        }

        // after applying hoisting optimization. Other threads will not see which leads to liveness failure
        stopRequested = false;

        if (!stopRequested) {
            while(true) {
                i++;
                // not part of example
                break;
            }
        }

        // synchronization is not guaranteed to work unless both read and write operations are synchronized
        // sometimes synchronization is needed solely for communication purposes
        // volatile can be used, but has performance impact..
        // possible for object field
        // broken! cause operation on volatileValue is not atomic (read and write). Safety failure
        volatileValue++;

        // use atomics in this case
        AtomicLong atomicLong = new AtomicLong(0);
        atomicLong.incrementAndGet();
        // or
        atomicLong.getAndIncrement();

        // not to have issues with problems above - use immutable data and confine mutable data to a single thread
        // or use effectively immutable objects that can not be made immutable

        // in observer pattern, do not synchronize to invoke the callback alien method
        // (The one, you do not have control of code). This may lead to data corruption, deadlocks, etc.
        // locks are reentrant in java. If thread owns a lock to object and then tries to get a lock one more time
        // to the same object - access is granted

        // It is better to move alien method call out of synchronization block - called open call.
        // or use concurrent collection. Like CopyOnWriteArrayList which is secure to use in concurrent multi threaded env

        // Contention is the real cost of excessive synchronization than CPU time
        // Synchronization can be done internally in the class or require external code.

        // Executors framework has thread pool. Work queue is formed by tasks to be executed/submitted (Runnable/Callable)
        // Better to use ConcurrentMap instead of Collections.synchronizedMap

        // some collections are extended with blocking operations (BlockingQueue, etc.) - block until new data comes
        // or able to be putted - called producer-consumers queues

        // Synchronizers are CountDownLatch, Semaphore, CyclicBarrier, Reentrant lock, Exchanger, most powerful Phaser
        // Be aware that it can cause thread starvation deadlock

        // use while idiom instead of if idiom to wait, cause thread can be woken up and should not continue if condition fails
        // private lock object can be used to ensure proper locks
        // lazy initialization makes synchronization harder
        // (double check idiom / racy single check with volatile which tolerate repeated initialization)
    }
}
