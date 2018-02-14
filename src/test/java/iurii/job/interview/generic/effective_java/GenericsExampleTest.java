package iurii.job.interview.generic.effective_java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class GenericsExampleTest {

    // Generic singleton factory for any generic type parameter T (here Integer)
    private static Function<Integer, Integer> identity = Function.<Integer> identity();

    @Test(expected = ArrayStoreException.class)
    public void arrayCastIssuesExample() {
        // array is covariant. we can cast to more general arrays
        // array is reified and not type safe
        // Object[] is more general type and String[] -> Object[]
        String[] stringObjects = new String[1];
        Object[] objects = stringObjects;
        // assigning int to array of Strings throws ArrayStoreException
        objects[0] = 2;
    }

    @Test
    public void arrayList() {
        // generics are type safe and implemented via erasure
        // generics are invariant. we can not assign
        //! not possible
        //List<Number> list = new ArrayList<Integer>();

        // upper bounded wildcard type
        List<? extends Number> extendsNumberList = new ArrayList<Integer>();

        // lower bounded wildcard type
        List<? super Integer> superIntegerList = new ArrayList<Integer>();

    }

    // parameter T will be _inferred_ to concrete type during invocation
    private static <T> T returnT(T element) {
        return element;
    }

    // lower bounded wildcard type -> possible to add value to list
    private static void addElementSuper(List<? super Integer> list) {
        list.add(5);
    }

    // upper bounded wildcard type -> get value without cast
    private static Integer getElementExtend(List<? extends Integer> list) {
        return list.get(0);
    }

    // ! super is not allowed in type parameters, but only in wildcard types
    // ! since the top most type is Object, it would be unbounded
    // private static <E super Integer> E addElementSuperE(List<E> list) {
    // }

    // upper bounded generic type -> get value without cast
    private static <E extends Object> E getElementExtendE(List<E> list) {
        return list.get(0);
    }
}
