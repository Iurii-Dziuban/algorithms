package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 22/12/2017.
 */
public class CircularArrayLoopTest {

    @Test
    public void testLeetCodeCircularFind() {
        assertThat(new CircularArrayLoop().circularArrayLoopLeetCode(new int[]{2, -1, 1, -2, -2})).isFalse();
        assertThat(new CircularArrayLoop().circularArrayLoopLeetCode(new int[]{2, -1, 1, 2, 2})).isTrue();
        assertThat(new CircularArrayLoop().circularArrayLoopLeetCode(new int[]{-1, 2})).isFalse();
    }

    @Test
    public void testCircularArrayLoopWithOutbound() {
        assertThat(new CircularArrayLoop().circularArrayLoopWithOutbound(new int[]{2, 0, 3, 1, 2})).isTrue();
        assertThat(new CircularArrayLoop().circularArrayLoopWithOutbound(new int[]{2, 0, 3, 5, 6})).isFalse();
        assertThat(new CircularArrayLoop().circularArrayLoopWithOutbound(new int[]{-1, 2})).isFalse();
    }
}
