package iurii.job.interview.amazon;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by iurii.dziuban on 19/05/2017.
 */
public class CountOddObjectsTest {

    private CountOddObjects countOddObjects = new CountOddObjects();

    @Test
    public void testNulls() {
        Assertions.assertThat(countOddObjects.takeOdd1(null)).isEmpty();
        Assertions.assertThat(countOddObjects.takeOdd2(null)).isEmpty();
        Assertions.assertThat(countOddObjects.takeOdd3(null)).isEmpty();
        Assertions.assertThat(countOddObjects.takeOdd4(null)).isEmpty();
        Assertions.assertThat(countOddObjects.takeOdd5(null)).isEmpty();
    }

    /**
     * Not sorted and type is Object, not type safe
     */
    @Test
    public void test1() {
        List<Object> objects = countOddObjects.takeOdd1(Arrays.asList(2, 3, 1, 2, 4, 0, 5, 5, 5, 4, null));

        Assertions.assertThat(objects).containsExactly(0, null, 1,3,5);
    }

    /**
     * Not sorted, but universal type
     */
    @Test
    public void test2() {
        List<Integer> objects = countOddObjects.takeOdd2(Arrays.asList(2, 3, 1, 2, 4, 0, 5, 5, 5, 4, null));

        Assertions.assertThat(objects).containsExactly(0, null, 1,3,5);
    }


    /**
     * Sorted by LinkedHashMap and universal type
     */
    @Test
    public void test3() {
        List<Integer> objects = countOddObjects.takeOdd3(Arrays.asList(2, 3, 1, 2, 4, 0, 5, 5, 5, 4, null));

        Assertions.assertThat(objects).containsExactly(3, 1, 0, 5, null);
    }

    /**
     * Sorted by LinkedHashSet and universal type . Takes more memory and Operations in general
     */
    @Test
    public void test4() {
        List<Integer> objects = countOddObjects.takeOdd4(Arrays.asList(2, 3, 1, 2, 4, 0, 5, 5, 5, 4, null));

        Assertions.assertThat(objects).containsExactly(3, 1, 0, 5, null);
    }

    /**
     * Sorted by TreeMap and universal type. Nulls are not possible
     */
    @Test
    public void test5() {
        List<Integer> objects = countOddObjects.takeOdd5(Arrays.asList(2, 3, 1, 2, 4, 0, 5, 5, 5, 4));

        Assertions.assertThat(objects).containsExactly(0, 1, 3, 5);
    }

    /**
     * Sorted by TreeMap and universal type. Nulls are possible
     */
    @Test
    public void test5_1() {
        List<Integer> objects = countOddObjects.takeOdd5(Arrays.asList(2, 3, 1, 2, 4, 0, 5, 5, 5, 4, null), new NullIntegerComparator()::compare);

        Assertions.assertThat(objects).containsExactly(null, 0, 1, 3, 5);
    }

    private static class NullIntegerComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 == null) {
                if (o2 == null) {
                    return 0;
                } else {
                    return -1;
                }
            } else {
                if (o2 == null) {
                    return 1;
                } else {
                    return o1 - o2;
                }
            }
        }
    }

}
