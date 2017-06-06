package iurii.job.interview.datastructure.heap;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        MinArrayHeap<Integer> minHeap = new MinArrayHeap<Integer>(Integer.class);
        minHeap.enqueue(3);
        minHeap.enqueue(2);
        minHeap.enqueue(4);
        minHeap.enqueue(1);
        minHeap.enqueue(5);

        System.out.println(minHeap.dequeue());
        System.out.println(minHeap.dequeue());
        System.out.println(minHeap.dequeue());
        System.out.println(minHeap.dequeue());
        System.out.println(minHeap.dequeue());

        MaxArrayHeap<Integer> maxHeap = new MaxArrayHeap<Integer>(Integer.class);
        maxHeap.enqueue(3);
        maxHeap.enqueue(2);
        maxHeap.enqueue(4);
        maxHeap.enqueue(1);
        maxHeap.enqueue(5);

        System.out.println(maxHeap.dequeue());
        System.out.println(maxHeap.dequeue());
        System.out.println(maxHeap.dequeue());
        System.out.println(maxHeap.dequeue());
        System.out.println(maxHeap.dequeue());


    }

}
