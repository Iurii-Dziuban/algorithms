package iurii.job.interview.yandex.bencode.utils;

/**
 * Created by iurii.dziuban on 19/05/2017.
 */

import java.nio.charset.Charset;

/**
 * Class to represent Byte String concept
 * <p>
 * Internal can not be null
 *
 * @author Iurii
 */
public class ByteString implements Comparable<ByteString> {

    private final byte[] byteString;

    public ByteString(byte[] byteString) {
        this.byteString = byteString;
    }

    public static ByteString valueOf(String value) {
        return new ByteString(getBytes(value));
    }

    /**
     * For console needs. Assuming there are only ASCII characters in byte string
     */
    @Override
    public String toString() {
        String s = "";
        for (byte b : byteString) {
            s += (char) b;
        }
        return s;
    }

    /**
     * Method implementation is needed to be a key to the TreeMap
     */
    @Override
    public int compareTo(ByteString o) {
        // assuming null values are not possible. byte[0] is possible
        for (int i = 0; i < Math.min(byteString.length, o.byteString.length); i++) {
            int compareByte = compare(byteString[i], o.byteString[i]);
            if (compareByte != 0) {
                return compareByte;
            }
        }
        return compare(byteString.length, o.byteString.length);
    }

    // greater > return 1
    // less than < return -1
    // equal =  return 0
    private static int compare(int first, int second) {
        return first > second ? 1 : (first == second) ? 0 : -1;
    }

    public byte[] getByteStringInternal() {
        return byteString;
    }

    public static byte[] getBytes(String value) {
        return value.getBytes(Charset.forName("US-ASCII"));
    }

}
