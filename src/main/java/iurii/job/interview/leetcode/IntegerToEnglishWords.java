package iurii.job.interview.leetcode;

/**
 * 273. Integer to English Words https://leetcode.com/problems/integer-to-english-words/description/
 *
 * https://stackoverflow.com/questions/13219091/int-to-english-words-in-java
 *
 * Idea is similar to {@link IntegerToRoman}
 *
 * Time complexity: O(log(N)) where N is length of the number
 * Auxiliary Space complexity: O(1) constant length arrays
 */
public class IntegerToEnglishWords {

    private static final String SEPARATOR = " ";
    private static String HUNDREDS[] = {"", "One Hundred", "Two Hundred", "Three Hundred", "Four Hundred",
            "Five Hundred", "Six Hundred", "Seven Hundred", "Eight Hundred", "Nine Hundred"};
    private static String DECADES[] = {"", "Ten", "Twenty", "Thirty", "Forty",
            "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static String ONE_DECADES[] = {"", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static String CENTS[] = {"", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        int billions = num / 1000_000_000;
        int millions = (num % 1000_000_000) / 1000_000;
        int thousands = (num % 1000_000) / 1000;
        int cents = (num % 1000);
        StringBuilder res = new StringBuilder();
        helper(billions, res, "Billion");
        helper(millions, res, "Million");
        helper(thousands, res, "Thousand");
        helper(cents, res, "");
        return res.toString();
    }

    private void helper(int number, StringBuilder res, String name) {
        String hundred = HUNDREDS[(number % 1000) / 100];
        int decadeInt = (number % 100) / 10;
        int oneInt = number % 10;
        StringBuilder part = new StringBuilder();
        if (decadeInt == 1 && oneInt != 0) {
            String oneDecade = ONE_DECADES[oneInt];
            concatenate(part, SEPARATOR, hundred, oneDecade);
        } else {
            String decade = DECADES[decadeInt];
            String one = CENTS[oneInt];
            concatenate(part, SEPARATOR, hundred, decade, one);
        }
        if (!part.toString().isEmpty()) {
            concatenate(part, SEPARATOR, name);
        }
        concatenate(res, SEPARATOR, part.toString());
    }

    private static void concatenate(final StringBuilder result, final String separator, final String... parameters) {
        for (String param : parameters) {
            if (!param.isEmpty()) {
                if (result.length() > 0) {
                    result.append(separator);
                }
                result.append(param);
            }
        }
    }
}
