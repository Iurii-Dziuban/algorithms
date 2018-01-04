package iurii.job.interview.recursion;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxTest {

    @Test(expected = NoSuchElementException.class)
    public void testMaxEmpty() {
        Max max = new Max();
        max.max(new LinkedList<>());
    }

    @Test(expected = NoSuchElementException.class)
    public void testMaxNull() {
        Max max = new Max();
        max.max(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testMaxTailRecEmpty() {
        Max max = new Max();
        max.maxTailRec(new LinkedList<>());
    }

    @Test(expected = NoSuchElementException.class)
    public void testMaxTailRecNull() {
        Max max = new Max();
        max.maxTailRec(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testMaxStreamFoldLeftEmpty() {
        Max max = new Max();
        max.maxFoldLeft(new LinkedList<>());
    }

    @Test(expected = NoSuchElementException.class)
    public void testMaxStreamFoldLeftNull() {
        Max max = new Max();
        max.maxFoldLeft(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testMaxStreamEmpty() {
        Max max = new Max();
        max.maxStream(new LinkedList<>());
    }

    @Test(expected = NoSuchElementException.class)
    public void testMaxStreamNull() {
        Max max = new Max();
        max.maxStream(null);
    }

    @Test
    public void testMaxNormal() {
        Max max = new Max();
        assertThat(max.max(new LinkedList<>(Collections.singletonList(1)))).isEqualTo(1);
        assertThat(max.max(new LinkedList<>(Arrays.asList(1,2,3,4)))).isEqualTo(4);
    }

    @Test
    public void testMaxTailRecNormal() {
        Max max = new Max();
        assertThat(max.maxTailRec(new LinkedList<>(Collections.singletonList(1)))).isEqualTo(1);
        assertThat(max.maxTailRec(new LinkedList<>(Arrays.asList(1,2,3,4)))).isEqualTo(4);
    }

    @Test
    public void testMaxStreamFoldLeftNormal() {
        Max max = new Max();
        assertThat(max.maxFoldLeft(new LinkedList<>(Collections.singletonList(1)))).isEqualTo(1);
        assertThat(max.maxFoldLeft(new LinkedList<>(Arrays.asList(1,2,3,4)))).isEqualTo(4);
    }

    @Test
    public void testMaxStreamNormal() {
        Max max = new Max();
        assertThat(max.maxStream(new LinkedList<>(Collections.singletonList(1)))).isEqualTo(1);
        assertThat(max.maxStream(new LinkedList<>(Arrays.asList(1,2,3,4)))).isEqualTo(4);
    }
}
