package iurii.job.interview.topcoder.srm505;

/**
  Problem Statement
    
A perfect sequence is a sequence such that all of its elements are non-negative integers 
and the product of all of them is equal to their sum. For example: {2,2}, {1,3,2} and {0,0,0,0} 
are perfect sequences and {4,5,6} and {0,2,-2} are not perfect sequences 
(4*5*6 is not equal to 4+5+6, and negative numbers are not allowed by the definition). 
 You are given a int[] seq. Return "Yes" if it is possible to change exactly one element of seq 
 so that the resulting sequence is perfect. Otherwise, return "No".

Definition
    
Class:
PerfectSequences
Method:
fixIt
Parameters:
int[]
Returns:
String
Method signature:
String fixIt(int[] seq)
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
Each element of seq will be between 0 and 1000000000 (10^9), inclusive.
Examples
0)

    
{1,3,4}
Returns: "Yes"
If we change the last element to 2, we have {1,3,2}. 1+3+2 = 1*3*2.
1)

    
{1,2,3}
Returns: "No"
This sequence is already perfect and it is not possible to change exactly one of its elements and keep it perfect.
2)

    
{1,4,2,4,2,4}
Returns: "No"

3)

    
{1000000,1,1,1,1,2}
Returns: "Yes"
It is possible to replace 1000000 with 6 to make the sequence become perfect.
4)

    
{8}
Returns: "Yes"
It is possible to change the first element to any non-negative number and the sequence will stay perfect.
5)

    
{2,0,2}
Returns: "No"
Note that {2,0,-2} is not considered a perfect sequence because negative numbers are not allowed by the definition.
 */
public class PerfectSequences {
    public String fixIt(int[] seq) {
        int negativeIndex = retrieveNegativeIndex(seq);
        if (negativeIndex == -2) {
            return "No";
        }
        
        if (negativeIndex == -1) {
            for (int i = 0; i< seq.length; i++) {
                if (canBePerfect(seq, i)) {
                    return "Yes";
                }
            }
            return "No"; 
        } else {
            return canBePerfect(seq, negativeIndex) ? "Yes" : "No";
        }
    }
    
    private boolean canBePerfect(int[] seq, int index) {
        int sum = 0;
        int prod = 1;
        for (int i = 0; i < seq.length; i++) {
            if (i != index) {
                sum += seq[i];
                prod *= seq[i];
            }
        }
        return (prod != 1) ? (sum % (prod - 1) == 0) && (sum / (prod - 1) != seq[index] && (sum / (prod - 1) > 0)) : sum == 0; 
    }
    
    /**
    returns -1 if all numbers are positive
            index of negative element if it is only one
            -2 if there are many negative elements
    */
    private int retrieveNegativeIndex(int[] seq) {
        int result = -1;
        for (int i = 0; i < seq.length; i++) {
            if (result >= 0 && seq[i] < 0) {
                return -2;
            }
            if (seq[i] < 0) {
                result = i;
            }
        }
        return result;
    }
}