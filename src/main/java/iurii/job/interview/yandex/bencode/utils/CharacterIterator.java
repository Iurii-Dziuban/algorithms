package iurii.job.interview.yandex.bencode.utils;

import java.util.Iterator;

/**
 * Iterator for symbols that works for String representation.
 * Note: Easier than InputSteam to use in tests and in memory data
 * Created by iurii.dziuban on 02/06/2017.
 */
public class CharacterIterator implements Iterator<Character> {

    private final String str;
    private int pos = 0;

    public CharacterIterator(String str) {
        this.str = str;
    }

    @Override
    public boolean hasNext() {
        return pos < str.length();
    }

    @Override
    public Character next() {
        return str.charAt(pos++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
