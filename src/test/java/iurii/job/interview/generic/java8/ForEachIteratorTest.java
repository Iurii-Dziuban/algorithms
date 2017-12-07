package iurii.job.interview.generic.java8;

import org.junit.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class ForEachIteratorTest {

    @Test
    public void shouldIncreaseByOne() {
        assertThat(new ForEachIterator().iteratePlus1(Collections.singletonList(1))).containsExactly(2);
    }
}
