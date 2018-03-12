package iurii.job.interview.generic.effective_java;

import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * Functional types are added (type definition is a broader than class). Their instances are called functional objects
 *
 */
public class LambdaAndStreamTest {

    // interfaces are static inner classes
    // annotation guarantees that this interface is intended two have one method to be used in lambda expressions
    // strategy pattern is different with functional interfaces and lambda in comparison to anonymous classes
    // interface as abstract strategy and lambda as a concrete strategy
    // compiler deduces the types from the context - called type inference
    // better to omit types for lambda where it is possible
    @FunctionalInterface
    public interface FuncInterface {

        // abstract method that can be used in lambda expressions
        int value();

        // default methods are not counted as a target function for lambda
        default int defaultValue() {
            return 0;
        }

        // static methods are not counted as a target function for lambda (in java 9 private static as well)
        static int staticValue() {
            return 0;
        }
    }

    @Test
    public void testLambdaAndMethodReferences() {
        // lambda should be self explanatory otherwise use method reference
        FuncInterface lambda = () -> 2;
        FuncInterface methodReference = ThreadLocalRandom.current()::nextInt;
        // method references and lambda types
        // 1) static - reference to static methods
        // 2) bound - reference to instance method (bounded to instance)
        // 3) unbound - uses parameter instance method
        // 4) class constructor : TreeMap<K,V>::new
        // 5) array constructor : int[]::new

        // Template method pattern is less attractive cause based on abstract class instead of interface. which allows lambda
        // use standard java functional interfaces where possible
        // 1) UnaryOperator<T>  T -> T
        // 2) BinaryOperator<T> T, T -> T
        // 3) Predicate<T> T -> boolean
        // 4) Function<T, R> T -> R
        // 5) Supplier<T> () -> T  - default constructors methods :: new are suppliers or Producers
        // 6) Consumer<T> T -> ()
        // there are also functional interfaces for primitive types to save on boxing/unboxing
        // there is ToIntBiFunction<T, T>, which is similar to Comparator, but it is general contract
    }

    @Test
    public void testStreamPipeline() {
        // creating stream, multiple intermediate operations and in the end terminal operation
        IntStream.rangeClosed(0, 5).filter(i -> i % 2 == 0).count();
        // stream is lazy (if based on collection depends on its latest state) and invoked only on terminal operation
        // stream is one time if terminated (finished calculations) can not be used any more. New one should be created
        // stream uses fluent API for intermediate operations if stream is return value - the operation is not terminal
        // refrain from using streams for characters as they are implemented through int...

        // terminal operation can be reduction to one value of all values
        // or reduction strategy - collector to store the result (mutable reduction)
        // reduction function can do some merge as well
        // also has grouping by called classifier function
        // downstream collector can be used after classifier function

        // prefer side-effect-free or pure functions in streams

        // prefer collection to stream as a return type, cause it is not possible to know how it will be used
        // and collection api provides both iterations and stream processing

        // parallel should be used only if benefits can be obtained during execution (depends on nature of stream)
        // liveness failures may occur.. or safety failures (incorrect results or unpredictable behaviour)
        // spliterator is the abstraction to be used during parallel procession
        // collections have locality of reference references to each element are close in memory (critical important)

        // allMatch, noneMatch, anyMatch are called short circuiting operations similarly to binary & |
    }
}
