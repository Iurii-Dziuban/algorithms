package iurii.job.interview.google;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 1) There is a two-dimensional area (n x n), where in each cell represents a cost for the cell.
 * There is a cost value. It is needed to take the biggest possible rectangle area from the given area
 * which total cell cost is <= given cost value.
 * Example:
 * [1 2 1 1 1]
 * [2 3 4 5 2]
 * [1 3 2 2 2]
 * [1 2 3 4 3]
 * [2 3 2 1 2]
 * Cost value = 3 => rectangle with [1 1 1] is the best and its size is  1 x 3  = 3. Answer = 3 .
 *
 * Solution: Brute Force - check each possible starting point for rectangle and check all possible end points.
 * Move starting point to next cell. Small optimization is not to take rectangle if it is already bigger.
 *
 * Dynamic programming.
 *
 * Save the current sum in dp. Go first row and first column.
 * Next row and next column equal = [i-1][j] + [i][j - 1] - [i - 1][j - 1] + element[i][j]
 *
 * Looks similar to https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/
 * But leetcode question is different (max sum of rectangle no larger than k)
 * and in google question to find max area rectangle with sum no larger than k
 *
 * 2) There is a list of words. Find the longest linked list that can be organized using words from it,
 * so that each next word is created by adding a new letter at any place of the previous word.
 * Example:
 * r -> rg -> srg -> srig -> sring -> string . If all words are present in the list. And the size of the list is 6.
 * If there are no longer lists when return 6;
 *
 * Looks like it is from https://leetcode.com/problems/longest-string-chain/
 *
 * 3) There is a two-dimensional area (n x m) with starting point startX, startY and end point endX, endY
 * There are walls = 1, open points 0 => Find any path from start to end or return null if not exists.
 *
 * BFS or DFS on grid.
 * better BFS to find the closest path.
 * maintain set of visited points.
 *
 * 4) Design Google photos. (System Design interview) Main functions: Upload photo, view photo.
 * Calculations:
 * 500 million users, 1/10 active users
 * on average 40 photos per day
 * each photo 3 Mb
 *
 * Total storage for 1 day = 500 * 10^6 / 10 * 40 3 * 10^6 = 600 * 10^12 = 600 PB
 * 1 computer storage 1 TB
 * Number of computers per day = 600 PB / 1 TB = 600 000
 * Total storage for 5 years = 365 * 5 * 600 PB;
 * Total number of computers per 5 years = 6 * 10^5 * 365 * 5 = 10^9 = 1 Billion.
 *
 * Two different set of computers for read and write. Read is 10 times more than write.
 * For read - servers in different regions to make less latency (closer to the user) . CDN (content distribution networks should be used)
 * Cache first N for each user. Use least frequently used cache policy - cache 20% of days traffic.
 * Cache on the client side (phone or browser) / cache smaller images of real photos
 * Use consistent hashing to easily match user to the server and rebalance in case computer dies/joins
 * For each user master/slave model might be used so that data replication is done
 * Distribution of photos can be done by id, so that aggregation servers will be needed. Or by user.
 * The problem by user is in case user is very active (in case of sharing, etc. more popular, famous) which can be
 * updated with caching more popular users.
 * Using consistent hashing will help to navigate to particular set of servers.
 *
 * Protocols: HTTPS - secure by the user, internal queues, etc. might be used
 * as from CAP theorem Availability matters more than consistency. Uploaded photo might be seen later.
 *
 * Databases: Metadata database to store the locations of photos in distributed, when it is created, etc.
 * Can be SQL or NoSQL depending on the operations.
 * Photos itself stored in the distributed file storage
 *
 * 5) Extend ArrayList to support two operations: takeSnapshot to save current state of element s and return identifier.
 * And add get(long snapshotId, int index) function to get arraylist element from specific snapshot by index.
 *
 *
 * Q&A
 * - Assuming arrayList is big and saving the whole list does not make sense.
 * (Assuming copying array on each take snapshot too costly.)
 * - Assuming that arrayList has specific length and there are no delete() or add operations, but
 * - Better to have Mapping with logging changes for each element that was changed. (Last change, instead of whole log)
 *
 * Going to task -> solution one by one
 */
public class GoogleOnsite {


