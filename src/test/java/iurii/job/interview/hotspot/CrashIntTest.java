package iurii.job.interview.hotspot;

import org.junit.Ignore;
import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Example from http://jeeconf.com/program/analyzing-hotspot-crashes/
 * More info https://github.com/simonis/AnalyzingHotSpotCrashes
 * Created by iurii.dziuban on 18/09/2017.
 */
public class CrashIntTest {
    private int[] value = new int[1];

    private final static Unsafe UNSAFE = getUnsafe();

    private int crash() {
        return value.length;
    }

    // jvm crash on crashIntTest.crash() because the field is corrupted because of Unsafe
    // comment @Ignore to run the example
    // jvm crash can not be caught :)
    // at offset 12 of CrashIntTest link to int[] value is stored
    // 0: aload_0 // load 'this'
    // 1: getfield // int[] this.value
    // 4: arraylength
    // 5: ireturn
    @Ignore
    @Test
    public void test() {
        CrashIntTest crashIntTest = new CrashIntTest();
        // any of values {12,13,14,15} will crash because 4 bytes of link to array are stored there
        UNSAFE.putLong(crashIntTest, 12L, 0xbadbabe);
        crashIntTest.crash();
    }

    @Test
    public void testNotFailed() {
        CrashIntTest crashIntTest = new CrashIntTest();
        // 16L is working
        UNSAFE.putLong(crashIntTest, 16L, 0xbadbabe);
        crashIntTest.crash();
        assertThat(value.length).isEqualTo(1);
    }

    // the way how to get Unsafe without Security exception
    private static Unsafe getUnsafe() {
        try {
            Field singleOneInstanceField = Unsafe.class.getDeclaredField("theUnsafe");
            singleOneInstanceField.setAccessible(true);
            return (Unsafe) singleOneInstanceField.get(null);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
