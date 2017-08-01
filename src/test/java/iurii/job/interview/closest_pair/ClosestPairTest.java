package iurii.job.interview.closest_pair;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 31/07/2017.
 */
public class ClosestPairTest {

    @Test
    public void test() {
        ClosestPair.Pair[] pairs = new ClosestPair.Pair[]{new ClosestPair.Pair(0, 0),
                new ClosestPair.Pair(0, 5),
                new ClosestPair.Pair(2, 0),
                new ClosestPair.Pair(5, 0),
                new ClosestPair.Pair(5, 5),
                new ClosestPair.Pair(3, 5),
                new ClosestPair.Pair(100, 100),
                new ClosestPair.Pair(3, 1)};
        ClosestPair.Pair[] brute = ClosestPair.shortestBruteForce(pairs);
        assertThat(brute[0]).isEqualTo(new ClosestPair.Pair(3,1));
        assertThat(brute[1]).isEqualTo(new ClosestPair.Pair(2,0));

        ClosestPair.Pair[] nlogn = ClosestPair.closestPair(pairs);
        assertThat(nlogn[0]).isEqualTo(new ClosestPair.Pair(3,1));
        assertThat(nlogn[1]).isEqualTo(new ClosestPair.Pair(2,0));
    }
}
