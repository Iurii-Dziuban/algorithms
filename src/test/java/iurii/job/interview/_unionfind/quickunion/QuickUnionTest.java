package iurii.job.interview._unionfind.quickunion;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickUnionTest {

    @Test
    public void test() {
        QuickUnion quickUnion = new QuickUnion(10);
        quickUnion.union(4, 3);
        quickUnion.union(8, 3);
        quickUnion.union(8, 3);
        quickUnion.union(6, 5);
        quickUnion.union(4, 9);
        quickUnion.union(1, 2);
        assertThat(quickUnion.find(4, 3)).isTrue();
        assertThat(quickUnion.find(8, 3)).isTrue();
        assertThat(quickUnion.find(8, 9)).isTrue();
        assertThat(quickUnion.find(7, 1)).isFalse();
        assertThat(quickUnion.find(4, 9)).isTrue();
    }

}
