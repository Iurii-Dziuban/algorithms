package iurii.job.interview.generic.java8;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultAndStaticInInterfaceTest {

    @Test
    public void testStatic() {
        assertThat(DefaultAndStaticInInterface.inc(4)).isEqualTo(5);
    }

    @Test
    public void testDefault() {
        assertThat(((DefaultAndStaticInInterface) i -> i++).increment(4)).isEqualTo(5);
    }

    @Test
    public void testFunctionalInterface() {
        assertThat(method1(i-> ++i, 4)).isEqualTo(5);
    }

    private static int method1(DefaultAndStaticInInterface d, int i) {
        return d.method1(i);
    }
}
