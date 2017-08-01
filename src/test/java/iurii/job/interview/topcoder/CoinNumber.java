package iurii.job.interview.topcoder;

import java.util.ArrayList;
import java.util.List;

public class CoinNumber {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nominals = {7, 5, 3};
        int sum = 4;
        CoinState[] coinStates = new CoinState[sum + 1];
        for (int i = 0; i < coinStates.length; i++) {
            coinStates[i] = new CoinState(Integer.MAX_VALUE, 0,
                    Integer.MAX_VALUE);
        }
        coinStates[0] = new CoinState(0, 0, 0);
        for (int i = 0; i < nominals.length; i++) {
            if (nominals[i] < sum) {
                coinStates[nominals[i]] = new CoinState(1, 0, nominals[i]);
            }
        }
        for (int i = 1; i < coinStates.length; i++) {
            for (int j = 0; j < nominals.length; j++) {
                if (i - nominals[j] >= 0) {
                    int coinNumber = coinStates[i - nominals[j]]
                            .getCoinNumber();
                    if (coinNumber == Integer.MAX_VALUE) {
                        continue;
                    }
                    if (coinNumber + 1 < coinStates[i].getCoinNumber()) {
                        coinStates[i] = new CoinState(coinNumber + 1, i
                                - nominals[j], nominals[j]);
                    }
                }
            }
        }
        List<Integer> monets = new ArrayList<Integer>();
        int index = sum;
        while (index != 0) {
            monets.add(coinStates[index].getCoinNominal());
            index = coinStates[index].getPreviousCoinStateIndex();
        }
        if (coinStates[sum].getCoinNumber() == Integer.MAX_VALUE) {
            System.out.println("No way to get sum using nominal coins");
        } else {
            System.out.println(coinStates[sum].getCoinNumber());
            for (int i = 0; i < monets.size(); i++) {
                System.out.print(monets.get(i) + " ");
            }
            System.out.println();
        }

    }

    public static class CoinState {
        private final int coinNumber;
        private final int previousCoinStateIndex;
        private final int coinNominal;

        public CoinState(int coinNumber, int previousCoinStateIndex,
                         int coinNominal) {
            this.coinNumber = coinNumber;
            this.previousCoinStateIndex = previousCoinStateIndex;
            this.coinNominal = coinNominal;
        }

        public int getCoinNumber() {
            return coinNumber;
        }

        public int getPreviousCoinStateIndex() {
            return previousCoinStateIndex;
        }

        public int getCoinNominal() {
            return coinNominal;
        }
    }

}
