package iurii.job.interview.topcoder.srm501;
/**
 Problem Statement
    
Fox Ciel likes sequences of integers. 
She especially likes sequences that are either an arithmetic progression of integers 
or a geometric progression of integers with an integer common ratio. 
She calls these beautiful sequences. 
An arithmetic progression is a sequence of numbers such 
that the difference of any two consecutive numbers of the sequence is a constant. 
A geometric progression is a sequence of numbers where each number after the first 
is found by multiplying the previous one by a constant non-zero number which is called the common ratio.
 
Ciel has a sequence of integers. She says that an integer is good if she can obtain a beautiful sequence by appending the integer to the end of the sequence. You are given a int[] seq. Calculate the number of good integers for the given sequence. If there are infinitely many good integers, return -1.
Definition
    
Class:
FoxProgression
Method:
theCount
Parameters:
int[]
Returns:
int
Method signature:
int theCount(int[] seq)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
64
Constraints
-
seq will contain between 1 and 50 elements, inclusive.
-
Each element of seq will be between 1 and 500, inclusive.
Examples
0)

    
{1, 2, 4, 8}
Returns: 1
This sequence can become a geometric progression with ratio 2 if you append 16.
1)

    
{5, 3, 1}
Returns: 1
This sequence can become an arithmetic progression with difference -2 if you append -1. Note that neither the difference/ratio nor the appended integer has to be strictly positive.
2)

    
{1, 1}
Returns: 1
If you append 1, this sequence becomes a geometric progression (with ratio 1) and an arithmetic progression (with ratio 0) simultaneously. Despite the two reasons to call the resulted sequence "beautiful", there is still only one good integer.
3)

    
{8, 4}
Returns: 1
This sequence can become an arithmetic progression if you append 0. It can also become a geometric progression with ratio 0.5 if you append 2, but progressions with non-integer ratio are not beautiful.
4)

    
{1}
Returns: -1
Every integer is good for the given sequence.
5)

    
{4, 8}
Returns: 2
There are two good integers: appending 12 turns this sequence into an arithmetic progression with difference 4, and appending 16 turns it into a geometric progression with ratio 2.
6)

    
{1, 3, 4}
Returns: 0
This sequence is already neither an arithmetic nor a geometric progression, so nothing that you append can fix it.
 */
public class FoxProgression {
    public int theCount (int[] seq) {
    if (seq.length <= 1) {
        return -1;
    } else {
        double mult = (double) seq[1] / seq[0];
        int sum = seq[1] - seq[0];
        boolean isA = true;
        boolean isG = true;
        for (int i = 1; i < seq.length; i++) {
            isG = seq[i] / seq[i-1] == mult;
            isA = seq[i] - seq[i-1] == sum;
            if (!isA && !isG) {
                return 0;
            }
        }
        if (isA && isG && seq[seq.length - 1] * mult != seq[seq.length - 1] + sum) {
            return 2;
        }
        return 1;
    }
    } 
 }