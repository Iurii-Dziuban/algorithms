package iurii.job.interview.generic.java8;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

/**
 * Example of Custom (Common) ForkJoinPool usage for parallel streams as they are executed in the specific pool
 */
public class ForkJoinExamples {

    public List<Integer> incByOneUseExistingPool(List<Integer> values) throws ExecutionException, InterruptedException {

        ForkJoinPool customThreadPool = new ForkJoinPool(4);

        try {
            //ForkJoinCommonPool is configured via SystemProperty for parallelism
            // each time parallel stream is used it is better to provide explicitly the thread pool
            // defaul number of threads in common pool is number of proc - 1, because of the main thread as well
            System.out.println("Common Pool Parallelism = " + ForkJoinPool.commonPool().getParallelism());

            return customThreadPool.submit(() -> values.parallelStream().map(i -> {
                System.out.println("" + Thread.currentThread());
                return i + 1;}).collect(Collectors.toList()))
                    .get();
        } finally {
            customThreadPool.shutdown();
        }
    }
}
