package iurii.job.interview.datastructure.redblacktree;

import org.junit.Test;

import java.util.Iterator;

public class MainBST {

    @Test
    public void test() {
        BST<Integer, String> bst = new BST<Integer, String>();
        bst.put(6, "Hello");
        bst.put(2, "WOrld");
        bst.put(8, "I");
        bst.put(4, "Love");

        System.out.println(bst.get(6));
        System.out.println(bst.get(2));
        System.out.println(bst.get(8));
        System.out.println(bst.get(4));

        System.out.println(bst.floor(3));
        System.out.println(bst.floor(5));
        System.out.println(bst.floor(7));
        System.out.println(bst.floor(9));

        System.out.println(bst.ceiling(1));
        System.out.println(bst.ceiling(3));
        System.out.println(bst.ceiling(5));
        System.out.println(bst.ceiling(7));

        System.out.println(bst.rank(3));
        System.out.println(bst.rank(5));
        System.out.println(bst.rank(7));
        System.out.println(bst.rank(9));

        Iterator<Integer> iterator = bst.iterator();
        while (iterator.hasNext()) {
            System.out.println(bst.get(iterator.next()));
        }
        bst.hibbardDelete(6);
        iterator = bst.iterator();
        while (iterator.hasNext()) {
            System.out.print(bst.get(iterator.next()) + " ");
        }
        System.out.println();
        System.out.println(bst.size());

        bst.hibbardDelete(2);
        iterator = bst.iterator();
        while (iterator.hasNext()) {
            System.out.print(bst.get(iterator.next()) + " ");
        }
        System.out.println();
        System.out.println(bst.size());
        bst.hibbardDelete(4);

        iterator = bst.iterator();
        while (iterator.hasNext()) {
            System.out.print(bst.get(iterator.next()) + " ");
        }
        System.out.println();
        System.out.println(bst.size());

        RedBlackTree<Integer, String> tree = new RedBlackTree<Integer, String>();
        for (int i = 0; i < 8; i++) {
            tree.put(i, "" + i);
        }
        System.out.println();

        RedBlackBST<Integer, String> rbbst = new RedBlackBST<Integer, String>();
        for (int i = 0; i < 8; i++) {
            rbbst.put(i, "" + i);
        }
        System.out.println();
    }

}
