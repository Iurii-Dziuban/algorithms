package iurii.job.interview.codility.onpex;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegerPositionInOtherIntegerTest {

    @Test
    public void test() {
        IntegerPositionInOtherInteger integerInOtherInteger = new IntegerPositionInOtherInteger();
        assertThat(integerInOtherInteger.solution(32, 4532032)).isEqualTo(2);
        assertThat(integerInOtherInteger.solution(1, 11111)).isEqualTo(0);
        assertThat(integerInOtherInteger.solution(32, 4500032)).isEqualTo(5);
        assertThat(integerInOtherInteger.solution(32, 4533031)).isEqualTo(-1);
    }
}
