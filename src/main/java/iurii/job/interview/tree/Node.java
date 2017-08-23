package iurii.job.interview.tree;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by iurii.dziuban on 23/08/2017.
 */
public class Node {

    private final int value;
    private final Collection<Node> children = new ArrayList<>();

    public Node(int value, Collection<Node> children) {
        this.value = value;
        this.children.addAll(children);
    }

    public int getValue() {
        return value;
    }

    public Collection<Node> getChildren() {
        return children;
    }
}
