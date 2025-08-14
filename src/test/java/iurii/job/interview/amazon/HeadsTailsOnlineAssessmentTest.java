package iurii.job.interview.amazon;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class HeadsTailsOnlineAssessmentTest {

    @Test
    public void minFlipsForBeautifulSequence() {
        HeadsTailsOnlineAssessment assessment = new HeadsTailsOnlineAssessment();

        // zero flips
        assertThat(assessment.minFlipsForBeautifulSequence("HHHTTT")).isEqualTo(
            new HeadsTailsOnlineAssessment.HeadsTailsResult(3, 0)
        );
        // 2 flips
        assertThat(assessment.minFlipsForBeautifulSequence("HTHTHT")).isEqualTo(
            new HeadsTailsOnlineAssessment.HeadsTailsResult(1, 2)
        );

        // 3 flips to head
        assertThat(assessment.minFlipsForBeautifulSequence("TTTHHHH")).isEqualTo(
            new HeadsTailsOnlineAssessment.HeadsTailsResult(7, 3)
        );
    }
}