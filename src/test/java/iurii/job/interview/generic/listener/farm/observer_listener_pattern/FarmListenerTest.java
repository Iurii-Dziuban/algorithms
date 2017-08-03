package iurii.job.interview.generic.listener.farm.observer_listener_pattern;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FarmListenerTest {

	@Test
	public void test() throws InterruptedException, ExecutionException {

		FarmListenerOrObserver farmListenerOrObserver = new FarmListenerOrObserver();

		AnimalObservable cat = farmListenerOrObserver.createAnimal("cat", 2);
		cat.addObserver(farmListenerOrObserver);
		AnimalObservable dog = farmListenerOrObserver.createAnimal("dog", 1);
		dog.addObserver(farmListenerOrObserver);
		AnimalObservable pig = farmListenerOrObserver.createAnimal("pig", 3);
		pig.addObserver(farmListenerOrObserver);

		ExecutorService executorService = Executors.newFixedThreadPool(4);
		Future<?> farm = executorService.submit(farmListenerOrObserver);
		executorService.submit(cat);
		executorService.submit(dog);
		executorService.submit(pig);

		farm.get();
		executorService.shutdown();
	}

}
