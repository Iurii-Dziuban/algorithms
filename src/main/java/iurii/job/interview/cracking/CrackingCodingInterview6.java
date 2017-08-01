package iurii.job.interview.cracking;

import java.util.LinkedList;
import java.util.List;

/**
 * BrainTeasers
 */
public class CrackingCodingInterview6 {

    /**
     * 6.1 Add arithmetic operators to make it true 3 1 3 6 = 8
     * Hint: you should think what two numbers can make 8.
     * One of the ways is 4 * 2. We can make 4 by 3 + 1 . To make 2 we should *3 / 6.
     * So (3+1)*3/6 = 8
     */
    public static int brainTeaser1Result() {
        return (3 + 1) * 3 / 6; // it is 8
    }

    /**
     * 6.2 We have chess 8x8, where we removed two diagonal opposite corners.
     * Can we cover the chessboard with 31 dominos by 2x1?
     * Answer: If we have chessboard with white and dark cells when we removed two cells with same color.
     * (Because diagonal opposite colors have same color)
     * So we have 32 cells with one color and 30 with another color.
     * But each domino 2x1 covers exactly one cell with one color and one cell with another color.
     * So this task is impossible.
     */
    public static boolean brainTeaser2Result() {
        return false; // Impossible because of explanation
    }

    /**
     * 6.3 We have jugs with 5 and 3 liters. Is it possible to make 4 litters?
     * Answer: yes. Check all variants of litters that you can make.
     * 5 jug    3jug  5liters 3liters
     * +        -      5      0
     * ->        2      3
     * -      2      0
     * ->        0      2
     * +               5      2
     * ->        4      3
     * We get it
     */
    public static boolean brainTeaser3Result() {
        return true; // Possible because of explanation
    }

    /**
     * 6.4 Some men have a hat. They can see hats on others, but can not see on themself.
     * If a man has a hat only then he should take it off at the end of the day.
     * When will all hats be removed.
     * Answer:
     * The main idea how the men think. If a man has a hat than he sees n-1 hat.
     * If a man has not a hat than he sees all n hats.
     * But how to decide? Lets make it by induction.
     * If only one hat - than a man with hat will think this way:
     * All others have no hat, so I have a hat or not. So he does not try to take of the hat this night.
     * If next day begins when he has a hat and will take it off because he knows for sure, that he has a hat
     * Suppose there are two hats.
     * A man with a hat will think this way: I have a hat or not.
     * If not than this another man with hat will take it off the second day.
     * If not - for sure he has a hat and next day he will take it off.
     * So by induction number of days is n + 1.
     * Interesting fact that all this is possible
     * because others see all n hats and these mans with hats see only n-1 hat.
     */
    public static int brainTeaser4Result(int hatsNumber) {
        return hatsNumber + 1; // Explanation is given
    }

    /**
     * 6.5 We have 2 eggs. and 100 floors.
     * We should determine the smallest number of throwing eggs to decide the floor from which eggs brake.
     * Answer: You can think about such 2 ways:
     * 1) Is to cut off half of the floors. So just throw from the 50 floor the first egg.
     * And then in the worst case you should use 49 throws of first egg.
     * But it is not effective in this case.
     * 2) You can throw egg from smallest floor by 3 step. Like throw at 3 if Ok
     * than throw at 6 if not than throw at 2 and based on the result of 2 you can decide 1 or 2.
     * in this case the number of tries in worst case is 33 (99/3). better but not good enough.
     * <p>
     * So from this moment you should start to think that throwing should be adaptive.
     * <p>
     * 3) Lets think that by the first throw we divide floors by two halves(different sizes).
     * For the first half, which should be smaller we will have one egg to decide,
     * for the second half we still would have 2 eggs
     * but each time we will have number of throws(decreasing by 1) for the first half
     * to still have the smallest possible number of throws in worst case.
     * So parts will make an arithmetic progression decreasing by one. Lets find the size of first part.
     * (1 + x) / 2 * x >= 100
     * (1+x) * x >= 200
     * but x is integer.
     * So the first integer that succeeds is 14.
     * These means that we will have only 14 throws to determine the floor, which is the best choice.
     * Solution for any floor <= 100, step should be <=15.
     * At what floor to throw egg at each step if egg is not broken.
     * If egg brakes then check one by one each floor from the smallest half.
     */
    public static long floorToThrow(int step) {
        return Math.round((14.0 + (15 - step)) / 2 * step);
    }

    // Automatic determination for throws
    public static List<Integer> findFloorAndReturnThrows(int floorsCount, int floorNumber) {
        LinkedList<Integer> throwsList = new LinkedList<Integer>();
        int firstMinPartSize = 1;
        // find firstPartSize
        while (firstMinPartSize * (firstMinPartSize + 1) < 2 * floorsCount) {
            firstMinPartSize++;
        }
        int partSize = firstMinPartSize;
        int floorToThrow = firstMinPartSize;
        // find floor where first egg breaks
        while (floorToThrow < floorNumber) {
            throwsList.add(floorToThrow);
            floorToThrow += --partSize;
        }
        throwsList.add(floorToThrow);
        floorToThrow -= partSize - 1;
        // find second egg breaks
        while (floorToThrow != floorNumber) {
            throwsList.add(floorToThrow);
            floorToThrow++;
        }
        return throwsList;
    }

    /**
     * 6.6 There are hundred closed lockers. a man starts with opening each locker.
     * Then he changes the position of lockers that have have numbers % 2. Then  %3. And so on till 100.
     * Which locker will be opened in the end?
     * Answer: you should think how many times the position of locker changes.
     * It changes exactly number of times equal to number of different divisors of the number of locker.
     * To make the locker open it should be odd.
     * In all cases if number has a divisor div1 it will have also div2 so that div1 * div2 = number
     * The only way that number of divisors is odd in case if in one case div2 == div1
     * this is only possible if number is square of div1 (div2).
     * We should count how many square numbers we have till 100.
     */
    public static int squareCount(int number) {
        return (int) Math.sqrt(number);
    }
}
