package iurii.job.interview.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses https://leetcode.com/problems/generate-parentheses/description/
 *
 * https://leetcode.com/articles/generate-parentheses/
 * https://www.geeksforgeeks.org/print-all-combinations-of-balanced-parentheses/
 *
 * https://www.geeksforgeeks.org/find-number-valid-parentheses-expressions-given-length/
 * https://www.geeksforgeeks.org/program-nth-catalan-number/
 *
 * Catalan number is needed to calculate the complexity
 *
 * Time complexity O(4^n / Math.sqrt(n))
 * Space complexity O(4^n / Math.sqrt(n))
 */
public class GenerateParentheses {

    public List<String> generateParenthesisClosureNumber(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: generateParenthesisClosureNumber(c))
                    for (String right: generateParenthesisClosureNumber(n-1-c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }

    public List<String> generateParenthesisBacktracking(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }
        if (open < max) {
            backtrack(ans, cur + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(ans, cur + ")", open, close + 1, max);
        }
    }

    // Returns value of Binomial Coefficient C(n, k)
    private long binomialCoeff(int n, int k) {
        long res = 1;
        // Since C(n, k) = C(n, n-k)
        if (k > n - k) {
            k = n - k;
        }
        // Calculate value of [n*(n-1)*---*(n-k+1)] / [k*(k-1)*---*1]
        for (int i = 0; i < k; i++) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }

    // A Binomial coefficient based function to find nth catalan
    // number in O(n) time
    public long catalan(int n) {
        // Calculate value of 2nCn
        long c = binomialCoeff(2*n, n);
        // return 2nCn/(n + 1)
        return c /(n + 1);
    }

    // Function to find possible ways to put balanced parenthesis
    // in an expression of length n
    public long findWays(int n) {
        // If n is odd, not possible to create any valid parentheses
        if (n % 2 == 1) {
            return 0;
        }
        // Otherwise return n/2'th Catalan Number
        return catalan(n/2);
    }
}
