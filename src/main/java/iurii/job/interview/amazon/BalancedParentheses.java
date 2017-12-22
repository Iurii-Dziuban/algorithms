package iurii.job.interview.amazon;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Check that parenthesis are balanced in the expression {} [] ()
 * Balanced means for each opening follows closing one with the same type.
 * Tree like structure
 *
 * The idea behind is to use stack to track recent open brackets
 * and on closing bracket check the latest bracket type.
 *
 * http://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
 * https://www.youtube.com/watch?v=xY65bgfXJTk
 *
 * N - number of characters in expression
 * Time complexity: O(N) for expression traversal
 * Auxiliary space O(N) for stack
 *
 * Immutable map vs Unmodifiable
 *    - Immutable is not modifiable and Unmodifiable is only decorator/view. Underlying map still can change
 *
 * Created by iurii.dziuban on 02/06/2017.
 */
public class BalancedParentheses {

    private Map<Character, Character> oppositeBrackets = new HashMap<>();

    public BalancedParentheses() {
        oppositeBrackets.put(']', '[');
        oppositeBrackets.put(')', '(');
        oppositeBrackets.put('}', '{');
        oppositeBrackets = Collections.unmodifiableMap(oppositeBrackets);
    }

    public boolean areParenthesesBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (isOpen(c)) {
                stack.push(c);
            } else {
                Character oppositeBracket = oppositeBrackets.get(c);
                if (isClosed(c) && (stack.isEmpty() || !oppositeBracket.equals(stack.pop()))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isClosed(char c) {
        return oppositeBrackets.get(c) != null;
    }

    private boolean isOpen(char c) {
        return c == '[' || c == '(' || c == '{';
    }
}
