package iurii.job.interview.cracking;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.LinkedList;

import static iurii.job.interview.cracking.CrackingCodingInterview2.deleteMedian;
import static iurii.job.interview.cracking.CrackingCodingInterview2.findFirstCirleElement;
import static iurii.job.interview.cracking.CrackingCodingInterview2.nthElementToEnd;
import static iurii.job.interview.cracking.CrackingCodingInterview2.removeDuplicates;
import static iurii.job.interview.cracking.CrackingCodingInterview2.removeDuplicates2;
import static iurii.job.interview.cracking.CrackingCodingInterview2.sumUp;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * LinkedLists
 *
 * @author Iurii
 */
public class CrackingCodingInterview2Test {

    @Test
    public void creation(){
        new CrackingCodingInterview2();
    }

    @Test
    public void removeDuplicatesTest() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        removeDuplicates(list);
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
        removeDuplicates2(list);
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
        assertThat(nthElementToEnd(list1, 2)).isEqualTo(3);
        assertThat(nthElementToEnd(list1, 7)).isEqualTo(-1);
    }

    @Test
    public void deleteMedianTest() {
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        deleteMedian(list2);
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
        assertThat(sumUp(add1, add2)).containsExactly(8,0,8);

        LinkedList<Integer> add11 = new LinkedList<Integer>();
        add11.add(3);
        add11.add(1);
        add11.add(5);
        LinkedList<Integer> add22 = new LinkedList<Integer>();
        add22.add(5);
        add22.add(9);
        add22.add(4);
        assertThat(sumUp(add11, add22)).containsExactly(8,0,0,1);
    }

    // Modify
    @Test
    public void findFirstCircleElementTest() {
        LinkedList<Integer> add1 = new LinkedList<Integer>();
        add1.add(3);
        add1.add(1);
        add1.add(5);
        assertThat(findFirstCirleElement(add1)).isEqualTo(0);
    }
}
