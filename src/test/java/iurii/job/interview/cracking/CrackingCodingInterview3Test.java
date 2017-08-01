package iurii.job.interview.cracking;

import org.junit.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Stacks and Queues
 */
public class CrackingCodingInterview3Test {

    @Test
    public void creation(){
        new CrackingCodingInterview3();
    }

    @Test
    public void towerTest() {
        int n = 5;
        CrackingCodingInterview3.Tower[] towers = new CrackingCodingInterview3.Tower[3];
        for (int i = 0; i < 3; i++) towers[i] = new CrackingCodingInterview3.Tower(i);
        for (int i = n - 1; i >= 0; i--) towers[0].add(i);
        towers[0].moveDisks(n, towers[2], towers[1]);
        assertThat(towers[0].index()).isEqualTo(0);
    }

    @Test
    public void sortStackTest() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(4);
        stack.add(5);
        stack.add(3);
        stack.add(1);
        stack.add(2);
        stack.add(0);
        Stack<Integer> sortedStack = CrackingCodingInterview3.sort(stack);
        assertThat(sortedStack).containsExactly(5,4,3,2,1,0);
    }

    @Test(expected = IllegalStateException.class)
    public void arrayThreeStackExceptionTest() {
        CrackingCodingInterview3.ArrayThreeStack arrayThreeStack = new CrackingCodingInterview3.ArrayThreeStack();
        arrayThreeStack.pop(2);
    }

    @Test
    public void arrayThreeStackTest() {
        CrackingCodingInterview3.ArrayThreeStack arrayThreeStack = new CrackingCodingInterview3.ArrayThreeStack();
        arrayThreeStack.push(0,1);
        arrayThreeStack.push(1,2);
        arrayThreeStack.push(2,3);

        assertThat(arrayThreeStack.pop(0)).isEqualTo(1);
        assertThat(arrayThreeStack.pop(1)).isEqualTo(2);
        assertThat(arrayThreeStack.pop(2)).isEqualTo(3);
    }

    @Test
    public void minStackTest() {
        CrackingCodingInterview3.MinStack minStack = new CrackingCodingInterview3.MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(0);

        assertThat(minStack.min()).isEqualTo(0);
        assertThat(minStack.pop()).isEqualTo(0);
        assertThat(minStack.min()).isEqualTo(1);
        assertThat(minStack.pop()).isEqualTo(2);
        assertThat(minStack.min()).isEqualTo(1);
        assertThat(minStack.pop()).isEqualTo(1);
    }

    @Test
    public void setOfStacksTest() {
        CrackingCodingInterview3.SetOfStacks setOfStacks = new CrackingCodingInterview3.SetOfStacks(2);
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(0);

        assertThat(setOfStacks.pop()).isEqualTo(0);
        assertThat(setOfStacks.pop()).isEqualTo(2);
        assertThat(setOfStacks.pop()).isEqualTo(1);
    }

    @Test
    public void myQueueTest() {
        CrackingCodingInterview3.MyQueue myQueue = new CrackingCodingInterview3.MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(0);

        assertThat(myQueue.size()).isEqualTo(3);
        assertThat(myQueue.pop()).isEqualTo(1);
        assertThat(myQueue.size()).isEqualTo(2);
        assertThat(myQueue.pop()).isEqualTo(2);
        assertThat(myQueue.size()).isEqualTo(1);
        assertThat(myQueue.pop()).isEqualTo(0);
        assertThat(myQueue.size()).isEqualTo(0);
    }
}
