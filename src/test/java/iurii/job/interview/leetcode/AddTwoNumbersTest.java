package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddTwoNumbersTest {

    @Test
    public void testWithoutCurring() {
        AddTwoNumbers.ListNode first = new AddTwoNumbers.ListNode(2);
        first.next = new AddTwoNumbers.ListNode(4);
        first.next.next = new AddTwoNumbers.ListNode(3);

        AddTwoNumbers.ListNode second = new AddTwoNumbers.ListNode(5);
        second.next = new AddTwoNumbers.ListNode(6);
        second.next.next = new AddTwoNumbers.ListNode(4);

        AddTwoNumbers.ListNode result = new AddTwoNumbers.ListNode(7);
        result.next = new AddTwoNumbers.ListNode(0);
        result.next.next = new AddTwoNumbers.ListNode(8);

        AddTwoNumbers.ListNode listNode = new AddTwoNumbers().addTwoNumbers(first, second);
        assertThat(listNode.val).isEqualTo(7);
        assertThat(listNode.next.val).isEqualTo(0);
        assertThat(listNode.next.next.val).isEqualTo(8);
        assertThat(listNode.next.next.next).isNull();
    }

    @Test
    public void testWithCurring() {
        AddTwoNumbers.ListNode one = new AddTwoNumbers.ListNode(7);
        AddTwoNumbers.ListNode two = new AddTwoNumbers.ListNode(8);

        AddTwoNumbers.ListNode moreThan10 = new AddTwoNumbers().addTwoNumbers(one, two);
        assertThat(moreThan10.val).isEqualTo(5);
        assertThat(moreThan10.next.val).isEqualTo(1);
        assertThat(moreThan10.next.next).isNull();
    }
}
