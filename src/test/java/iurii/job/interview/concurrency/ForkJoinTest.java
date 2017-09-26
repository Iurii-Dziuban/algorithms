package iurii.job.interview.concurrency;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 25/09/2017.
 */
public class ForkJoinTest {

    private static final int PARALLELISM = 10;

    private int calcSumOfTen() {
        return Stream.of(1,2,3,4,5,6,7,8,9,10).mapToInt(i -> {
            System.out.println(Thread.currentThread());
            return i;}).parallel().sum();
    }

    @Test
    public void test() throws Exception {
        ForkJoinPool pool = new ForkJoinPool(PARALLELISM);

        final int[] result = {0};
        pool.submit(() -> {
            result[0] = calcSumOfTen();});
        pool.awaitTermination(2, TimeUnit.SECONDS);
        assertThat(result[0]).isEqualTo(55);
        pool.shutdown();
    }
}
