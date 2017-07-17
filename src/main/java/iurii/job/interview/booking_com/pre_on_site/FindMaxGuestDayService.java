package iurii.job.interview.booking_com.pre_on_site;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by iurii.dziuban on 14/07/2017.
 *  * NOTE!!!!
 * 1) Same task as booking.com CustomerServiceCapacity. Difference in naming, solution the same
 * 2) Same task as amazon ProcessorsForTasks. Difference in naming input data
 */
public class FindMaxGuestDayService {

    public int findMaxGuestDayWithTimeline(int[] checkIns, int[] checkOuts) {
        validate(checkIns, checkOuts);
        int maxCheckOutTime = maxCheckOut(checkOuts);
        int[] guestChangeTimeline = new int[maxCheckOutTime + 2];
        for(int checkIn : checkIns) {
            guestChangeTimeline[checkIn]++;
        }
        for(int checkOut : checkOuts) {
            guestChangeTimeline[checkOut + 1]--;
        }
        int currentNumberOfGuests = 0;
        int maxGuests = 0;
        int maxGuestsIndex = 0;
        for (int i = 0; i < guestChangeTimeline.length;i++) {
            currentNumberOfGuests += guestChangeTimeline[i];
            if (currentNumberOfGuests > maxGuests) {
                maxGuests = currentNumberOfGuests;
                maxGuestsIndex = i;
            }
        }
        return maxGuestsIndex;
    }

    public int findMaxGuestDayWithSorting(int[] checkIns, int[] checkOuts) {
        validate(checkIns, checkOuts);
        ArrayList<Integer> checks = new ArrayList<>();
        for(int check : checkIns) {
            checks.add(check);
        }
        for(int check : checkOuts) {
            checks.add(- check);
        }
        int maxGuests = 0;
        int maxGuestsIndex = 0;
        int currentNumberOfGuests = 0;
        checks.sort(new ChecksComparator());
        for(int check : checks) {
            currentNumberOfGuests += check > 0 ? 1 : - 1;
            if (currentNumberOfGuests > maxGuests) {
                maxGuests = currentNumberOfGuests;
                maxGuestsIndex = Math.abs(check);
            }
        }
        return maxGuestsIndex;
    }

    public static class ChecksComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            int difference = Math.abs(o1) - Math.abs(o2);
            if (difference == 0) {
                return o2 - o1;
            }
            return difference;
        }
    }

    private int maxCheckOut(int[] checkout) {
        return Arrays.stream(checkout).max().orElse(0);
    }

    private void validate(int[] checkIns, int[] checkOuts) {
        if (checkIns == null) {
            throw new IllegalArgumentException("checkIns should not be null");
        }
        if (checkOuts == null) {
            throw new IllegalArgumentException("checkIns should not be null");
        }
        if (checkIns.length != checkOuts.length) {
            throw new IllegalArgumentException("number of check ins should be same as number of check outs");
        }
        for(int i = 0; i< checkIns.length; i++) {
            if (checkIns[i]>= checkOuts[i]) {
                throw new IllegalArgumentException("Check in time should be strictly less than check out");
            }
            if (checkIns[i] <= 0) {
                throw new IllegalArgumentException("Check in should not be negative or zero");
            }
        }
    }
}
