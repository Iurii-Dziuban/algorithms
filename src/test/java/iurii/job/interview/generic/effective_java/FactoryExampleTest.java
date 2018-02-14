package iurii.job.interview.generic.effective_java;

import java.util.function.Function;

public class FactoryExampleTest {

    // Generic singleton factory for any generic type T
    private static Function<Integer, Integer> identity = Function.<Integer> identity();


}
