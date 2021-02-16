package iurii.job.interview.facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FacebookInterview {

    // Onsite Online Interviews
    /**
     * We have N animals in a line. Each animal has a different size.
     We have to feed the animals so that:

     1: Each animal must have at least ONE piece of food
     2: Animals larger than any of their neighbors get more pieces of food

     Write a function that returns the minimum number of pieces of food to meet the conditions above.


     For example, if the sizes are [1, 3, 2, 2, 1], then the counts for each animal would be [1, 2, 1, 2, 1],
     and the output of the function would be 7

     [5,4,3,2,1]
     a = [1,1,1,1,1]
     b = [5,4,3,2,1]
     [1, 3, 2, 2, 1]
     ^
     1. -->
     a = [1, 2, 1, 1, 1]

     2. <--
     b = [1, 2, 1, 2, 1]
     ^
     3. merge results
     c = [1, 2, 1, 2, 1]
     *
     */
    int minNumberOfFoodPieces(int[] h) {
        if (h.length == 0) {
            return 0;
        }
        int size = h.length;

        // a =[1,1,...,1] = b
        List<Integer> biggerThanLeftCheck = new ArrayList<>(Collections.nCopies(size, 1));
        List<Integer> biggerThanRightCheck = new ArrayList<>(Collections.nCopies(size, 1));

        for (int i = 1 ; i < size ; i++) {
            if (h[i-1] < h[i])
                biggerThanLeftCheck.set(i, biggerThanLeftCheck.get(i - 1) + 1);
        }

        for (int i = size - 1 ; i > 0 ; i--) {
            if (h[i-1] > h[i])
                biggerThanRightCheck.set(i -1, biggerThanRightCheck.get(i) + 1);
        }
        int res = 0;
        for (int i = 0 ; i < size; i++) {
            res += Math.max(biggerThanLeftCheck.get(i), biggerThanRightCheck.get(i));
        }

        return res;
    }

    // Following during Phone Interview

    /**
     * There are two non-negative valid float numbers as strings
     * num1 = 1.45
     * num2 = 135.8889
     *
     * return sum of two numbers
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

        if (num12.length() >  num22.length()) {
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
     *  There are two non negative valid big integer numbers as strings
     * @param num1 first big integer number
     * @param num2 second big integer number
     * @return sum of two numbers as a string
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
        for (int i = num1.length() - 1, j = num2.length() - 1 ; ; i--, j--) {
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
     *
     * Example of true:
     * 1 2 3 4
     * 5 1 2 3
     * 6 5 1 2
     * 7 6 5 1
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
                if (matrix[i][j] != matrix[i - 1] [j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
