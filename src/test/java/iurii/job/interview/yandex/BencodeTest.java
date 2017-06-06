package iurii.job.interview.yandex;

import iurii.job.interview.yandex.bencode.Bencode;
import iurii.job.interview.yandex.bencode.decoders.CompositeDecoder;
import iurii.job.interview.yandex.bencode.encoders.CompositeEncoder;
import iurii.job.interview.yandex.bencode.utils.ByteString;
import iurii.job.interview.yandex.bencode.utils.CharacterIterator;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 02/06/2017.
 */
public class BencodeTest {

    @Test
    public void encodeTest() {
        String encodedValue = "d4:name11:Arthur Dent6:numberi42e7:picture0:7:planetsl5:Earth14:Somewhere else9:Old Earthee";
        Map<ByteString, Object> dictionary = new TreeMap<>();
        List<Object> list = new ArrayList<>();
        list.add(ByteString.valueOf("Earth"));
        list.add(ByteString.valueOf("Somewhere else"));
        list.add(ByteString.valueOf("Old Earth"));
        dictionary.put(ByteString.valueOf("name"), ByteString.valueOf("Arthur Dent"));
        dictionary.put(ByteString.valueOf("number"), 42);
        dictionary.put(ByteString.valueOf("picture"), ByteString.valueOf(""));
        dictionary.put(ByteString.valueOf("planets"), list);

        assertThat(new CompositeEncoder().encode(dictionary)).isEqualTo(encodedValue);
    }

    @Test
    public void decodeTest() {
        String encodedValue = "d4:name11:Arthur Dent6:numberi42e7:picture0:7:planetsl5:Earth14:Somewhere else9:Old Earthee";
        String decodedValue = "{name=Arthur Dent, number=42, picture=, planets=[Earth, Somewhere else, Old Earth]}";

        assertThat(new CompositeDecoder().decode(new CharacterIterator(encodedValue), "").toString()).isEqualTo(decodedValue);
    }

    @Test
    public void testMain() throws IOException {
        new Bencode().main(new String[0]);
    }
}
