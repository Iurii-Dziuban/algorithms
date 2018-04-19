package iurii.job.interview.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted List
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * https://leetcode.com/articles/merge-k-sorted-list/
 *
 * Brute force, Priority Queue enhancement and DivideAndConquerorMerge
 *
 * Time complexity: O(N log (K)) where N - total number of elements and k - number of lists
 * Auxiliary space complexity: O(1) - for divide and conqueror, O(K) for priority queue & reusing existing nodes
 */
public class MergeKSortedList {

    static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    static class ListNodeComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return Integer.compare(o1.val, o2.val);
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new ListNodeComparator());
        ListNode dummy = new ListNode(0);
        Arrays.stream(lists).parallel().filter(Objects::nonNull).forEach(queue::add);
        ListNode current = dummy;
        while (!queue.isEmpty()) {
            ListNode minList = queue.poll();
            current.next = minList;
            if (minList.next != null) {
                queue.add(minList.next);
            }
            minList.next = null;
            current = current.next;
        }
        return dummy.next;
    }

    public ListNode mergeKListsDivideAndConqueror(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        return recurse(lists, 0, lists.length - 1);
    }

    private ListNode recurse(ListNode[] lists, int left, int right) {
        if(left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode first = recurse(lists, left, mid);
        ListNode last = recurse(lists, mid + 1, right);
        return merge(first, last);
    }
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode l = left;
        ListNode r = right;
        while(l != null && r != null) {
            if(l.val < r.val) {
                cur.next = l;
                l = l.next;
            } else {
                cur.next = r;
                r = r.next;
            }
            cur = cur.next;
        }
        if(l != null) {
            cur.next = l;
        }
        if(r != null) {
            cur.next = r;
        }
        return dummy.next;
    }
}
