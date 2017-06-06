package iurii.job.interview.yandex.bencode;

import iurii.job.interview.yandex.bencode.decoders.CompositeDecoder;
import iurii.job.interview.yandex.bencode.encoders.CompositeEncoder;
import iurii.job.interview.yandex.bencode.encoders.IntEncoder;
import iurii.job.interview.yandex.bencode.exceptions.EmptyValueException;
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
import java.util.Map.Entry;
import java.util.SortedMap;
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

    private IntEncoder intEncoder = new IntEncoder();
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

        System.out.println(new Bencode().decode(is));

        is = new FileInputStream(decodedFile);

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
        new Bencode().encode(dictionary,os);
        System.out.println(new CompositeEncoder().encode(dictionary));
        is.close();
        os.close();
    }
    
    public void encode(Object data, OutputStream os) throws IOException {
        if (data == null) {
            throw new EmptyValueException("Value is null!");
        }
        if (data instanceof Integer) {
            Integer intValue = (Integer) data;
            os.write(("i" + intValue + "e").getBytes(Charset.forName("US-ASCII")));
        } else if (data instanceof ByteString) {
            ByteString byteString = (ByteString) data;
            if (byteString.getByteStringInternal() != null) {
                os.write((byteString.getByteStringInternal().length + ":").getBytes(Charset.forName("US-ASCII")));
                os.write(byteString.getByteStringInternal());
            }
        } else if (data instanceof List) {
            try {
                List<Object> list = (List<Object>) data;
                os.write(("l").getBytes(Charset.forName("US-ASCII")));
                for (Object value : list) {
                    encode(value, os);
                }
                os.write(("e").getBytes(Charset.forName("US-ASCII")));
            } catch(ClassCastException castException) {
                throw new IOException("Unsupported object class " + data.getClass());
            }
        } else if (data instanceof Map) {
            try {
                Map<ByteString, Object> map = (Map<ByteString, Object>) data;
                os.write(("d").getBytes(Charset.forName("US-ASCII")));
                for (Entry<ByteString, Object> entry : map.entrySet()) {
                    encode(entry.getKey(), os);
                    encode(entry.getValue(), os);
                }
                os.write(("e").getBytes(Charset.forName("US-ASCII")));
            } catch(ClassCastException castException) {
                throw new IOException("Unsupported object class " + data.getClass());
            }
        } else {
            throw new IOException("Unsupported object class " + data.getClass());
        }
    }
    
    public Object decode(InputStream is) throws IOException {
        int character = is.read();
        if (character == -1) {
            return null;
        }
        switch ((char)character) {
                case 'i' : return decodeInt(is);
                case 'l' : return decodeList(is);
                case 'd' : return decodeDictionary(is);
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
                    return decodeByteString(is, character);
                case 'e':
                    throw new EmptyValueException("Empty value. Found e");
                default:
                    throw new IOException("Illegal character'" + character +"'");
            } 
    }
    
    private SortedMap<ByteString, Object> decodeDictionary(InputStream is) throws IOException {
        SortedMap<ByteString, Object> map = new TreeMap<>();
        int character = is.read();
        while(character != 'e' && character != -1) {
            ByteString key = decodeByteString(is, character);
            Object value = decode(is);
            if (value == null) {
                throw new IOException("Unexpected end of Bencode data");
            }
            map.put(key, value);
            character = is.read();
        }
        if (character == -1) {
            throw new IOException("Unexpected end of Bencode data");
        }
        return map;
    }

    private List<Object> decodeList(InputStream is) throws IOException {
        List<Object> list = new ArrayList<Object>();
        try {
            while(true) {
                list.add(decode(is));
            }
        } catch(EmptyValueException e) {
            return list;    
        }
    }

    private ByteString decodeByteString(InputStream is, int firstCharacter) throws IOException {
        String size = new String();
        size += (char) firstCharacter;
        int character = is.read();
        while (character != ':' && character != -1) {
            switch ((char)character) {
                case '0': 
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9': if (size.charAt(0) == '0') {
                              throw new IOException("Starting 0 is not allowed in size of string");
                          }
                          size += (char) character;
                          break;
                default: throw new IOException("Illegal character'" + character +"' should not appear in size of string");
            }
            character = is.read();
        }
        if (character == -1) {
            throw new IOException("Unexpected end of Bencode data");
        }
        byte[] byteString = new byte[Integer.valueOf(size)];
        for (int i = 0; i < Integer.valueOf(size); i++) {
            int curCharacter = is.read();
            if (curCharacter == -1) {
                throw new IOException("Unexpected end of Bencode data");
            }
            byteString[i] = (byte) curCharacter;
        }
        return new ByteString(byteString);
    }

    private int decodeInt(InputStream is) throws IOException {
        String intValue = "";
        int character = is.read();
        while(character != -1 && character != 'e') {
            switch ((char)character) {
                case '-': if (!intValue.isEmpty()) {
                              throw new IOException("Illegal character'" + character +"' inside int value");
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
                case '9': if (!intValue.isEmpty() && intValue.charAt(0) == '0') {
                              throw new IOException("Starting 0 is not allowed in int");
                          }
                          intValue += String.valueOf((char)character);
                          break;
                default: throw new IOException("Illegal character'" + character +"' inside int value");
            }
            character = is.read();
        }
        if (character == -1 || intValue.isEmpty()) {
            throw new IOException("Unexpected end of Bencode data");
        }
        return Integer.valueOf(intValue);
    }

}
