package iurii.job.interview.topcoder;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 06/11/2017.
 */
public class AnagramsQuickTest {
    @Test
    public void test() {
        AnagramsQuick anagramsQuick = new AnagramsQuick();
        File file = new File("src/test/resources/lemmad.txt");
        String absolutePath = file.getAbsolutePath();
        assertThat(anagramsQuick.findAnagramsQuickly(absolutePath, "PArisi")).containsExactly("Pariis");
    }
}
