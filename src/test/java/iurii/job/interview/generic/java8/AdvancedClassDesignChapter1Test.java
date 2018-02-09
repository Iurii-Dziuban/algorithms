package iurii.job.interview.generic.java8;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.function.IntToLongFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class AdvancedClassDesignChapter1Test {

    // Java 8 certification Question 2.
    /* private static abstract class Message {
        public abstract final void sendMessage(); // ! abstract final class/method not possible
    }*/

    // --- End of Question 2.

    // Java 8 certification Question 3.
    public static class Tail3 {
    }

    public static class Bird implements Serializable {
        private String name;
        private transient int age;
        private Tail3 tail;

        public String getName() {
            return name;
        }

        public Tail3 getTail() {
            return tail;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setTail(Tail3 tail) {
            this.tail = tail;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    @Test(expected = FileNotFoundException.class)
    public void testSerialization() throws IOException, ClassNotFoundException { // ! throws is important IOException super of FileNotFoundException
        try (ObjectInputStream is = new ObjectInputStream( //! just InputStream does not have readObject method
                new BufferedInputStream(new FileInputStream("birds.dat")))) {
            Bird bird = (Bird) is.readObject();
            //! readObject method throws ClassNotFoundException and IOException
            //! Will throw java.io.NotSerializableException because Tail3 is not serializable at runtime
        }
    }

    // --- End of Question 3.

    // Java 8 certification Question 4.
    public static class Box<T> {
        T value;

        Box(T value) {
            this.value = value;
        }

        T getValue() {
            return value;
        }
    }

    @Test
    public void testGenerics() {
        Box<String> one = new Box<String>("a string");
        Box<Integer> two = new Box<>(123);
        assertThat(one.getValue()).isEqualToIgnoringCase("a string");
        assertThat(two.getValue()).isEqualTo(123);
        // correct code for generics with/without diamond operator
    }

    // --- End of Question 4.

    // Java 8 certification Question 5.
    @Test(expected = ConcurrentModificationException.class)
    public void testConcurrentLists() {
        List<Integer> source = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> fish = new CopyOnWriteArrayList<>(source);
        List<Integer> mammals = Collections.synchronizedList(source);
        Set<Integer> birds = new ConcurrentSkipListSet<>();
        birds.addAll(source);
        synchronized (new Integer(10)) {
            for (Integer f : fish) fish.add(4); // c1
            for (Integer m : mammals) mammals.add(4); // c2
            for (Integer b : birds) birds.add(5); // c3
            assertThat(fish.size()).isEqualTo(8);
            assertThat(mammals.size()).isEqualTo(4);
            assertThat(birds.size()).isEqualTo(5);
        }

        // Not if c2 removed code will run without exceptions
    }

    // --- End of Question 5.

    // Java 8 certification Question 6.
    // What changes would need to be made to make the following immutable object pattern correct?
    // no changes?
    public static class Duck { // make final?  // implement Immutable interface?
        private String name;
        private List<Duck> ducklings; // make final?

        public Duck(String name, List<Duck> ducklings) {
            this.name = name;
            this.ducklings = new ArrayList<Duck>(ducklings);
        }

        public String getName() {
            return name;
        }

        public List<Duck> getDucklings() {
            return ducklings;
        } // do not give direct access to list?

        // change return type to List<Object>
        public String hasDucklings(Predicate<Duck> p) { // remove this method?
            return p.test(this) ? "Quack Quack" : "";
        }

        // Answer : 1) Make class final, so no one will extend it
        // 2) make ducklings final, it is important for the immutable pattern, so fields "private final"
        // 3) do not give direct access to List<Duck>
    }
    // --- End of Question 6.

    // Java 8 certification Question 7.
    @Test(expected = NoSuchFileException.class)
    public void test() throws IOException {
        // current dir is /bats/day
        Path path1 = Paths.get("/bats/night", "../").resolve(Paths.get("./sleep.txt")).normalize();
        // it will resolve to /bats/sleep.txt
        Path path2 = new File("../sleep.txt").toPath().toRealPath();
        // /bats/sleep.txt
        assertThat(Files.isSameFile(path1, path2)).isTrue();
        assertThat(path1.equals(path2)).isTrue();
        // SO that it is the same file it will return true / true
    }
    // --- End of Question 7.

    // Java 8 certification Question 8.
    public static class Tail {
    }

    public static class Animal {
        public String name;
    }

    public static class Canine extends Animal {
        public Tail tail;
    }

    public static class Wolf extends Canine {
    }

    /**
     * A. Wolf has-a name.
     * B. Wolf has-a Tail.
     * C. Wolf is-a Tail.
     * D. Wolf is-a Animal.
     * E. Canine is-a Wolf.
     * F. Animal has-a Tail
     */

    // Answers: A, B, D

    // --- End of Question 8.

    // Java 8 certification Question 9.
    // what is possible instead of i!
    public void stmt(Connection conn, int a) throws SQLException {
        int i = 0;
        Statement stmt = conn.createStatement(a, i);
    }
    /*
    A. ResultSet.CONCUR_READ_ONLY
    B. ResultSet.CONCUR_INSERTABLE
    C. ResultSet.CONCUR_UPDATABLE
    D. ResultSet.TYPE_FORWARD_ONLY
    E. ResultSet.TYPE_SCROLL_INSENSITIVE
    F. ResultSet.TYPE_SCROLL_SENSITIVE
    */

    // Answers: A, C . B not exists and D,E,F represent first parameter

    // --- End of Question 9.

    // Java 8 certification Question 10.
    @Test(expected = AssertionError.class)
    public void test10() {
        Integer x = 10;
        x++; // 4
        assert x == null && x >= 0; // 5
        System.out.println(x); // 6
    }

    /**
     * A. Line 3 generates a compiler error.
     * B. Line 4 generates a compiler error.
     * C. Line 5 generates a compiler error.
     * D. Line 5 throws an AssertionError at runtime.
     * E. The output is 10.
     * F. The output is 11.
     */

    // Answer: Assertion error at runtime
    // --- End of Question 10.

    // Java 8 certification Question 11.
    private static void magic(Stream<Integer> s) {
        Optional o = s.filter(x -> x < 5).limit(3).max((x, y) -> x - y);
        System.out.println(o.get());
    }
    /**
     * A. magic(Stream.empty()); runs infinitely.
     B. magic(Stream.empty()); throws an exception.
     C. magic(Stream.iterate(1, x -> x++)); runs infinitely.
     D. magic(Stream.iterate(1, x -> x++)); throws an exception.
     E. magic(Stream.of(5, 10)); runs infinitely.
     F. magic(Stream.of(5, 10)); throws an exception.
     G. The method does not compile
     */
    // Answer: B, F are correct because o.get() on empty will throw the NoSuchElementException

    // --- End of Question 11.

    // Java 8 certification Question 12.

    /**
     * Suppose that we have the following property files and code. Which bundle is used on lines
     * 7 and 8, respectively?
     * <p>
     * Dolphins.properties
     * <p>
     * name=The Dolphin
     * age=0
     * <p>
     * Dolphins_fr.properties
     * <p>
     * name=Dolly
     * <p>
     * Dolphins_fr_CA.properties
     * <p>
     * name=Dolly
     * age=4
     * 5: Locale fr = new Locale("fr");
     * 6: ResourceBundle b = ResourceBundle.getBundle("Dolphins", fr);
     * 7: b.getString("name");
     * 8: b.getString("age");
     * <p>
     * A. Dolphins.properties and Dolphins.properties
     * B. Dolphins.properties and Dolphins_fr.properties
     * C. Dolphins_fr.properties and Dolphins_fr.properties
     * D. Dolphins_fr.properties and Dolphins.properties
     * E. Dolphins_fr.properties and Dolphins_fr_CA.properties
     * F. Dolphins_fr_CA.properties and Dolphins_fr.properties
     * <p>
     * D is correct.  File Dolphins_fr.properties exact match and has name, and age is not found,
     * go higher in the hierarchy to Dolphins.properties
     */
    // --- End of Question 12.

    // Java 8 certification Question 13.
    @Test(expected = NullPointerException.class)
    public void testConsole() {
        String line;
        Console c = System.console();
        if ((line = c.readLine()) != null) {
            // ! does not throw IOException. NullPointerException may be throw if console is not available
            // if console exists - prints what User enters
            System.out.println(line);
        }
    }

    /**
     * A. The code runs without error but prints nothing.
     * B. The code prints what was entered by the user.
     * C. An ArrayIndexOutOfBoundsException might be thrown.
     * D. A NullPointerException might be thrown.
     * E. An IOException might be thrown.
     * F. The code does not compile
     * <p>
     * Answer: B, D are correct
     */

    // --- End of Question 13.

    // Java 8 certification Question 14.

    /*public class Compiles {
        class RainException extends Exception {}

        public static void main(String[] args) {
            try(Scanner s = new Scanner("rain"); String line = "";) { //line does not implement AutoClosable!

                if (s.nextLine().equals("rain"))
                    throw new RainException();  // RainException can not be referenced from static context
                } finally {
                    s.close();  // s is not visible here
                } } }*/
    // How many compilation issues:
    // Answer: 3
    // --- End of Question 14.

    // Java 8 certification Question 15.
    public static class VisitPark {
        enum AnimalsInPark { // 2
            SQUIRREL, CHIPMUNK, SPARROW;
        }

        @Test
        public void test() {
            AnimalsInPark[] animals = AnimalsInPark.values(); // 6
            System.out.println(animals[1]); // 7
        }
    }
    /**
     A. CHIPMUNK
     B. SQUIRREL
     C. The code compiles, but the output is indeterminate.
     D. A compiler error occurs on line 2.
     E. A compiler error occurs on line 6.
     F. A compiler error occurs on line 7.
     */
    // Answer: A . Enum can be inner class and values are 0-based in the order they are defined
    // --- End of Question 15.

    // Java 8 certification Question 16.
    @Test
    public void testDurationAndPeriod() {
        String d = Duration.ofDays(1).toString();
        String p = Period.ofDays(1).toString();
        assertThat(d == p).isFalse();
        assertThat(d.equals(p)).isFalse();
        assertThat(d).isEqualTo("PT24H");
        assertThat(p).isEqualTo("P1D");
    }
    // --- End of Question 16.

    // Java 8 certification Question 17.


    /**
     A. The code compiles but does not produce any output at runtime.
     B. It does not compile because of line k1.
     C. It does not compile because of line k2.
     D. It does not compile because of line k3.
     E. It does not compile because of line k4.
     F. The code prints all of the .txt files in the directory tree.
     G. The code prints all of the words in the signed-words.txt file, each on a different line

     Answer: B,C,E .
     - the second parameter to Files.find() is the depth limit and must be an int
     - Files.find() method uses a BiPredictate<Path,BasicFileAttribute>, not a Predicate<Path>
     - Files.readAllLines() returns a List<String>, not a stream
     */

    /*public void testPathsIncorrect() {
        Path path = Paths.get("/gorilla/signed-words.txt");
        Files.find(path.getParent(),10.0, // k1
                (Path p) -> p.toString().endsWith(".txt") && Files.isDirectory(p)) // k2
                .collect(Collectors.toList())
                .forEach(System.out::println);
        Files.readAllLines(path) // k3
                .flatMap(p -> Stream.of(p.split(" "))) // k4
                .map(s -> s.toLowerCase()) // k5
                .forEach(System.out::println);
    }*/

    @Test(expected = IOException.class)
    public void testPathsCorrect() throws IOException {
        Path path = Paths.get("/gorilla/signed-words.txt");
        Files.find(path.getParent(),10,
                (Path p, BasicFileAttributes basicFileAttributes)
                        -> p.toString().endsWith(".txt") && Files.isDirectory(p))
                .collect(Collectors.toList())
                .forEach(System.out::println);
        Files.readAllLines(path).stream()
                .flatMap(p -> Stream.of(p.split(" ")))
                .map(s -> s.toLowerCase())
                .forEach(System.out::println);


    }
    // --- End of Question 17.

    // Java 8 certification Question 18.

    /**
     * Which of the following statements can fill in the blank to make the code compile successfully? (Choose all that apply.)

     Set[? extends RuntimeException] set = VALUE

     A. new HashSet[? extends RuntimeException]();
     B. new HashSet<Exception>();
     C. new TreeSet<RuntimeException>();
     D. new TreeSet<NullPointerException>();
     E. None of the above

     Answer: C,D . A is not possible on the right side of expression.
     B is not possible, cause Exception is higher in hierarchy
     */

    // --- End of Question 18.

    // Java 8 certification Question 19.

    /**
     * Which of the following position a ResultSet cursor to a location immediately before the
     first row? (Choose all that apply.)
     A. rs.absolute(-1)
     B. rs.absolute(0)
     C. rs.absolute(1)
     D. rs.beforeFirst()
     E. rs.first()
     F. rs.next()

     Answer: B, D. On scrollable ResultSet absolute -1 -> end row, 0 -> before first row, 1 -> the first row
     beforeFirst() is equivalent method
     */
    // --- End of Question 19.

    // Java 8 certification Question 20.

    /**
     * Assume that today is June 1, 2016. What is the result of the following?
     */
    @Test
    public void testDatePlusStream() {
        LocalDate localDate = LocalDate.of(2016, 6, 1);
        Stream<LocalDate> s = Stream.of(localDate);
        UnaryOperator<LocalDate> u = l -> l;
        s.filter(l -> l != null).map(u).peek(System.out::println);


        assertThat(Stream.of(localDate).filter(l -> l != null)
                .map(u).collect(Collectors.toList()).get(0)).isEqualTo(localDate);
    }
     /**
     A. 2016–05–01
     B. 2016–06–01
     C. There is no output.
     D. The output is something other than 2016–05–01 or 2016–06–01.
     E. The code does not compile.
     F. An exception is thrown.

      Answer C. No terminal operation. if was terminal operation B is the answer
     */

    // --- End of Question 20.s
}

/**
 * Functional interfaces, lambda, static and default methods in the interfaces
 */
// having one method in the interface (and even additionally marking with @FunctionalInterface)
// gives the ability to use lambda expressions as an implementation
// in the place, where instance of functional interface is needed. so lambda can be used instead of
// instance of anonymous class
// lambdas provide notion of deferred executions. Invoke only when needed
@FunctionalInterface // make sure that there will be only one method/lambda
interface DefaultAndStaticInInterface {

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
