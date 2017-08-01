package iurii.job.interview.topcoder.srm505;

/**
 * Problem Statement
 * ����
 * You are given a simple paragraph containing a number of sentences,
 * the original person who wrote the paragraph was in a rush and used only lower case letters ('a'-'z')
 * for the words in the paragraph and did not use any punctuation other than a period to separate sentences.
 * Your task is to fix the capitalization in the paragraph, the objective is to make it so
 * every sentence in the paragraph begins with a capital (upper case) letter ('A'-'Z').
 * The paragraph is formatted as one or more sentences separated by single space (' ') characters.
 * Each sentence consists of one or more words separated by single space (' ') characters.
 * The last word in a sentence is always immediately followed by a single dot ('.') character.
 * Each word is a non-empty string containing only lower case letters ('a'-'z').
 * As an example, consider the following paragraph (quotes for clarity):
 * <p>
 * "this is merely an example. be careful. this is a new sentence."
 * The result of your program must then be as follows:
 * "This is merely an example. Be careful. This is a new sentence."
 * <p>
 * Definition
 * ����
 * Class:
 * SentenceCapitalizerInator
 * Method:
 * fixCaps
 * Parameters:
 * String
 * Returns:
 * String
 * Method signature:
 * String fixCaps(String paragraph)
 * (be sure your method is public)
 * Limits
 * ����
 * Time limit (s):
 * 2.000
 * Memory limit (MB):
 * 64
 * Constraints
 * -
 * paragraph will contain between 2 and 50 characters, inclusive.
 * -
 * Each character in paragraph will be a lower case letter ('a'-'z'), a space (' ') or a dot ('.').
 * -
 * The first character of paragraph will be a lower case letter ('a'-'z').
 * -
 * The last character of paragraph will be a dot ('.').
 * -
 * There will be no two consecutive space characters in paragraph.
 * -
 * Every space (' ') character in paragraph will precede a letter.
 * -
 * Every '.' character in paragraph except the last one will precede a space character.
 * Examples
 * 0)
 * <p>
 * ����
 * "hello programmer. welcome to topcoder."
 * Returns: "Hello programmer. Welcome to topcoder."
 * <p>
 * 1)
 * <p>
 * ����
 * "one."
 * Returns: "One."
 * A sentence can consist of just a single word.
 * 2)
 * <p>
 * ����
 * "not really. english. qwertyuio. a. xyz."
 * Returns: "Not really. English. Qwertyuio. A. Xyz."
 * <p>
 * 3)
 * <p>
 * ����
 * "example four. the long fourth example. a. b. c. d."
 * Returns: "Example four. The long fourth example. A. B. C. D."
 */
public class SentenceCapitalizerInator {
    public String fixCaps(String paragraph) {
        String[] sentences = paragraph.split("\\.");
        String result = new String(sentences[0].substring(0, 1).toUpperCase() + sentences[0].substring(1)) + ".";
        for (int i = 1; i < sentences.length; i++) {
            result += " " + sentences[i].trim().substring(0, 1).toUpperCase() + sentences[i].trim().substring(1) + ".";
        }
        return result;
    }
}
