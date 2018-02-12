package iurii.job.interview.leetcode;

/**
 * 19. Remove Nth Node From End of List https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 *  https://leetcode.com/articles/remove-nth-node-end-list/
 *
 *  Time complexity: O(N) one go through the list
 *  Auxiliary space complexity: O(1) two additional pointers
 */
public class RemoveNthNodeFromEndOfList {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointerHead = dummy;
        ListNode pointerLast = head;
        for (int i = 0; i < n ; i++) {
            pointerLast = pointerLast.next;
        }
        while(pointerLast != null) {
            pointerLast = pointerLast.next;
            pointerHead = pointerHead.next;
        }
        pointerHead.next = pointerHead.next.next;
        return dummy.next;
    }
}
