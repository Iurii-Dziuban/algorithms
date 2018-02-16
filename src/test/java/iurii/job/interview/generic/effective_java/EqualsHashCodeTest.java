package iurii.job.interview.generic.effective_java;

import java.util.Objects;

public class EqualsHashCodeTest {
    // reflexive x.equals(x) true
    // symmetric x.equals(y) == y.equals(x)
    // transitive x.equals(y) and y.equals(z) -> x.equals(z)
    // consistent many calls to the method will give same result
    // non null reference x.equals(null) false
    // provides equivalence class notion, that an instance of class can be interchanged with over equal instance
    @Override
    public boolean equals(Object obj) {
        // sometimes can be useful to save canonical form and compare using it
        // do not compare derived fields
        Objects.equals(1,2);
        Objects.deepEquals(1,2);
        return super.equals(obj);
    }
    // in inheritance class hierarchies there is no good way of implementing equals to cover both.
    // Liskov substitution principle will be violated (child can not replace parent in HashSet)
    // but it can be changed to view parent class through the view or adapter pattern
    private static class Point {
        int x;
        int y;
    }

    private static class ColoredPoint {
        // aggregation instead of inheritance
        Point point; // calling point method - delegation
        String color;

        // view / adapter
        Point asPoint() {
            return point;
        }
    }


    private int hashcode;
    // always override hashcode if override equals
    // - consistent - same value after multiple calls (can be cashed). Do not rely on untrusted resources
    // - if x.equal(y) x.hashCode=y.hashCode
    // - if !x.equal(y) hash codes can be equal or different
    @Override
    public int hashCode() {
        if (hashcode == 0) { // lazy initialization 0 should not be one of existing hash codes for this object
            hashcode = 1;
            Short.hashCode((short) 1);
            Integer.hashCode(1);
            Objects.hash(1, 2, 3);
        }
        return super.hashCode();
    }
}