    // ========================== Task 1 ========================================
    /**
     * Task 1.
     * 1) There is a two-dimensional area (n x n), where in each cell represents a cost for the cell.
     *  * There is a cost value. It is needed to take the biggest possible rectangle area from the given area
     *  * which total cell cost is <= given cost value.
     *  * Example:
     *  * [1 2 1 1 1]
     *  * [2 3 4 5 2]
     *  * [1 3 2 2 2]
     *  * [1 2 3 4 3]
     *  * [2 3 2 1 2]
     *  * Cost value = 3 => rectangle with [1 1 1] is the best and its size is  1 x 3  = 3. Answer = 3 .
     *  *
     *  * Solution: Brute Force - check each possible starting point for rectangle and and check all possible end points.
     *  * Move starting point to next cell. Small optimization is not to take rectangle if it is already bigger.
     *  *
     *  * Dynamic programming.
     *  *
     *  * Save the current sum in dp. Go first row and first column.
     *  * Next row and next column equal = [i-1][j] + [i][j - 1] - [i - 1][j - 1] + element[i][j]
     *
     *
     * Each cell cost value >= 0
     * Idea is to use dynamic programming approach;
     * Traverse all rectangles that start and x, y and accumulate sum cost value.
     * Each next rectangle
     *
     * @param matrix - cells with the costValue for cell
     * @param costValue (filter of all the rectangle values)
     * @return max square rectangle which is less or given cost value
     *
     * Brute force with memoization : for each cell as starting position
     *
     * Time complexity: O(n^4) - n ^ 2 starting positions, n ^ 2 end positions
     * Space complexity: O(n^2) - to store all computed sums
     */
    public static int findMaxRectangleLessOrEqualGivenCostValue_BruteForceWithMemoization(int[][] matrix, int costValue) {
        // the main idea is to have prefix sum array to calculate costValue for rectangle in O(1)
        // https://leetcode.com/problems/range-sum-query-2d-immutable/

        // check condition
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int size = matrix.length;
        // starting index
        int x = 0;
        int y = 0;
        int max = 0;
        while (x != size) {
            int [][] sum = new int[size][size];
            for (int i = x; i < size; i++) {
                for (int j = y;  j < size; j++) {
                    sum[i][j] = matrix[i][j]
                            + ((i - 1 >= 0) ? sum[i - 1][j]: 0)
                            + ((j - 1 >= 0) ? sum[i][j - 1]: 0)
                            - ((i - 1 >= 0 && j - 1 >= 0) ? sum[i - 1] [j - 1] : 0);
                    // potentially break cycles earlier if cost increased more than costValue
                    // but worst case is check all.
                    if (sum[i][j] <= costValue) {
                        max = Math.max(max, Math.abs((i - x + 1) * (j - y + 1)));
                    }
                }
            }
            y++;
            if (y == size) {
                y = 0;
                x++;
            }
        }
        return max;
    }


    /**
     * Trying to find the best way using approach of method `maxSumSubmatrix` to solve leetcode problem
     *
     * @param matrix - cells with the costValue for cell
     * @param costValue (filter of all the rectangle values)
     * @return max square rectangle which is less or given cost value
     */
    public static int findMaxRectangleLessOrEqualGivenCostValue(int[][] matrix, int costValue) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        Rectangle res = new Rectangle();
        res.sum = Integer.MIN_VALUE;

        // Improvement 1. check rows > cols : run algorithm on cols instead of rows.
        // For simplicity - here continue algo on rows.

