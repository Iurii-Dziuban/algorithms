package iurii.job.interview.yandex.bencode.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * Iterator for symbols that encapsulates input stream and works with files
 * Created by iurii.dziuban on 02/06/2017.
 */
public class CharacterInputStreamIterator implements Iterator<Character> {

    private final InputStream is;
    private Integer current;

    public CharacterInputStreamIterator(InputStream is) {
        this.is = is;
    }

    @Override
    public boolean hasNext() {
        if (current == null) {
            try {
                current = is.read();
            } catch (IOException e) {
                throw new IllegalStateException();
            }
        }
        return current != -1;
    }

    @Override
    public Character next() {
        Integer cur = current;
        current = null;
        return (char)(int) cur;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
