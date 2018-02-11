package iurii.job.interview.codility.onpex;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestSubarrayDifferenceMaxOneTest {

    @Test
    public void test () {
        LongestSubarrayDifferenceMaxOne longestSubarrayDifferenceMaxOne = new LongestSubarrayDifferenceMaxOne();

        assertThat(longestSubarrayDifferenceMaxOne.solution(new int[]{1,2,2,2,3,3,3})).isEqualTo(6);
        assertThat(longestSubarrayDifferenceMaxOne.solution(new int[]{0,0,1,1,3,3,3})).isEqualTo(4);
        assertThat(longestSubarrayDifferenceMaxOne.solution(new int[]{1,2,3,4,5,5,6,7})).isEqualTo(3);
        assertThat(longestSubarrayDifferenceMaxOne.solution(new int[]{})).isEqualTo(0);
        assertThat(longestSubarrayDifferenceMaxOne.solution(new int[]{1})).isEqualTo(1);
    }
}
