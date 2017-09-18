package iurii.job.interview.hotspot;

import org.junit.Ignore;
import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by iurii.dziuban on 18/09/2017.
 */
public class NotValidAddressCrashTest {

    private final static Unsafe UNSAFE = getUnsafe();

    private static Unsafe getUnsafe () {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe)field.get(null);
        } catch (Exception ex) {
            throw new RuntimeException("can't get Unsafe instance", ex);
        }
    }

    private static void crash(int x) {
        // segmentation fault - address 0x99 is not readable or writable
        UNSAFE.putInt(0x99, x);
    }


    @Ignore
    @Test
    public void test() {
        crash(0x42);
    }
}