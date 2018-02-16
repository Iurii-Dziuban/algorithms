package iurii.job.interview.generic.effective_java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.function.Function;

/**
 * Factories are widely used inside Dependency Injection frameworks ( broader Inversion Of Control concept)
 * which benefits if interface reference is used and during runtime needed implementation is injected.
 * It provided low coupling between classes, based on contract/interface interaction
 */
public class FactoryExampleTest {

    // Generic singleton factory for any generic type T
    // type is inferred from the right side declaration
    private static Function<Integer, Integer> identity = Function.identity();

    // static factory method pattern
    // hides that no entry are actually created, but pool of existing immutable objects to be reused (Flyweight pattern)
    // example of boxing primitive boolean
    // ability to control instances called instance-controlled
    // no need to check for equals. Enough to check by reference
    // technique allows to use interface as return type and hide real implementation classes(Interface-based frameworks)
    // this also allows not to have impl class during development but only at runtime ->
    // service provider frameworks use this approach like JDBC. Register provider first. Bridge pattern
    // of and valueOf are good names to change from one type to another. of is aggregation method for Lists, Sets in java9
    private static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

    // from is good name to type conversion methods
    private static Date from(Instant instant) {
        return Date.from(instant);
    }

    // getInstance/instance good name if instance is described by its parameters
    private static DateFormat getInstance() {
        return SimpleDateFormat.getInstance();
    }

    // newInstance/creteInstance good name if a new instance is created each time
    private static Object newInstance() {
        return Array.newInstance(String.class, 1);
    }

    // getType/type similar to getInstance but in different class
    private static FileStore getType(String s) throws IOException {
        return Files.getFileStore(Paths.get(s));
    }

    // Example of using non instantiable companion object/class for a Factory which controls instances of Address being created
    // similar technique is used in other languages like scala/kotlin
    private static class AddressCompanion {
        private AddressCompanion() {
        }

        public static Address create() {
            return new Address();
        }
    }

    private static class Address {
        // can be created only from AddressCompanion
        private Address() {
        }
    }

    // unintentional object retentions is when reference forgot to be set null on not used object
    // causes memory leaks (object is not used but there is a reference to it), Heap profiler can help to find
    // such references are called obsolete references
    // short example
    private static class Stack {
        // manages its own memory
        // allocated storage pool
        private Object[] elements;
        private int size;

        // gives an object, but reference is still in the elements array
        public Object pop() {
            // free elements[size] = null before returning the reference
            return elements[size--];
        }
        // alternative to having own storage to have Weak references - they do not prevent object from GC
        // if only weak references exist to the object

        // finalizers - in general do not use or use as a safety net that may/may not be called
        // alternative is Cleaner, which is more safe that finalizer but also should not be trusted
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
        }
    }

    // prefer try with resources first exception is man one other are getting suppressed
    private static void tryWithResources(String path) {
        try (BufferedReader br1 = new BufferedReader(new FileReader(path));
             BufferedReader br2 = new BufferedReader(new FileReader(path))) {

        } catch (Exception e) {

        }
    }
}
