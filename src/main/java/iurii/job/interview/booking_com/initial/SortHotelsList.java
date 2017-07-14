package iurii.job.interview.booking_com.initial;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given a set of hotels and its guests reviews. Sort the hotels based on a list of words specified by a user.
 * The criteria to sort the hotels should be how many times the words specified by the user is mentioned in the hotel reviews.
 *
 * Input
 *
 * - Set of words which we want to find in the hotel reviews
 * - List of hotels each element contains list of reviews
 *
 * Output
 *
 * A list of hotel IDs sorted in the descending order by how many mentions they have of the words specified in the input
 *
 * Notes:
 * - Words are always single words without spaces. Never like  'swimming pool'
 * - HotelID is integer
 * - Words match should be case insensitive
 * - Dots and commas should be ignored
 * - If the word appears in the review twice, it should be counted twice
 * - If two hotels have the same number of words they should be sorted by ID
 * - Consider revisiting time complexity
 * Created by iurii.dziuban on 07/06/2017.
 */
public class SortHotelsList {

    /**
     * Implementation should be the most efficient. So couple insights:
     * 1) There are no Tuples in java, so new Classes instead of Spark or Scala Tuples are a need.
     * 2) Because Tuples are absent stream can not be done on a couple of values.
     * That is why inside hotel stream there is a reviews stream. We can not do on both
     * 3) in case of word matching it is better to do streaming on bigger collection:
     * assuming that there will be much more reviews than words. (one stream operation is smaller).
     * 4) Parallel Stream is used assuming that number of hotels and/or words in reviews are pretty big.
     * Potentially, multithreading can be reused.
     * 5) Methods to accumulate stream object into collection should be only in the end.
     * Collecting stream object in the middle can drive to more CPU and memory overhead.
     */
    public List<HotelRating> getSortedHotelIdNumberOfWords(Set<String> wordsLowercase, List<Hotel> hotelReviews) {
        List<HotelRating> hotelRatingList = hotelReviews.parallelStream()
                .map(hotel -> {
                    long wordsMatchedCount = hotel.getReviews()
                            .parallelStream()
                            .flatMap(review -> Arrays.stream(review.split(" ")))
                            .map(word -> word.replaceAll("[.,]", ""))
                            .filter(word -> wordsLowercase.contains(word.toLowerCase()))
                            .count();
                    return new HotelRating(hotel.getId(), wordsMatchedCount);
                }).sorted().collect(Collectors.toList());
        return hotelRatingList;
    }

    // input data structure
    public static class Hotel {
        private final int id;
        private final List<String> reviews;

        public Hotel(int id, List<String> reviews) {
            this.id = id;
            this.reviews = reviews;
        }

        public int getId() {
            return id;
        }

        public List<String> getReviews() {
            return reviews;
        }
    }

    // output result class with sorting possibility
    public static class HotelRating implements Comparable<HotelRating> {
        private final int id;
        private final long count;

        public HotelRating(int id, long count) {
            this.id = id;
            this.count = count;
        }

        public int getId() {
            return id;
        }

        public long getCount() {
            return count;
        }

        @Override
        public int compareTo(HotelRating o) {
            // assume null not possible
            int countDifference = count - o.count > 0 ? -1 : 1;
            if (countDifference != 0) {
                return countDifference;
            }
            return id - o.id;
        }

        @Override
        public String toString() {
            return String.format("Hotel[%d] has %d", id, count);
        }
    }

}
