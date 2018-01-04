package iurii.job.interview.recursion;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

public class SumTest {

    @Test
    public void testSumEmpty() {
        Sum sum = new Sum();
        assertThat(sum.sum(new LinkedList<>())).isEqualTo(0);
        assertThat(sum.sum(null)).isEqualTo(0);
    }

    @Test
    public void testSumTailRecEmpty() {
        Sum sum = new Sum();
        assertThat(sum.sumTailRec(new LinkedList<>())).isEqualTo(0);
        assertThat(sum.sumTailRec(null)).isEqualTo(0);
    }

    @Test
    public void testSumStreamFoldLeftEmpty() {
        Sum sum = new Sum();
        assertThat(sum.sumFoldLeft(new LinkedList<>())).isEqualTo(0);
        assertThat(sum.sumFoldLeft(null)).isEqualTo(0);
    }

    @Test
    public void testSumStreamEmpty() {
        Sum sum = new Sum();
        assertThat(sum.sumStream(new LinkedList<>())).isEqualTo(0);
        assertThat(sum.sumStream(null)).isEqualTo(0);
    }

    @Test
    public void testSumNormal() {
        Sum sum = new Sum();
        assertThat(sum.sum(new LinkedList<>(Collections.singletonList(1)))).isEqualTo(1);
        assertThat(sum.sum(new LinkedList<>(Arrays.asList(1,2,3,4)))).isEqualTo(10);
    }

    @Test
    public void testSumTailRecNormal() {
        Sum sum = new Sum();
        assertThat(sum.sumTailRec(new LinkedList<>(Collections.singletonList(1)))).isEqualTo(1);
        assertThat(sum.sumTailRec(new LinkedList<>(Arrays.asList(1,2,3,4)))).isEqualTo(10);
    }

    @Test
    public void testSumStreamFoldLeftNormal() {
        Sum sum = new Sum();
        assertThat(sum.sumFoldLeft(new LinkedList<>(Collections.singletonList(1)))).isEqualTo(1);
        assertThat(sum.sumFoldLeft(new LinkedList<>(Arrays.asList(1,2,3,4)))).isEqualTo(10);
    }

    @Test
    public void testSumStreamNormal() {
        Sum sum = new Sum();
        assertThat(sum.sumStream(new LinkedList<>(Collections.singletonList(1)))).isEqualTo(1);
        assertThat(sum.sumStream(new LinkedList<>(Arrays.asList(1,2,3,4)))).isEqualTo(10);
    }
}
