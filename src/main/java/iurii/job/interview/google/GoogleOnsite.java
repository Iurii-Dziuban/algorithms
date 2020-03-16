package iurii.job.interview.google;

/**
 * 1) There is a two dimensional area (n x n), where in each cell represents a cost for the cell.
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
 * Solution: Brute Force - check each possible starting point for rectangle and and check all possible end points.
 * Move starting point to next cell. Small optimization is not to take rectangle if it is already bigger.
 *
 * Dynamic programming.
 *
 * Save the current sum in dp. Go first row and first column.
 * Next row and next column equal = [i-1][j] + [i][j - 1] - [i - 1][j - 1] + element[i][j]
 *
 * 2) There is a list of words. Find the longest linked list that can be organized using words from it,
 * so that each next word is created by adding a new letter at any place of the previous word.
 * Example:
 * r -> rg -> srg -> srig -> sring -> string . If all words are present in the list. And the size of the list is 6.
 * If there are no longer lists when return 6;
 *
 * 3) There is a two dimensional area (n x m) with starting point startX, startY and end point endX, endY
 * There are walls = 1, open points 0 => Find any path from start to end or return null if not exists.
 *
 * BFS or DFS on grid.
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
 * Q&A
 * - Assuming arrayList is big and saving the whole list does not make sense.
 * - Assuming that arrayList has specific length and there are no delete() or add operations, but
 * - Better to have Mapping with logging changes for each element that was changed. (Last change, instead of whole log)
 */
public class GoogleOnsite {

    /**
     * Each cell cost value >= 0
     * Idea is to use dynamic programming approach;
     * Traverse all rectangles that start and x, y and accumulate sum cost value.
     * Each next rectangle
     * @param area - cells with the costValue for cell
     * @param costValue (filter of all the rectangle values)
     * @return max square rectangle which is less or given cost value
     *
     * Time complexity: O(n^4) - n ^ 2 starting positions, n ^ 2 end positions
     * Space complexity: O(n^2) - to store all computed sums
     */
    public static int findMaxRectangleLessOrEqualGivenCostValue(int[][] area, int costValue) {
        if (area == null || area.length == 0 || area[0] == null || area[0].length == 0) {
            return 0;
        }
        int n = area.length;
        int x = 0;
        int y = 0;
        int max = 0;
        while (x != n) {
            int [][] sum = new int[n][n];
            for (int i = x; i < n; i++) {
                for (int j = y;  j < n; j++) {
                    sum[i][j] = area[i][j] + ((i - 1 >= 0) ? sum[i - 1][j]: 0) + ((j - 1 >= 0) ? sum[i][j - 1]: 0)
                            - ((i - 1 >= 0 && j - 1 >= 0) ? sum[i - 1] [j - 1] : 0);
                    if (sum[i][j] <= costValue) {
                        max = Math.max(max, Math.abs((i - x + 1) * (j - y + 1)));
                    }
                }
            }
            y++;
            if (y == n) {
                y = 0;
                x++;
            }
        }
        return max;
    }
}
