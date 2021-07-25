package iurii.job.interview.facebook;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FacebookInterviewTest {

    @Test
    public void testCopyRandomList() {
        FacebookInterview facebookInterview = new FacebookInterview();
        FacebookInterview.Node node1 = new FacebookInterview.Node(1);
        FacebookInterview.Node node2 = new FacebookInterview.Node(2);
        FacebookInterview.Node node3 = new FacebookInterview.Node(3);
        node1.next = node2;
        node2.next = node3;
        node2.random = node1;
        node3.random = node2;

        FacebookInterview.Node newNode = facebookInterview.copyRandomList(node1);
        assertThat(newNode).isNotEqualTo(node1);
        assertThat(newNode.val).isEqualTo(node1.val);
        assertThat(newNode.random).isNull();
        FacebookInterview.Node new2 = newNode.next;
        assertThat(new2).isNotEqualTo(node2);
        assertThat(new2.val).isEqualTo(node2.val);
        assertThat(new2.random).isEqualTo(newNode);
        FacebookInterview.Node new3 = new2.next;
        assertThat(new3).isNotEqualTo(node3);
        assertThat(new3.val).isEqualTo(node3.val);
        assertThat(new3.next).isNull();
        assertThat(new3.random).isEqualTo(new2);

    }

    @Test
    public void testFindKSmallest() {
        int[] arr =  new int[] {5,7,8,9,6,2,1,4,3};
        FacebookInterview facebookInterview = new FacebookInterview();

        // when / then
        assertThat(facebookInterview.findKSmallest(arr, 1)).isEqualTo(1);
        assertThat(facebookInterview.findKSmallest(arr, 2)).isEqualTo(2);
        assertThat(facebookInterview.findKSmallest(arr, 3)).isEqualTo(3);
        assertThat(facebookInterview.findKSmallest(arr, 4)).isEqualTo(4);
        assertThat(facebookInterview.findKSmallest(arr, 5)).isEqualTo(5);
        assertThat(facebookInterview.findKSmallest(arr, 6)).isEqualTo(6);
        assertThat(facebookInterview.findKSmallest(arr, 7)).isEqualTo(7);
        assertThat(facebookInterview.findKSmallest(arr, 8)).isEqualTo(8);
        assertThat(facebookInterview.findKSmallest(arr, 9)).isEqualTo(9);
        assertThat(facebookInterview.findKSmallest(arr, 10)).isEqualTo(-1);

    }
    @Test
    public void testMinNumberOfFoodPieces() {
        FacebookInterview interview = new FacebookInterview();

        // when / then
        assertThat(interview.minNumberOfFoodPieces(new int[]{1, 3, 2, 2, 1}))
            // expected {1, 2, 1, 2, 1 } => sum = 7
            .isEqualTo(7);

        assertThat(interview.minNumberOfFoodPieces(new int[]{1, 1, 2, 3, 1}))
                // expected {1, 1, 2, 3, 1 } => sum = 8
                .isEqualTo(8);
    }

    @Test
    public void testMinBracketsToBeRemoved() {
        FacebookInterview facebookInterview = new FacebookInterview();

        assertThat(facebookInterview.minBracketsToBeRemovedToBalanceCount("ab(a(c)fg)9)")).isEqualTo(1);
        assertThat(facebookInterview.minBracketsToBeRemovedToBalanceReturnAnyValid("ab(a(c)fg)9)")).isEqualTo("ab(a(c)fg)9");

        assertThat(facebookInterview.minBracketsToBeRemovedToBalanceCount(")a(b)c()(")).isEqualTo(2);
        assertThat(facebookInterview.minBracketsToBeRemovedToBalanceReturnAnyValid(")a(b)c()(")).isEqualTo("a(b)c()");

        assertThat(facebookInterview.minBracketsToBeRemovedToBalanceCount(")(")).isEqualTo(2);
        assertThat(facebookInterview.minBracketsToBeRemovedToBalanceReturnAnyValid(")(")).isEqualTo("");

        assertThat(facebookInterview.minBracketsToBeRemovedToBalanceCount("a(b))")).isEqualTo(1);
        assertThat(facebookInterview.minBracketsToBeRemovedToBalanceReturnAnyValid("a(b))")).isEqualTo("a(b)");

        assertThat(facebookInterview.minBracketsToBeRemovedToBalanceCount("(a(c()b)")).isEqualTo(1);
        assertThat(facebookInterview.minBracketsToBeRemovedToBalanceReturnAnyValid("(a(c()b)")).isEqualTo("(a(c)b)");

        assertThat(facebookInterview.minBracketsToBeRemovedToBalanceCount("(a)b(c)d(e)f)(g)")).isEqualTo(1);
        assertThat(facebookInterview.minBracketsToBeRemovedToBalanceReturnAnyValid("(a)b(c)d(e)f)(g)")).isEqualTo("(a)b(c)d(e)f(g)");
    }

    // ------ Phone interview questions -------

    @Test
    public void testAreParallelDiagonalsSame() {
        FacebookInterview interview = new FacebookInterview();

        // when / then
        assertThat(interview.areParallelDiagonalsSame(new int[][] {
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {6, 5, 1, 2},
                {7, 6, 5, 1},
        })).isTrue();
        assertThat(interview.areParallelDiagonalsSame(new int[][] {
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {6, 5, 1, 2},
                {7, 6, 5, 6},
        })).isFalse();
    }

    @Test
    public void testAddBigIntegerStrings() {
        FacebookInterview interview = new FacebookInterview();

        // when / then
        assertThat(interview.addBigIntegerStrings("12345", "9678")).isEqualTo("22023");
    }

    @Test
    public void testAddFloatStrings() {
        FacebookInterview interview = new FacebookInterview();

        // when / then
        assertThat(interview.addFloatStrings("1.45", "135.8889")).isEqualTo("137.3389");
    }
}