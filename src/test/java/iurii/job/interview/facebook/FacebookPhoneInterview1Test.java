package iurii.job.interview.facebook;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FacebookPhoneInterview1Test {

    private final FacebookPhoneInterview1 interview = new FacebookPhoneInterview1();

    @Test
    public void depthSum() {
        /**
         * [2, [8, [3], 1], 4] = 2 + (8 + (3 x 3) + 1) x 2 + 4 = 42
         */
        FacebookPhoneInterview1.Element[] root = new FacebookPhoneInterview1.Element[3];
        root[0] = new FacebookPhoneInterview1.Element();
        root[0].num = 2;
        root[1] = new FacebookPhoneInterview1.Element();
        root[1].array = new FacebookPhoneInterview1.Element[3];
        root[2] = new FacebookPhoneInterview1.Element();
        root[2].num = 4;

        FacebookPhoneInterview1.Element[] level2 = root[1].array;
        level2[0] = new FacebookPhoneInterview1.Element();
        level2[0].num = 8;
        level2[1] = new FacebookPhoneInterview1.Element();
        level2[1].array = new FacebookPhoneInterview1.Element[1];
        level2[2] = new FacebookPhoneInterview1.Element();
        level2[2].num = 1;

        FacebookPhoneInterview1.Element[] level3 = level2[1].array;
        level3[0] = new FacebookPhoneInterview1.Element();
        level3[0].num = 3;

        assertThat(interview.depthSum(root)).isEqualTo(42);

        /**
         * [1, [2, [3]]] = 1*1 + 2 * (2 + 3*(3)) = 1 + 11 * 2 = 23
         */
        root = new FacebookPhoneInterview1.Element[2];
        root[0] = new FacebookPhoneInterview1.Element();
        root[0].num = 1;
        root[1] = new FacebookPhoneInterview1.Element();
        root[1].array = new FacebookPhoneInterview1.Element[2];

        level2 = root[1].array;
        level2[0] = new FacebookPhoneInterview1.Element();
        level2[0].num = 2;
        level2[1] = new FacebookPhoneInterview1.Element();
        level2[1].array = new FacebookPhoneInterview1.Element[1];

        level3 = level2[1].array;
        level3[0] = new FacebookPhoneInterview1.Element();
        level3[0].num = 3;
        assertThat(interview.depthSum(root)).isEqualTo(23);
    }

    @Test
    public void makeStringBalanced() {
        assertThat(interview.makeStringBalanced(")(")).isEqualTo("");
        assertThat(interview.makeStringBalanced("(((")).isEqualTo("");
        assertThat(interview.makeStringBalanced(")))")).isEqualTo("");
        assertThat(interview.makeStringBalanced("((a)")).isEqualTo("(a)");
        assertThat(interview.makeStringBalanced("(a))(b)(")).isEqualTo("(a)(b)");
    }
}