package iurii.job.interview.yandex.bencode.decoders;

import iurii.job.interview.yandex.bencode.exceptions.EmptyValueException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Decoder for list value
 * Created by iurii.dziuban on 02/06/2017.
 */
public class ListDecoder implements Decoder<List<Object>> {

    private final Decoder<Object> compositeDecoder;

    public ListDecoder(Decoder<Object> compositeDecoder) {
        this.compositeDecoder = compositeDecoder;
    }

    @Override
    public List<Object> decode(Iterator<Character> iterator, String s)  {
        List<Object> list = new ArrayList<Object>();
        try {
            while(true) {
                list.add(compositeDecoder.decode(iterator, s));
            }
        } catch(EmptyValueException e) {
            return list;
        }
    }
}
