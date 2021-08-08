package iurii.job.interview.google;

import org.junit.Test;
import org.mockito.internal.util.collections.Sets;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class GoogleOnsite2Test {

    private final GoogleOnsite2 google = new GoogleOnsite2();

    @Test
    public void findAllPossibleMessages() {
        // given
        Set<String> dictionaryWords = Sets.newSet("sweet", "escape", "sw", "ete", "scape");
        String message = "sw  t  scap ";

        // when
        List<String> allPossibleMessages = google.findAllPossibleMessages(message, dictionaryWords);

        //then
        assertThat(allPossibleMessages).containsExactlyInAnyOrder(
            "sweet escape",
            "sw ete scape"
        );
    }

    @Test
    public void deleteAllEvenPositionNodes4() {
        GoogleOnsite2.Node node0 = new GoogleOnsite2.Node();
        GoogleOnsite2.Node node1 = new GoogleOnsite2.Node();
        GoogleOnsite2.Node node2 = new GoogleOnsite2.Node();
        GoogleOnsite2.Node node3 = new GoogleOnsite2.Node();

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node0;

        node0.val = 0;
        node1.val = 1;
        node2.val = 2;
        node3.val = 3;

        GoogleOnsite2.Node node = GoogleOnsite2.deleteAllEvenPositionNodes(node0);

        assertThat(node).isEqualTo(node1);
        assertThat(node.next).isEqualTo(node3);
        assertThat(node3.next).isEqualTo(node);
    }

    @Test
    public void deleteAllEvenPositionNodes3() {
        GoogleOnsite2.Node node0 = new GoogleOnsite2.Node();
        GoogleOnsite2.Node node1 = new GoogleOnsite2.Node();
        GoogleOnsite2.Node node2 = new GoogleOnsite2.Node();

        node0.next = node1;
        node1.next = node2;
        node2.next = node0;

        node0.val = 0;
        node1.val = 1;
        node2.val = 2;

        GoogleOnsite2.Node node = GoogleOnsite2.deleteAllEvenPositionNodes(node0);

        assertThat(node).isEqualTo(node1);
        assertThat(node.next).isEqualTo(node1);
    }

    @Test
    public void deleteAllOddPositionNodes4() {
        GoogleOnsite2.Node node0 = new GoogleOnsite2.Node();
        GoogleOnsite2.Node node1 = new GoogleOnsite2.Node();
        GoogleOnsite2.Node node2 = new GoogleOnsite2.Node();
        GoogleOnsite2.Node node3 = new GoogleOnsite2.Node();

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node0;

        node0.val = 0;
        node1.val = 1;
        node2.val = 2;
        node3.val = 3;

        GoogleOnsite2.deleteAllOddPositionNodes(node0);

        assertThat(node0.next).isEqualTo(node2);
        assertThat(node2.next).isEqualTo(node0);
    }

    @Test
    public void deleteAllOddPositionNodes3() {
        GoogleOnsite2.Node node0 = new GoogleOnsite2.Node();
        GoogleOnsite2.Node node1 = new GoogleOnsite2.Node();
        GoogleOnsite2.Node node2 = new GoogleOnsite2.Node();

        node0.next = node1;
        node1.next = node2;
        node2.next = node0;

        node0.val = 0;
        node1.val = 1;
        node2.val = 2;

        GoogleOnsite2.deleteAllOddPositionNodes(node0);

        assertThat(node0.next).isEqualTo(node2);
        assertThat(node2.next).isEqualTo(node0);
    }

    @Test
    public void merge() {
        /*
         * example: [1,3 e] [4,8 e], [5, 11 e], [13, 15 e]
         * dnd : [10, 14, dnd]
         * answer: [1,3 e][4,10 e] [10, 14 dnd][14, 15 e];
         */
        List<GoogleOnsite2.Interval> intervals = Arrays.asList(
                new GoogleOnsite2.Interval(5, 11, GoogleOnsite2.IntervalType.E),
                new GoogleOnsite2.Interval(13, 15, GoogleOnsite2.IntervalType.E),
                new GoogleOnsite2.Interval(1, 2, GoogleOnsite2.IntervalType.E),
                new GoogleOnsite2.Interval(4, 8, GoogleOnsite2.IntervalType.E),
                new GoogleOnsite2.Interval(1, 3, GoogleOnsite2.IntervalType.E)
        );

        GoogleOnsite2.Interval dnd = new GoogleOnsite2.Interval(10, 14, GoogleOnsite2.IntervalType.DND);

        List<GoogleOnsite2.Interval> merged = google.merge(intervals, dnd);

        assertThat(merged).hasSize(4);

        assertThat(merged.get(0).a).isEqualTo(1);
        assertThat(merged.get(0).b).isEqualTo(3);
        assertThat(merged.get(0).type).isEqualTo(GoogleOnsite2.IntervalType.E);

        assertThat(merged.get(1).a).isEqualTo(4);
        assertThat(merged.get(1).b).isEqualTo(10);
        assertThat(merged.get(1).type).isEqualTo(GoogleOnsite2.IntervalType.E);

        assertThat(merged.get(2).a).isEqualTo(10);
        assertThat(merged.get(2).b).isEqualTo(14);
        assertThat(merged.get(2).type).isEqualTo(GoogleOnsite2.IntervalType.DND);

        assertThat(merged.get(3).a).isEqualTo(14);
        assertThat(merged.get(3).b).isEqualTo(15);
        assertThat(merged.get(3).type).isEqualTo(GoogleOnsite2.IntervalType.E);
    }
}