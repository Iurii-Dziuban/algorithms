package iurii.job.interview.yandex.bencode.encoders;

/**
 * Encoder for integer value
 * Created by iurii.dziuban on 02/06/2017.
 */
public class IntEncoder implements Encoder<Integer> {

    @Override
    public String encode(Integer value) {
        return "i" + value + "e";
    }
}
