package iurii.job.interview.generic.java8;

/**
 * Functional interfaces, lambda, static and default methods in the interfaces
 */

@FunctionalInterface
public interface DefaultAndStaticInInterface {

    int method1(int i);

    default int increment(int i){
        return i + 1;
    }

    static int inc(int i){
        return i + 1;
    }

    //trying to override Object method gives compile time error as
    //"A default method cannot override a method from java.lang.Object"

    //	default String toString(){
    //		return "i1";
    //	}

}