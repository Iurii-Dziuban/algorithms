package iurii.job.interview.recursion;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

public class CountTest {

    @Test
    public void testCountEmpty() {
        Count count = new Count();
        assertThat(count.count(new LinkedList<>())).isEqualTo(0);
        assertThat(count.count(null)).isEqualTo(0);
    }

    @Test
    public void testCountTailRecEmpty() {
        Count count = new Count();
        assertThat(count.countTailRec(new LinkedList<>())).isEqualTo(0);
        assertThat(count.countTailRec(null)).isEqualTo(0);
    }

    @Test
    public void testCountStreamFoldLeftEmpty() {
        Count count = new Count();
        assertThat(count.countFoldLeft(new LinkedList<>())).isEqualTo(0);
        assertThat(count.countFoldLeft(null)).isEqualTo(0);
    }

    @Test
    public void testCountStreamEmpty() {
        Count count = new Count();
        assertThat(count.countStream(new LinkedList<>())).isEqualTo(0);
        assertThat(count.countStream(null)).isEqualTo(0);
    }

    @Test
    public void testCountNormal() {
        Count count = new Count();
        assertThat(count.count(new LinkedList<>(Collections.singletonList(1)))).isEqualTo(1);
        assertThat(count.count(new LinkedList<>(Arrays.asList(1,2,3,4)))).isEqualTo(4);
    }

    @Test
    public void testCountTailRecNormal() {
        Count count = new Count();
        assertThat(count.countTailRec(new LinkedList<>(Collections.singletonList(1)))).isEqualTo(1);
        assertThat(count.countTailRec(new LinkedList<>(Arrays.asList(1,2,3,4)))).isEqualTo(4);
    }

    @Test
    public void testCountStreamFoldLeftNormal() {
        Count count = new Count();
        assertThat(count.countFoldLeft(new LinkedList<>(Collections.singletonList(1)))).isEqualTo(1);
        assertThat(count.countFoldLeft(new LinkedList<>(Arrays.asList(1,2,3,4)))).isEqualTo(4);
    }

    @Test
    public void testCountStreamNormal() {
        Count count = new Count();
        assertThat(count.countStream(new LinkedList<>(Collections.singletonList(1)))).isEqualTo(1);
        assertThat(count.countStream(new LinkedList<>(Arrays.asList(1,2,3,4)))).isEqualTo(4);
    }
}
