package iurii.job.interview.generic.effective_java;

import java.io.Serializable;
import java.util.function.Supplier;

public class SingletonExample {

    // enum singleton is the best approach: no issues with multithreading, no issues with serialization or reflection creation
    // can not be used if needs to extend other class than Enum
    public enum EnumSingleton {
        ONE(1), TWO(2); // how many instances of the class you need

        private int value;

        // public and protected modifiers are not allowed for the enum
        EnumSingleton(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static class UtilityClass {
        // enforcing noninstantiability of the class via introducing private constructor,
        // otherwise default public constructor will be included by compiler
        // non instantiable class is also called utility class
        // assertion error can be used for safety
        private UtilityClass() {
            throw new AssertionError("UtilityClass should not be initialised. It is Utility class");
        }
    }

    public static class ClassSingleton implements Serializable, Supplier<ClassSingleton> {

        // public field approach
        public static ClassSingleton INSTANCE;

        // enforcing noninstantiability.
        // can not be subclassed cause private constructor can not be invoked from subclass
        private ClassSingleton() {}


        // mechanism against deserialization
        private Object readResolve(){
            return INSTANCE;
        }

        // generic singleton factory with implementing supplier
        // factory method mechanism with possibility to be used as Supplier via method references
        public ClassSingleton get(){
            return INSTANCE;
        }

    }
}
