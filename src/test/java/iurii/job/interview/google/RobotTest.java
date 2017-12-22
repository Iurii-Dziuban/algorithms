package iurii.job.interview.google;

import org.junit.Test;

/**
 * Google phone call interview question
 *
 * There is a robot on the stairs that go infinitely up and down.
 * There is a a method tryStep that is implemented and you do not know details about its implementation
 * All you know is about it functionality. If it return true than step is successful and robot made one step up,
 * in case of false robot was not able
 *
 * You should implement method makeStep which ensures that robot made exactly one step up.
 *
 * There are two possible approaches: iterative and recursive.
 * Pluses and minuses of both implementations:
 * Recursive:
 * 1+ always terminates (based on stack size) regardless the pattern for tryStep (stack grows)
 * Use option -Xss to set size for java call stack size (default bytes, k - kilobytes, m - megabytes)
 * Example:
 *     -Xss40m    (40 megabytes)
 * 1- stack size depends on language, runtime configuration
 * 2- solution is a bit more less readable
 *
 * Iterative
 * 1+ solution is more readable
 * 1- depending on how much maximum minus step possible decision on int/long/BigInteger to use - it depends
 * 2- solution might not terminate at all (pattern minus step - plus step) or wrongly terminate in case of overflow.
 * It take 2^32 - 1 to terminate in case of integer
 *
 * Created by iurii.dziuban on 08/12/2017.
 */
public class RobotTest {

    @Test
    public void testIterative() {
        new Robot().iterativeMakeStep();
    }

    @Test
    public void testRecursive() {
        new Robot().recursiveMakeStep();
    }

    public static class Robot {

        private long i = 1;

        public boolean tryStep() {
            return i++ % 1000 == 0 || i > 1000;
        }

        public void iterativeMakeStep() {
            long counterStepsLeft = 1;
            while (counterStepsLeft != 0) {
                if (tryStep()) {
                    counterStepsLeft--;
                } else {
                    counterStepsLeft++;
                }
            }
        }

        public void recursiveMakeStep() {
            if (!tryStep()) {
                recursiveMakeStep();
                recursiveMakeStep();
            }
        }
    }
}
