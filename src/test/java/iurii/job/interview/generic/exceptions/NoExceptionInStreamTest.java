package iurii.job.interview.generic.exceptions;

import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test of https://dzone.com/articles/noexception-in-stream-operations
 * <p>
 * Created by iurii.dziuban on 04/09/2017.
 */
public class NoExceptionInStreamTest {

    private static final String[] allowed = {"127.0.0.1", "::1"};

    @Test
    public void noExceptionUglyTest() {
        Set<InetAddress> allowedAddresses = Arrays.stream(allowed)
                .map(s -> {
                    try {
                        return InetAddress.getByName(s);
                    } catch (UnknownHostException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toSet());
        assertThat(allowedAddresses).size().isEqualTo(2);
    }

    @Test
    public void noExceptionBetterTest() {
        Set<InetAddress> allowedAddresses = Arrays.stream(allowed)
                .map(s -> ExceptionalSupplier.wrap(() -> InetAddress.getByName(s)))
                .collect(Collectors.toSet());
        assertThat(allowedAddresses).size().isEqualTo(2);
    }

    @Test
    public void noExceptionTheBestTest() {
        Set<InetAddress> allowedAddresses = Arrays.stream(allowed)
                .map(ExceptionalFunction.wrap(InetAddress::getByName))
                .collect(Collectors.toSet());
        assertThat(allowedAddresses).size().isEqualTo(2);
    }

    @Test (expected = IOException.class)
    public void noExceptionTheBestWithCatchTest() throws IOException {
        try {
            boolean throwException = true;
            Set<InetAddress> allowedAddresses = Arrays.stream(allowed)
                    .map(e -> {
                        if (throwException) {
                            throw new ExceptionalFunction.WrapperException(new IOException());
                        } else {
                            return ExceptionalSupplier.wrap(() -> InetAddress.getByName(e));
                        }
                    })
                    .collect(Collectors.toSet());
            assertThat(allowedAddresses).size().isEqualTo(2);
        } catch (ExceptionalFunction.WrapperException we) {
            throw (IOException) we.getCause();
        }
    }
}
