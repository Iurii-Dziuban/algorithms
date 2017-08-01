package iurii.job.interview.cracking;

/**
 * Java.
 */
public interface CrackingCodingInterview14 {

    /**
     * 14.1 in terms of inheritance what is the result of making constructor private ?
     * Answer: 
     * You can not create an object of this class by yourself outside of the class. 
     * The only way to use is in static method (Factory Method pattern). 
     * In terms of inheritance it means that class can not be inherited
     *
     * 14.2 In Java, does the finally block gets executed if we insert a return statement inside the 
     * try block of a try-catch-finally?
     * Answer:
     * Yes. Exactly after return statement if normal execution and jvm do not crash or the thread is killed.
     *
     * 14.3 What is the difference between final-finally-finalize
     * Answer:
     * Final keyword is used with class (means class can not be inherited), 
     * with method (method can not be overridden), 
     * with variable (means the value (or reference) can not be changed)
     *
     * Finally is keyword used in try-catch-finally or try-finally blocks for exception handling.
     * The block in finally always executed after try block or after catch block 
     * or after exception occurs in try-finally block
     *
     * Finalize is a method of object that may be or not be executed before garbage collection.
     *
     * 14.4 Difference between templates in C++ and generics?
     * Answer:
     * In C++ classes and functions can be templated. In java classes and methods
     * In C++ Parameters can be any values. In java only reference values.
     * In C++ each version of class for parameters is generated. In java only one.
     * In C++ for each parameter different implementations are possible. In java one implementation
     * In C++ wildCards not supported. In java supported.
     * In C++ static variables are not shared. In java shared. 
     *
     * 14.5 Explain what object reflection is in java and when used ?
     * Answer:
     * Each class has a full name with package path. You can instantiate a class by name.
     * Execute a method by name. Set/get parameter of class by its name.
     * But this can lead to untrackable problems.
     *
     * Useful for debugging and manipulation of behavior.
     *
     * 14.6 Suppose you are using a map in your program, how would you count the number of 
     * times the program calls the put() and get() functions?
     * Answer:
     * The best way is to extend Map and provide increment in put and get functions to count order.
     * In this case count will be made for particular object of this class.
     * If count is needed for all objects of class use static variables (class variables) 
     * instead of variables of class object
     */

}
