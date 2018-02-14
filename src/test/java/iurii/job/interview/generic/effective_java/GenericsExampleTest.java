package iurii.job.interview.generic.effective_java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class GenericsExampleTest {

    // Heap pollution with arrays - runtime type of array does not match compile time array type

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
        // generics are invariant and erased. we can not assign
        //! not possible
        //List<Number> list = new ArrayList<Integer>();

        // parametrized type
        // upper bounded wildcard type
        List<? extends Number> extendsNumberList = new ArrayList<Integer>(); // integer - actual type parameter

        // lower bounded wildcard type
        List<? super Integer> superIntegerList = new ArrayList<Integer>();

        // unbounded wildcard type
        List<?> unboundedTypeList = new ArrayList<Integer>();

        // new List<E>[], new List<String>[], new E[] is not possible - generic array creation

    }

    // formal type parameter T will be _inferred_ to concrete type during invocation
    // T is called reifiable type - during runtime it is Object
    // generic method
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

    // recursive type bound
    // make two instances mutually comparable
    // express instance of Address should be comparable only to itself
    public static <E extends Comparable<E>> E max(List<E> list) {
        return list.stream().max(E::compareTo).get();
    }
}
