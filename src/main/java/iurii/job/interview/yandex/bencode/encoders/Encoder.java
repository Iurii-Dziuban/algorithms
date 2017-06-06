package iurii.job.interview.yandex.bencode.encoders;

/**
 * Interface for all encoders
 * Created by iurii.dziuban on 06/06/2017.
 */
public interface Encoder<T> {
    String encode(T value);
}
