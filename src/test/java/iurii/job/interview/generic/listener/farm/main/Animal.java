package iurii.job.interview.generic.listener.farm.main;

public interface Animal extends Comparable<Animal> {
	String getName();
	void setName(String name);
	void setPeriodAction(int period);
	boolean isReady();
	String eat();
	String walk();
	String grow();
	String sleep();
	String die();
	String doSomething();
}
