package iurii.job.interview._unionfind;

import iurii.job.interview._unionfind.quickfind.QuickFind;
import iurii.job.interview._unionfind.quickunion.QuickUnion;
import iurii.job.interview._unionfind.quickunion.QuickUnionFlat;
import iurii.job.interview._unionfind.quickunion.QuickUnionFlatGrandParent;
import iurii.job.interview._unionfind.quickunion.QuickUnionWeighted;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        QuickFind quickFind = new QuickFind(10);
        quickFind.union(4, 3);
        quickFind.union(8, 3);
        quickFind.union(6, 5);
        quickFind.union(4, 9);
        quickFind.union(1, 2);
        System.out.println(quickFind.find(8, 9));
        System.out.println(quickFind.find(7, 1));
        System.out.println(quickFind.find(4, 9));
        //
        QuickUnion quickUnion = new QuickUnion(10);
        quickUnion.union(4, 3);
        quickUnion.union(8, 3);
        quickUnion.union(6, 5);
        quickUnion.union(4, 9);
        quickUnion.union(1, 2);
        System.out.println(quickUnion.find(8, 9));
        System.out.println(quickUnion.find(7, 1));
        System.out.println(quickUnion.find(4, 9));
        //
        QuickUnionFlat quickUnionFlat = new QuickUnionFlat(10);
        quickUnionFlat.union(4, 3);
        quickUnionFlat.union(8, 3);
        quickUnionFlat.union(6, 5);
        quickUnionFlat.union(4, 9);
        quickUnionFlat.union(1, 2);
        System.out.println(quickUnionFlat.find(8, 9));
        System.out.println(quickUnionFlat.find(7, 1));
        System.out.println(quickUnionFlat.find(4, 9));
        //
        QuickUnionFlatGrandParent quickUnionFlatGrandParent = new QuickUnionFlatGrandParent(10);
        quickUnionFlatGrandParent.union(4, 3);
        quickUnionFlatGrandParent.union(8, 3);
        quickUnionFlatGrandParent.union(6, 5);
        quickUnionFlatGrandParent.union(4, 9);
        quickUnionFlatGrandParent.union(1, 2);
        System.out.println(quickUnionFlatGrandParent.find(8, 9));
        System.out.println(quickUnionFlatGrandParent.find(7, 1));
        System.out.println(quickUnionFlatGrandParent.find(4, 9));
        //
        QuickUnionWeighted quickUnionWeighted = new QuickUnionWeighted(10);
        quickUnionWeighted.union(4, 3);
        quickUnionWeighted.union(8, 3);
        quickUnionWeighted.union(6, 5);
        quickUnionWeighted.union(4, 9);
        quickUnionWeighted.union(1, 2);
        System.out.println(quickUnionWeighted.find(8, 9));
        System.out.println(quickUnionWeighted.find(7, 1));
        System.out.println(quickUnionWeighted.find(4, 9));


    }

}
