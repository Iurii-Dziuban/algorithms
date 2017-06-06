package iurii.job.interview.yandex.bencode.encoders;

import java.util.List;

/**
 * Encoder for list
 * Created by iurii.dziuban on 06/06/2017.
 */
public class ListEncoder implements Encoder<List<Object>> {

    private final Encoder<Object> encoder;

    public ListEncoder(Encoder<Object> encoder) {
        this.encoder = encoder;
    }

    @Override
    public String encode(List<Object> list) {
        StringBuilder values = new StringBuilder("l");
        for (Object value : list) {
            values.append(encoder.encode(value));
        }
        values.append("e");
        return values.toString();
    }
}
