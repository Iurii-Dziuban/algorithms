package iurii.job.interview.cracking;

import java.util.Arrays;

/**
 * Arrays and Strings
 */
public class CrackingCodingInterview1 {

    /**
     * 1.1 Are all characters in String unique. O(n^2). space O(0).
     */
    public static boolean isUnique(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 1.1 Are all characters in String unique. O(n). space O(n)
     */
    public static boolean isUnique2(String s) {
        boolean[] isInString = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            if (isInString[s.charAt(i)]) {
                return false;
            } else {
                isInString[s.charAt(i)] = true;
            }
        }
        return true;
    }


    // 1.2 is C++ style question about reverse String. O(n). space O(n). We cannot save space in java.

    /**
     * 1.2 Reverse String.
     */
    public static String reverseString(String s) {
        String result = new String();
        for (int i = s.length() - 1; i >= 0; i--) {
            result += String.valueOf(s.charAt(i));
        }
        return result;
    }

    /**
     * 1.3 Remove duplicate characters from String. O(n) with additional memory of constant size.
     * Ask if array of constant size is Ok.
     */
    public static char[] removeDuplicates(char[] string) {
        if (string == null) {
            return null;
        }
        int index = 0;
        boolean[] hit = new boolean[256];
        for (int i = 0; i < string.length; i++) {
            if (!hit[string[i]]) {
                hit[string[i]] = true;
                string[index++] = string[i];
            }
        }
        for (int i = index; i < string.length; i++) {
            string[i] = ' ';
        }
        return string;
    }

    /**
     * 1.3 Remove duplicate characters from String. O(n^2) without additional memory.
     * Ask if array of constant size is Ok.
     */
    public static char[] removeDuplicates2(char[] string) {
        if (string == null) {
            return null;
        }
        int index = 0;
        for (int i = 0; i < string.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (string[j] == string[i]) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                string[index++] = string[i];
            }
        }
        for (int i = index; i < string.length; i++) {
            string[i] = ' ';
        }
        return string;
    }

    /**
     * 1.4 If two strings are anagrams. Use sorting. O(n*log(n)) time
     */
    public static boolean areAnagrams(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        char[] s1CharArray = s1.toCharArray();
        Arrays.sort(s1CharArray);
        String sortedS1 = new String(s1CharArray);

        char[] s2CharArray = s2.toCharArray();
        Arrays.sort(s2CharArray);
        String sortedS2 = new String(s2CharArray);

        return sortedS1.equals(sortedS2);
    }

    /**
     * 1.4 If two strings are anagrams. O(n) time. array of constant size.
     */
    public static boolean areAnagrams2(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        int[] characterCount = new int[256];
        for (int i = 0; i < s1.length(); i++) {
            characterCount[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            characterCount[s2.charAt(i)]--;
            if (characterCount[s2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 1.5 Replace spaces with %20. O(n) time algorithm. First of all count spaces and new length.
     */
    public static char[] replaceSpaces(char[] string) {
        int spacesCount = 0;
        for (int i = 0; i < string.length; i++) {
            if (string[i] == ' ') {
                spacesCount++;
            }
        }
        int newSize = string.length + 2 * spacesCount;
        char[] newString = new char[newSize];
        int index = 0;
        for (char character : string) {
            if (character == ' ') {
                newString[index++] = '%';
                newString[index++] = '2';
                newString[index++] = '0';
            } else {
                newString[index++] = character;
            }
        }
        return newString;
    }

    /**
     * 1.6 Rotate NxN matrix on 90 degrees. For rotation making 4 exchanges
     */
    public static void rotateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            int iterNumber = matrix.length - 2 * i - 1;
            for (int j = 0; j < iterNumber; j++) {
                int buffer = matrix[matrix.length - i - j - 1][i];
                matrix[matrix.length - i - j - 1][i] = matrix[i][i + j];
                matrix[i][i + j] = matrix[i + j][matrix.length - i - 1];
                matrix[i + j][matrix.length - i - 1] = matrix[matrix.length - i - 1][matrix.length - i - j - 1];
                matrix[matrix.length - i - 1][matrix.length - i - j - 1] = buffer;
            }
        }
    }

    /**
     * 1.7 Set row and column of matrix into 0 if it contains 0
     */
    public static void setZeros(int[][] matrix) {
        boolean[] isRowZero = new boolean[matrix.length];
        boolean[] isColumnZero = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    isRowZero[i] = true;
                    isColumnZero[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (isRowZero[i] || isColumnZero[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 1.8 Using only one call to SubString check if rotation is a rotation of s
     *
     * @param s
     * @param rotation
     * @return
     */
    public static boolean isRotation(String s, String rotation) {
        if (s == null || rotation == null || s.length() != rotation.length()) {
            return false;
        }
        return (rotation + rotation).contains(s);
    }
}
