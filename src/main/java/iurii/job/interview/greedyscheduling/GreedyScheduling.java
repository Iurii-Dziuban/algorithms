package iurii.job.interview.greedyscheduling;

/**
 * We have jobs with weights and length.
 * Task is to schedule tasks so that sum (w_i * t_i) -> min, where t_i is time when t_i is solved.
 * It is solved by greedy algorithm.
 * It is hard to prove but you should schedule by w_i/l_i in descending order.
 */
public class GreedyScheduling {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] weights = {2, 5, 8, 3, 6, 1};
        int[] lengths = {3, 2, 5, 6, 4, 7};
        Task[] tasks = new Task[weights.length];
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = new Task(weights[i], lengths[i]);
        }
        QuickSort.sort(tasks);
        for (int i = 0; i < tasks.length; i++) {
            System.out.println(i + ") " + tasks[i]);
        }
    }

}
