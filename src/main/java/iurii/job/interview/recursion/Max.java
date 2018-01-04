package iurii.job.interview.recursion;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Max {

    public int max (LinkedList<Integer> list) {
        if (list == null || list.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            int head = list.remove();
            return list.isEmpty() ? head : Math.max(head, max(list));
        }
    }

    public int maxTailRec (LinkedList<Integer> list) {
        if (list == null || list.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return maxTailRec(list, list.remove());
        }
    }

    private int maxTailRec (LinkedList<Integer> list, int max) {
        return (list == null || list.isEmpty()) ? max :  maxTailRec(list, Math.max(max, list.remove()));
    }

    public int maxFoldLeft(LinkedList<Integer> list) {
        if (list == null || list.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return list.stream().reduce(list.remove(), Integer::max, Integer::max);
        }
    }

    public int maxStream(LinkedList<Integer> list) {
        if (list == null || list.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return list.stream().mapToInt(Integer::intValue).max().orElseThrow(NoSuchElementException::new);
        }
    }
}
