package iurii.job.interview.codility.zooplus.logic;

/**
 * You wake up in a room with 4 walls. On each of them, there is an ON/OFF switch.
 * However, you can not tell in what state each switch is. You can change the states of all/some
 * switches and shout "Java!". If all switches are in the same state, the door will open.
 * If not, the walls will spin around so quickly you don`t know which one is which.
 * In how many tries can you get out?
 *
 * Solution:
 *
 * From combinatorics it is a permutation lock, because the order matters.
 *
 * -- "Switches are in the same state" - it is either all ON or all OFF.
 *    For 4 switches there are 2^4 = 16 possibilities and 2 are the ones we seek.
 *
 * -- "Walls spin you do not know which one is which" - but you can figure it out
 * based on the positions
 *
 * What is important to notice is that there are two solutions and they are completely opposite - all ON or all OFF,
 * and they are opposite in binary form regardless what is the current state.
 * This means we can split the finding the solution into two sets:
 *
 * Switches:
 * 1 set - sum (all OFF, 3 OFF, 2 OFF) and set 2 - sum (all ON, 3 ON, 2 ON)
 *
 * So we can focus either on 1-set or 2-set to find the solution. Just to find the way to try all combinations
 * from the set.
 *
 * In the beginning we can ignore the current state and make all switches into position
 * 1) - - - - (also because after rotating will not be possible to find the positions)
 * After walls moved we can start doing switches with one up:
 * 2) + - - -
 * 3) - + - -
 * 4) - - + -
 * 5) - - - +
 * Regardless how the walls end ep it is easy to understand what was the positions of the switches before rotation.
 * For combitations for 2 off/ 2 on we need to take only ones from one set: for instance:
 * 6) - - + +
 * 7) + - - +
 * 8) - + - + (This should be the last tried, because after rotating will not be possible to determine)
 *
 * So it is possible to find the solution in 8 steps.
 *
 * Related to combinatorics, binary representation
 */
public interface OpenTheCombinationLock {
}
