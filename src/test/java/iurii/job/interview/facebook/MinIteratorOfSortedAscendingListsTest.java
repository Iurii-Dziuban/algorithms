package iurii.job.interview.facebook;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 04/12/2017.
 */
@RunWith(value = Parameterized.class)
public class MinIteratorOfSortedAscendingListsTest {

    private static List<List<Integer>> list = new ArrayList<>(
            Arrays.asList(new ArrayList<>(Arrays.asList(2, 4, 8)),
                    new ArrayList<>(Arrays.asList(3, 4, 5)),
                    new ArrayList<>(Arrays.asList(1, 3, 7)),
                    new ArrayList<>(Arrays.asList(6, 9)),
                    new ArrayList<>())
    );

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Parameterized.Parameter
    public String name;

    @Parameterized.Parameter(value = 1)
    public MinIteratorOfSortedAscendingLists iterator;

    @Parameterized.Parameters(name = "{index}: {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"BruteForceListsIterator", new MinIteratorOfSortedAscendingLists.BruteForceListsIterator(list)},
                {"PreProcessingListsIterator", new MinIteratorOfSortedAscendingLists.PreProcessingListsIterator(list)},
                {"MixedListsIterator", new MinIteratorOfSortedAscendingLists.MixedListsIterator(list)},
                {"IteratorBasedIterator", new MinIteratorOfSortedAscendingLists.IteratorBasedListsIterator<>(list,
                        new MinIteratorOfSortedAscendingLists.NonNullIntegerComparator())},
        });
    }

    @Test
    public void testGeneralBehaviour() {
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.next()).isEqualTo(3);
        assertThat(iterator.next()).isEqualTo(3);
        assertThat(iterator.next()).isEqualTo(4);
        assertThat(iterator.next()).isEqualTo(4);
        assertThat(iterator.next()).isEqualTo(5);
        assertThat(iterator.next()).isEqualTo(6);
        assertThat(iterator.next()).isEqualTo(7);
        assertThat(iterator.next()).isEqualTo(8);
        assertThat(iterator.next()).isEqualTo(9);
        assertThat(iterator.hasNext()).isFalse();

        thrown.expect(NoSuchElementException.class);
        iterator.next();
    }
}
