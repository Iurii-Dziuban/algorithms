package iurii.job.interview.booking_com.pre_on_site;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 19/07/2017.
 */
public class PathsFromRootTest {

    /**
     *      2
     *    /   \
     *   1     2
     *  / \   /  \
     * 3  2   1   2
     *
     * k= 5 -> {2,1,2} and {2,2,1}
     */
    @Test
    public void test() {
        PathsFromRoot.Node node_2_0 = new PathsFromRoot.Node(null, null, 3);
        PathsFromRoot.Node node_2_1 = new PathsFromRoot.Node(null, null, 2);
        PathsFromRoot.Node node_2_2 = new PathsFromRoot.Node(null, null, 1);
        PathsFromRoot.Node node_2_3 = new PathsFromRoot.Node(null, null, 2);

        PathsFromRoot.Node node_1_0 = new PathsFromRoot.Node(node_2_0, node_2_1, 1);
        PathsFromRoot.Node node_1_1 = new PathsFromRoot.Node(node_2_2, node_2_3, 2);

        PathsFromRoot.Node node_0_0 = new PathsFromRoot.Node(node_1_0, node_1_1, 2);

        node_1_0.setTop(node_0_0);
        node_1_1.setTop(node_0_0);

        node_2_0.setTop(node_1_0);
        node_2_1.setTop(node_1_0);

        node_2_2.setTop(node_1_1);
        node_2_3.setTop(node_1_1);

        List<List<Integer>> paths = new PathsFromRoot().findPathsEqualK(node_0_0, 5);

        assertThat(paths.size()).isEqualTo(2);
        assertThat(paths).contains(Arrays.asList(2,1,2));
        assertThat(paths).contains(Arrays.asList(2,2,1));
    }

}
