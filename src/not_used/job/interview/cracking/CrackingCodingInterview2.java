package iurii.job.interview.cracking;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * LinkedLists
 * @author Iurii
 */
public class CrackingCodingInterview2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);list.add(2);list.add(2);list.add(2);list.add(2);
        removeDuplicates2(list);
        System.out.println(list);
        
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        list1.add(1);list1.add(2);list1.add(3);list1.add(4);list1.add(5);
        System.out.println(nthElementToEnd(list1, 2));
        
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list2.add(1);list2.add(2);list2.add(3);list2.add(4);list2.add(5);
        deleteMedian(list2);
        System.out.println(list2);
        
        LinkedList<Integer> add1 = new LinkedList<Integer>();
        add1.add(3);add1.add(1);add1.add(5);
        LinkedList<Integer> add2 = new LinkedList<Integer>();
        add2.add(5);add2.add(9);add2.add(2);
        System.out.println(sumUp(add1, add2));
    }
    
    /**
     * 2.1 remove duplicates of unsorted list. Using HashTable we can check if duplicate in O(1) time.
     * Algorithm is O(n)
     * @param list
     */
    public static void removeDuplicates(LinkedList<Integer> list) {
        Set<Integer> set = new HashSet<Integer>();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int el = iterator.next();
            if (set.contains(el)) {
                iterator.remove();
            }
            set.add(el);
        }
    }
    
    /**
     * 2.1 remove duplicates of unsorted list. Algorithm is O(n^2). Memory O(1).
     * @param list
     */
    public static void removeDuplicates2(LinkedList<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            int el = iterator.next();
            Iterator<Integer> checker = list.iterator();
            boolean isFound = false;
            for (int i = 0; i < index; i++) {
                int checkEl = checker.next();
                if (checkEl == el) {
                    iterator.remove();
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                index++;
            }
        }
    }
    
    /**
     * 2.2 Find n-th element in single linked list. O(n) time. 2 pointers. 
     * p1-p2 = n elements. increase pointers by 1.
     * @param list
     */
    public static int nthElementToEnd(LinkedList<Integer> list, int n) {
        if (list.size() <= n) {
            return -1;
        }
        Iterator<Integer> pointer1 = list.iterator();
        for (int i = 0; i <= n; i++) {
            pointer1.next();
        }
        Iterator<Integer> pointer2 = list.iterator();
        while (pointer1.hasNext()) {
            pointer1.next();
            pointer2.next();
        }
        return pointer2.next();
    }
    
    /**
     * 2.3 Find and delete median in single linked list. O(n) time. 2 pointers. 
     * Increase one pointer by 2 and second by 1.
     * @param list
     */
    public static void deleteMedian(LinkedList<Integer> list) {
        Iterator<Integer> pointer1 = list.iterator();
        Iterator<Integer> pointer2 = list.iterator();
        while (pointer1.hasNext()) {
            pointer1.next();
            pointer2.next();
            if (pointer1.hasNext()) {
                pointer1.next();
            } else {
                pointer2.remove();
            }
        }
    }
    
    /**
     * 2.4 Sum up two numbers. Each number as Linked list of digit. Return as Linked list. O(n) time.
     */
    public static LinkedList<Integer> sumUp(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        Iterator<Integer> pointer1 = list1.iterator();
        Iterator<Integer> pointer2 = list2.iterator();
        LinkedList<Integer> result = new LinkedList<Integer>();
        int caryOver = 0;
        while (pointer1.hasNext() || pointer2.hasNext()) {
            int p1 = 0, p2 = 0;
            if (pointer1.hasNext()) {
                p1 = pointer1.next();
            }
            if (pointer2.hasNext()) {
                p2 = pointer2.next();
            }
            int sum = p1+p2+caryOver;
            caryOver = sum / 10;
            result.add(sum % 10);
        }
        if (caryOver == 1) {
            result.add(1);
        }
        return result;
    }
    
    
    /**
     * 2.5 Given corrupted linked list which contains circle. Find first element of circle.
     * Use 2 pointers with 2x and 1x speed. When they are equal start from beginning and make 1x steps until equal.
     * Another way is to use Hash Set to find equal elements while making steps.
     */
    public static int findFirstCirleElement(LinkedList<Integer> list) {
        return 0;
    }

}
