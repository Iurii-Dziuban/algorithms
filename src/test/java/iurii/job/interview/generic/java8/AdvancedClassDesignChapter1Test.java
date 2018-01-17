package iurii.job.interview.generic.java8;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.Console;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.assertThat;

public class AdvancedClassDesignChapter1Test {

    /* private static abstract class Message {
        public abstract final void sendMessage(); // ! abstract final class/method not possible
    }*/

    public static class Tail {
    }

    public static class Bird implements Serializable {
        private String name;
        private transient int age;
        private Tail tail;

        public String getName() {
            return name;
        }

        public Tail getTail() {
            return tail;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setTail(Tail tail) {
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
            //! Will throw java.io.NotSerializableException because Tail is not serializable at runtime
        }
    }

    @Test(expected = NullPointerException.class)
    public void testConsole() {
        String line;
        Console c = System.console();
        if ((line = c.readLine()) != null) { // ! does not throw IOException. NullPointerException may be thrown
            // if console is not available
            System.out.println(line);
        } // if console exists - prints what User enters
    }

    public static class Box<T> {
        T value;

        public Box(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }

    @Test
    public void testGenerics() {
        Box<String> one = new Box<String>("a string");
        Box<Integer> two = new Box<>(123);
        assertThat(one.getValue()).isEqualToIgnoringCase("a string");
        assertThat(two.getValue()).isEqualTo(123); // correct code for generics with/without diamond operator
    }

}
