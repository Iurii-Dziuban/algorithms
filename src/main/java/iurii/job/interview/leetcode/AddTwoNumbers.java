package iurii.job.interview.leetcode;

/**
 * 2. Add Two Numbers https://leetcode.com/problems/add-two-numbers/description/
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Time complexity: O(max(n,m))
 * Auxiliary space complexity O(max(n,m)) for result value
 * n,m - lengths of each number
 */
public class AddTwoNumbers {
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode prev = result;
        int car = 0;
        while (l1 != null || l2 != null) {
            int l2Value = 0;
            if (l2 != null) {
                l2Value = l2.val;
                l2 = l2.next;
            }
            int l1Value = 0;
            if (l1 != null) {
                l1Value = l1.val;
                l1 = l1.next;
            }
            int value = l1Value + l2Value + car;
            car = value / 10;
            value = value % 10;
            prev.next = new ListNode(value);
            prev = prev.next;
        }
        if (car != 0) {
            prev.next = new ListNode(car);
        }
        return result.next;
    }
}
