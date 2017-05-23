package iurii.job.interview.datastructure.stack.linkedlist;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push(1);
		stack.push(2);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
