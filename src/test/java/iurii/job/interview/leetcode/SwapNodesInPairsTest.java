package iurii.job.interview.leetcode;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SwapNodesInPairsTest {

    @Test
    public void test1() {
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        SwapNodesInPairs.ListNode head = new SwapNodesInPairs.ListNode(1);
        SwapNodesInPairs.ListNode two = new SwapNodesInPairs.ListNode(2);
        SwapNodesInPairs.ListNode three = new SwapNodesInPairs.ListNode(3);
        SwapNodesInPairs.ListNode four = new SwapNodesInPairs.ListNode(4);
        head.next = two;
        two.next = three;
        three.next = four;
        List<Integer> values = Arrays.asList(2, 1, 4, 3);
        SwapNodesInPairs.ListNode listNode = swapNodesInPairs.swapPairs(head);
        for (int value : values) {
            Assertions.assertThat(listNode.val).isEqualTo(value);
            listNode = listNode.next;
        }
    }

    @Test
    public void test2() {
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        SwapNodesInPairs.ListNode head = new SwapNodesInPairs.ListNode(1);
        SwapNodesInPairs.ListNode two = new SwapNodesInPairs.ListNode(2);
        SwapNodesInPairs.ListNode three = new SwapNodesInPairs.ListNode(3);
        SwapNodesInPairs.ListNode four = new SwapNodesInPairs.ListNode(4);
        SwapNodesInPairs.ListNode five = new SwapNodesInPairs.ListNode(5);
        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        List<Integer> values = Arrays.asList(2, 1, 4, 3, 5);
        SwapNodesInPairs.ListNode listNode = swapNodesInPairs.swapPairs(head);
        for (int value : values) {
            Assertions.assertThat(listNode.val).isEqualTo(value);
            listNode = listNode.next;
        }
    }
}
