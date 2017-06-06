package iurii.job.interview.yandex.bencode.encoders;

import iurii.job.interview.yandex.bencode.utils.ByteString;

import java.util.Map;

/**
 * Encoder for dictionary
 * Created by iurii.dziuban on 06/06/2017.
 */
public class MapEncoder implements Encoder<Map<ByteString, Object>> {

    private final Encoder<Object> encoder;

    public MapEncoder(Encoder<Object> encoder) {
        this.encoder = encoder;
    }

    @Override
    public String encode(Map<ByteString, Object> map) {
        StringBuilder result = new StringBuilder("d");
        for (Map.Entry<ByteString, Object> entry : map.entrySet()) {
            result.append(encoder.encode(entry.getKey()));
            result.append(encoder.encode(entry.getValue()));
        }
        result.append("e");
        return result.toString();
    }
}
