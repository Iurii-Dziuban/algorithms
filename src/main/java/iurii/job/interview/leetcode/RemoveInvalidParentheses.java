package iurii.job.interview.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 301. Remove Invalid Parentheses https://leetcode.com/problems/remove-invalid-parentheses/description/
 *
 * https://www.geeksforgeeks.org/remove-invalid-parentheses/
 *
 * The idea is to track all visited strings
 * Queue to track all strings after removing 1,2, .. step characters
 * Flag to track if level with valid Parentheses was achieved
 *
 * Time complexity: O(N^2) check if invalid and remove it
 * Auxiliary space complexity: O(N^2) to store all valid strings with minimum amount removed
 */
public class RemoveInvalidParentheses {

    public List<String> removeInvalidParenthesesOptimized(String s) {
        List<String> result = new ArrayList<>();
        remove(result, s, 0, '(', ')');
        return result;
    }

    private void remove(List<String> result, String s, int startIndex, char openBracket, char closeBracket) {
        int openClosedBalance = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == openBracket) {
                openClosedBalance++;
            }
            if (s.charAt(i) == closeBracket) {
                openClosedBalance--;
            }
            if (openClosedBalance < 0) {
                for (int j = startIndex; j <= i; j++) {
                    if (s.charAt(j) == closeBracket && (j == startIndex || s.charAt(j - 1) != closeBracket)) {
                        remove(result, s.substring(0, j) + s.substring(j + 1), j, openBracket, closeBracket);
                    }
                }
                return;
            }
        }
        String reverseS = new StringBuilder(s).reverse().toString();
        if (openBracket == '(') {
            remove(result, reverseS, 0, ')', '(');
        } else {
            result.add(reverseS);
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> results = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.add(s);
        visited.add(s);
        boolean level = false;
        while (!queue.isEmpty() && !level) {
            Queue<String> newQueue = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                String string = queue.poll();
                if (isValid(string)) {
                    results.add(string);
                    level = true;
                }
                if (!level) {
                    for (int i = 0; i < string.length(); i++) {
                        if (string.charAt(i) != ')' && string.charAt(i) != '(') {
                            continue;
                        }
                        String stringToQueue = string.substring(0, i) + string.substring(i + 1);
                        if (!visited.contains(stringToQueue)) {
                            newQueue.add(stringToQueue);
                            visited.add(stringToQueue);
                        }
                    }
                }
            }
            queue = newQueue;
        }
        return results;
    }

    private boolean isValid(String s) {
        int open = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            }
            if (c == ')') {
                if (open > 0) {
                    open--;
                } else {
                    return false;
                }
            }
        }
        return open == 0;
    }
}
