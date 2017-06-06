package iurii.job.interview.topcoder;

public class NCoinPilesEachTakesAtLeastOne {

    /**
     * loose if n1 xor n2 xor.... xor n_m == 0
     * And you always move from loosing to winning position
     * and you always have move from wining to loosing
     * (choosing the greatest word with 1 which is the top 1 in the xor result.
     * As you can change it to 0 and all less digits to whatever you want)
     */
    public static void main(String[] args) {
        int[] number = {10, 15, 13, 18, 17, 14, 2};
        int xorResult = 0;
        for (int i = 0; i < number.length; i++) {
            xorResult = xorResult ^ number[i];
        }
        if (xorResult == 0) {
            System.out.println("Loose");
        } else {
            System.out.println("Win");
        }
    }

}
