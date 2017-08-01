package iurii.job.interview.cracking;

/**
 * Only stub. It contains only C++ questions;
 */
public interface CrackingCodingInterview13 {
    /**
     * 13.1 Write method to write only 10 last Strings from file. 
     * Answer:
     * Use 10 Strings buffer and always replace the oldest one. Something like circular array.
     *
     * 13.2 Difference between hashtable and treemap?
     * Answer:
     * Second is sorted by values. Values should be comparable. keys should implement hash and equals.
     * Treemap is efficient for retrieving min, max, and print elements in sorted order
     *
     * 13.3 Virtual functions?
     * Answer:
     * Like abstract functions in java. Used for inheritance. 
     * Binding is done dynamically by class name.
     * In java classes with abstract methods can not be instantiated.
     *
     * 13.4 What is the difference between deep copy and shallow copy
     * Answer:
     * In shallow you just have additional reference to object. 
     * In deepCopy you have another object that has values equal to values in first object.
     * Working with shallow copy can lead to side effects if you changing some values by one reference,
     * when the changes will be seen by another reference as you are working with same data.
     *
     * 13.5 What is a volatile keyword?
     * Volatile is an instruction for compiler not to cache (optimize) 
     * the value as it can be used by many threads.
     * So in code like public static int i = 0; while (i == 0) - infinite loop if value is changed outside.
     * With volatile it will be terminated when value is changed.
     *
     * 13.6 What is name hiding?
     * We can have local and global variables - local - in block or method 
     * and global - variables of class or object.
     * By using the same name as in global by local we hide global 
     * the only way to get it is to use 'this.<variable>' keyword for object variable or
     * 'ClassName.<variable>' for class variable
     *
     * 13.7 Why destructor in base class should be virtual?
     * Non virtual can lead to memory leaks as destructor of particular class will not be executed
     * Only Base class destructor will be executed.
     *
     * 13.8 Deep copy 
     * 13.9 smart pointer
     */
}
