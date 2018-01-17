package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FindKClosestElementsTest {

    @Test
    public void test() {
        FindKClosestElements findKClosestElements = new FindKClosestElements();
        assertThat(findKClosestElements.findClosestElements(new int[]{1,2,3,4,5}, 4, 3))
                .containsExactly(1,2,3,4);

        assertThat(findKClosestElements.findClosestElements(new int[]{0,0,1,2,3,3,4,7,7,8}, 3, 5))
                .containsExactly(3, 3, 4);
    }
}
