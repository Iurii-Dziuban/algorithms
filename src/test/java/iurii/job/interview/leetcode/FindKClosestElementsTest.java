package iurii.job.interview.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class FindKClosestElementsTest {

    @Test
    public void testNotSortedWithPriorityQueue() {
        FindKClosestElements findKClosestElements = new FindKClosestElements();
        assertThat(findKClosestElements.findClosestElementsWithPriorityQueue(new int[]{1,2,3,4,5}, 4, 3))
                .containsExactly(1,2,3,4);

        assertThat(findKClosestElements.findClosestElementsWithPriorityQueue(new int[]{0,0,1,2,3,3,4,7,7,8}, 3, 5))
                .containsExactly(3, 3, 4);
    }

    @Test
    public void testSortedWithTwoPointers() {
        FindKClosestElements findKClosestElements = new FindKClosestElements();
        assertThat(findKClosestElements.findClosestElementsSortedWithTwoPointers(new int[]{1,2,3,4,5}, 0, 3))
                .isEmpty();
        assertThat(findKClosestElements.findClosestElementsSortedWithTwoPointers(new int[]{}, 2, 3))
                .isEmpty();
        assertThat(findKClosestElements.findClosestElementsSortedWithTwoPointers(null, 2, 3))
                .isEmpty();

        assertThat(findKClosestElements.findClosestElementsSortedWithTwoPointers(new int[]{1,2,3,4,5}, 4, 3))
                .containsExactly(1,2,3,4);

        assertThat(findKClosestElements.findClosestElementsSortedWithTwoPointers(new int[]{0,0,1,2,3,3,4,7,7,8}, 3, 5))
                .containsExactly(3, 3, 4);
    }

    @Test
    public void testWithCollectionSortingWithComparator() {
        FindKClosestElements findKClosestElements = new FindKClosestElements();
        assertThat(findKClosestElements.findClosestElementsWithSortingList(Arrays.asList(1,2,3,4,5), 0, 3))
                .isEmpty();
        assertThat(findKClosestElements.findClosestElementsWithSortingList(new ArrayList<>(), 2, 3))
                .isEmpty();
        assertThat(findKClosestElements.findClosestElementsWithSortingList(null, 2, 3))
                .isEmpty();

        assertThat(findKClosestElements.findClosestElementsWithSortingList(Arrays.asList(1,2,3,4,5), 4, 3))
                .containsExactly(1,2,3,4);

        assertThat(findKClosestElements.findClosestElementsWithSortingList(Arrays.asList(0,0,1,2,3,3,4,7,7,8), 3, 5))
                .containsExactly(3, 3, 4);
    }


}
