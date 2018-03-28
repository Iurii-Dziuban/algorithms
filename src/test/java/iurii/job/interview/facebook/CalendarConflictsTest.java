package iurii.job.interview.facebook;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CalendarConflictsTest {

    @Test
    public void test() {
        CalendarConflicts cc = new CalendarConflicts();
        CalendarConflicts.Event[] events = new CalendarConflicts.Event[] {
                new CalendarConflicts.Event(1,2, "a"),
                new CalendarConflicts.Event(3,5, "b"),
                new CalendarConflicts.Event(4,6, "c"),
                new CalendarConflicts.Event(7,10, "d"),
                new CalendarConflicts.Event(8,11, "e"),
                new CalendarConflicts.Event(10,12, "f"),
                new CalendarConflicts.Event(13,14, "g"),
                new CalendarConflicts.Event(13,14, "h"),
        };
        assertThat(cc.findConflicts(events)).containsExactlyInAnyOrder(
                Arrays.asList("b", "c"), Arrays.asList("d", "e", "f"), Arrays.asList("g", "h"));
    }
}
