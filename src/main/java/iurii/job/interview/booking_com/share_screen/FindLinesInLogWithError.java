package iurii.job.interview.booking_com.share_screen;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Initial question was based on reading huge log from the log file.
 * Here is simplified version having smaller log in the memory as list
 *
 * Each line is similar to  "12:34:56 Thread1 SUCCESS doing something"
 *                          "12:34:57 Thread1 ERROR to save"
 * Might also be also line: "12:34:58 Thread2 SUCCESS finished processing ERROR"
 *
 * Each thread does a set of operations, considered as one transaction
 *
 * Print all the log lines related to all threads, that has an error
 *
 * In example above only Thread1 has error on second line. So both lines from log should be printed
 *
 * In both cases (File or List) solution is to store thread names in the Collection parsing each line separately.
 * And then to have one more loop through log to take lines that has thread name in it.
 *
 * Time complexity: O(N) - N number of lines
 * Auxiliary space complexity: O(N) - N number of lines
 */
public class FindLinesInLogWithError {

    List<String> findLinesInLogForThreadsWithError(List<String> log) {
        Set<String> threadNames = new HashSet<>();
        for(String line : log) {

        }
        return null;
    }
}
