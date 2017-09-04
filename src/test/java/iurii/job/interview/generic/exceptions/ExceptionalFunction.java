package iurii.job.interview.generic.exceptions;

import java.util.function.Function;

/**
 * Created by iurii.dziuban on 04/09/2017.
 */
public interface ExceptionalFunction<T, R> {
    R apply(T r) throws Exception;

    static <T, R> Function<T, R> wrap(ExceptionalFunction<T, R> f) {
        return (T r) -> {
            try {
                return f.apply(r);
            } catch (Exception e) {
                throw new WrapperException(e);
            }
        };
    }

    class WrapperException extends RuntimeException {
        WrapperException(Exception e) {
            super(e);
        }
    }
}

