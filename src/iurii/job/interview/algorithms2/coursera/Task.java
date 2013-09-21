package iurii.job.interview.algorithms2.coursera;

public class Task {
	
	private final int weight;
	private final int length;
	public Task(int weight, int length) {
		this.weight = weight;
		this.length = length;
	}
	public int getWeight() {
		return weight;
	}
	public int getLength() {
		return length;
	}
	
	@Override
	public String toString() {
		return "weight="+weight+";length="+length;
	}

}
