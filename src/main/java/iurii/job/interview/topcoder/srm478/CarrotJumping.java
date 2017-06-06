package iurii.job.interview.topcoder.srm478;

import java.util.LinkedList;
import java.util.Queue;

public class CarrotJumping {

    public static void main(String[] args) {
        System.out.println(new CarrotJumping());
    }

    public int theJump(int init) {
        if (init % 1000000007 == 0) {
            return 0;
        }
        int maxFirst = (Integer.MAX_VALUE - 3) / 4;
        int maxSecond = (Integer.MAX_VALUE - 7) / 8;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(init);
        for (int i = 0; i < 100000; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int value = queue.remove();
                if (value <= maxFirst) {
                    int item = 4 * value + 3;
                    queue.add(item);
                    if (item % 1000000007 == 0) {
                        return i + 1;
                    }
                }
                if (value <= maxSecond) {
                    int item = 8 * value + 7;
                    queue.add(item);
                    if (item % 1000000007 == 0) {
                        return i + 1;
                    }
                }
            }
        }
        return -1;
    }
}
