package iurii.job.interview.hotspot;

import org.junit.Ignore;
import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by iurii.dziuban on 18/09/2017.
 */
public class CrashStringTest {

    final static Unsafe UNSAFE = getUnsafe();

    public static Unsafe getUnsafe () {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe)field.get(null);
        } catch (Exception ex) {
            throw new RuntimeException("can't get Unsafe instance", ex);
        }
    }

    public static boolean crash2(String s) {
        return s instanceof String;
    }

    @Test
    @Ignore
    public void test() {
        String s = "Break";
        UNSAFE.putLong(s, 8L, 0xffffffff);
        crash2(s);
    }
}
