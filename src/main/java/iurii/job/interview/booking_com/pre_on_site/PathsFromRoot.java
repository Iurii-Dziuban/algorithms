package iurii.job.interview.booking_com.pre_on_site;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * There is a binary tree:
 *      2
 *    /   \
 *   1     2
 *  / \   /  \
 * 3  2   1   2
 *
 * Find all paths from the root that in sum give k
 * In example above
 * if k = 5 -> {2,1,2} and {2,2,1}
 *
 * Notes:
 * 1) Paths can terminate on any Node - regardless if it is Leaf or not
 * 2) No cyclic or return paths. Only from top to bottom
 * 3) values inside the node that form the path - can be negative (in case not: termination of algorithm can be earlier)
 *
 * Design Node class with all needed values for the algorithm
 * Implement the algorithm
 *
 * Brute force algorithm is to go and collect the paths and save in each node.
 * Too much memory needed. n^2
 *
 * Here is the solution based on calculating path and saving in each node as well as having link
 * to the parent element to do backtracking and collect path, in case path was found.
 * Created by iurii.dziuban on 17/07/2017.
 */
public class PathsFromRoot {

    public List<List<Integer>> findPathsEqualK(Node root, int k) {
        Stack<Node> curNodes = new Stack<>();
        List<List<Integer>> results = new ArrayList<>();
        root.setTotalPath(root.getValue());
        curNodes.push(root);
        while(!curNodes.isEmpty()) {
            Node curNode = curNodes.pop();
            if (curNode.getTotalPath() == k) {
                LinkedList<Integer> linkedList = new LinkedList<>();
                Node nodeOnThePath = curNode;
                do {
                    linkedList.addFirst(nodeOnThePath.getValue());
                    nodeOnThePath = nodeOnThePath.getTop();
                } while(nodeOnThePath != null);
                results.add(linkedList);
            }
            Node left = curNode.getLeft();
            if (left != null) {
                left.setTotalPath(curNode.getTotalPath() + left.getValue());
                curNodes.push(left);
            }
            Node right = curNode.getRight();
            if (right != null) {
                right.setTotalPath(curNode.getTotalPath() + right.getValue());
                curNodes.push(right);
            }
        }
        return results;
    }

    public static class Node {
        private final Node left;
        private final Node right;
        private Node top;
        private final int value;
        private int totalPath;

        public Node(Node left, Node right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public Node getTop() {
            return top;
        }

        public int getValue() {
            return value;
        }

        public int getTotalPath() {
            return totalPath;
        }

        public void setTotalPath(int totalPath) {
            this.totalPath = totalPath;
        }

        public void setTop(Node top) {
            this.top = top;
        }
    }
}
