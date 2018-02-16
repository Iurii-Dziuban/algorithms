package iurii.job.interview.generic.effective_java;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Interface inheritance (contract inheritance) is ok.
 * Class inheritance (implementation inheritance) is worse. Favor composition.
 */
public class CompositionInheritanceTest {

    // reusable forwarding class
    static class ForwardingSet<E> implements Set<E> {

        // using backed instance (composition instead of class inheritance) and implementing interface - more flexibility,
        // without ruining clients
        // Pattern called decorator or Wrapper
        private final Set<E> set;

        // provides loosely coupled delegation
        ForwardingSet(Set<E> set) {
            this.set = set;
        }

        // providing skeleton abstract class (well documented!)
        // that is good to start in many cases is a good thing. (Template method)
        // But in many cases it is better to implement interface than inherit abstract class

        // one of disadvantages is that it can not be used in callback frameworks cause wrapped object does not know
        // who wraps it and can not provide self reference to this.

        // using inheritance - should be documented, cause changes in parent can break children or vice versa
        // doing changes or overriding methods. instantiations can break cause order is parent then child

        // default methods in the interfaces provide methods for all who inherit them.
        // Even though its implementation might be wrong.. in this case overriding is needed
        @Override
        public int size() {
            // forwarding is a bit tedious
            return set.size();
        }

        @Override
        public boolean isEmpty() {
            return set.isEmpty();
        }

        @Override
        public boolean contains(Object o) {
            return set.contains(o);
        }

        @Override
        public Iterator<E> iterator() {
            return set.iterator();
        }

        @Override
        public Object[] toArray() {
            return set.toArray();
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return set.toArray(a);
        }

        @Override
        public boolean add(E e) {
            return set.add(e);
        }

        @Override
        public boolean remove(Object o) {
            return set.remove(o);
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return set.containsAll(c);
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            return set.addAll(c);
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return set.retainAll(c);
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return set.retainAll(c);
        }

        @Override
        public void clear() {
            set.clear();
        }
    }
}
