package iurii.job.interview.yandex.bencode.decoders;

import java.util.Iterator;

/**
 * Interface for all decoders
 * Created by iurii.dziuban on 02/06/2017.
 */
public interface Decoder<T> {

    T decode(Iterator<Character> iterator, String begining);

}
