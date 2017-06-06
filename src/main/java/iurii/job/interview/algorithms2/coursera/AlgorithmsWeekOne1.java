package iurii.job.interview.algorithms2.coursera;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Scheduling
 *
 * @author Iurii
 */
public class AlgorithmsWeekOne1 {

    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/main/resources/jobs.txt"));
        int tasksCount = sc.nextInt();
        List<Task> tasks = new ArrayList<Task>(tasksCount);
        for (int i = 0; i < tasksCount; i++) {
            tasks.add(new Task(sc.nextInt(), sc.nextInt()));
        }
        sc.close();
        //1) w - l decreasing
        Collections.sort(tasks, new Comparator<Task>() {

            @Override
            public int compare(Task o1, Task o2) {
                if (o1.getWeight() - o1.getLength() == o2.getWeight() - o2.getLength()) {
                    return o1.getWeight() > o2.getWeight() ? -1 : o1.getWeight() < o2.getWeight() ? 1 : 0;
                } else {
                    return o1.getWeight() - o1.getLength() < o2.getWeight() - o2.getLength() ? 1 : -1;
                }
            }
        });
        long total = 0;
        long time = 0;
        for (Task t : tasks) {
            time += t.getLength();
            total += time * t.getWeight();
        }
        System.out.println(total);

        // w/l decreasing
        Collections.sort(tasks, new Comparator<Task>() {

            @Override
            public int compare(Task o1, Task o2) {
                if (o1.getWeight() * 1.0 / o1.getLength() == o2.getWeight() * 1.0 / o2.getLength()) {
                    return 0;
                } else {
                    return o1.getWeight() * 1.0 / o1.getLength() < o2.getWeight() * 1.0 / o2.getLength() ? 1 : -1;
                }
            }
        });
        total = 0;
        time = 0;
        for (Task t : tasks) {
            time += t.getLength();
            total += time * t.getWeight();
        }
        System.out.println(total);

    }

}
