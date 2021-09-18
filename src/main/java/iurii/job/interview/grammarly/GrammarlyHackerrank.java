package iurii.job.interview.grammarly;

import java.util.*;

/**
 * https://www.hackerrank.com/test/17kaqb094as/questions
 */
public class GrammarlyHackerrank {

    /**
     Array Reduction

     Find the minimum cost of reducing the array to one element

     There is an array of 'n' integers called 'num'. The array can be reduced by 1 element
     by performing a 'move'. Each move consists of the following three steps:

     - Pick two different elements num[i] and num[j], i ≠ j.
     - Remove the two selected elements from the array.
     - Add the sum of the two selected elements to the end of the array.

     Each move has a 'cost' associated with it: the sum of the two elements removed from the array during the move.
     Calculate the minimum total cost of reducing the array to one element.

     Example:
     num = [4,6,8]

     - Remove '4' and '6' in the first move at a cost of 4 + 6 = 10, and the resultant array is 'num' = [8,10].
     - Remove '8' and '10' in the second move at a cost of 8 + 10 = 18, and the resultant array is 'num' = [18].

     The total cost of reducing this array to one element using this sequence of moves is 10 + 18 = 28.
     This is just one set of possible moves. For instance, one could have started with '4' and '8'.
     Then 4 + 8 = 12, 'num' = [6, 12], 6 + 12 = 18, num'' = [18], cost = 12 + 18 = 30.

     Function Description

     Complete the function 'reductionCost' in the editor below.
     reductionCost has the following parameter(s):
     int num[n]: an array of integers
     Return
     int: the minimum total cost of reducing the input array to one element

     Constraints
     2 ≤ n ≤ 10^4
     0 ≤ num[i] ≤ 10^5

     Make the following moves to reduce the array num = [1, 2, 3]

     - Remove 1 and 2 at cost = 1 + 2 = 3, resulting in 'num' = [3, 3].
     - Remove 3 and 3 at cost = 3 + 3 = 6, resulting in 'num' = [6]

     Sum up the cost of each reduction to get 3 + 6 = 9

     Sample Case 1

     Sample Input 1
     [1, 2, 3, 4]

     Sample Output 1
     19

     Explanation 1

     Make the following moves to reduce the array num = [1, 2, 3, 4] :
     - Remove 1 and 2 at cost= 1 + 2 = 3, resulting in num= [3, 4, 3].
     - Remove 3 and 3 at cost = 3 + 3 = 6, resulting in num= [4, 6].
     - Remove 4 and 6 at cost = 4 + 6 = 10, resulting in num= [10].

     Sum up the cost of each reduction to get 3 + 6 + 10 = 19

     Using Greedy algo and taking always 2 min elements at each step.
     Min Heap will help with that.

     Time Complexity: O(n log n) ; adding to priority queue once
     and then removing 2 minimal elements is O(1) but inserting 1 element is log N,
     and it is done N times, so it is still O(n log n)

     Space complexity: O(N) to  store N elements in the queue and O(1) to store temp sum and cost function
     */
    public static int reductionCost(List<Integer> num) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // min heap is default
        // fill min heap
        minHeap.addAll(num);
        int cost = 0;
        // making each step to calculate min cost function
        while (minHeap.size() > 1) {
            int value1 = minHeap.poll();
            int value2 = minHeap.poll();
            int sum = value1 + value2;
            cost += sum;
            minHeap.add(sum);
        }
        return cost;
    }

    /**
     2. Scatter-Palindrome

     A palindrome is a string which reads the same forward and backwards, for example, 'tacocat' and 'mom'.
     A string is a scatter-palindrome if its letters can be rearranged to form a palindrome.
     Given an array consisting of 'n' strings, for each string,
     determine how many of its substrings are scatter-palindromes.
     A substring is a contiguous range of characters within the string.

     Example:
     strToEvaluate = ['aabb']

     <p>The scatter-palindromes are <em>a, aa, aab, aabb, a, abb, b, bb, b.
     There are '9' substrings that are scatter-palindromes.

     Function Description

     Complete the 'scatterPalindrome' function in the editor below.

     scatterPalindrome has one parameter:
     string strToEvaluate[n]: the 'n' strings to be evaluated

     Returns
     int[n]: each element 'i' represents the number of substrings of strToEvaluate[i],  which are scatter-palindromes.

     Constraints
     - 1 ≤ n ≤ 100
     - 1 ≤ size of strToEvaluate[i] ≤ 1000
     - all characters of strToEvaluate[i] ∈ ascii[a-z]

     Sample Input For Custom Testing:
     strToEvaluate = [ "abc" ]

     Sample Output:
     3

     Explanation

     The substrings that are scatter-palindromes of the string 'abc' are:
     - a
     - b
     - c

     Sample Case 1:
     strToEvaluate = [ "bbrrg" ]

     Sample Output
     12

     Explanation

     The substrings that are scatter-palindromes of the string 'bbrrg' are:

     - b
     -bb
     -bbr
     -bbrr
     -bbrrg
     -b
     -brr
     -r
     -rr
     -rrg
     -r
     -g

     One of solutions I come up is to check each substring of each string,
     and count in a set/array [a-z] letters that are odd
     - knowing size of substring :
         - if it is even : set should be empty to be scattered palindrome
         - if it is odd : set should have exactly one element to be scattered palindrome
     Checking set size is O(1)
     What about updating set?
     If we update set based on one new character - it is O(1) time for hashset:
     - check if it is present in set :
         - if yes - remove
         - if no - add
     What about the whole algo:
     let m - strings count
     let n - max string size
     We need to go through each string : m
     and for each string we need to form each substring : there are n starting points and n end points for string :
     n^2
     and we will be updating set in O(1) time by 1 character, so

     Time Complexity : O(m x n^2)
     Space Complexity : O(1) actually, cause need to hold max all [a-z] 26 characters.

     Maybe it is not the optimal solution if we can reuse some space complexity to
     hold scattered palindromes... But can not come up with algo.
     */
    public static List<Integer> scatterPalindrome(List<String> strToEvaluate) {
        List<Integer> results = new ArrayList<>();
        for (String str : strToEvaluate) {
            results.add(scatterPalindromeCount(str));
        }
        return results;
    }

    private static int scatterPalindromeCount(String str) {
        int count = 0;
        // checking each starting point
        for (int start = 0; start < str.length(); start++) {
            // for each starting point collecting set of odd chars
            Set<Character> oddChars = new HashSet<>();
            for (int end = start; end < str.length(); end++) {
                // for each char update set of odd chars
                char c = str.charAt(end);
                if (oddChars.contains(c)) {
                    oddChars.remove(c);
                } else {
                    oddChars.add(c);
                }
                // check if substring is odd size or even
                boolean oddSize = (end - start) % 2 == 0;
                // if odd size and set of odd chars contains only one OR
                // if even size and set of odd chars is empty
                // this means substring is scattered palindrome, so add count
                if (oddSize && oddChars.size() == 1 || !oddSize && oddChars.isEmpty()) {
                    count++;
                }
            }
        }
        return count;
    }
}
