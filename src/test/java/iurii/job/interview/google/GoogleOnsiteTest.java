package iurii.job.interview.google;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GoogleOnsiteTest {

    @Test
    public void findRectangleArea() {
        assertThat(GoogleOnsite.findMaxRectangleLessOrEqualGivenCostValue(null, 3)).isEqualTo(0);
        assertThat(GoogleOnsite.findMaxRectangleLessOrEqualGivenCostValue(new int[][]{}, 3)).isEqualTo(0);
        assertThat(GoogleOnsite.findMaxRectangleLessOrEqualGivenCostValue(new int[][]{{}}, 3)).isEqualTo(0);
        assertThat(GoogleOnsite.findMaxRectangleLessOrEqualGivenCostValue(new int[][]{{}}, 3)).isEqualTo(0);

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

        assertThat(GoogleOnsite.findMaxRectangleLessOrEqualGivenCostValue(easyExample, 3)).isEqualTo(3);
        assertThat(GoogleOnsite.findMaxRectangleLessOrEqualGivenCostValue(hardExample, 7)).isEqualTo(6);
    }
}
