package iurii.job.interview.booking_com.initial;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 07/06/2017.
 */
public class DeltaEncodingTest {

    private DeltaEncoding deltaEncoding = new DeltaEncoding();

    @Test
    public void test() {
        ArrayList<Integer> values = new ArrayList<>();
        values.add(25626);
        values.add(25757);
        values.add(24367);
        values.add(24267);
        values.add(16);
        values.add(100);
        values.add(2);
        values.add(7277);

        List<Integer> encoded = deltaEncoding.encode(values);

        assertThat(encoded).containsExactly(25626, -128, 131, -128, -1390, -100, -128, -24251, 84, -98, -128, 7275);
    }

}
