package iurii.job.interview.leetcode;

public class MergeTwoSortedLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                l2 = takeAndReturn(head, l2);
                head = head.next;
            } else {
                l1 = takeAndReturn(head, l1);
                head = head.next;
            }
        }
        ListNode nonNullList = l1 == null ? l2 : l1;
        while (nonNullList != null) {
            nonNullList = takeAndReturn(head, nonNullList);
            head = head.next;
        }
        return dummy.next;
    }

    private ListNode takeAndReturn(ListNode to, ListNode from) {
        to.next = from;
        from = from.next;
        to = to.next;
        to.next = null;
        return from;
    }
}
