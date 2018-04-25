package iurii.job.interview.leetcode;

/**
 * 24. Swap Nodes in Pairs https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Time complexity: O(N) - N number of nodes
 * Auxiliary space complexity: O(1) additional dummy node and checks
 */
public class SwapNodesInPairs {

    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode next = current.next;
            ListNode newNode = current.next.next;
            ListNode newNext = newNode.next;
            newNode.next = next;
            next.next = newNext;
            current.next = newNode;
            current = next;
        }
        return dummy.next;
    }
}
