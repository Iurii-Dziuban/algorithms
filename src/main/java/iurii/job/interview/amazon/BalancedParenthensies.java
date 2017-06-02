package iurii.job.interview.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Check that paranthesis are balanced in the expression {} [] ()
 * Created by iurii.dziuban on 02/06/2017.
 */
public class BalancedParenthensies {

    private Map<Character, Character> brackets = new HashMap<>();

    public BalancedParenthensies () {
        brackets.put(']','[');
        brackets.put(')','(');
        brackets.put('}','{');
    }

    public boolean areParenthensiesBalanced(String s) {
        Stack<Character> stack  = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '[' || c == '(' || c == '{' ) {
                stack.push(c);
            }else {
                Character oppositeBracket = brackets.get(c);
                if(oppositeBracket != null) {
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
