package iurii.job.interview.topcoder;

/**
 * Java ReadWriteLock implementation for concurrency
 * Many reads can be done at the same time;
 * Only one write can be done at the same time
 * <p>
 * implementation via java monitor class
 * readLock, writeLock, releaseLock methods provided
 */
public class ReadWriteLock {

    private int locksNumber = 0;
    private int waitingReaders = 0;
    private int waitingWritters = 0;

    public synchronized void readLock() {
        waitingReaders++;
        while (locksNumber == -1) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        locksNumber++;
        waitingReaders--;
    }

    public synchronized void writeLock() {
        waitingWritters++;
        while (locksNumber != 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        locksNumber = -1;
        waitingWritters--;
    }

    public synchronized void releaseLock() {
        if (locksNumber == 0) {
            return;
        }
        if (locksNumber == -1) {
            locksNumber = 0;
        } else {
            locksNumber--;
        }
        this.notifyAll();
    }

    // Not important methods

    public synchronized int getLocksNumber() {
        return locksNumber;
    }

    public synchronized int getWaitingReaders() {
        return waitingReaders;
    }

    public synchronized int getWaitingWritters() {
        return waitingWritters;
    }

}
