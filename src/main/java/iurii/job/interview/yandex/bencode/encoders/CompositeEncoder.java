package iurii.job.interview.yandex.bencode.encoders;

import iurii.job.interview.yandex.bencode.exceptions.EmptyValueException;
import iurii.job.interview.yandex.bencode.utils.ByteString;

import java.util.List;
import java.util.Map;

/**
 * Entry point of decoders. Contains all needed encoders and able to decode any data type recursively
 * In case of invalid data format Exception is thrown
 * Created by iurii.dziuban on 06/06/2017.
 */
public class CompositeEncoder implements Encoder<Object> {

    private MapEncoder mapEncoder = new MapEncoder(this);
    private ByteStringEncoder byteStringEncoder = new ByteStringEncoder();
    private ListEncoder listEncoder = new ListEncoder(this);
    private IntEncoder intEncoder = new IntEncoder();

    @Override
    public String encode(Object data) {
        if (data == null) {
            throw new EmptyValueException("Value is null!");
        }
        if (data instanceof Integer) {
            return intEncoder.encode((int) data);
        } else if (data instanceof ByteString) {
            ByteString byteString = (ByteString) data;
            return byteStringEncoder.encode(byteString);
        } else if (data instanceof List) {
            List<Object> list = (List<Object>) data;
            return listEncoder.encode(list);
        } else if (data instanceof Map) {
            Map<ByteString, Object> map = (Map<ByteString, Object>) data;
            return  mapEncoder.encode(map);
        } else {
            throw new ClassCastException("Unsupported object class " + data.getClass());
        }
    }
}
