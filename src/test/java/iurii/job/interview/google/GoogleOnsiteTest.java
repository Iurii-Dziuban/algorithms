package iurii.job.interview.google;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GoogleOnsiteTest {

    @Test
    public void findRectangleArea() {
        assertThat(GoogleOnsite.findMaxRectangleLessOrEqualGivenCostValue_BruteForceWithMemoization(null, 3)).isEqualTo(0);
        assertThat(GoogleOnsite.findMaxRectangleLessOrEqualGivenCostValue_BruteForceWithMemoization(new int[][]{}, 3)).isEqualTo(0);
        assertThat(GoogleOnsite.findMaxRectangleLessOrEqualGivenCostValue_BruteForceWithMemoization(new int[][]{{}}, 3)).isEqualTo(0);
        assertThat(GoogleOnsite.findMaxRectangleLessOrEqualGivenCostValue_BruteForceWithMemoization(new int[][]{{}}, 3)).isEqualTo(0);

        int[][] easyExample = new int[][]{ {1,2,1,1,1},
                                           {2,1,2,5,2},
                                           {2,3,2,5,1},
                                           {2,2,4,2,2},
                                           {2,1,4,5,1}
        };

        int[][] hardExample = new int[][]{ {3,3,1,4,1},
                                           {2,1,1,5,2},
                                           {4,2,1,5,1},
                                           {2,1,1,2,2},
                                           {2,1,4,5,1}
        };

        assertThat(GoogleOnsite.findMaxRectangleLessOrEqualGivenCostValue_BruteForceWithMemoization(easyExample, 3)).isEqualTo(3);
        assertThat(GoogleOnsite.findMaxRectangleLessOrEqualGivenCostValue_BruteForceWithMemoization(hardExample, 7)).isEqualTo(6);

        // the best solution came so far (complex one)
        assertThat(GoogleOnsite.findMaxRectangleLessOrEqualGivenCostValue(easyExample, 3)).isEqualTo(3);
        assertThat(GoogleOnsite.findMaxRectangleLessOrEqualGivenCostValue(hardExample, 7)).isEqualTo(6);

        // finds not area but sum of area closest ( <= k ) to cost function :
        assertThat(GoogleOnsite.maxSumSubmatrix(easyExample, 3)).isEqualTo(3);
        assertThat(GoogleOnsite.maxSumSubmatrix(hardExample, 7)).isEqualTo(7);
    }

    @Test
    public void testLongestStrChain() {
        String[] words = new String[] {"a","b","ba","bca","bda","bdca"};

        assertThat(GoogleOnsite.longestStrChainTopDown(words)).isEqualTo(4);
        assertThat(GoogleOnsite.longestStrChainBottomUp(words)).isEqualTo(4);
    }

    @Test
    public void findPath() {
        int[][] easyExample = new int[][]{
                {0,1,1,1,1},
                {0,0,0,0,1},
                {1,1,1,0,1},
                {1,1,1,0,1},
                {1,1,1,0,0}
        };

        List<int[]> answer = new ArrayList<>();
        answer.add(new int[]{0,0});
        answer.add(new int[]{1,0});
        answer.add(new int[]{1,1});
        answer.add(new int[]{1,2});
        answer.add(new int[]{1,3});
        answer.add(new int[]{2,3});
        answer.add(new int[]{3,3});
        answer.add(new int[]{4,3});
        answer.add(new int[]{4,4});

        List<int[]> easyPath = GoogleOnsite.findPath(easyExample, new int[]{0, 0}, new int[]{4, 4});
        assertThat(easyPath).containsExactlyElementsOf(answer);

        int[][] complexExample = new int[][]{
                {0,1,0,0,0},
                {0,0,0,0,1},
                {1,0,1,0,0},
                {0,0,1,0,1},
                {0,0,1,0,0}
        };
        List<int[]> complexPath = GoogleOnsite.findPath(complexExample, new int[]{0, 0}, new int[]{4, 4});
        assertThat(complexPath).containsExactlyElementsOf(answer);
    }
}
