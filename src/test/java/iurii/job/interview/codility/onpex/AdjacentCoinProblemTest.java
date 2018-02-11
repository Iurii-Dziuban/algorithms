package iurii.job.interview.codility.onpex;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AdjacentCoinProblemTest {

    @Test
    public void test() {
        AdjacentCoinProblem adjacentCoinProblem = new AdjacentCoinProblem();
        assertThat(adjacentCoinProblem.solution(new int[]{1})).isEqualTo(0);
        assertThat(adjacentCoinProblem.solution(new int[]{0,0})).isEqualTo(0);
        assertThat(adjacentCoinProblem.solution(new int[]{0,1})).isEqualTo(1);
        assertThat(adjacentCoinProblem.solution(new int[]{1,1,1})).isEqualTo(1);
        assertThat(adjacentCoinProblem.solution(new int[]{1,0,1})).isEqualTo(2);
        assertThat(adjacentCoinProblem.solution(new int[]{0,1,1})).isEqualTo(2);
        assertThat(adjacentCoinProblem.solution(new int[]{1,1,0})).isEqualTo(2);
    }
}
