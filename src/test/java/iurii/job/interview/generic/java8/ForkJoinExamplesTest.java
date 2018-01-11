package iurii.job.interview.generic.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ForkJoinExamplesTest {

    @Test
    public void test() throws ExecutionException, InterruptedException {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        System.out.println("Parallel Custom Pool");
        assertThat(new ForkJoinExamples().incByOneUseExistingPool(integers))
                .containsExactly(2,3,4,5,6);

        System.out.println("Parallel Common Pool");

        assertThat(integers.parallelStream().map(i ->{
            System.out.println("" + Thread.currentThread());
            return i + 1;
            }).collect(Collectors.toList())).containsExactly(2,3,4,5,6);
    }
}
