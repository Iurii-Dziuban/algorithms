package iurii.job.interview.booking_com.initial;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list of numbers as input
 *
 * 25626 25757 24367 24267 16 100 2 7277
 *
 * Output a delta encoding for the sequence. In a delta encoding the first element is represented as it is.
 * Each subsequent element is represented as the numeric difference from the element before it.
 * So for the sequence above it will be:
 *
 * 25626 131 -1390 -100 -24251 84 -98 7275
 *
 * However if the difference does not fit single signed byte -127 <= x <=127,
 * then instead of the difference, use an escape token, printing it
 *
 * This will denote that the value following the escape token is a full four byte difference value rather than a one-byte difference value
 *
 * For this task use -128 as the escape symbol
 *
 * Following the same example above, the final output would be:
 *
 * 25626 -128 131 -128 -1390 -100 -128 -24251 84 -98 -128 7275
 *
 * Created by iurii.dziuban on 07/06/2017.
 */
public class DeltaEncoding {

    private static final int ESCAPE_TOKEN = -128;
    private static final int MIN_DIFFERENCE = -127;
    private static final int MAX_DIFFERENCE = 127;

    public int[] encode(int[] values) {
        List<Integer> encoded = new ArrayList<>();
        int last = 0;
        for (int value : values) {
            if (encoded.isEmpty()) {
                encoded.add(value);
            } else {
                int difference = value - last;
                if (difference > MAX_DIFFERENCE || difference < MIN_DIFFERENCE) {
                    encoded.add(ESCAPE_TOKEN);
                }
                encoded.add(difference);
            }
            last = value;
        }
        return encoded.parallelStream().mapToInt(i -> i).toArray();
    }

    public List<Integer> encode (List<Integer> values) {
        List<Integer> encoded = new ArrayList<>();
        int last = 0;
        for (int value :values) {
            if (encoded.isEmpty()) {
                encoded.add(value);
            } else {
                int difference = value - last;
                if (difference > MAX_DIFFERENCE || difference < MIN_DIFFERENCE) {
                    encoded.add(ESCAPE_TOKEN);
                }
                encoded.add(difference);
            }
            last = value;
        }
        return encoded;
    }
}
