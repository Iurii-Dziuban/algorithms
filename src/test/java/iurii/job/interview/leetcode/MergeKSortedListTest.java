package iurii.job.interview.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MergeKSortedListTest {

    @Test
    public void testPriorityQueue() {
        MergeKSortedList.ListNode listNode1 = new MergeKSortedList.ListNode(1);
        MergeKSortedList.ListNode listNode2 = new MergeKSortedList.ListNode(3);
        MergeKSortedList.ListNode listNode3 = new MergeKSortedList.ListNode(2);
        listNode1.next = new MergeKSortedList.ListNode(7);
        listNode2.next = new MergeKSortedList.ListNode(6);
        listNode3.next = new MergeKSortedList.ListNode(9);

        MergeKSortedList mergeKSortedList = new MergeKSortedList();
        MergeKSortedList.ListNode listNode = mergeKSortedList.mergeKLists(new MergeKSortedList.ListNode[]{listNode1, listNode2, listNode3});

        List<Integer> result = Arrays.asList(1, 2, 3, 6, 7, 9);
        for (int value : result) {
            assertThat(listNode.val).isEqualTo(value);
            listNode = listNode.next;
        }
    }

    @Test
    public void testEmptyPriorityQueue() {
        MergeKSortedList mergeKSortedList = new MergeKSortedList();
        MergeKSortedList.ListNode listNode = mergeKSortedList.mergeKLists(new MergeKSortedList.ListNode[]{});
        assertThat(listNode).isNull();
    }

    @Test
    public void testDivideAndConqueror() {
        MergeKSortedList.ListNode listNode1 = new MergeKSortedList.ListNode(1);
        MergeKSortedList.ListNode listNode2 = new MergeKSortedList.ListNode(3);
        MergeKSortedList.ListNode listNode3 = new MergeKSortedList.ListNode(2);
        listNode1.next = new MergeKSortedList.ListNode(7);
        listNode2.next = new MergeKSortedList.ListNode(6);
        listNode3.next = new MergeKSortedList.ListNode(9);

        MergeKSortedList mergeKSortedList = new MergeKSortedList();
        MergeKSortedList.ListNode listNode = mergeKSortedList
                .mergeKListsDivideAndConqueror(new MergeKSortedList.ListNode[]{listNode1, listNode2, listNode3});

        List<Integer> result = Arrays.asList(1, 2, 3, 6, 7, 9);
        for (int value : result) {
            assertThat(listNode.val).isEqualTo(value);
            listNode = listNode.next;
        }
    }

    @Test
    public void testEmptyDivideAndConqueror() {
        MergeKSortedList mergeKSortedList = new MergeKSortedList();
        MergeKSortedList.ListNode listNode = mergeKSortedList
                .mergeKListsDivideAndConqueror(new MergeKSortedList.ListNode[]{});
        assertThat(listNode).isNull();
    }

    @Test
    public void testDivideAndConquerorMore() {
        MergeKSortedList.ListNode listNode1 = new MergeKSortedList.ListNode(1);
        MergeKSortedList.ListNode listNode2 = new MergeKSortedList.ListNode(3);
        MergeKSortedList.ListNode listNode3 = new MergeKSortedList.ListNode(2);
        MergeKSortedList.ListNode listNode4 = new MergeKSortedList.ListNode(7);
        listNode1.next = listNode4;
        MergeKSortedList.ListNode listNode5 = new MergeKSortedList.ListNode(6);
        listNode2.next = listNode5;
        MergeKSortedList.ListNode listNode6 = new MergeKSortedList.ListNode(9);
        listNode3.next = listNode6;

        listNode4.next = new MergeKSortedList.ListNode(13);
        listNode5.next = new MergeKSortedList.ListNode(11);
        listNode6.next = new MergeKSortedList.ListNode(15);

        MergeKSortedList mergeKSortedList = new MergeKSortedList();
        MergeKSortedList.ListNode listNode = mergeKSortedList
                .mergeKListsDivideAndConqueror(new MergeKSortedList.ListNode[]{listNode1, listNode2, listNode3});

        List<Integer> result = Arrays.asList(1, 2, 3, 6, 7, 9, 11, 13, 15);
        for (int value : result) {
            assertThat(listNode.val).isEqualTo(value);
            listNode = listNode.next;
        }
    }
}
