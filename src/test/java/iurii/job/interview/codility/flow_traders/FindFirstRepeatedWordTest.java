package iurii.job.interview.codility.flow_traders;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FindFirstRepeatedWordTest {

    @Test
    public void testStreamSolution(){
        FindFirstRepeatedWord findFirstRepeatedWord = new FindFirstRepeatedWord();
        assertThat(findFirstRepeatedWord.firstRepeatedWordStream("He had had quite enough of this nonsense"))
                .isEqualTo("had");
        assertThat(findFirstRepeatedWord.firstRepeatedWordStream("We are going to the park")).isNull();
    }

    @Test
    public void testNonStreamSolution() {
        FindFirstRepeatedWord findFirstRepeatedWord = new FindFirstRepeatedWord();
        assertThat(findFirstRepeatedWord.firstRepeatedWordNonStream("He had had quite enough of this nonsense"))
                .isEqualTo("had");
        assertThat(findFirstRepeatedWord.firstRepeatedWordNonStream("We are going to the park")).isNull();
    }
}
