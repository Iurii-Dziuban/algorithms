package iurii.job.interview.generic.listener.farm.observer_listener_pattern;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by iurii.dziuban on 03/08/2017.
 */
public class AnimalObservable implements Observable, Runnable {

    private final String name;
    private final Set<ListenerOrObserver> listenerOrObserverList = new HashSet<>();
    private boolean isDead = false;
    private final int period;

    public AnimalObservable(String name, int period) {
        this.name = name;
        this.period = period;
    }

    public void doSomething() {
        Random rand = new Random();
        int chooseNumber = rand.nextInt(11);
        if (chooseNumber < 3) {
            notifyObservers(new Event(name + " die", this));
            removeAllObservers();
            isDead = true;
        } else {
            notifyObservers(new Event(name + " live", this));
        }
    }

    private void removeAllObservers() {
        listenerOrObserverList.clear();
    }

    public String getName() {
        return name;
    }

    @Override
    public void addObserver(ListenerOrObserver listenerOrObserver) {
        listenerOrObserverList.add(listenerOrObserver);
    }

    @Override
    public void removeObserver(ListenerOrObserver listenerOrObserver) {
        listenerOrObserverList.remove(listenerOrObserver);
    }

    @Override
    public void notifyObservers(final Event e) {
        listenerOrObserverList.forEach(listener -> listener.listen(e));
    }

    @Override
    public void run() {
        while (!isDead) {
            doSomething();
            try {
                Thread.sleep(period * 200);
            } catch (InterruptedException e) {
                throw new IllegalStateException("Thread interrupted");
            }
        }
    }
}
