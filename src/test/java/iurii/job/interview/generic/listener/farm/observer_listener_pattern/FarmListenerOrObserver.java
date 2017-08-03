package iurii.job.interview.generic.listener.farm.observer_listener_pattern;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by iurii.dziuban on 03/08/2017.
 */
public class FarmListenerOrObserver implements ListenerOrObserver, Runnable {

    private List<AnimalObservable> animals = new CopyOnWriteArrayList<>();

    @Override
    public void run() {
        while(!animals.isEmpty()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new IllegalStateException("Thread interrupted");
            }
        }
    }

    public AnimalObservable createAnimal(String name, int period) {
        AnimalObservable animal = new AnimalObservable(name, period);
        animals.add(animal);
        animal.addObserver(this);
        return animal;
    }

    @Override
    public synchronized void listen(Event e) {
        System.out.println(e.getMessage());
        if (e.getMessage().endsWith("die")) {
            animals.remove(e.getSource());
        }
    }
}
