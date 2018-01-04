package iurii.job.interview.recursion;

import java.util.LinkedList;

public class Sum {

    public int sum (LinkedList<Integer> list) {
        return (list == null || list.isEmpty()) ? 0 : list.remove() + sum (list);
    }

    public int sumTailRec (LinkedList<Integer> list) {
        return sumTailRec(list, 0);
    }

    private int sumTailRec (LinkedList<Integer> list, int sum) {
        return (list == null || list.isEmpty()) ? sum :  sumTailRec(list, sum + list.remove());
    }

    public int sumFoldLeft(LinkedList<Integer> list) {
        return list == null ? 0 : list.stream().reduce(0, Integer::sum, Integer::sum);
    }

    public int sumStream(LinkedList<Integer> list) {
        return list == null ? 0 : list.stream().mapToInt(Integer::intValue).sum();
    }
}
