package iurii.job.interview.yandex.bencode.decoders;

import iurii.job.interview.yandex.bencode.exceptions.EmptyValueException;

import java.util.Iterator;

/**
 * Entry point of decoders. Contains all needed decoders and able to decode any data type recursively
 * In case of invalid data format Exception is thrown
 * Created by iurii.dziuban on 02/06/2017.
 */
public class CompositeDecoder implements Decoder<Object> {

    private final ByteStringDecoder byteStringDecoder = new ByteStringDecoder();
    private final IntDecoder intDecoder = new IntDecoder();
    private final DictionaryDecoder dictionaryDecoder = new DictionaryDecoder(this);
    private final ListDecoder listDecoder = new ListDecoder(this);

    @Override
    public Object decode(Iterator<Character> iterator, String s) {
        if (!iterator.hasNext()) {
            return null;
        }
        char character = iterator.next();
        switch (character) {
            case 'i':
                return intDecoder.decode(iterator, "");
            case 'l':
                return listDecoder.decode(iterator, "");
            case 'd':
                return dictionaryDecoder.decode(iterator, "");
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return byteStringDecoder.decode(iterator, "" + character);
            case 'e':
                throw new EmptyValueException("Empty value. Found e");
            default:
                throw new IllegalStateException("Illegal character'" + character + "'");
        }
    }
}
