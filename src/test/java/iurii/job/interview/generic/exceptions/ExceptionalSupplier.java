package iurii.job.interview.generic.exceptions;

/**
 * Created by iurii.dziuban on 04/09/2017.
 */
public interface ExceptionalSupplier<T> {
    T apply() throws Exception;

    static <T> T wrap(ExceptionalSupplier<T> exceptionalSupplier) {
        try {
            return exceptionalSupplier.apply();
        } catch (Exception e) {
            throw new ExceptionalFunction.WrapperException(e);
        }
    }
}