        // Stores 1D representation of matrix
        int[] rowSum = new int[matrix[0].length]; // based on number of columns
        for (int i = 0; i < rows; i++) {
            Arrays.fill(rowSum, 0); // reset array of rowSum starting from rowIndex = i;
            // convert matrix from i..row into 1D array
            for (int row = i; row < rows; row++) {
                // height of considered rectangles
                int height = row - i + 1;
                // add current row element to previous rows sum collected for this column
                for (int col = 0; col < cols; col++) {
                    rowSum[col] += matrix[row][col];
                }
                // Improvement 2. kadane improvement : if max <= k no need to run algo for that round.
                // we can take row.length here
                int max = maxSubArrayKadaneSimplified(rowSum);
                if (max <= costValue) {
                    int sum = Arrays.stream(rowSum).sum();
                    if (res.height * res.width <= height * cols) {
                        res.height = height;
                        res.width = cols;
                        res.sum = sum;
                    }
                    continue;
                }
                // run 1D algorithm for rowSum
                updateResult(rowSum, costValue, res, height);
                // if result is k, this is the best possible answer,
                // but there might be bigger rectangle with same value, so do not return
            }
        }
        return res.width * res.height;
    }

    private static void updateResult(int[] nums, int k, Rectangle res, int height) {
        // running sum
        int sum = 0;
        // Container to store sorted prefix sums  with mapping to last index to be able to restore width
        TreeMap<Integer, Integer> sortedSum = new TreeMap<>();
        // adding 0 as initially it is prefix sum for empty sub-array and -1 as index
        sortedSum.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num;
            // get X where running sum - X <= k such that sum - X closest to k
            Map.Entry<Integer, Integer> x = sortedSum.ceilingEntry(sum - k);
            // if x is found - update global max value
            if (x != null) {
                // width of subarray is current index minus previous index which has needed (sum - k)
                int width = i - x.getValue();
                if (res.size() < height * width) {
                    res.sum = sum - x.getKey();
                    res.height = height;
                    res.width = width;
                }

            }
            // first must win in case of collision
            if (!sortedSum.containsKey(sum)) {
                sortedSum.put(sum, i);
            }
        }
    }

    /**
     * Rectangle class to hold sum of rectangle cells its height and width
     */
    public static class Rectangle {
        int sum;
        int width;
        int height;

        int size() {
            return width * height;
        }
    }

    // ========================== End of Task1 ========================================

    // ========================== follow up on Task 1 details.
    /**
     * https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/
     *
     * Solution approach : prefix sum on 1D SortedContainer (TreeSet) extended to 2D
     * - Improvement 1. Complexity of algo depends more on number of rows than columns
     * - Improvement 2. Using Kadane`s algo check if max sub array sum <= k - take largest;
     *
     * and what if number of rows is more than number of columns : transpose matrix;
     *
     * k == costValue
     *
     * Time complexity: O(min(N,M) ^ 2 x max(N,M) * log(max(N,M))):
     *                  - finding result for 1D : M log M
     *                  - but running it for N^2 iterations for rows
     *                  min/max here just for changing algo running on rows or cols.
     *
     * Memory / Space complexity : O(max(N,M)) maintaining array for rows or cols (which is smaller)
     *
     * @param matrix - cells with the costValue for cell
     * @param k (filter of all the rectangle values)
     *
     * @return max submatrix sum <= k
     */
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int res = Integer.MIN_VALUE;

        // Improvement 1. check rows > cols : run algorithm on cols instead of rows.
        // For simplicity - here continue algo on rows.

        // Stores 1D representation of matrix
        int[] rowSum = new int[matrix[0].length]; // based on number of columns
        for (int i = 0; i < rows; i++) {
            Arrays.fill(rowSum, 0); // reset array of rowSum starting from rowIndex = i;
            // convert matrix from i till row into 1D array
            for (int row = i; row < rows; row++) {
                // add current row element to previous rows sum collected for this column
                for (int col = 0; col < cols; col++) {
                    rowSum[col] += matrix[row][col];
                }
                // Improvement 2. kadane improvement : if max <= k no need to run algo for that round it is result.
                int max = maxSubArrayKadaneSimplified(rowSum);
                if (max <= k) {
                    res = Math.max(max, res);
                    continue;
                }
                // run 1D algorithm for rowSum
                res = updateResult(rowSum, k, res);
                // if result is k, this is the best possible answer, so return
                if (res == k) {
                    return k;
                }
            }
        }
        return res;
    }

    // prefix sums - how they help?
    // current sum - each prefix sum : gives all potential sub arrays for this index
    private static int updateResult(int[] nums, int k, int res) {
        int max = res;
        // running sum
        int sum = 0;
        // Container to store sorted prefix sums
        TreeSet<Integer> sortedSum = new TreeSet<>();
        // adding 0 as initially it is prefix sum for empty sub-array
        sortedSum.add(0);
        for (int num : nums) {
            sum += num;
            // get X where running sum - X <= k such that sum - X closest to k
            Integer x = sortedSum.ceiling(sum - k);
            // if x is found - update global max value
            if (x != null) {
                max = Math.max(max, sum - x);
            }
            sortedSum.add(sum);
        }
        return max;
    }


    /**
     * Task simpler than current to query rectangle sum in matrix
     */

    /**
     * Approach to have smart caching for rectangles starting from [0; 0] ending [row][col]:
     *
     * Formula : dp[row2][col2] - dp[row1-1][col2] - dp[row2][col1 - 1] + dp[row1 - 1][col1 -1]
     *
     * Time Complexity:  pre-computation : O(N x M) ; query : O(1)
     * Space Complexity: O(N xM) for caching / DP
     */
    // https://leetcode.com/problems/range-sum-query-2d-immutable/
    class NumMatrixSmartCaching {

        private final int[][] dp;

        public NumMatrixSmartCaching(int[][] matrix) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            dp = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    dp[i][j] = ((i - 1 >= 0) ? dp[i - 1][j] : 0)
                            + ((j - 1 >= 0) ? dp[i][j - 1] : 0)
                            - ((i - 1 >= 0 && j - 1 >= 0) ? dp[i-1][j-1] : 0)
                            + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return dp[row2][col2]
                    + ((row1 - 1 >= 0 && col1 - 1 >= 0) ?  dp[row1 - 1][col1 - 1] : 0)
                    - ((row1 - 1 >= 0) ? dp[row1 - 1][col2] : 0)
                    - ((col1 - 1 >= 0) ? dp[row2][col1 - 1] : 0);
        }
    }

    /**
     * See 2D matrix as M rows of 1D arrays; sum or the reqion row by row
     *
     * Time Complexity:  pre-computation : O(N x M) ; query : O(N) per row
     * Space Complexity: O(N x M) for caching / DP per row (and column in row)
     */
    class NumMatrixCachingRows {

        // sum of elements by row
        private final int[][] dp;

        public NumMatrixCachingRows(int[][] matrix) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            dp = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    dp[i][j] = ((j - 1 >= 0) ? dp[i][j - 1] : 0) + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int row = row1; row <= row2; row++) {
                sum += dp[row][col2] - ((col1 - 1) >= 0 ? dp[row][col1 -1] : 0);
            }
            return sum;
        }
    }


    // Kadane`s algorithm maximum sub array
    /**
     * Works with negative numbers. Important : at least one number in arr.
     * Invariant: current max sub array value is either subarray + element or element itself
     * smart way to update : if previous max sub sum was negative - it is better to restart calculation from current
     * element.
     *
     * Time complexity : O(N) - going through array once
     * Memory/ Space complexity : O(1) - to maintain cur and max subarray sum.
     *
     * @param nums - array
     * @return max subarray sum value;
     */
    private int maxSubArrayKadane(int[] nums) {
        int maxSubarray = nums[0];
        int curSubarray = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            curSubarray =  Math.max(curSubarray + num, num);
            maxSubarray = Math.max(maxSubarray, curSubarray);
        }
        return maxSubarray;
    }

    private static int maxSubArrayKadaneSimplified(int[] nums) {
        int maxKadane = Integer.MIN_VALUE;
        int curSubarray = 0;
        for (int num : nums) {
            curSubarray =  Math.max(curSubarray + num, num);
            maxKadane = Math.max(maxKadane, curSubarray);
        }
        return maxKadane;
    }

    // Divide and Conquer maximum sub array
    /**
     * Works with negative numbers.
     *
     * Divide and conquer approach is to split problem into smaller chunks
     * Solve smaller chunks and combine them to give final answer.
     * Here:
     * - The maximum subarray contained only on the left side
     * - The maximum subarray contained only on the right side
     * - The maximum subarray that can use elements from both sides
     *
     * Time complexity : O(N * log N) - dividing array in half but need to go through all N elements,
     * diving in halves is done log N times until reaching one element array best case.
     *
     * Memory/ Space complexity : O(log N) - additional memory occupied is used on recursion stack,
     * which is of size log N (number of recursion calls).
     *
     * @param nums - array
     * @return max subarray sum value;
     */
    // Divide and conquer algorithm
    private int maxSubArrayDivideAndConquer(int[] nums) {
        return findBestSubarray(0, nums.length - 1, nums);
    }

    private int findBestSubarray(int l, int r, int[] nums) {
        // base case
        if (l > r) {
            return Integer.MIN_VALUE;
        }

        int mid = (l + r) / 2;
        int cur = 0;
        int lbest = 0;
        int rbest = 0;

        // left best
        for (int i = mid - 1; i >= l; i--) {
            cur += nums[i];
            lbest = Math.max(lbest, cur);
        }

        // reset
        cur = 0;

        // right best
        for (int i = mid + 1; i <= r; i++) {
            cur += nums[i];
            rbest = Math.max(rbest, cur);
        }

        int bestCombined = lbest + nums[mid] + rbest;

        int lhalf = findBestSubarray(l, mid - 1, nums);
        int rhalf = findBestSubarray(mid + 1, r, nums);

        // largest of 3 is the answer
        return Math.max(bestCombined, Math.max(lhalf, rhalf));
    }

    // ============== end of Task1 one and Task1 follow up ===========

    /**
     * Task2. There is a list of words. Find the longest linked list that can be organized using words from it,
     *  so that each next word is created by adding a new letter at any place of the previous word.
     *  Example:
     *  r -> rg -> srg -> srig -> sring -> string . If all words are present in the list. And the size of the list is 6.
     *  If there are no longer lists when return 6;
     *
     *  https://leetcode.com/problems/longest-string-chain/
     */
    /**
     * Solution 1. Top-down approach with memoization and recursive approach (without sorting)
     *
     * @param words words
     * @return longest string chain length
     */
    // Time complexity O(N * L^2) - iterate over N words for each word its length L and to create new word spending L
    // Memory complexity : O (N) : set of N words and map of N words + stack of max N words
    public static int longestStrChainTopDown(String[] words) {
        // Top down with memoization
        Set<String> wordsPresent = Arrays.stream(words).collect(Collectors.toSet());
        // memo : word to the longest chain until word
        Map<String, Integer> memo = new HashMap<>();
        int ans = 0;
        for (String word : words) {
            ans = Math.max(ans, dfs(wordsPresent, memo, word));
        }
        return ans;
    }

    private static int dfs(Set<String> wordsPresent, Map<String, Integer> memo, String word) {
        if (memo.containsKey(word)) {
            return memo.get(word);
        }
        StringBuilder sb = new StringBuilder(word);
        // max sequence length with cur word as last.
        int maxLength = 1;
        for (int i = 0; i < word.length(); i++) {
            sb.deleteCharAt(i);
            String newWord = sb.toString();
            if (wordsPresent.contains(newWord)) {
                int curLength = 1 + dfs(wordsPresent, memo, newWord);
                maxLength = Math.max(curLength, maxLength);
            }
            sb.insert(i, word.charAt(i));
        }
        memo.put(word, maxLength);
        return maxLength;
    }

    /**
     * Solution 2: Bottom - up approach without need for recursion (with sorting at first)
     * @param words words
     * @return longest string chain length
     */
    // Time complexity O(N * log N + N * L^2) - sort words iterate over N words for each word its length L and to create new word spending L
    // Memory complexity : O (N) : set of N words and map of N words + stack of max N words
    public static int longestStrChainBottomUp(String[] words) {
        // Bottom up with memoization
        Arrays.sort(words, (a , b) -> a.length() - b.length());
        // memo : word to longest chain until word
        Map<String, Integer> memo = new HashMap<>();
        int ans = 1;
        for (String word : words) {
            int presentLength = 1;
            // find possible predecessors by removing one letter
            StringBuilder sb = new StringBuilder(word);
            // max sequence length with cur word as last.
            for (int i = 0; i < word.length(); i++) {
                sb.deleteCharAt(i);
                String predecessor = sb.toString();
                int prevLength = memo.getOrDefault(predecessor, 0);
                presentLength = Math.max(presentLength, prevLength + 1);
                sb.insert(i, word.charAt(i));
            }
            memo.put(word, presentLength);
            ans = Math.max(ans, presentLength);
        }
        return ans;
    }

    // ========================== end of Task 2 =================================


    // ========================== Task 3 ========================================
    /**
     * Task3. There is a two-dimensional area (n x m) with starting point startX, startY and end point endX, endY
     * There are walls = 1, open points 0 => Find any path from start to end or return null if not exists.
     *
     * Potential Solutions:
     * 1. DFS approach. (recursive and iterative)
     * Pluses:
     *      1. path will be already in call Stack
     * Minuses:
     *      1. We will find any path and not the shortest
     *
     * 2. BFS approach.
     * Pluses:
     *      1. We will find the shortest path
     * Minuses:
     *      1. Constructing path is additional step. Backtracking.
     *
     * In both approaches maintain set of visited points.
     *
     * Implementing here BFS approach
     */
    public static List<int[]> findPath(int[][] matrix, int[] p1, int[] p2) {
        // check conditions

        // skipping check that p1 and p2 lengths are equal 2;
        // skipping check that matrix is not empty and consists only from {0, 1}

        int rows = matrix.length;
        int cols = matrix[0].length;

        // point 1 is in matrix
        if (p1[0] >= rows || p1[0] < 0) {
            return null;
        }
        if (p1[1] >= cols || p1[1] < 0) {
            return null;
        }
        // point 2 is in matrix
        if (p2[0] >= rows || p2[0] < 0) {
            return null;
        }
        if (p2[1] >= cols || p2[1] < 0) {
            return null;
        }

        // point 1 is not equal 1
        if (matrix[p1[0]][p1[1]] == 1) {
            return null;
        }
        if (matrix[p2[0]][p2[0]] == 1) {
            return null;
        }
        // check ends

        // tracking previous cell we come from
        // Note: arrays call not be used as map/set keys!
        // Using List<Integer> here brings need to convert between List<Integer> and int[]
        // Alternatives : ImmutableList.of(x, y) - guava or create own object Pair with equals/hashcode (consider Lombok)
        // Note: moves should be implemented then the same way for consistency
        Map<List<Integer>, int[]> cellToPreviousCell = new HashMap<>();
        // cells to check
        Set<List<Integer>> cells = new HashSet<>();
        cells.add(asList(p1));
        cellToPreviousCell.put(asList(p1), null);
        // moves
        int[][] moves = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        int pathLength = 0;
        boolean found = false;

        while (!cells.isEmpty() && !found) {
            Set<List<Integer>> nextCells = new HashSet<>();

            for (List<Integer> cellList : cells) {
                int[] cell = cellList.stream().mapToInt(i -> i).toArray();
                if (Arrays.equals(p2, cell)) {
                    found = true;
                    break;
                }
                for(int[] move : moves) {
                    int[] next = new int[]{cell[0] + move[0], cell[1] + move[1]};
                    // check boarders
                    if (next[0] >= 0 && next[0] < rows && next[1] >= 0 && next[1] < cols) {
                        // check walls
                        if (matrix[next[0]][next[1]] != 1) {
                            // check seen
                            if (!cellToPreviousCell.containsKey(asList(next))) {
                                cellToPreviousCell.put(asList(next), cell);
                                nextCells.add(asList(next));
                            }
                        }
                    }
                }
            }
            // update for next level
            cells = nextCells;
            pathLength++;
        }
        if (!found) {
            return null;
        }
        // construct path from p2 to p1
        List<int[]> path = new ArrayList<>();
        int[] cur = p2;
        path.add(p2);
        while(cellToPreviousCell.get(asList(cur)) != null) {
            int[] cell = cellToPreviousCell.get(asList(cur));
            path.add(cell);
            cur = cell;
        }
        //from p1 to p2
        Collections.reverse(path);
        System.out.printf("path length from {%s} to {%s} is %d%n", Arrays.toString(p1), Arrays.toString(p2), pathLength);
        return path;
    }

    private static List<Integer> asList(int[] p1) {
        return Arrays.asList(p1[0], p1[1]);
    }

    // ========================== End of Task 3 ========================================

    // ========================== Task 4 ========================================
    /**
     * * 4) Design Google photos. (System Design interview) Main functions: Upload photo, view photo.
     *  * Calculations:
     *  * 500 million users, 1/10 active users
     *  * on average 40 photos per day
     *  * each photo 3 Mb
     *  *
     *  * Total storage for 1 day = 500 * 10^6 / 10 * 40 3 * 10^6 = 600 * 10^12 = 600 PB
     *  * 1 computer storage 1 TB
     *  * Number of computers per day = 600 PB / 1 TB = 600 000
     *  * Total storage for 5 years = 365 * 5 * 600 PB;
     *  * Total number of computers per 5 years = 6 * 10^5 * 365 * 5 = 10^9 = 1 Billion.
     *  *
     *  * Two different set of computers for read and write. Read is 10 times more than write.
     *  * For read - servers in different regions to make less latency (closer to the user) . CDN (content distribution networks should be used)
     *  * Cache first N for each user. Use least frequently used cache policy - cache 20% of days traffic.
     *  * Cache on the client side (phone or browser) / cache smaller images of real photos (thumbnails)
     *  * Use consistent hashing to easily match user to the server and re-balance in case computer dies/joins
     *  * For each user master/slave model might be used so that data replication is done
     *  * Distribution of photos can be done by id, so that aggregation servers will be needed. Or by user.
     *  * The problem by user is in case user is very active (in case of sharing, etc. more popular, famous) which can be
     *  * updated with caching more popular users.
     *  * Using consistent hashing will help to navigate to particular set of servers.
     *  *
     *  * Protocols: HTTPS - secure by the user, internal queues, etc. might be used
     *  * as from CAP theorem Availability matters more than consistency. Uploaded photo might be seen later.
     *  *
     *  * Databases: Metadata database to store the locations of photos in distributed, when it is created, etc.
     *  * Can be SQL or NoSQL depending on the operations.
     *  * Photos itself stored in the distributed file storage
     */
    // ========================== End of Task 4 ========================================

    // ========================== Task 5 ========================================
    /**
     * 5) Extend ArrayList to support two operations: takeSnapshot to save current state of element s and return identifier.
     *  And add get(long snapshotId, int index) function to get arraylist element from specific snapshot by index.
     *
     *  Approaches:
     *  1. On each takeSnapshot copy whole arrayList into new Map<snapshotId; arrayList>
     *  Time Complexity : O(N) to copy snapshot; O(1) to get element
     *  Space Complexity : O(N * S) where S is the number of snapshots.
     *
     *  // first approach is two expensive, if there are only some values updated from previous snapshot,
     *  and we continue to copy whole list (expensive in time and space)
     *
     *  2. What if we track only changes per index and  if element was not changed we keep it.
     *  Potential implementation of that is two have map<snapshotId, copiedValue>
     *  But here we will continue to copy the value, even if value did not change (space complexity!)
     *
     *  What if we copy only if value was change?
     *
     *  But in that case how can we get element at specific snapshot if it was not changed?
     *  1. One way is to continue decreasing snapshotId by 1 until we find value in Map (linear time O(S))
     *  2. Or we can make use of TreeMap at search for first floor key, which is O(log S) time
     *
     *  We should "log" all the updates (indexes) that are done to specific element to know which indexes
     *  are changed since previous snapshot.
     *
     *  And copy only them.
     *
     *  Let`s implement it
     */
    public static class SnapshotArrayList<T> extends ArrayList<T> {

        // no delete add operations (throws unsupported operation exception)
        // size is fixed
        private final int size;
        private int snapshotIndex = 0;

        private final List<TreeMap<Integer, T>> snapshotIndexToElement;
        private final Set<Integer> updatedIndexes;

        public SnapshotArrayList(int initialCapacity) {
            super(initialCapacity);
            size = initialCapacity;
            snapshotIndexToElement = new ArrayList<>(initialCapacity);
            updatedIndexes = new HashSet<>();
            // initialize all elements were updated.
            IntStream.range(0, initialCapacity).forEach(updatedIndexes::add);
        }

        @Override
        public T set(int index, T element) {
            updatedIndexes.add(index);
            return super.set(index, element);
        }

        /**
         * Takes snapshot of the arrayList;
         * @return identifier (for simplicity index of snapshot)
         */
        public int takeSnapshot() {
            // save snapshot
            // go only through elements that were updated since last update
            for (int index : updatedIndexes) {
                // get log of updates for index. If it is not created, create it and put into array.
                TreeMap<Integer, T> treeMap = snapshotIndexToElement.get(index);
                if (treeMap == null) {
                    treeMap = new TreeMap<>();
                    snapshotIndexToElement.set(index, treeMap);
                }
                // put the latest (updated!) value from array list into at snapshotIndex -> index mapping
                treeMap.put(snapshotIndex, get(index));
            }
            // reset set
            updatedIndexes.clear();
            return ++snapshotIndex;
        }

        /**
         * To get the latest value from Map for index : with maxKey <= snapshotIndex
         * using TreeMap.floor value to find max possible <= snapshotIndex
         *
         * @param snapshotId identifier (for simplicity index of snapshot)
         * @param index element index to get value
         * @return element value at index in snapshotId
         */
        public T get(int snapshotId, int index) {
            // returns snapshot value; if value was not changed at index
            // take the closest smallest snapshotId value and take its value
            return snapshotIndexToElement.get(index).floorEntry(snapshotId).getValue();
        }
    }
    // ========================== End of Task 5 ========================================
}
