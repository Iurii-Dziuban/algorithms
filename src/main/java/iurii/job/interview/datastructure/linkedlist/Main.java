package iurii.job.interview.datastructure.linkedlist;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addFirst(1);
		list.push(2);
		list.push(3);
		list.addLast(4);
		
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		
		
		System.out.println(list.pop());
		System.out.println(list.pop());
		System.out.println(list.pop());
		System.out.println(list.pop());
		list.push(1);
		list.push(2);
		System.out.println(list.pop());
		System.out.println(list.pop());

	}

}
