package iurii.job.interview.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *  17. Letter Combinations of a Phone Number https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 *  https://stackoverflow.com/questions/2344496/how-can-i-print-out-all-possible-letter-combinations-a-given-phone-number-can-re
 *
 *  Combinatorics question : Permutation with repetition
 *
 *  Time complexity: N^S
 *  Auxiliary space complexity: N^S
 *
 *  where N is length of dictionary for digit to peak and S is the length of the string
 */
public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        String[] phone = new String[]{"abc","def", "ghi", "jkl","mno", "pqrs", "tuv", "wxyz"};

        List<String> results = new ArrayList<>();
        results.add("");
        for (int i = digits.length() - 1; i >= 0; i--) {
            int index = digits.charAt(i) - '2';
            List<String> newResults = new ArrayList<>();
            for (String result : results) {
                for (int j = 0; j < phone[index].length(); j++) {
                    newResults.add(phone[index].charAt(j) + result);
                }
            }
            results = newResults;
        }
        return results;
    }
}
