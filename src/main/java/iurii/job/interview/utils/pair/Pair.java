package iurii.job.interview.utils.pair;

/**
 * Created by iurii.dziuban on 06/06/2017.
 */
public class Pair {
    private final int first;
    private final int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
    public int getFirst() {
        return first;
    }
    public int getSecond() {
        return second;
    }

    public String toString() {
        return "[" + first + "," + second + "]";
    }
}
