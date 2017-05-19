package iurii.job.interview.yandex.bencode.exceptions;

/**
 * Exception to tell that 'e' was found. Used to find end of a list
 * @author Iurii
 */
public class EmptyValueException extends RuntimeException {
    public EmptyValueException(String message) {
        super(message);
    }
}
