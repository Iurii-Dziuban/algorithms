package iurii.job.interview.yandex.bencode;

import iurii.job.interview.yandex.bencode.decoders.CompositeDecoder;
import iurii.job.interview.yandex.bencode.encoders.CompositeEncoder;
import iurii.job.interview.yandex.bencode.utils.ByteString;
import iurii.job.interview.yandex.bencode.utils.CharacterInputStreamIterator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * Implement encode, decode methods for basic data structures:
 *
 * byte strings,
 * integers,
 * lists, and
 * dictionaries (associative arrays).
 *
 * More details at: https://en.wikipedia.org/wiki/Bencode
 */
public class Bencode {
    /**
     * Only for testing
     */
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/decodeBencode.txt");
        Writer writer = new OutputStreamWriter(fileOutputStream, Charset.forName("US-ASCII"));
        writer.append("d4:name11:Arthur Dent6:numberi42e7:picture0:7:planetsl5:Earth14:Somewhere else9:Old Earthee");
        writer.close();
        File decodedFile = new File("src/main/resources/decodeBencode.txt");
        File encodedFile = new File("src/main/resources/encodeBencode.txt");
        InputStream is = new FileInputStream(decodedFile);
        OutputStream os = new FileOutputStream(encodedFile);

        System.out.println(new CompositeDecoder().decode(new CharacterInputStreamIterator(is), ""));

        Map<ByteString, Object> dictionary = new TreeMap<ByteString, Object>();
        List<Object> list = new ArrayList<Object>();
        list.add(ByteString.valueOf("Earth"));
        list.add(ByteString.valueOf("Somewhere else"));
        list.add(ByteString.valueOf("Old Earth"));
        dictionary.put(ByteString.valueOf("name"), ByteString.valueOf("Arthur Dent"));
        dictionary.put(ByteString.valueOf("number"), 42);
        dictionary.put(ByteString.valueOf("picture"), ByteString.valueOf(""));
        dictionary.put(ByteString.valueOf("planets"), list);
        System.out.println(new CompositeEncoder().encode(dictionary));
        is.close();
        os.close();
    }
}
