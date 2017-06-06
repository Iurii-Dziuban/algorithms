package iurii.job.interview.topcoder;

/**
 * Ann and Bob playing game. String with only A and B letters.
 * On each step player can cross out sequence of continuous letters.
 * Ann wins if only A letters left (not crossed out) and Bob if only B letters left(not crossed out)
 *
 * @author Jacky
 */
public class AbabbbaGame {
    public static String whoWins(String letters) {
        if (letters.charAt(letters.length() - 1) == 'A' || letters.charAt(0) == 'A') {
            return "Ann wins";
        } else {
            return "Bob wins";
        }
    }
}
