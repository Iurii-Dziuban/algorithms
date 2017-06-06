package iurii.job.interview.dynamic_programming;

/**
 * Item of knapsack.
 * Value is good thing, that we try to make greater.
 * Weight is bad thing, that we can not put item in knapsack if weight is too big.
 */
public class KnapsackItem {
    private final int value;
    private final int weight;

    public KnapsackItem(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return "[weight = " + weight + ", value=" + value + "]";
    }

}
