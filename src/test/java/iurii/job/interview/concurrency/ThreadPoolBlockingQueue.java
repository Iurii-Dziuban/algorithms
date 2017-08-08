package iurii.job.interview.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPoolBlockingQueue {

    private final BlockingQueue<Runnable> taskQueue;
    private final Thread[] threadPool;

    public ThreadPoolBlockingQueue(final int poolSize) {
        taskQueue = new LinkedBlockingQueue<Runnable>();
        threadPool = new Thread[poolSize];
        for (int i = 0; i < poolSize; i++) {
            threadPool[i] = new WorkerThread(taskQueue);
            threadPool[i].start();
        }
    }

    public void enqueue(Runnable task) {
        taskQueue.add(task);
    }

    private static final class WorkerThread extends Thread {

        private final BlockingQueue<Runnable> taskQueue;

        public WorkerThread(final BlockingQueue<Runnable> taskQueue) {
            this.taskQueue = taskQueue;
        }

        @Override
        public void run() {
            while (true) {
                while (taskQueue.isEmpty()) {
                    try {
                        taskQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                taskQueue.remove().run();
            }
        }
    }

}
