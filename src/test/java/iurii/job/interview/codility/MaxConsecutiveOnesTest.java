package iurii.job.interview.codility;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 29/09/2017.
 */
public class MaxConsecutiveOnesTest {

    @Test
    public void test(){
        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        assertThat(maxConsecutiveOnes.maxConsecutiveOnes(14)).isEqualTo(3); // 1110
        assertThat(maxConsecutiveOnes.maxConsecutiveOnes(222)).isEqualTo(4); // 11011110
    }
}
