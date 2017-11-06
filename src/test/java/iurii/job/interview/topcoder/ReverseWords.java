package iurii.job.interview.topcoder;

/**
 * https://www.workinestonia.com/challenge/tests/
 * https://www.interviewzen.com/apply/8BqbkY
 *
 * Created by iurii.dziuban on 06/11/2017.
 */
public class ReverseWords {

    public char[] reverseWords(char [] input) {
        int begin = 0;
        int index = 0;
        for (char character: input) {
            if (character == ' ') {
                reverse(input, begin, index - 1);
                begin = index + 1;
            }
            index++;
        }
        reverse(input, begin, index - 1);
        return input;
    }

    private void reverse(char[] input, int begin, int end) {
        while (begin < end) {
            char buffer = input[begin];
            input[begin] = input[end];
            input[end] = buffer;
            begin++;
            end--;
        }
    }
}
