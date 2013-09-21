package iurii.job.interview;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Crypto {

    /**
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            if ((i*7 % 23) == 1) {
                System.out.println(i);
                System.out.println((i*7-1)/23);
                break;
            } 
        }
        
        int count = 1;
        for (int i = 1; i < 35; i++) {
            if ((i % 3 != 0) && (i % 7 != 0)) {
                count++;
            }
        }
        System.out.println(count);
        
        Set<Integer> set = new HashSet<Integer>();
        int i = 1;
        int value = 2 * i % 35;
        while (!set.contains(value)) {
            set.add(value);
            value = 2 * value % 35;
            
        }
        System.out.println(set.size());
        
        
        for (int j = 1; j < 1000; j++) {
            BigInteger cur = new BigInteger(""+j);
            if (cur.pow(11).mod(new BigInteger("19")).equals(new BigInteger("2"))) {
                System.out.println(cur);
                break;
            }
        }
    }

}
