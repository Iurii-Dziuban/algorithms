package iurii.job.interview.codility.crx;

/**
 * You are able to throw the dice (6 sides). Generate randomly with equal probability number from 1 to 60.
 *
 * Solution:
 * The approach of summing the values by each throw will not work, because it will be normal distribution
 * and not uniform. So we can not use it. Throws should independently contribute to the range value.
 *
 * Only if the number in range is representable in the base of one of the dividers of the number of dice sides
 * (Or better to say by multiplication of different number of its dividers)
 * When it is possible to generate the number exactly in a number of throws.
 *
 * For instance, if you have a dice with 6 sides. You are able to generate number in the range of 18 = 3 * 2 * 3
 * 18 is representable by multiplication of divisors of 6 - 2 and 3. 3 is taken here 2 times.
 *
 * So how can we do it? Simplest way is to throw the dice number of times we use dividers in the range representation:
 * 3 * 2 * 3 -> number of times is 3. In case of first throw we should split the dice into 3 sections by 2 sides
 * in section (does not matter which sides, because they have the same likelihood 1/6)
 * So we are able to generate number based on the group we get after throw in 0,1,2
 * For second throw we need to split dice sides into 2 sections by 3 sides in section to generate either 0 or 1
 * And for last throw again generate from 0,1,2
 *
 * All the possibilities are equal and the range will be between :
 * (0-2) * 2 * 3 + (0-1) * 3 + (0-2)  ->
 * min = 0
 * max = 2*2*3 + 1*3 + 2 = 17
 * So it is between 0-17 and the total range is 18, what was needed
 *
 * However, 60 is represented by 5 * 2 * 2 * 3 and 6 does not have 5 as a divisor, so it is not possible to do it
 * that way.
 *
 * In general there are two approaches to this problem:
 *
 * 1) Approximation - with probability close to uniform distribution.
 * Find the range bigger than needed and possible to generate uniformly via the possible values.
 * And the bigger numbers change to repeat from beginning.
 * In this case the distribution closer to uniform, especially if the range is closer to needed one.
 *
 * For instance, to generate 60 - we can generate 64 based on 2^6. In case 61 -> 1, 62 -> 2, 63 -> 3, 64 -> 4
 *
 * 2) Exact, with big chance of positive result, but with close to 0 probability, possibly infinite approach
 * Approach is similar to approximation, but in case the number was generated outside, repeat the procedure again.
 *
 * In case of 60, if 61,62,63,64 was generated when repeat generation again. Uniform distribution, but possible infinite.
 * And with each try the probability of not generating the value is 4/60 = 1/15, after 6 tries (1/15) ^ 6
 * probability is significantly small
 */
public interface GenerateNumberWithProbability {
}
