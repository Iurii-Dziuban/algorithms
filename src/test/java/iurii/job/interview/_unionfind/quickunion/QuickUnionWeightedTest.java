package iurii.job.interview._unionfind.quickunion;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickUnionWeightedTest {

    @Test
    public void test() {
        QuickUnionWeighted quickUnionWeighted = new QuickUnionWeighted(10);
        quickUnionWeighted.union(4, 3);
        quickUnionWeighted.union(3, 8);
        quickUnionWeighted.union(8, 3);
        quickUnionWeighted.union(5, 6);
        quickUnionWeighted.union(5, 8);
        quickUnionWeighted.union(9, 4);
        quickUnionWeighted.union(1, 2);
        assertThat(quickUnionWeighted.find(4, 3)).isTrue();
        assertThat(quickUnionWeighted.find(8, 3)).isTrue();
        assertThat(quickUnionWeighted.find(8, 9)).isTrue();
        assertThat(quickUnionWeighted.find(7, 1)).isFalse();
        assertThat(quickUnionWeighted.find(4, 9)).isTrue();
    }

}
