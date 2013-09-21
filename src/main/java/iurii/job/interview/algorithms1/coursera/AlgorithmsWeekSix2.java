package iurii.job.interview.algorithms1.coursera;

import iurii.job.interview.datastructure.heap.MaxArrayHeap;
import iurii.job.interview.datastructure.heap.MinArrayHeap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AlgorithmsWeekSix2 {

    /**
     * @param args
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/main/resources/Median.txt"));
        MaxArrayHeap<Long> maxHeap = new MaxArrayHeap<Long>(Long.class);
        MinArrayHeap<Long> minHeap = new MinArrayHeap<Long>(Long.class);
        long result = 0;
        while (sc.hasNext()) {
            long value = sc.nextLong();
            if (maxHeap.size() == minHeap.size()) {
                if (maxHeap.size() == 0) {
                    maxHeap.enqueue(value);
                } else {
                    Long median = minHeap.peek();
                    if (median < value) {
                        maxHeap.enqueue(minHeap.dequeue());
                        minHeap.enqueue(value);
                    } else {
                        maxHeap.enqueue(value);
                    }
                }
            } else {
                Long median = maxHeap.peek();
                if (median > value) {
                    minHeap.enqueue(maxHeap.dequeue());
                    maxHeap.enqueue(value);
                } else {
                    minHeap.enqueue(value);
                }
            }
            result += maxHeap.peek();
            result %= 10000;
        }
        System.out.println(result);
        sc.close();
    }

}
