package iurii.job.interview._unionfind.quickfind;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickFindTest {

    @Test
    public void test() {
        QuickFind quickFind = new QuickFind(10);
        quickFind.union(4, 3);
        quickFind.union(8, 3);
        quickFind.union(8, 3);
        quickFind.union(6, 5);
        quickFind.union(4, 9);
        quickFind.union(1, 2);

        assertThat(quickFind.find(4, 3)).isTrue();
        assertThat(quickFind.find(8, 3)).isTrue();
        assertThat(quickFind.find(8, 9)).isTrue();
        assertThat(quickFind.find(7, 1)).isFalse();
        assertThat(quickFind.find(4, 9)).isTrue();

        assertThat(quickFind.different()).isEqualTo(5);
    }

}
