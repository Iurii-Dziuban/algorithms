package iurii.job.interview.generic.effective_java;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

public class CompareExampleTest {

    // recursive type bound
    // make two instances mutually comparable
    // express instance of Address should be comparable only to itself
    public static class Address implements Comparable<Address> {
        private final String address;

        public Address(String address) {
            this.address = address;
        }

        @Override
        public int compareTo(Address o) {
            return address.compareTo(o.address);
        }
    }

    // recursive type bound
    // make two instances mutually comparable
    // express instance of Address should be comparable only to itself
    public static <E extends Comparable<E>> E max(List<E> list) {
        return list.stream().max(E::compareTo).get();
    }
}
