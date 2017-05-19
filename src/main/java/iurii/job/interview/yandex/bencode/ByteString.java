package iurii.job.interview.yandex.bencode;

/**
 * Created by iurii.dziuban on 19/05/2017.
 */

import java.nio.charset.Charset;

/**
 * Class to represent Byte String concept
 * @author Iurii
 */
public class ByteString implements Comparable<ByteString> {

    private final byte[] byteString;

    public ByteString(byte[] byteString) {
        this.byteString = byteString;
    }

    public static ByteString valueOf(String value) {
        return new ByteString(value.getBytes(Charset.forName("US-ASCII")));
    }

    /**
     * For console needs. Assuming there are only ASCII characters in byte string
     */
    @Override
    public String toString() {
        if (byteString == null) {
            return null;
        } else {
            String string = "";
            for (int i = 0; i < byteString.length; i++) {
                string += (char) byteString[i];
            }
            return string;
        }
    }

    @Override
    public int compareTo(ByteString o) {
        if (byteString == null && o.byteString == null) {
            return 0;
        }
        if (byteString == null) {
            return -1;
        }
        if (o.byteString == null) {
            return 1;
        }
        for (int i = 0; i < Math.min(byteString.length, o.byteString.length); i++) {
            if (byteString[i] > o.byteString[i]) {
                return 1;
            }
            if (byteString[i] < o.byteString[i]) {
                return -1;
            }
        }
        if (byteString.length == o.byteString.length) {
            return 0;
        }
        return byteString.length > o.byteString.length ? 1 : -1;
    }

    public byte[] getByteStringInternal() {
        return byteString;
    }

}
