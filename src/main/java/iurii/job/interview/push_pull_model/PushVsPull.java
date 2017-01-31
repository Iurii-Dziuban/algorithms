package iurii.job.interview.push_pull_model;

import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;
import rx.Observable;
/**
 * Created by iurii.dziuban on 31.01.2017.
 *
 * Push Vs Pull example based on http://blog.amitinside.com/Java-Iterator-Pattern-vs-Stream-vs-RxObservable/
 * And http://www.lightbend.com/resources/video/introducing-reactive-streams
 */
public final class PushVsPull {

    public static void main(final String[] args) {
        new PushVsPull().run();
    }

    private static void pullExample() {
        final List<String> list = Lists.newArrayList("Java", "C", "C++", "PHP", "Go");

        final Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void pushExample() {
        final List<String> list = Lists.newArrayList("Java", "C", "C++", "PHP", "Go");

        final Observable<String> observable = Observable.from(list);

        observable.subscribe(System.out::println, System.out::println,
                () -> System.out.println("We are done!"));
    }

    public void run() {
        pullExample();
        pushExample();
    }
}
