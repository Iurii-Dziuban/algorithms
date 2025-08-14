package iurii.job.interview.google;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import org.junit.Test;

public class FindRangeTest {

    @Test
    public void simpleTest() {
        FindRange findRange = new FindRange();
        findRange.putValue(1);
        findRange.putValue(3);
        findRange.putValue(5);
        findRange.putValue(7);

        Set<Integer> values = findRange.findValues(2, 6);
        assertThat(values).containsExactly(3, 5);
    }

}