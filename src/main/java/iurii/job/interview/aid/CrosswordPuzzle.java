package iurii.job.interview.aid;

import java.util.ArrayList;
import java.util.List;

/**
 * Crossword puzzle questions
 */
public class CrosswordPuzzle {

    /**
     * Question was asked by AID (Autonomous Intelligent Driving by Audi)
     * <p>
     * You are solving crossword puzzle
     * You know the length of the crossword and some of the letters.
     * Task is to find which word from possible options fits the crossword.
     * Match should be lower case (for option and for crossword)
     *
     * @param possibleMatches all possible options
     * @param crossword       string that has `dots` in place of unknown letters
     * @return one word which fits the pattern. There should be one word. In case many output first matched
     */

    // 1. filter out words that does not match length of crossword
    // 2. Go each word one by one and check with crossword. "." can be any letter.
    // Space complexity O(1) - no additional memory needed
    // Time complexity O(n x m) where n - number of words, m - length of longest word
    // Can we do better?
    // Potentially there could Tries structure used but worst case will be still
    // O(n x m) in case known only last letter
    public static String findMatch(List<String> possibleMatches, String crossword) {
        // 0. Assume crossword is not null or empty
        if (crossword == null || crossword.isEmpty()) {
            return "";
        }
        // Outputs and check should be lower cased
        String lowercaseCrossword = crossword.toLowerCase();
        return possibleMatches.stream()
            .filter(possibleMatch -> possibleMatch.length() == crossword.length())
            .map(String::toLowerCase)
            .filter(possibleMatch -> {
                for (int i = 0; i < crossword.length(); i++) {
                    if (possibleMatch.charAt(i) != lowercaseCrossword.charAt(i)
                        && lowercaseCrossword.charAt(i) != '.') {
                        return false;
                    }
                }
                return true;
            })
            .findFirst()
            .orElse("");
    }


    /**
     * Leetcode question to find word in the board
     * https://leetcode.com/problems/word-search/
     * Solution is introduced by backtracking
     * each (i;j) position can be starting ; then marking `#` (not to come twice),
     * trying to move into all possible directions
     * if word is not found backtrack by cleaning the path back
     *
     * @param board board of letters
     * @param word  word to be searched in board
     */
    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] board, String word, int i, int j, int index) {
        int rows = board.length;
        int columns = board[0].length;
        // 1. check bottom case
        if (index >= word.length()) {
            return true;
        }
        // 2. Check boundaries
        if (i == rows || i < 0 || j == columns || j < 0 ||
            word.charAt(index) != board[i][j]) {
            return false;
        }
        // 3. make path before next exploration
        board[i][j] = '#';
        boolean ret = false;
        int[] rowOffset = new int[]{0, 0, -1, 1};
        int[] colOffset = new int[]{1, -1, 0, 0};
        for (int d = 0; d < 4; d++) {
            ret = backtrack(board, word, i + rowOffset[d], j + colOffset[d], index + 1);
            if (ret) {
                break;
            }
        }
        // 4. clean up and return result
        board[i][j] = word.charAt(index);
        return ret;
    }


    /**
     * There is a crossword of `+` or '-' symbols
     * there is wordsLine : words split with `;`
     * words can be put into crossword strongly vertical or horizontal
     * only instead of `-` symbols
     * <p>
     * Populate the crossword
     * <p>
     * Solution
     * <p>
     * https://www.hackerrank.com/challenges/crossword-puzzle/problem
     *
     *
     * Some assumptions:
     * 1) not covered `-` are considered ok. Example : `hello-` population
     * 2) in case neighbour covering, do not care if the words formed are correct.
     * ex. `hello+` do not care about vertical words formed `ew, lo, lr`, etc.
     *     `+world`
     *
     * Solution is to take a word & try to put it on each possible place
     * horizontally or vertically.
     * Returning back if putting word into place did not work
     * should be via backtracking;
     * previous state of crossword restored
     *
     * if saving whole crossword additional memory O(n x m x k) needed
     * where n x m crossword size, k number of words
     *
     * this can be decreased by saving positions where word was put & should be cleaned
     * at most O(n x m), to be more precise : O(k x p) where p - max length of word
     *
     * In terms of runtime O(n x m x k) worst case as all combinations are possible
     *
     * @param crossword - crossword of `-` and `+`
     * @param wordsLine - words to be put into crossword on `-` positions
     * @return filled crossword
     */
    public static String[] crosswordPuzzle(String[] crossword, String wordsLine) {
        // transform inputs -> words and board as char[][], so can be modified
        String[] words = wordsLine.split(";");
        int rows = crossword.length;
        int cols = crossword[0].length();
        char[][] cross = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cross[i][j] = crossword[i].charAt(j);
            }
        }
        // main call  0 - index of the word to start search
        boolean res = call(cross, words, 0);
        // if res is found construct output
        if (res) {
            String[] result = new String[rows];
            for (int i = 0; i < rows; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < cols; j++) {
                    sb.append(cross[i][j]);
                }
                result[i] = sb.toString();
            }
            return result;
        }
        return new String[0];  // or maybe throw exception if result is not found?
    }

    // recursive call to find words[in], in case all words are found return true
    private static boolean call(char[][] cross, String[] words, int in) {
        int rows = cross.length;
        int cols = cross[0].length;
        // 1. bottom case
        if (in == words.length) {
            return true;
        }
        // try to find next word
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean res = backtrack(cross, words, in, i, j);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    // recursive call with backtracking to start words[in] on cross[i][j] - try horizontally or vertically
    // and rollback if word is not possible to put
    private static boolean backtrack(char[][] cross, String[] words, int in, int i, int j) {
        String word = words[in];
        int rows = cross.length;
        int cols = cross[0].length;
        // 1. no bottom case here
        // 2. Check boundaries
        if (i == rows || i < 0 || j == cols || j < 0) {
            return false;
        }
        // horizontally
        // 3. Try to fill
        boolean rollback = false;
        List<Integer> y = new ArrayList<>();
        for (int k = 0; k < word.length(); k++) {
            if ((j + k < cols) && (cross[i][j + k] == '-' || cross[i][j + k] == word.charAt(k))) {
                if (cross[i][j + k] == '-') {
                    y.add(j + k);
                    cross[i][j + k] = word.charAt(k);
                }
            } else {
                rollback = true;
                break;
            }
        }
        // 4. continue
        if (!rollback && call(cross, words, in + 1)) {
            return true;
        }
        // 5. clean up
        for (int col : y) {
            cross[i][col] = '-';
        }
        // vertically
        // 3. Try to fill
        rollback = false;
        List<Integer> x = new ArrayList<>();
        for (int k = 0; k < word.length(); k++) {
            if ((i + k < rows) && (cross[i + k][j] == '-' || cross[i + k][j] == word.charAt(k))) {
                if (cross[i + k][j] == '-') {
                    x.add(i + k);
                    cross[i + k][j] = word.charAt(k);
                }
            } else {
                rollback = true;
                break;
            }
        }
        // 4. continue
        if (!rollback && call(cross, words, in + 1)) {
            return true;
        }
        // 5. clean up
        for (int row : x) {
            cross[row][j] = '-';
        }
        return false;
    }

    // TODO : https://leetcode.com/problems/word-search-ii/

}
