package iurii.job.interview.google;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstRecurringCharacterTest {

    @Test
    public void testNotFound() {
        FirstRecurringCharacter firstRecurringCharacter = new FirstRecurringCharacter();

        assertThat(firstRecurringCharacter.firstRecurringCharacter("abcdefk")).isNull();
    }

    @Test
    public void testFound() {
        FirstRecurringCharacter firstRecurringCharacter = new FirstRecurringCharacter();

        assertThat(firstRecurringCharacter.firstRecurringCharacter("abcdebac")).isEqualTo('b');
    }
}
