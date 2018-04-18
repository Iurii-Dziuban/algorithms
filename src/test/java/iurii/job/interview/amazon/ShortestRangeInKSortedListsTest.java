package iurii.job.interview.amazon;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShortestRangeInKSortedListsTest {

    @Test
    public void testLast() {
        List<Integer> list1 = Arrays.asList(1, 4, 8);
        List<Integer> list2 = Arrays.asList(2, 5, 8);
        List<Integer> list3 = Arrays.asList(3, 4, 8);
        List<List<Integer>> lists = Arrays.asList(list1, list2, list3);
        ShortestRangeInKSortedLists shortestRangeInKSortedLists = new ShortestRangeInKSortedLists();
        ShortestRangeInKSortedLists.Range range = shortestRangeInKSortedLists.findRange(lists);
        assertThat(range.getMin()).isEqualTo(8);
        assertThat(range.getMax()).isEqualTo(8);
    }

    @Test
    public void testMiddle() {
        List<Integer> list1 = Arrays.asList(1, 4, 6);
        List<Integer> list2 = Arrays.asList(2, 5, 8);
        List<Integer> list3 = Arrays.asList(3, 4, 7);
        List<List<Integer>> lists = Arrays.asList(list1, list2, list3);
        ShortestRangeInKSortedLists shortestRangeInKSortedLists = new ShortestRangeInKSortedLists();
        ShortestRangeInKSortedLists.Range range = shortestRangeInKSortedLists.findRange(lists);
        assertThat(range.getMin()).isEqualTo(4);
        assertThat(range.getMax()).isEqualTo(5);
    }

    @Test
    public void testWithPriorityQueueLast() {
        List<Integer> list1 = Arrays.asList(1, 4, 8);
        List<Integer> list2 = Arrays.asList(2, 5, 8);
        List<Integer> list3 = Arrays.asList(3, 4, 8);
        List<List<Integer>> lists = Arrays.asList(list1, list2, list3);
        ShortestRangeInKSortedLists shortestRangeInKSortedLists = new ShortestRangeInKSortedLists();
        ShortestRangeInKSortedLists.Range range = shortestRangeInKSortedLists.findRangeWithPriorityQueue(lists);
        assertThat(range.getMin()).isEqualTo(8);
        assertThat(range.getMax()).isEqualTo(8);
    }

    @Test
    public void testWithPriorityQueueMiddle() {
        List<Integer> list1 = Arrays.asList(1, 4, 6);
        List<Integer> list2 = Arrays.asList(2, 5, 7);
        List<Integer> list3 = Arrays.asList(3, 4, 8);
        List<List<Integer>> lists = Arrays.asList(list1, list2, list3);
        ShortestRangeInKSortedLists shortestRangeInKSortedLists = new ShortestRangeInKSortedLists();
        ShortestRangeInKSortedLists.Range range = shortestRangeInKSortedLists.findRangeWithPriorityQueue(lists);
        assertThat(range.getMin()).isEqualTo(4);
        assertThat(range.getMax()).isEqualTo(5);
    }
}
