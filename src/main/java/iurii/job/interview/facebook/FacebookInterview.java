package iurii.job.interview.facebook;

import java.util.*;

public class FacebookInterview {

    /**
     * Design Interview Question is basically Designing QuadTree:
     *
     * There is a list of places on the planet - you provide longitude and latitude of your location
     * Return a list of N closest places to current place.
     *
     * Assume database is read only and there are millions of places placed.
     *
     * Design API which returns sorted list of places and works from any place in the world.
     *
     * Check Quad Tree design:
     * 1. https://www.educative.io/courses/grokking-the-system-design-interview/B8rpM8E16LQ
     * 2. https://leetcode.com/problems/construct-quad-tree/
     *
     * Pain points:
     * 1. locations are not equally placed across the planet.
     * There will be a lot of places in one area and zero at another.
     * Data structure should adapt to data.
     * 2. How many locations at one place is too much to split into smaller quads?
     * 3. How to search across the quads when you provide the location.
     */


    /**
     * There is LinkedList of Nodes, which have pointer on next element,
     * plus random pointer to some node within the list
     *
     * Implement deep copy of such a list, so that pointers in new list point to corresponding new nodes.
     *
     * Looks like exactly https://leetcode.com/problems/copy-list-with-random-pointer/ task.
     *
     * So there can be different approaches for that task, which can bring to different issues.
     *
     * The most obvious idea is to use Map to have mapping between old nodes and new nodes
     *
     * And then going via linked list checking : either returning value from map or
     * first creating it. Important here : node should be immutable or not changed to be key in Map!
     *
     * Memory : O(N) to keep new nodes.
     * Time : O(N) to go through the list and retrieve/check/update map.
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> toNew = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            Node curNew = getNew(toNew, cur);
            if (cur.next != null) {
                curNew.next = getNew(toNew, cur.next);
            }
            if (cur.random != null) {
                curNew.random = getNew(toNew, cur.random);
            }
            cur = cur.next;
        }
        return toNew.get(head);
    }

    private Node getNew(Map<Node, Node> toNew, Node old) {
        Node curNew = toNew.get(old);
        if (curNew == null) {
            curNew = new Node(old.val);
            toNew.put(old, curNew);
        }
        return curNew;
    }


    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * Find k smallest from array
     *
     * There are multiple ways how to tackle it.
     * 1. Sorting - O( n log n) and taking [k] from array.
     * 2. making k iterations over array to swap first smallest with last element
     * and skip checking last element on the run O (k * n)
     * 3. Quick select - during quick sort find n-k element position or navigate
     * sorting to that position until you reach it.
     * O(N) average and O(N^2) worst case
     * 4. using max heap and maintain it : O (n * log k) - n elements, but update on heap is log k
     * if in previous solutions memory is constantin that case it is O(k) to maintain heap.
     *
     * Solution:
     * - Keep max heap - k elements
     * - if more than k - pop()
     */
    public int findKSmallest(int[] arr, int k) {
        if (k > arr.length) {
            return -1;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int v : arr) {
            maxHeap.offer(v);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }

    // Onsite Online Interviews
    /*
     * The problem statement was collect all sums from root to leaves in a tree.
     *
     * There is a statement on leetcode https://leetcode.com/problems/sum-root-to-leaf-numbers/,
     * but I believe it is a different problem. (With Preorder / Morris Tree traversal )
     *
     * I believe the problem was:
     *          1
     *        /  \
     *       2   4
     *      /     \
     *     3      7
     *  One path is 1-2-3 -> sum = 6
     *  Second path is 1-4-7 -> sum = 12
     *  Return [6,12].
     */

    // skipping solving, because not sure what exact problem was.


    /**
     * Given a string str consisting of parentheses '(' , ')' and alphanumeric characters.
     * Remove minimum number of parenthesis to make the string valid and return any valid result.
     * In a valid string for every opening/closing parentheses there is a matching closing/opening one.
     * <p>
     * Similar to https://leetcode.com/discuss/interview-question/algorithms/124551/facebook-onsite-remove-invalid-parentheses
     * <p>
     * Idea: is to keep track of number of opened brackets at the moment
     * <p>
     * Memory: O(1) - to keep number of currently opened brackets and result (number of brackets to remove)
     * O(N) - to construct any valid string
     * <p>
     * Time : O(N) - to go through the string
     * <p>
     * For finding any valid string by removing invalid parenthesis
     * there are multiple ways to approach:
     * 1. with first run by collecting string with not adding invalid ')'
     * and with second run not collecting last invalid '('.
     * 2. By keeping track after which opening '(' - remove all other '('
     * 3. By keeping two pointers one for next ')' and second for next '('
     * and as soon as you find ')' move second pointer to first '(' if it is not found till ')'
     * - remove (do not add ')' to answer)
     * 4. By making two passes
     * - from left to right and not adding ')'
     * - from right to left and not adding '('
     * <p>
     * in any of these approaches memory and time complexity remain O(N).
     * <p>
     * Problem itself is a variation of problems with balancing, removing / adding parenthesis
     * like https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
     * <p>
     * Note: for counts only number of brackets to be removed is same as number of brackets to be added,
     * because they are counter parts.
     */
    public int minBracketsToBeRemovedToBalanceCount(String s) {
        int res = 0;
        int opened = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                opened++;
            }
            if (c == ')') {
                if (opened > 0) {
                    opened--;
                } else {
                    res++;
                }
            }
        }
        return res + opened;
    }

    public String minBracketsToBeRemovedToBalanceReturnAnyValid(String s) {
        List<Character> temp = new ArrayList<>();
        int opened = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                opened++;
            }
            if (c == ')' ) {
                if (opened > 0) {
                    opened--;
                } else {
                    continue;
                }
            }
            temp.add(c);
        }
        StringBuilder res = new StringBuilder();
        for (int i = temp.size() -1; i >= 0; i--) {
            char c = temp.get(i);
            if (c == '(') {
                if (opened > 0) {
                    opened--;
                } else {
                    res.append(c);
                }
            } else {
                res.append(c);
            }
        }
        return res.reverse().toString();
    }

    /**
     * We have N animals in a line. Each animal has a different size.
     * We have to feed the animals so that:
     * <p>
     * 1: Each animal must have at least ONE piece of food
     * 2: Animals larger than any of their neighbors get more pieces of food
     * <p>
     * Write a function that returns the minimum number of pieces of food to meet the conditions above.
     * <p>
     * For example, if the sizes are [1, 3, 2, 2, 1], then the counts for each animal would be [1, 2, 1, 2, 1],
     * and the output of the function would be 7
     * <p>
     * Example solution: we can have two arrays : to keep track of size bigger than left animal
     * and bigger than right animal and increase by 1 (if not bigger put default 1 value to minimize)
     * and then merge two arrays with Math.max(left[i], right[i]) for proper solution.
     * <p>
     * Example
     * [5,4,3,2,1]
     * a = [1,1,1,1,1]
     * b = [5,4,3,2,1]
     * [5,4,3,2,1]
     * <p>
     * <p>
     * Example
     * [1, 3, 2, 2, 1]
     * ^
     * 1. -->
     * a = [1, 2, 1, 1, 1]
     * <p>
     * 2. <--
     * b = [1, 2, 1, 2, 1]
     * ^
     * 3. merge results
     * c = [1, 2, 1, 2, 1]
     * <p>
     * Memory: O(N) - two arrays and merge + sum
     * Time : O(N) - to calculate two arrays and merge/sum
     */
    public int minNumberOfFoodPieces(int[] h) {
        if (h.length == 0) {
            return 0;
        }
        int size = h.length;

        // a =[1,1,...,1] = b
        List<Integer> biggerThanLeftCheck = new ArrayList<>(Collections.nCopies(size, 1));
        List<Integer> biggerThanRightCheck = new ArrayList<>(Collections.nCopies(size, 1));

        for (int i = 1; i < size; i++) {
            if (h[i - 1] < h[i])
                biggerThanLeftCheck.set(i, biggerThanLeftCheck.get(i - 1) + 1);
        }

        for (int i = size - 1; i > 0; i--) {
            if (h[i - 1] > h[i])
                biggerThanRightCheck.set(i - 1, biggerThanRightCheck.get(i) + 1);
        }
        int res = 0;
        for (int i = 0; i < size; i++) {
            res += Math.max(biggerThanLeftCheck.get(i), biggerThanRightCheck.get(i));
        }

        return res;
    }

    // Following up during Phone Interview
    // Two questions:
    // 1. Add two non-negative valid float numbers as strings
    // 2. Check if matrix has same values on the diagonals parallel to main diagonal
    /**
     * There are two non-negative valid float numbers as strings
     * num1 = 1.45
     * num2 = 135.8889
     * <p>
     * return sum of two numbers
     * <p>
     * Memory: O(N+M) worst case - where N and M are sizes of num1 and num2
     * Time : O(N+M) worst case - where N and M are sizes of num1 and num2
     */
    public String addFloatStrings(String num1, String num2) {
        // split each number into integer and floating parts;
        String[] num1Arr = num1.split("\\.");
        String num11 = num1Arr[0];
        String num12 = num1Arr[1];
        String[] num2Arr = num2.split("\\.");
        String num21 = num2Arr[0];
        String num22 = num2Arr[1];

        // fill shorter floating number part with zeros;
        int diff = Math.abs(num12.length() - num22.length());

        if (num12.length() > num22.length()) {
            num22 = num22 + String.join("", Collections.nCopies(diff, "0"));
        } else {
            num12 = num12 + String.join("", Collections.nCopies(diff, "0"));
        }
        NumberAndCarry floatingPart = addStrings(num12, num22);
        int carry = floatingPart.lastCarry;
        String floating = floatingPart.value.substring(carry);
        NumberAndCarry integerPart = addStrings(num11, num21, carry);
        return integerPart.value + '.' + floating;
    }

    /**
     * There are two non negative valid big integer numbers as strings
     *
     * @param num1 first big integer number
     * @param num2 second big integer number
     * @return sum of two numbers as a string
     * <p>
     * Memory: O(N+M) worst case - where N and M are sizes of num1 and num2
     * Time : O(N+M) worst case - where N and M are sizes of num1 and num2
     */
    public String addBigIntegerStrings(String num1, String num2) {
        return addStrings(num1, num2).value;
    }

    private NumberAndCarry addStrings(String num1, String num2) {
        return addStrings(num1, num2, 0);
    }

    private NumberAndCarry addStrings(String num1, String num2, int addCarry) {
        int carry = addCarry;
        StringBuilder res = new StringBuilder();
        for (int i = num1.length() - 1, j = num2.length() - 1; ; i--, j--) {
            if (i < 0 && j < 0) {
                break;
            }
            int digitSum = carry;
            digitSum += i >= 0 ? num1.charAt(i) - '0' : 0;
            digitSum += j >= 0 ? num2.charAt(j) - '0' : 0;
            carry = digitSum / 10;
            int digit = digitSum % 10;
            char digitChar = (char) (digit + '0');
            res.append(digitChar);
        }
        if (carry != 0) {
            res.append((char) (carry + '0'));
        }
        return new NumberAndCarry(res.reverse().toString(), carry);
    }

    private static class NumberAndCarry {
        public final String value;
        public final int lastCarry;

        public NumberAndCarry(String value, int lastCarry) {
            this.value = value;
            this.lastCarry = lastCarry;
        }
    }

    /**
     * There is matrix
     * Check if it has same values on the diagonals parallel to main diagonal
     * <p>
     * Example of true:
     * 1 2 3 4
     * 5 1 2 3
     * 6 5 1 2
     * 7 6 5 1
     * <p>
     * Memory: O(1) - just checking with previous diagonal value in-place
     * Time : O(N * M) worst case - where N and M are sizes of matrix, considering square matrix O(N^2)
     */
    public boolean areParallelDiagonalsSame(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 1; i < rows; i++) {
            if (matrix[i].length != matrix[0].length) {
                return false;
            }
        }

        // checking from 1 row and 1 col
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
