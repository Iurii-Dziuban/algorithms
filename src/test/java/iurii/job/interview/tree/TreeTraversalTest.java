package iurii.job.interview.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 23/08/2017.
 */
public class TreeTraversalTest {

    @Test
    public void test() {
        Node root = new Node(2,
                new ArrayList<Node>(){{
                    add(new Node(13, new ArrayList<Node>() {{add(new Node(7, Collections.emptyList()));
                    add(new Node(3, new ArrayList<Node>() {{add(new Node(5, Collections.emptyList()));}}
                    ));
                }}));}});

        TreeTraversal treeTraversal = new TreeTraversal();
        assertThat(treeTraversal.traversePostOrderAndReturnSumRecursively(root)).isEqualTo(30);
        assertThat(treeTraversal.traversePreOrderAndReturnSumRecursively(root)).isEqualTo(30);
        assertThat(treeTraversal.traversePostOrderAndReturnSumStack(root)).isEqualTo(30);
        assertThat(treeTraversal.traversePreOrderAndReturnSumStack(root)).isEqualTo(30);
        assertThat(treeTraversal.traverseStreamAndReturnSumRecursively(root)).isEqualTo(30);
        assertThat(treeTraversal.traverseStreamOneLine(root)).isEqualTo(30);
    }
}
