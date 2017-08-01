package iurii.job.interview.topcoder.srm503;
/**Problem Statement
����
In most states, gamblers can choose from a wide variety of different lottery games.
 The rules of a lottery are defined by two integers (choices and blanks) and two boolean variables (sorted and unique).
 choices represents the highest valid number that you may use on your lottery ticket.
 (All integers between 1 and choices, inclusive, are valid and can appear on your ticket.)
 blanks represents the number of spots on your ticket where numbers can be written.
The sorted and unique variables indicate restrictions on the tickets you can create.
 If sorted is set to true, then the numbers on your ticket must be written in non-descending order.
 If sorted is set to false, then the numbers may be written in any order. Likewise, if unique is set to true,
 then each number you write on your ticket must be distinct. If unique is set to false, then repeats are allowed.
Here are some example lottery tickets, where choices = 15 and blanks = 4:
{3, 7, 12, 14} -- this ticket is unconditionally valid.
{13, 4, 1, 9} -- because the numbers are not in nondescending order, this ticket is valid only if sorted = false.
{8, 8, 8, 15} -- because there are repeated numbers, this ticket is valid only if unique = false.
{11, 6, 2, 6} -- this ticket is valid only if sorted = false and unique = false.
Given a list of lotteries and their corresponding rules, return a list of lottery names sorted by how easy they are to win.
 The probability that you will win a lottery is equal to (1 / (number of valid lottery tickets for that game)).
 The easiest lottery to win should appear at the front of the list. Ties should be broken alphabetically (see example 1).
Definition
����
Class:
Lottery
Method:
sortByOdds
Parameters:
String[]
Returns:
String[]
Method signature:
String[] sortByOdds(String[] rules)
(be sure your method is public)
Limits
����
Time limit (s):
2.000
Memory limit (MB):
64
Constraints
-
rules will contain between 0 and 50 elements, inclusive.
-
Each element of rules will contain between 11 and 50 characters, inclusive.
-
Each element of rules will be in the format "<NAME>:_<CHOICES>_<BLANKS>_<SORTED>_<UNIQUE>" (quotes for clarity).
 The underscore character represents exactly one space. The string will have no leading or trailing spaces.
-
<NAME> will contain between 1 and 40 characters, inclusive, and will consist of only uppercase letters ('A'-'Z')
 and spaces (' '), with no leading or trailing spaces.
-
<CHOICES> will be an integer between 10 and 100, inclusive, with no leading zeroes.
-
<BLANKS> will be an integer between 1 and 8, inclusive, with no leading zeroes.
-
<SORTED> will be either 'T' (true) or 'F' (false).
-
<UNIQUE> will be either 'T' (true) or 'F' (false).
-
No two elements in rules will have the same name.
Examples
0)

����
{"PICK ANY TWO: 10 2 F F"
,"PICK TWO IN ORDER: 10 2 T F"
,"PICK TWO DIFFERENT: 10 2 F T"
,"PICK TWO LIMITED: 10 2 T T"}
Returns: 
{ "PICK TWO LIMITED",
  "PICK TWO IN ORDER",
  "PICK TWO DIFFERENT",
  "PICK ANY TWO" }
The "PICK ANY TWO" game lets either blank be a number from 1 to 10. Therefore,
 there are 10 * 10 = 100 possible tickets, and your odds of winning are 1/100.
The "PICK TWO IN ORDER" game means that the first number cannot be greater than the second number.
 This eliminates 45 possible tickets, leaving us with 55 valid ones. The odds of winning are 1/55.
The "PICK TWO DIFFERENT" game only disallows tickets where the first and second numbers are the same.
 There are 10 such tickets, leaving the odds of winning at 1/90.
Finally, the "PICK TWO LIMITED" game disallows an additional 10 tickets from the 45 disallowed in "PICK TWO IN ORDER".
 The odds of winning this game are 1/45.
1)

����
{"INDIGO: 93 8 T F",
 "ORANGE: 29 8 F T",
 "VIOLET: 76 6 F F",
 "BLUE: 100 8 T T",
 "RED: 99 8 T T",
 "GREEN: 78 6 F T",
 "YELLOW: 75 6 F F"}
Returns: { "RED",  "ORANGE",  "YELLOW",  "GREEN",  "BLUE",  "INDIGO",  "VIOLET" }
Note that INDIGO and BLUE both have the exact same odds (1/186087894300).
 BLUE is listed first because it comes before INDIGO alphabetically.
2)

����
{}
Returns: { }
Empty case
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Lottery {

    public static void main(String[] args) {
        new Lottery().sortByOdds(new String[] { "PICK ANY TWO: 10 2 F F",
                "PICK TWO IN ORDER: 10 2 T F", "PICK TWO DIFFERENT: 10 2 F T",
                "PICK TWO LIMITED: 10 2 T T" });
    }

    public String[] sortByOdds(String[] rules) {
        List<RuleResult> results = new ArrayList<RuleResult>();
        for (String rule : rules) {
            String[] nameAndParameters = rule.split(":");
            String[] params = nameAndParameters[1].substring(1).split(" ");
            String name = nameAndParameters[0];
            int choices = Integer.parseInt(params[0]);
            int blanks = Integer.parseInt(params[1]);
            boolean sorted = retrieveBoolean(params[2]);
            boolean unique = retrieveBoolean(params[3]);
            double validTicketCount = 0;
            if (!sorted && !unique) {
                validTicketCount = power(choices, blanks);
            }
            if (!sorted && unique) {
                validTicketCount = factorial(choices)
                        / factorial(choices - blanks);
            }
            if (sorted && !unique) {
                validTicketCount = sorted(choices, blanks, 0, 1, false);
            }
            if (sorted && unique) {
                validTicketCount = sorted(choices, blanks, 0, 1, true);
            }
            RuleResult result = new RuleResult();
            result.name = name;
            System.out.println(validTicketCount);
            result.probability = 1 / validTicketCount;
            results.add(result);
        }
        Collections.sort(results);
        String[] resultNames = new String[rules.length];
        for (int i = 0; i < resultNames.length; i++) {
            resultNames[i] = results.get(i).name;
        }
        return resultNames;
    }

    private boolean retrieveBoolean(String booleanValue) {
        return "T".equals(booleanValue);
    }

    private double factorial(int value) {
        double result = 1;
        for (int i = 1; i <= value; i++) {
            result *= i;
        }
        return result;
    }

    private double power(int a, int power) {
        double result = 1;
        while (power != 0) {
            if ((power & 1) == 1) {
                result *= a;
            }
            a *= a;
            power = power >> 1;
        }
        return result;
    }

    private double sorted(int choices, int blanks, int max, int callNumber,
            boolean isUnique) {
        if (callNumber == blanks) {
            return max == 0 ? choices : choices - max + (isUnique ? 0 : 1);
        }
        double result = 0;
        for (int i = max == 0 ? 1 : max + (isUnique ? 1 : 0); i <= choices; i++) {
            result += sorted(choices, blanks, i, callNumber + 1, isUnique);
        }
        return result;
    }
}

class RuleResult implements Comparable<RuleResult> {
    public String name;
    public double probability;

    public int compareTo(RuleResult other) {
        double difference = probability - other.probability;
        if (difference > 0) {
            return -1;
        }
        if (difference < 0) {
            return 1;
        }
        return 0;
    }
}