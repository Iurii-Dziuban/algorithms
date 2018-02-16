package iurii.job.interview.generic.effective_java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * Never use raw types. violates type system.
 * Arrays violate type system as well
 * Generics provide compile time guarantees on types
 * So prefer lists over arrays and use wildcards or type parameters to extend.
 * use super for consumer and extends for producers. Comparable is consumer
 */
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
        // Heap pollution with arrays - runtime type of array does not match compile time array type
        objects[0] = 2;
    }

    @Test
    public void listTest() {
        // diamond operator from java 7
        List<Integer> integers = new ArrayList<>();
        List integer2 = integers;
        // Heap pollution with list - runtime type of adding element does not match compile time array type
        integer2.add("abcd");
        // no exceptions, only warnings - cause no casts
    }

    @Test
    public void arrayList() {
        // generics are type safe and implemented via erasure
        // generics are invariant and erased. non reifiable we can not assign
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

    // type params and wildcard types are dual (duality - do same things differently)
    // better for user to provide wildcard types - they are simpler and privately use  type parameter for flexibility
    public static void swap(List<?> list, int i, int j) {
        swapHelper(list, i, j);
    }

    private static <E> void swapHelper(List<E> list, int i, int j) {
        // works because getting element return the same type
        list.set(i, list.set(j, list.get(i)));
    }

    // varargs can be used with generics (leaky abstraction)! only because they are handy
    private Object[] varargsWithGeneric(List<Integer>... lists) {
        // but not type safe cause backed by arrays and nothing stops to return as array without type
        // heap pollution will occur trying to insert incorrect type
       return lists;
    }

    // heterogeneous type safe containers
    public static class Favourites {
        // map can hold values of different types
        private Map<Class<?>, Object> favourites = new HashMap<>();

        // hear T is unbounded but it can be bounded if it is needed for implementation (bounded type token)
        public <T> void putFavourite(/*type token */Class<T> type, T instance) {
            // problem is that we can provide incorrect parameters and cast will fail only on get
            // so it is better to check cast hear as well!
            favourites.put(Objects.requireNonNull(type), type.cast(instance));
        }

        // can not be used for non reifiable types like List<Integer>, List<String> .. only one class

        public <T> T getFavourite(Class<T> type) {
            // dynamic cast
            return type.cast(favourites.get(type));
        }
    }
    @Test(expected = ClassCastException.class)
    public void testAsSubclassDynamicCast () {
        // Integer can be safely dynamically casted to Number
        Integer.class.asSubclass(Number.class);
        // number can not casted to integer
        Number.class.asSubclass(Integer.class);
    }
}
