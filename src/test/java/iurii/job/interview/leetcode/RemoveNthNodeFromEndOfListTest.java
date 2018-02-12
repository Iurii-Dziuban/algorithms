package iurii.job.interview.leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveNthNodeFromEndOfListTest {

    private RemoveNthNodeFromEndOfList.ListNode head;

    @Before
    public void setUp() {
        RemoveNthNodeFromEndOfList.ListNode one = new RemoveNthNodeFromEndOfList.ListNode(1);
        RemoveNthNodeFromEndOfList.ListNode two = new RemoveNthNodeFromEndOfList.ListNode(2);
        RemoveNthNodeFromEndOfList.ListNode three = new RemoveNthNodeFromEndOfList.ListNode(3);
        RemoveNthNodeFromEndOfList.ListNode four = new RemoveNthNodeFromEndOfList.ListNode(4);
        RemoveNthNodeFromEndOfList.ListNode five = new RemoveNthNodeFromEndOfList.ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        head = one;
    }

    @Test
    public void test5() {
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        assertThat(getList(removeNthNodeFromEndOfList.removeNthFromEnd(head, 5)))
                .containsExactly(2, 3, 4, 5);

    }

    @Test
    public void test1() {
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        assertThat(getList(removeNthNodeFromEndOfList.removeNthFromEnd(head, 1)))
                .containsExactly(1, 2, 3, 4);

    }

    @Test
    public void test3() {
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        assertThat(getList(removeNthNodeFromEndOfList.removeNthFromEnd(head, 3)))
                .containsExactly(1, 2, 4, 5);

    }

    private List<Integer> getList(RemoveNthNodeFromEndOfList.ListNode node) {
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list;
    }
}
