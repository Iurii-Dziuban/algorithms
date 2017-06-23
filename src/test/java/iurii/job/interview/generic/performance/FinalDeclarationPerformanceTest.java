package iurii.job.interview.generic.performance;

import org.junit.Test;

/**
 * Created by iurii.dziuban on 21/06/2017.
 *
 * Example illustrates performance gain if using final where appropriate
 */
public class FinalDeclarationPerformanceTest {

    public static final int ITERATIONS_COUNT = 1_000_000;

    public static String testFinal() {
        final String a = "a";
        final String b = "b";
        return a + b;
    }
    public static String testNonFinal() {
        String a = "a";
        String b = "b";
        return a + b;
    }

    @Test
    public void nonFinalPerformance() {
        long tStart, tElapsed;
        tStart = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS_COUNT; i++) {
            testFinal();
        }
        tElapsed = System.currentTimeMillis() - tStart;
        System.out.println("Method with finals took " + tElapsed + " ms");
    }

    @Test
    public void finalPerformance() {
        long tStart, tElapsed;
        tStart = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS_COUNT; i++)
            testNonFinal();
        tElapsed = System.currentTimeMillis() - tStart;
        System.out.println("Method without finals took " + tElapsed + " ms");
    }
}
