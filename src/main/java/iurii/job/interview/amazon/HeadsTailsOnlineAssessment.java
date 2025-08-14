package iurii.job.interview.amazon;

/**
 * A Amazon Shopping recently launched a new coin collection album.
 * Each page has a coin pasted on it, with either the head or a tail side facing upwards,
 * represented by H or T respectively.
 * A sequence of coins is called beautiful if all the head-facing coins are pasted before all the tail-facing coins.
 * More formally, a beautiful sequence is a sequence of the form HHTTT.
 * One of the buyers has a hobby to collect and organize coins.
 * The buyer pastes the end coins on end pages and then wishes to organize them into a beautiful sequence.
 * Given the initial sequence of coins, find a minimum number of coins that must be flipped to obtain a beautiful sequence.
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
        return result;
    }

    public static class HeadsTailsResult {
        int firstTailPosition;
        int numberOfFlips;

        public HeadsTailsResult () {

        }

        public HeadsTailsResult (int firstTailPosition, int numberOfFlips) {
            this.firstTailPosition = firstTailPosition;
            this.numberOfFlips = numberOfFlips;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof HeadsTailsResult)) {
                return false;
            }
            HeadsTailsResult other = (HeadsTailsResult) obj;
            return firstTailPosition == other.firstTailPosition && numberOfFlips == other.numberOfFlips;
        }

        @Override
        public String toString() {
            return String.format("firstTailPosition = %d numberOfFlips = %d", firstTailPosition, numberOfFlips);
        }
    }
}
