package iurii.job.interview.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=olK6SWl8UrM&t=721s
 * https://jg.gg/2016/05/14/episode-03-calendar-conflicts-coding-interview-question/
 *
 * Brute force - compare every event with any other event O(N^2)
 *
 * Time complexity: O(N) - complexity in sorted array or O*(N logN) for sorting and proceeding
 * Auxiliary space complexity: O(N) to store conflicting events
 */
public class CalendarConflicts {

    // events are already in the sorted order
    public List<List<String>> findConflicts(Event[] events) {
        List<List<String>> conflicts = new ArrayList<>();
        if (events.length == 0) {
            return conflicts;
        }
        List<String> tempConflicts = new ArrayList<>();
        tempConflicts.add(events[0].getName());
        Arrays.sort(events);
        // priming the loop
        int endTime = events[0].getEndTime();
        for (int i = 1; i < events.length; i++) {
            if (events[i].getStartTime() >= endTime) {
                // no conflict
                if (tempConflicts.size() > 1) {
                    conflicts.add(tempConflicts);
                }
                tempConflicts = new ArrayList<>();
            }
            endTime = Math.max(endTime, events[i].getEndTime());
            tempConflicts.add(events[i].getName());
        }
        if (tempConflicts.size() > 1) {
            conflicts.add(tempConflicts);
        }
        return conflicts;
    }

    public static class Event implements Comparable<Event>{
        private final int startTime;
        private final int endTime;
        private final String name;

        public Event(int startTime, int endTime, String name) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.name = name;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Event o) {
            return startTime - o.startTime;
        }
    }
}
