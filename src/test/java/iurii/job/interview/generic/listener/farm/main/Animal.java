package iurii.job.interview.generic.listener.farm.main;

import java.util.Random;

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

	default String doSomething() {
		Random rand = new Random();
		int chooseNumber = rand.nextInt(41);
		if (chooseNumber == 0) {
            return this.die();
        }
        if (0 < chooseNumber && chooseNumber < 11) {
            return this.eat();
		}

        if (10 < chooseNumber && chooseNumber < 21) {
            return this.grow();
        }
        if (20 < chooseNumber && chooseNumber < 31) {
            return this.sleep();
        }
        return this.walk();
	}
}
