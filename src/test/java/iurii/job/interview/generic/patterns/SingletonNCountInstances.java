package iurii.job.interview.generic.patterns;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * How to make singleton pattern with specific amount of instances. Thread safe is added via AtomicInteger counter
 *
 * Example here is for three instances
 */
public enum SingletonNCountInstances {

    ONE, TWO, THREE;

    private final static List<SingletonNCountInstances> values = Collections.unmodifiableList(Arrays.asList(values()));

    private final static int N = values.size();
    private static final AtomicInteger atomicCounter = new AtomicInteger(-1);

    public static SingletonNCountInstances nextInstance() {
        return values.get(atomicCounter.updateAndGet(value -> (value + 1) % N));
        // in case of overflow goes to min value
        //return values.get(atomicCounter.incrementAndGet() % N);

    }

}
