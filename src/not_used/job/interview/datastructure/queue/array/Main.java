package iurii.job.interview.datastructure.queue.array;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayQueue<Integer> list = new ArrayQueue<Integer>(Integer.class);
		list.push(1);
		list.push(4);
		list.push(3);
		list.push(2);
		
		System.out.println(list.pop());
		System.out.println(list.pop());
		System.out.println(list.pop());
		System.out.println(list.pop());
		list.push(2);
		list.push(1);
		System.out.println(list.pop());
		System.out.println(list.pop());

	}

}
