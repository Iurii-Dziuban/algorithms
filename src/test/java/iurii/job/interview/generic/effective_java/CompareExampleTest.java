package iurii.job.interview.generic.effective_java;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CompareExampleTest {

    // recursive type bound to make two instances mutually comparable
    // [express instance of Address should be comparable only to itself]
    // Comparable is from java.lang package and assumes object has a natural ordering
    // Class should implement it, rather than use as a functional interface.
    // Comparable also can be named as mixin interface, cause provides additional functionality to the main one
    // Comparable and Comparator are Consumers (type parameter extends)
    public static class Address implements Comparable<Address> {

        // encapsulation
        private final String address;
        private final int id;

        public Address(String address, int id) {
            this.address = address;
            this.id = id;
        }

        // is the test for order instead of equality like equals. However it is better to comment
        // if equality by equals is different from equality provided by compareTo
        // consistent or inconsistent with equals
        @Override
        public int compareTo(Address o) {
            // String already has compareTo natural ordering function
            return address.compareTo(o.address);
        }

        // accessor methods
        public String getAddress() {
            return address;
        }

        public int getId() {
            return id;
        }

        // setters are known as mutator methods
        // to be immutable :
        // 1) Do not provide methods to modify state
        // 2) Ensure that class can not be extended. either private constructor or final to class
        // 3) make all  fields final - not to change inside the class. enforce by memory model
        // 4) make all fields private - no access to references to mutable objects
        // 5) ensure exclusive access to any mutable components. do defensive copies.
    }

    // recursive type bound
    // make two instances mutually comparable
    // express instance of Address should be comparable only to itself
    public static <E extends Comparable<E>> Optional<E> max(List<E> list) {
        // to compare primitive types use:
        Short.compare((short)1,(short)1);
        Float.compare((short)1,(short)1);
        Integer.compare((short)1,(short)1);
        Long.compare((short)1,(short)1);
        Double.compare((short)1,(short)1);
        // using Comparator API. could be a bit slower but provides ready API.
        // Returns comparator nulls first/last and order of comparing
        // in case first comparison is equal. reversing or natural order
        // comparator construction methods are used
        Comparator.nullsLast(Comparator.comparing(Address::getAddress).thenComparingInt(Address::getId)).reversed();
        // using compareTo if E extends Comparable
        return list.stream().max(E::compareTo);
    }
}
