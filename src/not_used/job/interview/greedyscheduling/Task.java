package iurii.job.interview.greedyscheduling;

public class Task {
	
	private final int weight;
	private final int length;
	private final double score;
	public Task(int weight, int length) {
		this.weight = weight;
		this.length = length;
		this.score = ((double) weight)/length;
	}
	public int getWeight() {
		return weight;
	}
	public int getLength() {
		return length;
	}
	public double getScore() {
		return score;
	}
	
	@Override
	public String toString() {
		return "weight="+weight+";length="+length;
	}

}
