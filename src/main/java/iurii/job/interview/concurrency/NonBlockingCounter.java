package iurii.job.interview.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by iurii.dziuban on 14/09/2017.
 */
public class NonBlockingCounter {

    private AtomicInteger value;

    NonBlockingCounter(int value) {
        this.value = new AtomicInteger(value);
    }

    public int getValue() {
        return value.get();
    }

    public int increment() {
        int v;
        do {
            v = value.get();
        }
        while (!value.compareAndSet(v, v + 1));
        return v + 1;
    }
}
