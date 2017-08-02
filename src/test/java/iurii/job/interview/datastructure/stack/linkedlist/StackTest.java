package iurii.job.interview.datastructure.stack.linkedlist;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

public class StackTest {

    @Test
    public void test() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertThat(stack.pop()).isEqualTo(4);
        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(1);
        stack.push(1);
        stack.push(2);
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void popNullTest() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.pop();
    }
}
