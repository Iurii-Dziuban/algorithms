package iurii.job.interview.topcoder;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 06/11/2017.
 */
public class ReverseWordsTest {

    @Test
    public void test() {
        assertThat(new String(new ReverseWords().reverseWords("I love Taxify".toCharArray()))).isEqualTo("I evol yfixaT");
        assertThat(new String(new ReverseWords().reverseWords("I love Taxify ".toCharArray()))).isEqualTo("I evol yfixaT ");
        assertThat(new String(new ReverseWords().reverseWords("I !".toCharArray()))).isEqualTo("I !");
    }
}
