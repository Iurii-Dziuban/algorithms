package iurii.job.interview.generic.effective_java;

import java.util.Comparator;

/**
 * Better to have static members. Not to have reference to the parent object implicitly
 * Better to use one top class per file - not to have clashes
 */
public class InnerClassesExampleTest {

    // private/protected/package default/ public
    // static and final are possible
    private int topPrivateValue;

    // by default inner interface is static
    // final is not possible
    private interface Interface {
        // static works here for methods and variables
        int a = 5;

        // default can not be static
        default int getValue() {
            return 1;
        }

        // static with different name than default with public. private static support added in Java 9
        static int getV() {
            return 1;
        }
    }

    public class InnerClass {

        // static does not work for methods and variables

        private InnerClass() {
            // get enclosing class field
            int local = topPrivateValue;
            // another way to get enclosing class field
            local = InnerClassesExampleTest.this.topPrivateValue;
        }
    }

    // method
    private void method() {
        // local inner class example
        int k = 1;
        // static is not allowed
        class LocalInnerClass {
            // static does not work for methods and variables
            LocalInnerClass() {
                // can easily use field variables from the class instance
                topPrivateValue = 5;
                // to use local variable - it should be effectively final
                // (with "final" or not changed in the method)
                int i = k;
            }
        }

        // anonymous class (also can be extracted as a lambda expression)
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // can easily use field variables from the class instance
                int t = topPrivateValue;
                // to use local variable - it should be effectively final
                // (with "final" or not changed in the method)
                return k;
            }
        }; // because it is expression ";" is necessary
    }
}