package iurii.job.interview.microsoft;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * There is a tree with root node
 * Find lowest common ancestor of two given nodes in the tree
 *
 * https://en.wikipedia.org/wiki/Lowest_common_ancestor
 *
 * http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 *
 * https://www.youtube.com/watch?v=GnliEfQo114
 * Created by iurii.dziuban on 15/12/2017.
 */
public class LowestCommonAncestor {

    public static class Node {
        public Node left;
        public Node right;
        public int value;

        public Node(Node left, Node right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }

    public int lca(Node root, int value1, int value2) {
        Stack<Integer> pathTo1 = pathToX(root, value1);
        Stack<Integer> pathTo2 = pathToX(root, value2);
        int value = 0;
        while (pathTo1 != null && pathTo2 != null && !pathTo1.isEmpty() && !pathTo2.isEmpty()) {
            int cur = pathTo1.pop();
            if (cur != pathTo2.pop()) {
                return value;
            } else {
                value = cur;
            }
        }
        throw new NoSuchElementException();
    }

    private Stack<Integer> pathToX(Node root, int value) {
        if (root == null) {
            return null;
        }
        if (root.value == value) {
            Stack<Integer> stack = new Stack<>();
            stack.push(value);
            return stack;
        }
        Stack<Integer> left = pathToX(root.left, value);
        if (left != null) {
            left.push(root.value);
            return left;
        }
        Stack<Integer> right = pathToX(root.right, value);
        if (right != null) {
            right.push(root.value);
            return right;
        }
        return null;
    }
}
