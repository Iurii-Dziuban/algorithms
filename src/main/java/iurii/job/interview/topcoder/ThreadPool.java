package iurii.job.interview.topcoder;

import java.util.LinkedList;

public class ThreadPool {

    private final LinkedList<Runnable> taskQueue;
    private final Thread[] threadPool;

    public ThreadPool(final int poolSize) {
        taskQueue = new LinkedList<Runnable>();
        threadPool = new Thread[poolSize];
        for (int i = 0; i < poolSize; i++) {
            threadPool[i] = new WorkerThread(taskQueue);
            threadPool[i].start();
        }
    }

    public void enqueue(Runnable task) {
        synchronized (taskQueue) {
            taskQueue.addLast(task);
            taskQueue.notify();
        }
    }

    private static final class WorkerThread extends Thread {

        private final LinkedList<Runnable> taskQueue;

        public WorkerThread(final LinkedList<Runnable> taskQueue) {
            this.taskQueue = taskQueue;
        }

        @Override
        public void run() {
            Runnable task;
            while (true) {
                synchronized (taskQueue) {
                    while (taskQueue.isEmpty()) {
                        try {
                            taskQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    task = taskQueue.removeFirst();
                }
                task.run();
            }
        }
    }

}
