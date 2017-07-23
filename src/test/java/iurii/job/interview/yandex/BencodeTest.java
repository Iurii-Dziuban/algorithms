package iurii.job.interview.yandex;

import iurii.job.interview.yandex.bencode.Bencode;
import iurii.job.interview.yandex.bencode.decoders.ByteStringDecoder;
import iurii.job.interview.yandex.bencode.decoders.CompositeDecoder;
import iurii.job.interview.yandex.bencode.decoders.IntDecoder;
import iurii.job.interview.yandex.bencode.encoders.ByteStringEncoder;
import iurii.job.interview.yandex.bencode.encoders.CompositeEncoder;
import iurii.job.interview.yandex.bencode.exceptions.EmptyValueException;
import iurii.job.interview.yandex.bencode.utils.ByteString;
import iurii.job.interview.yandex.bencode.utils.CharacterInputStreamIterator;
import iurii.job.interview.yandex.bencode.utils.CharacterIterator;
import org.junit.Test;
import org.mockito.BDDMockito;

import java.io.IOException;
import java.io.InputStream;
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

    @Test(expected = UnsupportedOperationException.class)
    public void testUnsupportedRemoveCharacter() {
        new CharacterIterator("qqq").remove();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testUnsupportedRemoveCharacterStream() {
        InputStream inputStream = BDDMockito.mock(InputStream.class);

        new CharacterInputStreamIterator(inputStream).remove();
    }

    @Test(expected = IllegalStateException.class)
    public void testIllegalStateExceptionCharacter() throws IOException {
        InputStream inputStream = BDDMockito.mock(InputStream.class);

        BDDMockito.given(inputStream.read()).willThrow(new IOException());

        new CharacterInputStreamIterator(inputStream).hasNext();
    }

    @Test
    public void testByteStringEncoderNull() {
        assertThat(new ByteStringEncoder().encode(new ByteString(null))).isNull();
    }

    @Test(expected = EmptyValueException.class)
    public void testCompositeEncoderNull() {
        new CompositeEncoder().encode(null);
    }

    @Test(expected = ClassCastException.class)
    public void testCompositeEncoderIllegalClass() {
        new CompositeEncoder().encode("");
    }

    @Test(expected = NumberFormatException.class)
    public void testIntDecoderInvalidNumber() {
        new IntDecoder().decode(new CharacterIterator("abc"), "");
    }

    @Test(expected = NumberFormatException.class)
    public void testIntDecoderInvalidMinus() {
        new IntDecoder().decode(new CharacterIterator("5-e"), "");
    }

    @Test(expected = NumberFormatException.class)
    public void testIntDecoderInvalidZeroPosition() {
        new IntDecoder().decode(new CharacterIterator("05e"), "");
    }

    @Test(expected = NumberFormatException.class)
    public void testIntDecoderNoEnd() {
        new IntDecoder().decode(new CharacterIterator("5"), "");
    }

    @Test(expected = IllegalStateException.class)
    public void testCompositeDecoderIncorrectValue() {
        new CompositeDecoder().decode(new CharacterIterator("w"), "");
    }

    @Test
    public void testCompositeDecoderNull() {
        assertThat(new CompositeDecoder().decode(new CharacterIterator(""), "")).isNull();
    }

    @Test(expected = NumberFormatException.class)
    public void testByteStringDecoderBeginning0() {
        new ByteStringDecoder().decode(new CharacterIterator("11"), "0");
    }

    @Test(expected = NumberFormatException.class)
    public void testByteStringDecoderNotNumber() {
        new ByteStringDecoder().decode(new CharacterIterator("ge"), "2");
    }

    @Test(expected = IllegalStateException.class)
    public void testByteStringDecoderNotEnd() {
        new ByteStringDecoder().decode(new CharacterIterator("5:e"), "3");
    }

    @Test(expected = IllegalStateException.class)
    public void testByteStringDecoderNotEnough() {
        new ByteStringDecoder().decode(new CharacterIterator("5:"), "3");
    }

    @Test(expected = IllegalStateException.class)
    public void dictionaryIncorrectDecoder() {
        String encodedValue = "d4:name";
        System.out.println(new CompositeDecoder().decode(new CharacterIterator(encodedValue), "").toString());
    }
}
