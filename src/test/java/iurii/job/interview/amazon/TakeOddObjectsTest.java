package iurii.job.interview.amazon;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by iurii.dziuban on 19/05/2017.
 */
public class TakeOddObjectsTest {

    private TakeOddObjects takeOddObjects = new TakeOddObjects();

    @Test
    public void testNulls() {
        Assertions.assertThat(takeOddObjects.takeOddHashMapAndArrayListNoOrderingOrSortingNotTypeSafed(null)).isEmpty();
        Assertions.assertThat(takeOddObjects.takeOddHashMapAndArrayListNoOrderingTypeSafe(null)).isEmpty();
        Assertions.assertThat(takeOddObjects.takeOddLinkedHashMapAndArrayListTypeSafeOrderByAppearance(null)).isEmpty();
        Assertions.assertThat(takeOddObjects.takeOddLinkedHashSetAndHashSetForDuplicatesTypeSafeOrderByAppearance(null)).isEmpty();
        Assertions.assertThat(takeOddObjects.takeOddTreeMapAndArrayListFromItOrderByDefaultComparator(null)).isEmpty();
    }

    /**
     * Not sorted and type is Object, not type safe
     */
    @Test
    public void testTakeOddHashMapAndArrayListNoOrderingOrSortingNotTypeSafed() {
        List<Object> inputList = Arrays.asList(2, 3, 1, 2, 4, 0, 5, 5, 5, 4, null);
        List<Object> objects = takeOddObjects.takeOddHashMapAndArrayListNoOrderingOrSortingNotTypeSafed(inputList);

        Assertions.assertThat(objects).containsExactly(0, null, 1,3,5);
    }

    /**
     * Not sorted, but universal type
     */
    @Test
    public void testTakeOddHashMapAndArrayListNoOrderingTypeSafe() {
        List<Integer> inputList = Arrays.asList(2, 3, 1, 2, 4, 0, 5, 5, 5, 4, null);
        List<Integer> objects = takeOddObjects.takeOddHashMapAndArrayListNoOrderingTypeSafe(inputList);

        Assertions.assertThat(objects).containsExactly(0, null, 1,3,5);
    }


    /**
     * Sorted by LinkedHashMap and universal type
     */
    @Test
    public void testTakeOddLinkedHashMapAndArrayListTypeSafeOrderByAppearance() {
        List<Integer> inputList = Arrays.asList(2, 3, 1, 2, 4, 0, 5, 5, 5, 4, null);
        List<Integer> objects = takeOddObjects.takeOddLinkedHashMapAndArrayListTypeSafeOrderByAppearance(inputList);

        Assertions.assertThat(objects).containsExactly(3, 1, 0, 5, null);
    }

    /**
     * Sorted by LinkedHashSet and universal type . Takes more memory and Operations in general
     */
    @Test
    public void testTakeOddLinkedHashSetAndHashSetForDuplicatesTypeSafeOrderByAppearance() {
        List<Integer> inputList = Arrays.asList(2, 3, 1, 2, 4, 0, 5, 5, 5, 4, null);
        List<Integer> objects = takeOddObjects.takeOddLinkedHashSetAndHashSetForDuplicatesTypeSafeOrderByAppearance(inputList);

        Assertions.assertThat(objects).containsExactly(3, 1, 0, 5, null);
    }

    /**
     * Sorted by TreeMap and universal type. Nulls are not possible
     */
    @Test
    public void testTakeOddTreeMapAndArrayListFromItOrderByDefaultComparator() {
        List<Integer> inputList = Arrays.asList(2, 3, 1, 2, 4, 0, 5, 5, 5, 4);
        List<Integer> objects = takeOddObjects.takeOddTreeMapAndArrayListFromItOrderByDefaultComparator(inputList);

        Assertions.assertThat(objects).containsExactly(0, 1, 3, 5);
    }

    /**
     * Sorted by TreeMap and universal type. Nulls are possible because of NullIntegerComparator
     */
    @Test
    public void testTakeOddTreeMapAndArrayListFromItOrderByComparator() {
        List<Integer> inputList = Arrays.asList(2, 3, 1, 2, 4, 0, 5, 5, 5, 4, null);
        List<Integer> objects = takeOddObjects.takeOddTreeMapAndArrayListFromItOrderByComparator(inputList, new NullIntegerComparator()::compare);

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
