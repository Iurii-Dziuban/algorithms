package iurii.job.interview.leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FindSmallestLetterGreaterThanTargetTest {

    @Test
    public void testBinarySearchInSorted() {
        FindSmallestLetterGreaterThanTarget findSmallestLetterGreaterThanTarget = new FindSmallestLetterGreaterThanTarget();
        assertThat(findSmallestLetterGreaterThanTarget.nextGreatestLetterBinarySearchInSorted
                (new char[]{}, 'a')).isEqualTo('!');
        assertThat(findSmallestLetterGreaterThanTarget.nextGreatestLetterBinarySearchInSorted
                (null, 'a')).isEqualTo('!');
        assertThat(findSmallestLetterGreaterThanTarget.nextGreatestLetterBinarySearchInSorted
                (new char[]{'c', 'f', 'j'}, 'a')).isEqualTo('c');
        assertThat(findSmallestLetterGreaterThanTarget.nextGreatestLetterBinarySearchInSorted
                (new char[]{'c', 'f', 'j'}, 'c')).isEqualTo('f');
        assertThat(findSmallestLetterGreaterThanTarget.nextGreatestLetterBinarySearchInSorted
                (new char[]{'c', 'f', 'j'}, 'd')).isEqualTo('f');
        assertThat(findSmallestLetterGreaterThanTarget.nextGreatestLetterBinarySearchInSorted
                (new char[]{'c', 'f', 'j'}, 'g')).isEqualTo('j');
        assertThat(findSmallestLetterGreaterThanTarget.nextGreatestLetterBinarySearchInSorted
                (new char[]{'c', 'f', 'j'}, 'j')).isEqualTo('c');
        assertThat(findSmallestLetterGreaterThanTarget.nextGreatestLetterBinarySearchInSorted
                (new char[]{'c', 'f', 'j'}, 'k')).isEqualTo('c');
    }

    @Test
    public void testLinearSearchInSorted() {
        FindSmallestLetterGreaterThanTarget findSmallestLetterGreaterThanTarget = new FindSmallestLetterGreaterThanTarget();
        assertThat(findSmallestLetterGreaterThanTarget.nextGreatestLetterLinearSearchInSorted
                (new char[]{}, 'a')).isEqualTo('!');
        assertThat(findSmallestLetterGreaterThanTarget.nextGreatestLetterLinearSearchInSorted
                (null, 'a')).isEqualTo('!');
        assertThat(findSmallestLetterGreaterThanTarget.nextGreatestLetterLinearSearchInSorted
                (new char[]{'c', 'f', 'j'}, 'a')).isEqualTo('c');
        assertThat(findSmallestLetterGreaterThanTarget.nextGreatestLetterLinearSearchInSorted
                (new char[]{'c', 'f', 'j'}, 'c')).isEqualTo('f');
        assertThat(findSmallestLetterGreaterThanTarget.nextGreatestLetterLinearSearchInSorted
                (new char[]{'c', 'f', 'j'}, 'd')).isEqualTo('f');
        assertThat(findSmallestLetterGreaterThanTarget.nextGreatestLetterLinearSearchInSorted
                (new char[]{'c', 'f', 'j'}, 'g')).isEqualTo('j');
        assertThat(findSmallestLetterGreaterThanTarget.nextGreatestLetterLinearSearchInSorted
                (new char[]{'c', 'f', 'j'}, 'j')).isEqualTo('c');
        assertThat(findSmallestLetterGreaterThanTarget.nextGreatestLetterLinearSearchInSorted
                (new char[]{'c', 'f', 'j'}, 'k')).isEqualTo('c');
    }

    @Test
    public void testLinearSearchInNonSorted() {
        FindSmallestLetterGreaterThanTarget findSmallestLetterGreaterThanTarget = new FindSmallestLetterGreaterThanTarget();
        assertThat(findSmallestLetterGreaterThanTarget.nextGreatestLetterGeneral
                (new char[]{}, 'a')).isEqualTo('!');
        assertThat(findSmallestLetterGreaterThanTarget.nextGreatestLetterGeneral
                (null, 'a')).isEqualTo('!');
        assertThat(findSmallestLetterGreaterThanTarget.nextGreatestLetterGeneral
                (new char[]{'c', 'f', 'j'}, 'a')).isEqualTo('c');
        assertThat(findSmallestLetterGreaterThanTarget.nextGreatestLetterGeneral
                (new char[]{'c', 'f', 'j'}, 'c')).isEqualTo('f');
        assertThat(findSmallestLetterGreaterThanTarget.nextGreatestLetterGeneral
                (new char[]{'c', 'f', 'j'}, 'd')).isEqualTo('f');
        assertThat(findSmallestLetterGreaterThanTarget.nextGreatestLetterGeneral
                (new char[]{'c', 'f', 'j'}, 'g')).isEqualTo('j');
        assertThat(findSmallestLetterGreaterThanTarget.nextGreatestLetterGeneral
                (new char[]{'c', 'f', 'j'}, 'j')).isEqualTo('c');
        assertThat(findSmallestLetterGreaterThanTarget.nextGreatestLetterGeneral
                (new char[]{'c', 'f', 'j'}, 'k')).isEqualTo('c');
    }
}
