package iurii.job.interview.topcoder;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadPoolBlockingQueueWithExecutor {

    private final BlockingQueue<Runnable> taskQueue;
    private final WorkerThread[] threadPool;
    private final ExecutorService executor;

    public ThreadPoolBlockingQueueWithExecutor(final int poolSize) {
        taskQueue = new LinkedBlockingQueue<Runnable>();
        executor = Executors.newFixedThreadPool(poolSize);
        threadPool = new WorkerThread[poolSize];
        for (int i = 0; i < poolSize; i++) {
            threadPool[i] = new WorkerThread(taskQueue);
            executor.execute(threadPool[i]);
        }
    }

    public void enqueue(Runnable task) {
        taskQueue.add(task);
        taskQueue.notify();
    }

    public void shutdown() {
        for (int i = 0; i < threadPool.length; i++) {
            threadPool[i].shutdown();
        }
        taskQueue.notifyAll();
        executor.shutdown();
    }

    private static final class WorkerThread extends Thread {

        private final BlockingQueue<Runnable> taskQueue;
        private final AtomicBoolean isActive;

        public WorkerThread(final BlockingQueue<Runnable> taskQueue) {
            this.taskQueue = taskQueue;
            this.isActive = new AtomicBoolean(true);
        }

        public void shutdown() {
            isActive.compareAndSet(true, false);

        }

        @Override
        public void run() {
            while (isActive.get()) {
                while (taskQueue.isEmpty()) {
                    try {
                        taskQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (!isActive.get()) {
                    break;
                }
                taskQueue.remove().run();
            }
        }
    }

}
