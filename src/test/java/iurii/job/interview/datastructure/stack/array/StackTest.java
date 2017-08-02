package iurii.job.interview.datastructure.stack.array;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StackTest {

    @Test
    public void test() {
        Stack<Integer> list = new Stack<Integer>(Integer.class);
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);

        assertThat(list.pop()).isEqualTo(4);
        assertThat(list.pop()).isEqualTo(3);
        assertThat(list.pop()).isEqualTo(2);
        assertThat(list.pop()).isEqualTo(1);
        list.push(1);
        list.push(2);
        assertThat(list.pop()).isEqualTo(2);
        assertThat(list.pop()).isEqualTo(1);
    }

}
