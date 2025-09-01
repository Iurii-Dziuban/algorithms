package iurii.job.interview.amazon;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class HeadsTailsOnlineAssessmentTest {

    @Test
    public void minFlipsForBeautifulSequence() {
        HeadsTailsOnlineAssessment assessment = new HeadsTailsOnlineAssessment();

        // zero flips
        assertThat(assessment.minFlipsForBeautifulSequence("HHHTTT")).isEqualTo(
            new HeadsTailsOnlineAssessment.HeadsTailsResult(3, 0, "HHHTTT")
        );

        assertThat(assessment.minFlipsForBeautifulSequenceFlip2CoinsAtOnce("HHHTTT")).isEqualTo(
            new HeadsTailsOnlineAssessment.HeadsTailsResult(3, 0, "HHHTTT")
        );

        // 2 flips
        assertThat(assessment.minFlipsForBeautifulSequence("HTHTHT")).isEqualTo(
            new HeadsTailsOnlineAssessment.HeadsTailsResult(1, 2, "HTTTTT")
        );

        assertThat(assessment.minFlipsForBeautifulSequenceFlip2CoinsAtOnce("HTHTHT")).isEqualTo(
            new HeadsTailsOnlineAssessment.HeadsTailsResult(3, 1, "HHHTTT")
        );

        // 3 flips to head
        assertThat(assessment.minFlipsForBeautifulSequence("TTTHHHH")).isEqualTo(
            new HeadsTailsOnlineAssessment.HeadsTailsResult(7, 3, "HHHHHHH")
        );

        assertThat(assessment.minFlipsForBeautifulSequenceFlip2CoinsAtOnce("TTTHHHH")).isEqualTo(
            new HeadsTailsOnlineAssessment.HeadsTailsResult(4, 3, "HHHHTTT")
        );
        // 4 flips to Tails
        assertThat(assessment.minFlipsForBeautifulSequence("TTTTHHHH")).isEqualTo(
            new HeadsTailsOnlineAssessment.HeadsTailsResult(0, 4, "TTTTTTTT")
        );

        assertThat(assessment.minFlipsForBeautifulSequenceFlip2CoinsAtOnce("TTTTHHHH")).isEqualTo(
            new HeadsTailsOnlineAssessment.HeadsTailsResult(4, 4, "HHHHTTTT")
        );
    }
}