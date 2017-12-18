package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 18/12/2017.
 */
public class JumpGame2Test {

    @Test
    public void testExampleReachableOutOfMaxIndex() {
        int[] exampleOfTowers = {4, 2, 0, 0, 2, 0};
        assertThat(new JumpGame2().greedyJumpsOutOfMaxIndex(exampleOfTowers)).isEqualTo(2);
    }

    @Test
    public void testExampleReachable1OutOfMaxIndex() {
        int[] exampleOfTowers = {2, 3, 1, 0, 2, 0};
        assertThat(new JumpGame2().greedyJumpsOutOfMaxIndex(exampleOfTowers)).isEqualTo(3);
    }

    @Test
    public void testExampleReachable2OutOfMaxIndex() {
        int[] exampleOfTowers = {2, 3, 0, 1, 4};
        assertThat(new JumpGame2().greedyJumpsOutOfMaxIndex(exampleOfTowers)).isEqualTo(3);
    }

    @Test
    public void testExampleNotReachableOutOfMaxIndex() {
        int[] exampleOfTowers = {2, 3, 1, 0, 1, -1};
        assertThat(new JumpGame2().greedyJumpsOutOfMaxIndex(exampleOfTowers)).isEqualTo(-1);
    }

    @Test
    public void testExampleOneElementJumpOutOfMaxIndex() {
        int[] exampleOfTowers = {2};
        assertThat(new JumpGame2().greedyJumpsOutOfMaxIndex(exampleOfTowers)).isEqualTo(1);
    }

    @Test
    public void testNegativeNotReachableOutOfMaxIndex() {
        int[] exampleOfTowers = {-2, 3, 1, 0, 2, 0};
        assertThat(new JumpGame2().greedyJumpsOutOfMaxIndex(exampleOfTowers)).isEqualTo(-1);
    }

    @Test
    public void testEmptyAndNullReachableOutOfMaxIndex() {
        assertThat(new JumpGame2().greedyJumpsOutOfMaxIndex(null)).isEqualTo(0);
        assertThat(new JumpGame2().greedyJumpsOutOfMaxIndex(new int[]{})).isEqualTo(0);
    }





    @Test
    public void testExampleReachableTillMaxIndex() {
        int[] exampleOfTowers = {4, 2, 0, 0, 2, 0};
        assertThat(new JumpGame2().greedyJumpsToLastElement(exampleOfTowers)).isEqualTo(2);
    }

    @Test
    public void testExampleReachable1TillMaxIndex() {
        int[] exampleOfTowers = {2, 3, 1, 0, 2, 0};
        assertThat(new JumpGame2().greedyJumpsToLastElement(exampleOfTowers)).isEqualTo(3);
    }

    @Test
    public void testExampleReachable2TillMaxIndex() {
        int[] exampleOfTowers = {2, 3, 0, 1, 4};
        assertThat(new JumpGame2().greedyJumpsToLastElement(exampleOfTowers)).isEqualTo(2);
    }

    @Test
    public void testExampleReachable2ElementsTillMaxIndex() {
        int[] exampleOfTowers = {1, 2};
        assertThat(new JumpGame2().greedyJumpsToLastElement(exampleOfTowers)).isEqualTo(1);
    }

    @Test
    public void testExampleReachableTillMaxIndexNegative() {
        int[] exampleOfTowers = {2, 3, 1, 0, 1, -1};
        assertThat(new JumpGame2().greedyJumpsToLastElement(exampleOfTowers)).isEqualTo(3);
    }

    @Test
    public void testExampleOneElementJumpTillMaxIndex() {
        int[] exampleOfTowers = {2};
        assertThat(new JumpGame2().greedyJumpsToLastElement(exampleOfTowers)).isEqualTo(0);
    }

    @Test
    public void testNegativeNotReachableTillMaxIndex() {
        int[] exampleOfTowers = {-2, 3, 1, 0, 2, 0};
        assertThat(new JumpGame2().greedyJumpsToLastElement(exampleOfTowers)).isEqualTo(-1);
    }

    @Test
    public void testEmptyAndNullReachableTillMaxIndex() {
        assertThat(new JumpGame2().greedyJumpsToLastElement(null)).isEqualTo(0);
        assertThat(new JumpGame2().greedyJumpsToLastElement(new int[]{})).isEqualTo(0);
    }
}
