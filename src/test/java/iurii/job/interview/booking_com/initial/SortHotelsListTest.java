package iurii.job.interview.booking_com.initial;

import org.assertj.core.util.Sets;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 13/06/2017.
 */
public class SortHotelsListTest {

    @Test
    public void testNumbersAreCorrect() {
        Set<String> words = Sets.newLinkedHashSet("breakfast", "beach", "citycenter", "location", "metro", "view", "staff", "price");

        List<String> reviewsForHotel1 = new ArrayList<>();
        reviewsForHotel1.add("This hotel has a nice view of the citycenter. The location is perfect.");
        reviewsForHotel1.add("Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.");
        reviewsForHotel1.add("They said I could not take my dog and there were other guests with dogs! That is not fair.");
        List<String> reviewsForHotel2 = new ArrayList<>();
        reviewsForHotel2.add("The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.");

        List<SortHotelsList.Hotel> hotels = new ArrayList<>();
        hotels.add(new SortHotelsList.Hotel(1, reviewsForHotel1));
        hotels.add(new SortHotelsList.Hotel(2, reviewsForHotel2));

        List<SortHotelsList.HotelRating> hotelRatings = new SortHotelsList().getSortedHotelIdNumberOfWords(words, hotels);

        System.out.println(hotelRatings);
        assertThat(hotelRatings).size().isEqualTo(2);
        assertThat(hotelRatings.get(0).getId()).isEqualTo(1);
        assertThat(hotelRatings.get(0).getCount()).isEqualTo(6);
        assertThat(hotelRatings.get(1).getId()).isEqualTo(2);
        assertThat(hotelRatings.get(1).getCount()).isEqualTo(4);
    }

    @Test
    public void testEqualCountsSortingCorrect() {
        Set<String> words = Sets.newLinkedHashSet("breakfast", "beach", "citycenter", "location", "metro", "view", "staff", "price");

        List<String> reviewsForHotel1 = new ArrayList<>();
        reviewsForHotel1.add("This hotel has a nice view of the citycenter. The location is perfect.");
        reviewsForHotel1.add("Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.");
        reviewsForHotel1.add("They said I could not take my dog and there were other guests with dogs! That is not fair.");
        List<String> reviewsForHotel2 = new ArrayList<>();
        reviewsForHotel2.add("The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.");
        reviewsForHotel2.add("Staff is lying on the beach");

        List<SortHotelsList.Hotel> hotels = new ArrayList<>();
        hotels.add(new SortHotelsList.Hotel(1, reviewsForHotel1));
        hotels.add(new SortHotelsList.Hotel(2, reviewsForHotel2));

        List<SortHotelsList.HotelRating> hotelRatings = new SortHotelsList().getSortedHotelIdNumberOfWords(words, hotels);

        System.out.println(hotelRatings);
        assertThat(hotelRatings).size().isEqualTo(2);
        assertThat(hotelRatings.get(0).getId()).isEqualTo(1);
        assertThat(hotelRatings.get(0).getCount()).isEqualTo(6);
        assertThat(hotelRatings.get(1).getId()).isEqualTo(2);
        assertThat(hotelRatings.get(1).getCount()).isEqualTo(6);
    }

    @Test
    public void testNotEqualCountsSorting() {
        Set<String> words = Sets.newLinkedHashSet("breakfast", "beach", "citycenter", "location", "metro", "view", "staff", "price");

        List<String> reviewsForHotel1 = new ArrayList<>();
        reviewsForHotel1.add("This hotel has a nice view of the citycenter. The location is perfect.");
        reviewsForHotel1.add("Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.");
        reviewsForHotel1.add("They said I could not take my dog and there were other guests with dogs! That is not fair.");
        List<String> reviewsForHotel2 = new ArrayList<>();
        reviewsForHotel2.add("The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.");
        reviewsForHotel2.add("Staff is lying on the beach. View is awesome");

        List<SortHotelsList.Hotel> hotels = new ArrayList<>();
        hotels.add(new SortHotelsList.Hotel(1, reviewsForHotel1));
        hotels.add(new SortHotelsList.Hotel(2, reviewsForHotel2));

        List<SortHotelsList.HotelRating> hotelRatings = new SortHotelsList().getSortedHotelIdNumberOfWords(words, hotels);

        System.out.println(hotelRatings);
        assertThat(hotelRatings).size().isEqualTo(2);
        assertThat(hotelRatings.get(0).getId()).isEqualTo(2);
        assertThat(hotelRatings.get(0).getCount()).isEqualTo(7);
        assertThat(hotelRatings.get(1).getId()).isEqualTo(1);
        assertThat(hotelRatings.get(1).getCount()).isEqualTo(6);
    }
}
