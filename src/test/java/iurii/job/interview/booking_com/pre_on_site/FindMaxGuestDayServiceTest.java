package iurii.job.interview.booking_com.pre_on_site;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 14/07/2017.
 */
public class FindMaxGuestDayServiceTest {

    private FindMaxGuestDayService service = new FindMaxGuestDayService();

    @Test
    public void testNormalScenarioWithTimeline() {
        int maxGuestDay = service.findMaxGuestDayWithTimeline(
                new int[]{1, 2, 3, 2, 6, 5, 1}, new int[]{3, 3, 5, 4, 7, 7, 4});

        assertThat(maxGuestDay).isEqualTo(3);
    }

    @Test
    public void testNormalScenarioWithSorting() {
        int maxGuestDay = service.findMaxGuestDayWithSorting(
                new int[]{1, 2, 3, 2, 6, 5, 1}, new int[]{3, 3, 5, 4, 7, 7, 4});

        assertThat(maxGuestDay).isEqualTo(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkInIsNullWithTimeLine() {
        service.findMaxGuestDayWithSorting(null, new int[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkOutIsNullWithTimeLine() {
        service.findMaxGuestDayWithSorting( new int[0], null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void differentSizesWithTimeLine() {
        service.findMaxGuestDayWithSorting( new int[0], new int[1]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkOutLessThanCheckInWithTimeLine() {
        service.findMaxGuestDayWithSorting( new int[]{2}, new int[]{1});
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkInIsNegativeWithTimeLine() {
        service.findMaxGuestDayWithSorting( new int[]{-2}, new int[]{1});
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkOutIsNegativeWithTimeLine() {
        service.findMaxGuestDayWithSorting( new int[]{1}, new int[]{-1});
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkInZeroWithTimeLine() {
        service.findMaxGuestDayWithSorting( new int[]{0}, new int[]{1});
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkOutZeroWithTimeLine() {
        service.findMaxGuestDayWithSorting( new int[]{1}, new int[]{0});
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkInIsNullWithSorting() {
        service.findMaxGuestDayWithSorting(null, new int[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkOutIsNullWithSorting() {
        service.findMaxGuestDayWithSorting( new int[0], null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void differentSizesWithSorting() {
        service.findMaxGuestDayWithSorting( new int[0], new int[1]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkOutLessThanCheckInWithSorting() {
        service.findMaxGuestDayWithSorting( new int[]{2}, new int[]{1});
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkInIsNegativeWithSorting() {
        service.findMaxGuestDayWithSorting( new int[]{-2}, new int[]{1});
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkOutIsNegativeWithSorting() {
        service.findMaxGuestDayWithSorting( new int[]{1}, new int[]{-1});
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkInZeroWithSorting() {
        service.findMaxGuestDayWithSorting( new int[]{0}, new int[]{1});
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkOutZeroWithSorting() {
        service.findMaxGuestDayWithSorting( new int[]{1}, new int[]{0});
    }
}
