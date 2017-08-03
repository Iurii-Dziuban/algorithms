package iurii.job.interview.generic.listener.farm.observer_listener_pattern;

/**
 * Created by iurii.dziuban on 03/08/2017.
 */
public class Event {

    private final String message;

    private final AnimalObservable source;

    public Event(String message, AnimalObservable source) {
        this.message = message;
        this.source = source;
    }

    public String getMessage() {
        return message;
    }

    public AnimalObservable getSource() {
        return source;
    }
}
