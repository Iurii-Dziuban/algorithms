package iurii.job.interview.cracking;

import org.junit.Test;

import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * LinkedLists
 *
 * @author Iurii
 */
public class CrackingCodingInterview2Test {

    CrackingCodingInterview2 cci2 = new CrackingCodingInterview2();

    @Test
    public void removeDuplicatesTest() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        cci2.removeDuplicates(list);
        assertThat(list).containsExactly(1,2);
    }

    @Test
    public void removeDuplicates2Test() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        cci2.removeDuplicates2(list);
        assertThat(list).containsExactly(1,2);
    }

    @Test
    public void nthElementToEndTest() {
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        assertThat(cci2.nthElementToEnd(list1, 2)).isEqualTo(3);
        assertThat(cci2.nthElementToEnd(list1, 7)).isEqualTo(-1);
    }

    @Test
    public void deleteMedianTest() {
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        cci2.deleteMedian(list2);
        assertThat(list2).containsExactly(1,2,4,5);
    }

    @Test
    public void sumUpTest() {
        LinkedList<Integer> add1 = new LinkedList<Integer>();
        add1.add(3);
        add1.add(1);
        add1.add(5);
        LinkedList<Integer> add2 = new LinkedList<Integer>();
        add2.add(5);
        add2.add(9);
        add2.add(2);
        assertThat(cci2.sumUp(add1, add2)).containsExactly(8,0,8);

        LinkedList<Integer> add11 = new LinkedList<Integer>();
        add11.add(3);
        add11.add(1);
        add11.add(5);
        LinkedList<Integer> add22 = new LinkedList<Integer>();
        add22.add(5);
        add22.add(9);
        add22.add(4);
        assertThat(cci2.sumUp(add11, add22)).containsExactly(8,0,0,1);
    }

    // Modify
    @Test
    public void findFirstCircleElementTest() {
        LinkedList<Integer> add1 = new LinkedList<Integer>();
        add1.add(3);
        add1.add(1);
        add1.add(5);
        assertThat(cci2.findFirstCirleElement(add1)).isEqualTo(0);
    }
}
