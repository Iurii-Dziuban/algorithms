package iurii.job.interview._unionfind.quickunion;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickUnionFlatTest {

    @Test
    public void test() {
        QuickUnionFlat quickUnionFlat = new QuickUnionFlat(10);
        quickUnionFlat.union(4, 3);
        quickUnionFlat.union(8, 3);
        quickUnionFlat.union(8, 3);
        quickUnionFlat.union(6, 5);
        quickUnionFlat.union(4, 9);
        quickUnionFlat.union(1, 2);
        assertThat(quickUnionFlat.find(4, 3)).isTrue();
        assertThat(quickUnionFlat.find(8, 3)).isTrue();
        assertThat(quickUnionFlat.find(8, 9)).isTrue();
        assertThat(quickUnionFlat.find(7, 1)).isFalse();
        assertThat(quickUnionFlat.find(4, 9)).isTrue();
    }

}
