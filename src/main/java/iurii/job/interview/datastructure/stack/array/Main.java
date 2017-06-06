package iurii.job.interview.datastructure.stack.array;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Stack<Integer> list = new Stack<Integer>(Integer.class);
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);

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
