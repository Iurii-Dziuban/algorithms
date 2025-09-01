package iurii.job.interview.amazon;

import java.util.Collections;

/**
 * A Amazon Shopping recently launched a new coin collection album.
 * Each page has a coin pasted on it, with either the head or a tail side facing upwards,
 * represented by H or T respectively.
 * A sequence of coins is called beautiful if all the head-facing coins are pasted before all the tail-facing coins.
 * More formally, a beautiful sequence is a sequence of the form HHTTT.
 * One of the buyers has a hobby to collect and organize coins.
 * The buyer pastes the end coins on end pages and then wishes to organize them into a beautiful sequence.
 * Given the initial sequence of coins, find a minimum number of coins that must be flipped to obtain a beautiful sequence.
 *
 * The sequence of coins can be very long;
 * THHHTH - 2
 * HHTT - 0
 * HHHH - 0
 *
 * (H)*(T)*
 * TTTTTT
 * HTTTTT
 * HHTTTT
 * ..
 * HHHHHH
 *
 * Algo:
 * - Find count of H - count of flips to make TTTTTT..
 * TflipsCount = 0
 * - on i =0, 1..
 * - if on i pos H : HflipsCount = HflipsCount-1
 * - if on i pos T: TflipsCount = TflipsCount + 1
 * - if TflipsCount+HflipsCount < Result : Result = TflipsCount+HflipsCount
 *
 * You can see constraints;
 *
 * Variation : what if 2 coins are flipped at a time? => see
 *
 * We will use sliding window to find first T from the left and first H from right and flip them.
 * Will this be optimal solution? It should be as we flip only coins that violate condition (H)*(T)*
 * This is different from original question when each flip is separate operation and we are not sure
 * if flipping in the beginning is better than flipping on the end.
 *
 * THTTTTTT
 * i     i
 *
 * HTTTTTTT
 *
 * TTTHHHH
 * i     i
 * HTTHHHT
 *  i   i
 * HHTHHTT
 *   i i
 * HHHHTTT
 */
public class HeadsTailsOnlineAssessment {

    /**
     * Potential solution. We know how the end sequence should look like:
     * a bunch of H follow by T.
     * We can find number of flips for each of end sequence, starting all Tails and then
     * making first character H, then HH, then HHH and count number of flips for each of them
     * and take minimum.
     *
     * Note: we do not need to traverse sequence for each example.
     * We can find number of heads in sequence then start traversing and check each character
     * and depending on character correct number of flips.
     *
     * Complexity: O(N), N - sequence length / coin count; we need to go once to count heads
     * and once from left to right to collect the answer
     * Memory: O(1) - we need a couple of values to store results and a couple of current values, pointers;
     *
     * @param sequence - H or T , ex. HTHTHT
     * @return minimum flips, for HTHTHT : 2 flips with ex. result : HTTTTT
     */
    public HeadsTailsResult minFlipsForBeautifulSequence(String sequence) {
        // skipping validation for sequence - only H and T

        // finding headCount
        int totalHeadCount = 0;
        int sequenceLength = sequence.length();
        for (char sequenceChar : sequence.toCharArray()) {
            if ('H' == sequenceChar) {
                totalHeadCount++;
            }
        }

        // finding the best number of flips and first T position
        int headFlips = totalHeadCount;
        int tailFlips = 0;
        HeadsTailsResult result = new HeadsTailsResult();
        // all Tails
        result.firstTailPosition = 0;
        result.numberOfFlips = headFlips;
        // Adding H (Head) in the beginning; we need to flip T to H or decrease head flips if we see Head
        for (int i = 0; i < sequenceLength; i++) {
            if (sequence.charAt(i) == 'H') {
                headFlips--;
            } else {
                tailFlips++;
            }
            // if current number of flips is smaller this is our best solution found so far;
            if (headFlips + tailFlips < result.numberOfFlips) {
                result.numberOfFlips = headFlips + tailFlips;
                result.firstTailPosition = i + 1; // Tails will start from next position
            }
        }
        result.resultSequenceAfterFlips =
            String.join("", Collections.nCopies(result.firstTailPosition,"H")) +
            String.join("", Collections.nCopies(sequenceLength - result.firstTailPosition,"T"));
        return result;
    }

    /**
     * This is variation with minimum 2 coin flips at a time.
     *
     * We will use sliding window to find first T from the left and first H from right and flip them.
     * Will this be optimal solution? It should be as we flip only coins that violate condition (H)*(T)*
     * This is different from original question when each flip is separate operation and we are not sure
     * if flipping in the beginning is better than flipping on the end.
     *
     * THTTTTTT
     * i     i
     *
     * HTTTTTTT
     *
     * TTTHHHH
     * i     i
     * HTTHHHT
     *  i   i
     * HHTHHTT
     *   i i
     * HHHHTTT
     * @param sequence
     * @return
     */
    public  HeadsTailsResult minFlipsForBeautifulSequenceFlip2CoinsAtOnce(String sequence) {
        int sequenceLength = sequence.length();
        int headPointer = findFromLeft(0, sequence, 'T');
        int tailPointer = findFromRight(sequenceLength - 1, sequence, 'H');
        char[] resSeq = sequence.toCharArray();
        HeadsTailsResult result = new HeadsTailsResult();
        while (headPointer < tailPointer) {
            // flip
            resSeq[headPointer] = 'H';
            resSeq[tailPointer] = 'T';
            result.numberOfFlips++;

            // next
            headPointer = findFromLeft(headPointer + 1, sequence, 'T');
            tailPointer = findFromRight(tailPointer - 1, sequence, 'H');
        }
        result.resultSequenceAfterFlips = String.valueOf(resSeq);
        result.firstTailPosition = result.resultSequenceAfterFlips.indexOf('T');
        return result;
    }

    // return position
    private int findFromLeft(int initialPosition, String sequence, char character) {
        int pos = initialPosition;
        while (pos < sequence.length()) {
            if (sequence.charAt(pos) == character) {
                return pos;
            }
            pos++;
        }
        return pos;
    }

    private int findFromRight(int initialPosition, String sequence, char character) {
        int pos = initialPosition;
        while (pos >= 0) {
            if (sequence.charAt(pos) == character) {
                return pos;
            }
            pos--;
        }
        return pos;
    }

    // helper data classes
    public static class HeadsTailsResult {
        int firstTailPosition = -1; // by default not set
        int numberOfFlips;
        // should be in format (H)*(T)*
        String resultSequenceAfterFlips = ""; // by default not set

        public HeadsTailsResult () {

        }

        public HeadsTailsResult (int firstTailPosition, int numberOfFlips, String resultSequenceAfterFlips) {
            this.firstTailPosition = firstTailPosition;
            this.numberOfFlips = numberOfFlips;
            this.resultSequenceAfterFlips = resultSequenceAfterFlips;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof HeadsTailsResult)) {
                return false;
            }
            HeadsTailsResult other = (HeadsTailsResult) obj;
            return firstTailPosition == other.firstTailPosition
                && numberOfFlips == other.numberOfFlips
                && resultSequenceAfterFlips.equals(other.resultSequenceAfterFlips);
        }

        @Override
        public String toString() {
            return String.format("firstTailPosition = %d numberOfFlips = %d resultSequenceAfterFlips = %s",
                firstTailPosition, numberOfFlips, resultSequenceAfterFlips);
        }
    }
}
