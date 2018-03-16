package iurii.job.interview.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MergeTwoSortedListsTest {

    @Test
    public void test() {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        MergeTwoSortedLists.ListNode node10 = new MergeTwoSortedLists.ListNode(1);
        MergeTwoSortedLists.ListNode node11 = new MergeTwoSortedLists.ListNode(2);
        MergeTwoSortedLists.ListNode node12 = new MergeTwoSortedLists.ListNode(4);
        node10.next = node11;
        node11.next = node12;

        MergeTwoSortedLists.ListNode node20 = new MergeTwoSortedLists.ListNode(1);
        MergeTwoSortedLists.ListNode node21 = new MergeTwoSortedLists.ListNode(3);
        MergeTwoSortedLists.ListNode node22 = new MergeTwoSortedLists.ListNode(4);
        node20.next = node21;
        node21.next = node22;

        MergeTwoSortedLists.ListNode head = mergeTwoSortedLists.mergeTwoLists(node10, node20);
        List<Integer> expectedValues = Arrays.asList(1, 1, 2, 3, 4, 4);
        int i = 0;
        while(head != null) {
            assertThat(head.val).isEqualTo(expectedValues.get(i++));
            head = head.next;
        }
    }
}