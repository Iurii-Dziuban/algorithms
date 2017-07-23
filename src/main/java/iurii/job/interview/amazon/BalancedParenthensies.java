package iurii.job.interview.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Check that paranthesis are balanced in the expression {} [] ()
 * Balanced means for each opening follows closing one with the same type.
 * Tree like structure
 *
 * The idea behind is to use stack to track recent open brackets
 * and on closing bracket check the latest bracket type.
 * Created by iurii.dziuban on 02/06/2017.
 */
public class BalancedParenthensies {

    private Map<Character, Character> oppositeBrackets = new HashMap<>();

    public BalancedParenthensies() {
        oppositeBrackets.put(']', '[');
        oppositeBrackets.put(')', '(');
        oppositeBrackets.put('}', '{');
    }

    public boolean areParenthensiesBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else {
                Character oppositeBracket = oppositeBrackets.get(c);
                if (oppositeBracket != null) {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.pop() != oppositeBracket) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
