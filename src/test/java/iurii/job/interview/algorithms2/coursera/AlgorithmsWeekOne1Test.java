package iurii.job.interview.algorithms2.coursera;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Scheduling
 *
 * @author Iurii
 */
public class AlgorithmsWeekOne1Test {


    @Test
    public void main() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/main/resources/jobs.txt"));
        int tasksCount = sc.nextInt();
        List<Task> tasks = new ArrayList<Task>(tasksCount);
        for (int i = 0; i < tasksCount; i++) {
            tasks.add(new Task(sc.nextInt(), sc.nextInt()));
        }
        sc.close();
        //1) w - l decreasing
        tasks.sort((o1, o2) -> {
            if (o1.getWeight() - o1.getLength() == o2.getWeight() - o2.getLength()) {
                return o1.getWeight() > o2.getWeight() ? -1 : o1.getWeight() < o2.getWeight() ? 1 : 0;
            } else {
                return o1.getWeight() - o1.getLength() < o2.getWeight() - o2.getLength() ? 1 : -1;
            }
        });
        long total = 0;
        long time = 0;
        for (Task t : tasks) {
            time += t.getLength();
            total += time * t.getWeight();
        }
        assertThat(total).isEqualTo(69119377652L);

        // w/l decreasing
        tasks.sort((o1, o2) -> {
            if (o1.getWeight() * 1.0 / o1.getLength() == o2.getWeight() * 1.0 / o2.getLength()) {
                return 0;
            } else {
                return o1.getWeight() * 1.0 / o1.getLength() < o2.getWeight() * 1.0 / o2.getLength() ? 1 : -1;
            }
        });
        total = 0;
        time = 0;
        for (Task t : tasks) {
            time += t.getLength();
            total += time * t.getWeight();
        }
        assertThat(total).isEqualTo(67311454237L);

    }

}
