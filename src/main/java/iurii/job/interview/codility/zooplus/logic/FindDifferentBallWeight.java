package iurii.job.interview.codility.zooplus.logic;

/**
 * You have 10 boxes containing 10 balls each. The balls in one box are heavier than the
 * ones in the other boxes by 10%. Find out which box contains the heavier balls with
 * only one weighing.
 *
 * Solution: We can do it only if the weights are electronic. And we will have 10-base number.
 *
 * Assuming that weights can output any weight exactly / correctly (without any round operations),
 *
 * We can take 1,2,3,4,5,6,7,8,9,10 balls from the boxes (just remember how many balls are takes from which box)
 * And just look at the last digit on the weights. The 10% heavier balls will form the last digit on the weights.
 * So if it is 1 - first box, 2 - second box, ... and 0 - 10th box, because 10 balls will not introduce the last digit.
 *
 * --------------------------------------------------------------------------------------------
 * The question comes from more generic topic of finding minimum number of weighings needed.
 * --------------------------------------------------------------------------------------------
 *
 * For instance, another question is:
 * You have 8 balls, one of the balls is heavier. Find it in 2 weighings.
 *
 * Solution: divide balls into 3 piles, containing the same (or closest to equal) number of balls.
 * In this case: 3,3,2
 * Compare two groups with equal number 3 < > 3 .
 * In case one plate of weights is heavier, take these 3 balls split into 3 parts: 1,1,1 - the heaviest is among them.
 *     Compare two of them, in case equal, the one which was not on the weights is the answer.
 * In case weights are same - the heavier among the other third pile balls. compare them and find the heavier.
 *
 * ----------------------------------------------------------------------------------------------
 * So basically, for two plate weights you will need to do log_base_3 (number_of_balls) ceiling rounding
 * number of comparisons to determine the needed ball. why 3 - because you will split into 3 piles - two to compare,
 * and one in case compare will be the same.
 * This split will guarantee that the tree of comparisons will be most balanced, and in this case the number of balls,
 * among which there will be a different weight ball will decrease logarithmically, in this case base 3
 *
 * Approach similar to divide-and-conqueror (logarithmically decreasing search space) and binary search approach
 *
 * In the first task there could be no possibility to use two plate weights for one weighing because
 * log_base_3(10) ceiling, so the solution comes based on electrical weight representation.
 *
 * Approach leads more on how to see the difference between normal and different element in number format.
 * Related to probabilities and number representation topics.
 *
 * -----------------------------------------------------------------------------------------------
 * Similar to problem with 100 floors and two eggs. Find the floor, starting from which eggs
 * start to crack.
 *
 * Solution:
 * The idea is to make balanced decisions. To make worst case balanced.
 *
 * In case one egg cracks - we will need to do linear search through all floors that are less than this one.
 * If not we can increase the next try by x-1 floors. So it is needed to find X starting from which we will do the throws.
 *
 * X + (X-1) + ... + 1 >= 100
 * (X + 1) / 2 * X >= 100
 * X^2 + X >= 200
 * The first X that satisfies is 14. So the throws are:
 * 14, 27, 39, 50, 60, 69, 77, 84, 90, 95, 99.
 *
 * So worst case is 14 throws no matter when the first egg will crack
 *
 */
public interface FindDifferentBallWeight {
}
