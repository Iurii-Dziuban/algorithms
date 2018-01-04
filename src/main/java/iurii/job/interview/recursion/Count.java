package iurii.job.interview.recursion;

import java.util.LinkedList;

public class Count {

    public int count(LinkedList<Integer> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        } else {
            list.remove();
            return 1 + count (list);
        }
    }

    public int countTailRec(LinkedList<Integer> list) {
        return countTailRec(list, 0);
    }

    private int countTailRec (LinkedList<Integer> list, int count) {
        if (list == null || list.isEmpty()) {
            return count;
        } else {
            list.remove();
            return countTailRec (list, count + 1);
        }
    }

    public int countFoldLeft(LinkedList<Integer> list) {
        return (list == null) ? 0 : list.stream().map(e -> 1).reduce(0, Integer::sum, Integer::sum);
    }

    public long countStream(LinkedList<Integer> list) {
        return list == null ? 0 : list.stream().mapToInt(Integer::intValue).count();
    }
}
