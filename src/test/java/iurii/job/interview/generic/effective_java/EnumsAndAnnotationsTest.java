package iurii.job.interview.generic.effective_java;

import org.junit.Test;

import java.util.EnumMap;
import java.util.EnumSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *  enums prove to be great abstraction for Singleton pattern {@link SingletonExampleTest}
 */
public class EnumsAndAnnotationsTest {

    // enum type is great to replace constants. having a scope and type provides type safety and compiler support
    // provides better support if constant value is changed. clients of api do not need to be recompiled (only if name changes)
    // [if ONE TWO names changed clients need to be recompiled. If 1 or 2 values are changed nothing is needed]
    // easy to extend and add additional enum values. easy to delete value
    // (only the clients that used deleted value should be recompiled and fixed)
    // limitation is that enum extends abstract class Enum and implements Comparable and Serializable under the hood,
    // in case it is needed to extend other class (and not an interface) - it is not possible to use enum
    // different behaviour can be associated as well (abstract method)
    // [needs to be implemented in each instance] - constant-specific class body
    // such methods are known as constant-specific method implementations.
    // static is obsolete in the inner enum declaration - they are static.
    // enums should be immutable it is their nature! instance fields should not be changed
    public enum EnumSingleton {
        ONE(1) {
            // enums are good to encapsulate strategy (strategy enum). More flexible instead of switch statements
            @Override
            public int getStrategyValue() {
                return getValue();
            }
        },

        TWO(2) {
            @Override
            public int getStrategyValue() {
                return getValue();
            }
        };
        // how many instances of the class you need

        // encapsulation, so that fields can not be accessed;
        // has non null invariant (property, truth that is maintained )
        private final int value;

        // public and protected modifiers are not allowed for the enum
        EnumSingleton(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public abstract int getStrategyValue();
    }

    @Test(expected = IllegalArgumentException.class)
    public void test() {
        // no issues to get enum constant by name
        EnumSingleton one = EnumSingleton.valueOf("ONE");
        assertThat(one.getValue()).isEqualTo(1);

        // ordinal starts from zero like array indexes, but it is better not to rely on order (it might change)
        assertThat(EnumSingleton.ONE.ordinal()).isEqualTo(0);

        // IllegalArgumentException is thrown
        EnumSingleton.valueOf("NOT EXISTING");
    }

    // enumSet and EnumMap store keys in the array optimised based on enum instead of hashcode
    // annotation @Test prefer instead of naming patterns for the methods. it is more safe
    // also called marker annotation (no parameters, simply marks)
    // also called meta annotations and can retains at runtime if retention policy is runtime
    // can be processed by annotation processors
    // use marker interfaces to define a type. Arguably Serializable is a type marker interface
    // that indicates that instance is eligible to be processed by ObjectOutputStream
    // Set is restricted marker interface case adds nothing just what collection has
    @Test
    public void testEnumSetMap() {
        EnumSet<EnumSingleton> enumSet = EnumSet.allOf(EnumSingleton.class);
        EnumMap<EnumSingleton, String> enumMap = new EnumMap<>(EnumSingleton.class);
    }
}
