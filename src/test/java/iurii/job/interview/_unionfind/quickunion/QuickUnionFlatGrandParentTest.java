package iurii.job.interview._unionfind.quickunion;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickUnionFlatGrandParentTest {

    @Test
    public void test() {
        QuickUnionFlatGrandParent quickUnionFlatGrandParent = new QuickUnionFlatGrandParent(10);
        quickUnionFlatGrandParent.union(4, 3);
        quickUnionFlatGrandParent.union(8, 3);
        quickUnionFlatGrandParent.union(8, 3);
        quickUnionFlatGrandParent.union(6, 5);
        quickUnionFlatGrandParent.union(4, 9);
        quickUnionFlatGrandParent.union(1, 2);
        assertThat(quickUnionFlatGrandParent.find(4, 3)).isTrue();
        assertThat(quickUnionFlatGrandParent.find(8, 3)).isTrue();
        assertThat(quickUnionFlatGrandParent.find(8, 9)).isTrue();
        assertThat(quickUnionFlatGrandParent.find(7, 1)).isFalse();
        assertThat(quickUnionFlatGrandParent.find(4, 9)).isTrue();
    }

}
