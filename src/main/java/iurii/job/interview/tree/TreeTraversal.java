package iurii.job.interview.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * Created by iurii.dziuban on 23/08/2017.
 */
public class TreeTraversal {

    // Depth first search with Stack pre order
    public int traversePreOrderAndReturnSumStack(Node node) {
        assert node != null;
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        int sum = 0;
        while(!stack.isEmpty()) {
            Node element = stack.pop();
            sum += element.getValue();
            stack.addAll(element.getChildren());
        }
        return sum;
    }

    // Bread first search with post order
    public int traversePostOrderAndReturnSumStack(Node node) {
        assert node != null;
        Stack<Node> stack = new Stack<>();
        List<Node> childrenStack = new ArrayList<>();
        childrenStack.add(node);
        int sum = 0;
        while(!childrenStack.isEmpty()) {
            List<Node> newChildrenStack = new ArrayList<>();
            for(Node child : childrenStack) {
                stack.push(child);
                newChildrenStack.addAll(child.getChildren());
            }
            childrenStack = newChildrenStack;
        }
        while(!stack.isEmpty()) {
            Node element = stack.pop();
            sum += element.getValue();
        }
        return sum;
    }

    // recursive first sum
    public int traversePreOrderAndReturnSumRecursively(Node node) {
        final int[] sum = {node.getValue()};
        node.getChildren().forEach(child -> {
            sum[0] += traversePreOrderAndReturnSumRecursively(child);
        });
        return sum[0];
    }

    // recursive first recurse then sum
    public int traversePostOrderAndReturnSumRecursively(Node node) {
        final int[] sum = {0};
        node.getChildren().forEach(child -> {
            sum[0] += traversePostOrderAndReturnSumRecursively(child) ;
        });
        return sum[0] + node.getValue();
    }

    public int traverseStreamAndReturnSumRecursively(Node node) {
        return flatten(node).map(Node::getValue).reduce(0, (a, b) -> a + b);
    }

    private Stream<Node> flatten(Node node) {
        return Stream.concat(Stream.of(node), node.getChildren().stream().flatMap(this::flatten));
    }
    public int traverseStreamOneLine(Node node) {
        return node.getChildren().stream()
                .flatMap(this::flatten)
                .map(Node::getValue)
                .reduce(node.getValue(), (a, b) -> a + b);
    }

}
