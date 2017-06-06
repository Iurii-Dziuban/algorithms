package iurii.job.interview.yandex.bencode.decoders;

import iurii.job.interview.yandex.bencode.utils.ByteString;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Decoder for dictionary. Uses main decoder cause any other type can be nested
 * Created by iurii.dziuban on 02/06/2017.
 */
public class DictionaryDecoder implements Decoder<Map<ByteString, Object>> {

    private ByteStringDecoder byteStringDecoder = new ByteStringDecoder();

    private final Decoder<Object> compositeDecoder;

    public DictionaryDecoder(Decoder<Object> compositeDecoder) {
        this.compositeDecoder = compositeDecoder;
    }

    @Override
    public Map<ByteString, Object> decode(Iterator<Character> iterator, String s) {
        Map<ByteString, Object> map = new TreeMap<>();
        char character;
        while(iterator.hasNext() && (character = iterator.next()) != 'e') {
            ByteString key = byteStringDecoder.decode(iterator, "" + character);
            Object value = compositeDecoder.decode(iterator, "");
            if (value == null) {
                throw new IllegalStateException("Unexpected end of Bencode data");
            }
            map.put(key, value);
        }
        return map;
    }

}
