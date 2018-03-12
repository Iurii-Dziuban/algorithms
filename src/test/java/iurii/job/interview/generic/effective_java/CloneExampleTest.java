package iurii.job.interview.generic.effective_java;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CloneExampleTest {
    // cloneable is extralinguistic and hides creating of objects without calling constructor
    // better approaches conversion/copy constructors and conversion/copy factories are better
    public static class Phone implements Cloneable {

        private final String number;

        // copy constructor. Functional approach to apply function to create new instance without changing params
        public Phone(Phone phone) {
            // do defensive copies if the object is not immutable before checking the validity of parameters
            // because of window of vulnerability between parameters checked and copied - time-of-check/time-of-use
            this.number = String.valueOf(phone.number);
        }

        public Phone(String number) {
            this.number = number;
        }

        // if support cloneable - make visibility public instead of protected to indicate it.
        // (visibility in the hierarchy can be changed to broader, but exceptions only to narrower!)
        // do the cast inside and provide covariant return type of the exact instance (here Phone)
        // if class implements Cloneable no exception will be thrown
        // does not provide synchronized, so not thread safe. synchronization should be done explicitly if needed
        @Override
        public Phone clone() {
            try {
                // imperative approach instead of functional copy constructor
                // Note: no deep copy by default!
                Phone clone = (Phone) super.clone();
                // fix clone before returning it
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError("");
            }
        }

        public String getNumber() {
            return number;
        }
    }

    public static class NotCloneable {

        // not public and throws exception. No children can change the method via inheritance
        // Also this interface does not implement Cloneable, so throwing the exception is default behaviour
        @Override
        protected final NotCloneable clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    @Test
    public void cloneTest() {
        Phone phone = new Phone("hello");
        Phone clone = phone.clone();
        assertThat(phone).isNotEqualTo(clone);
        assertThat(phone.getNumber()).isEqualTo(clone.getNumber());
    }
}
