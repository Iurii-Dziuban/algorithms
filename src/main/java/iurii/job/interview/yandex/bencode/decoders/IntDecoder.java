package iurii.job.interview.yandex.bencode.decoders;

import iurii.job.interview.yandex.bencode.utils.CharacterIterator;

import java.util.Iterator;

/**
 * Decoder for integer value (positive/negative) if not valid exception is thrown
 * Created by iurii.dziuban on 02/06/2017.
 */
public class IntDecoder implements Decoder<Integer> {

    @Override
    public Integer decode(Iterator<Character> iterator, String s) {
        String intValue = "";
        char character;
        while (iterator.hasNext() && ((character = iterator.next()) != 'e')) {
            switch (character) {
                case '-':
                    if (!intValue.isEmpty()) {
                        throw new NumberFormatException("Illegal character'" + character + "' inside int value");
                    }
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
                    if (!intValue.isEmpty() && intValue.charAt(0) == '0') {
                        throw new NumberFormatException("Starting 0 is not allowed in int");
                    }
                    intValue += character;
                    break;
                default:
                    throw new NumberFormatException("Illegal character'" + character + "' inside int value");
            }
        }
        if (!iterator.hasNext() || intValue.isEmpty()) {
            throw new NumberFormatException("Unexpected end of Bencode data in expected integer value");
        }
        return Integer.parseInt(intValue);
    }
}
