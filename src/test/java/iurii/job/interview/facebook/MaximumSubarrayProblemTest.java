package iurii.job.interview.facebook;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 15/12/2017.
 */
public class MaximumSubarrayProblemTest {

    @Test
    public void testKadaneAlgo() {
        long max = new MaximumSubarrayProblem().kadaneOn(new int[]{1,-3,2,1,-1});
        assertThat(max).isEqualByComparingTo(3L);
        max = new MaximumSubarrayProblem().kadaneOn(new int[]{-5,-3,-2,-1,-4});
        assertThat(max).isEqualByComparingTo(-1L);
        assertThat(new MaximumSubarrayProblem().kadaneOn(new int[]{})).isEqualByComparingTo(0L);
        assertThat(new MaximumSubarrayProblem().kadaneOn(null)).isEqualByComparingTo(0L);
    }

    @Test
    public void testDynamicApproach() {
        long max = new MaximumSubarrayProblem().dynamicOn(new int[]{1,-3,2,1,-1});
        assertThat(max).isEqualByComparingTo(3L);
        max = new MaximumSubarrayProblem().dynamicOn(new int[]{-5,-3,-2,-1,-4});
        assertThat(max).isEqualByComparingTo(-1L);
        assertThat(new MaximumSubarrayProblem().dynamicOn(new int[]{})).isEqualByComparingTo(0L);
        assertThat(new MaximumSubarrayProblem().dynamicOn(null)).isEqualByComparingTo(0L);
    }
}
