package iurii.job.interview.cracking;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * BrainTeasers
 */
public class CrackingCodingInterview6Test {

    @Test
    public void creation(){
        new CrackingCodingInterview6();
    }

    @Test
    public void brainTeaser1Test() {
        assertThat(CrackingCodingInterview6.brainTeaser1Result()).isEqualTo(2);
    }

    @Test
    public void brainTeaser2Test() {
        assertThat(CrackingCodingInterview6.brainTeaser2Result()).isFalse();
    }

    @Test
    public void brainTeaser3Test() {
        assertThat(CrackingCodingInterview6.brainTeaser3Result()).isTrue();
    }

    @Test
    public void brainTeaser4Test() {
        assertThat(CrackingCodingInterview6.brainTeaser4Result(3)).isEqualTo(4);
    }

    @Test
    public void floorToThrowTest() {
        assertThat(CrackingCodingInterview6.floorToThrow(1)).isEqualTo(14);
        assertThat(CrackingCodingInterview6.floorToThrow(2)).isEqualTo(27);
        assertThat(CrackingCodingInterview6.floorToThrow(3)).isEqualTo(39);
    }

    @Test
    public void squareCountTest() {
        assertThat(CrackingCodingInterview6.squareCount(101)).isEqualTo(10);
    }


    @Test
    public void floor() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(CrackingCodingInterview6.findFloorAndReturnThrows(100, i).size());
        }
    }
}
