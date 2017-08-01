package iurii.job.interview.cracking;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Recursion
 *
 * @author Iurii
 */
public class CrackingCodingInterview8Test {

    @Test
    public void creation(){
        new CrackingCodingInterview8();
    }

    @Test
    public void findFibonacciTest() {
        assertThat(CrackingCodingInterview8.findFibonacci(1)).isEqualTo(1);
        assertThat(CrackingCodingInterview8.findFibonacci(3)).isEqualTo(2);
        assertThat(CrackingCodingInterview8.findFibonacci(4)).isEqualTo(3);
        assertThat(CrackingCodingInterview8.findFibonacci(5)).isEqualTo(5);
    }
    @Test
    public void pathsNumberTest() {
        assertThat(CrackingCodingInterview8.pathsNumber(2)).isEqualTo(2);
        assertThat(CrackingCodingInterview8.pathsNumber(3)).isEqualTo(6);
    }

    @Test
    public void allSubsetsTest() {
        assertThat(CrackingCodingInterview8.allSubsets(Arrays.asList(0, 1, 2, 3)))
                .containsExactlyInAnyOrder(
                        Arrays.asList(),
                        Arrays.asList(0),
                        Arrays.asList(1),
                        Arrays.asList(2),
                        Arrays.asList(3),
                        Arrays.asList(0,1),
                        Arrays.asList(0,2),
                        Arrays.asList(0,3),
                        Arrays.asList(1,2),
                        Arrays.asList(1,3),
                        Arrays.asList(2,3),
                        Arrays.asList(0,1,2),
                        Arrays.asList(0,1,3),
                        Arrays.asList(0,2,3),
                        Arrays.asList(1,2,3),
                        Arrays.asList(0,1,2,3)
                );
    }

    @Test
    public void allSubsets2Test() {
        assertThat(CrackingCodingInterview8.allSubsets2(Arrays.asList(0, 1, 2, 3)))
                .containsExactlyInAnyOrder(
                                Arrays.asList(),
                                Arrays.asList(0),
                                Arrays.asList(1),
                                Arrays.asList(2),
                                Arrays.asList(3),
                                Arrays.asList(0,1),
                                Arrays.asList(0,2),
                                Arrays.asList(0,3),
                                Arrays.asList(1,2),
                                Arrays.asList(1,3),
                                Arrays.asList(2,3),
                                Arrays.asList(0,1,2),
                                Arrays.asList(0,1,3),
                                Arrays.asList(0,2,3),
                                Arrays.asList(1,2,3),
                                Arrays.asList(0,1,2,3)
                );
    }

    @Test
    public void allPermutationsTest() {
        Assertions.assertThat(CrackingCodingInterview8.allPermutations("abc")).isEmpty();
    }
}
