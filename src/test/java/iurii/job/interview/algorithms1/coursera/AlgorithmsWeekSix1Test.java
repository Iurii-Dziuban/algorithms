package iurii.job.interview.algorithms1.coursera;

import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class AlgorithmsWeekSix1Test {

    @Test
    @Ignore
    public void main() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/main/resources/algo1-programming_prob-2sum.txt"));
        List<Long> list = new ArrayList<Long>();
        Map<Long, Long> map = new HashMap<Long, Long>();
        while (sc.hasNext()) {
            long value = sc.nextLong();
            list.add(value);
            map.put(value, 0L);
        }
        sc.close();
        int count = 0;
        for (int i = -10000; i <= 10000; i++) {
            System.out.println(i);
            for (long value : list) {
                if (map.containsKey(i - value) && i - value != value) {
                    count++;
                    break;
                }
            }
        }
        assertThat(count).isEqualTo(427);
    }

}
