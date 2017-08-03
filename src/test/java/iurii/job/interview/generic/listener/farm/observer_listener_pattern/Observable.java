package iurii.job.interview.generic.listener.farm.observer_listener_pattern;

/**
 * Created by iurii.dziuban on 03/08/2017.
 */
public interface Observable {

    void addObserver(ListenerOrObserver listenerOrObserver);

    void removeObserver(ListenerOrObserver listenerOrObserver);

    void notifyObservers(Event event);
}
