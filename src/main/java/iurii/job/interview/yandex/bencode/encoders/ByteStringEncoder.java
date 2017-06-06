package iurii.job.interview.yandex.bencode.encoders;

import iurii.job.interview.yandex.bencode.utils.ByteString;

/**
 * Encoder for ByteString with ASCII symbols
 * Created by iurii.dziuban on 06/06/2017.
 */
public class ByteStringEncoder implements Encoder<ByteString>{

    @Override
    public String encode(ByteString value) {
        if (value.getByteStringInternal() != null) {
            return value.getByteStringInternal().length + ":" + value.toString();
        }
        return null;
    }
}
