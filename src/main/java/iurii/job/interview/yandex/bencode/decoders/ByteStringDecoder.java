package iurii.job.interview.yandex.bencode.decoders;

import iurii.job.interview.yandex.bencode.utils.ByteString;

import java.util.Iterator;

/**
 * Decoder for ByteString representation for ASCII characters.
 * Extracting length and content. In case illegal symbol Exception is thrown
 * Created by iurii.dziuban on 02/06/2017.
 */
public class ByteStringDecoder implements Decoder<ByteString> {

    @Override
    public ByteString decode(Iterator<Character> iterator, String beginning) {
        String size = beginning;
        char character;
        while (iterator.hasNext() && (character = iterator.next()) != ':' && character != -1) {
            switch (character) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9': if (size.charAt(0) == '0') {
                              throw new NumberFormatException("Starting 0 is not allowed in size of string");
                          }
                          size += character;
                          break;
                default: throw new NumberFormatException("Illegal character'" + character +"' should not appear in size of string");
            }
        }
        if (!iterator.hasNext()) {
            throw new IllegalStateException("Unexpected end of Bencode data");
        }
        int length = Integer.parseInt(size);
        byte[] byteString = new byte[length];
        for (int i = 0; i < length; i++) {
            if (!iterator.hasNext()) {
                throw new IllegalStateException("Unexpected end of Bencode data");
            }
            byteString[i] = (byte) (char) iterator.next();
        }
        return new ByteString(byteString);
    }
}
