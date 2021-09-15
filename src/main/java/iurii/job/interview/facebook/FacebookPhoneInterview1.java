package iurii.job.interview.facebook;


/**
 * Two phone screen tasks asked
 */
public class FacebookPhoneInterview1 {

/**
 * There is a recursive structure that there is a list of elements
 * and each element either a simple element or a list for example
 *
 * Input: [2, [8, [3], 1], 4]
 *
 * depth sum = each element times by its depth summed together
 *
 * apply this algorithm recursively to calculate depth sum of such structure.
 *
 * For example above, the formula is the following:
 * 2 + (8 + (3 x 3) + 1) x 2 + 4 = 42
 *
 * Note: here I put braces to indicate different levels.
 * Note: the element 3 at level 3 is multiplied by 3, then summed with all elements at level 2,
 * the result sum is multiplied by level 2, etc.
 *
 * so it is not just sum of each element multiplied 'once' by its level, but rather
 * combination of sum elements on particular level multiplied by its level and
 * then recursively summing up next level.
 *
 * Example 2:
 * [1, [2, [3]]] = 1*1 + 2 * (2 + 3*(3)) = 1 + 11 * 2 = 23
 *
 * So on each level we calculate : curDepth * (sum(List<>))
 *
 * Can be calculated recursively or via Stack<Depth>
 *
 * N: is the number of integers
 * D: is the max depth
 *
 * TimeComplexity = O(N)
 * SpaceComplexity : O(1) + O(D) = O(D)
 */

    /**
     * Done structure:
     */
    static class Element {

        int num;
        Element[] array;

        boolean isNum() {
            return array == null;
        }

        int getNum() {
            return num;
        }

        Element[] getArray() {
            return array;
        }
    }

    /**
     * Will use recursive approach with recursive calls and call Stack instead
     * of iterative approach for simplicity and in general less amount of code.
     *
     * Note: it is easy to redesign to iterative approach if needed.
     */

    /**
     * depthSum function should take a list of elements instead of one element
     * for general solution
     *
     * @param el top level list of elements
     * @return depthSum
     */
    public int depthSum(Element[] el) {
        return depthSum(el, 1);
    }

    /**
     * recursive function to calculate depth sum at specific level
     *
     * @param el       current level elements list
     * @param curDepth current depth to be multiplied and passed into deeper lists
     * @return depth sum on specific level (curDepth)
     */
    private int depthSum(Element[] el, int curDepth) {
        if (el == null || el.length == 0) {
            return 0;
        }
        int res = 0;
        for (Element element : el) {
            if (element.isNum()) {
                res += element.getNum() * curDepth;
            } else {
                res += depthSum(element.getArray(), curDepth + 1) * curDepth;
            }
        }
        return res;
    }

    /**
     * There is a string input, consisting of a-z letters and braces '(' ')'
     * return output by removing as little braces '(' ')' as possible to make input balanced.
     *
     * input: string -- where chars are: '(', ')', 'a-z;
     * output: string -- where input is taken, as little chars are removed to make it balanced
     *
     * Examples:
     * input: ((a)
     * output: (a)
     *
     * input -> output
     * ((( -> ""
     *
     * input -> output
     * ))) -> ""
     *
     * input -> output
     * )(
     *
     * So there can be cases with redundant open braces and with closing braces.
     *
     * If we navigate from left to right and track number of open braces,
     * we can ensure closing braces will close one of opening braces,
     *
     * if there is no open brace before, we will skip current closing brace.
     *
     * How can we balance open braces then?
     *
     * What if we do two passes? One from left to right and ensure closing brackets have open bracket before.
     *
     * And second run from right to left and track closing brackets and ensure there is closing bracket to open one
     *
     * What do we need to track?
     * int curOpened
     * StringBuilder.append(char)
     *
     * N - number characters
     * Memory Complexity : O(N)
     * Time Complexity : O(N)
     *
     * We can not do better than that from Memory and Time Complexity
     */
    public String makeStringBalanced(String s) {
        // edge case
        if (s == null) {
            return null;
        }

        // first run from left to right and collecting temp result with closing brackets in place
        int curOpened = 0;
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                curOpened++;
            }
            if (c == ')') {
                if (curOpened > 0) {
                    curOpened--;
                } else {
                    continue;
                }
            }
            res.append(c);
        }

        // temporally collect result
        String tempString = res.toString();

        // second run from right to left and collecting result with correct open brackets in place
        int curClosed = 0;

        res = new StringBuilder();
        for (int i = tempString.length() - 1; i >= 0; i--) {
            char c = tempString.charAt(i);
            if (c == ')') {
                curClosed++;
            }
            if (c == '(') {
                if (curClosed > 0) {
                    curClosed--;
                } else {
                    continue;
                }
            }
            res.append(c);
        }
        // as we collected from right to left, we need to reverse result
        return res.reverse().toString();
    }

}
