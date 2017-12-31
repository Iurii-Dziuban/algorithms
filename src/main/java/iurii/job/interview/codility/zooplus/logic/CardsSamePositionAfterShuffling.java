package iurii.job.interview.codility.zooplus.logic;

/**
 * You have a deck with 52 playing cards. How many cards on average will end up in the
 * same position after shuffling the deck
 *
 * Solution: Think about card ending up on any position probability.
 * If you start to think in terms of permutations, like:
 *  - The first card can be on position 1,2, .. 52
 *  - The second card can be on one of 51 left positions
 * This is a good thinking in terms of possible permutations of the cards,
 * but not in terms of the probabilities of card ending on some position.
 * Events of two cards ending on the specific positions are independent and equal.
 * So the chance that card land on the same position is 1/52
 * Talking of all 52 cards it is 1/52 + 1/52 + ... } 52 times or 52 * (1/52) = 1
 *
 * You can interpret it as:
 *     - The chance that at least one card will appear on the same position is 100%,
 *     so in general one card will remain on its position after shuffling
 *
 *     OR number of cards that will remain on average on its own position
 *
 * So the answer is 1.
 *
 * Related to probability, dependent/independent events, combinatorics
 */
public interface CardsSamePositionAfterShuffling {
}
