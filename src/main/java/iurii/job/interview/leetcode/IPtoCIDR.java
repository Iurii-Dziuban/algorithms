package iurii.job.interview.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 751. IP to CIDR
 * Given a start IP address ip and a number of ips we need to cover n,
 * return a representation of the range as a list (of smallest possible length) of CIDR blocks.
 * A CIDR block is a string consisting of an IP, followed by a slash, and then the prefix length.
 * For example: "123.45.67.89/20".
 * That prefix length "20" represents the number of common prefix bits in the specified range.
 * <p>
 * http://bookshadow.com/weblog/2017/12/24/leetcode-ip-to-cidr/
 * https://tw.saowen.com/a/92b62b4272924d1438b0eba0c571df14fd632a62e845c6e09a9565b83126c417
 * Note:
 * - ip will be a valid IPv4 address.
 * - Every implied address ip + x (for x < n) will be a valid IPv4 address.
 * - n will be an integer in the range [1,1000].
 * <p>
 * Time complexity :
 * Auxiliary space complexity:
 */
public class IPtoCIDR {

    public List<String> ipToCIDR(String ip, int range) {
        long ipInLong = 0;
        String[] ips = ip.split("\\.");
        for (String ipPart : ips) {
            ipInLong = Integer.parseInt(ipPart) + ipInLong * 256;
        }
        List<String> ans = new ArrayList<>();
        while (range > 0) {
            long step = ipInLong & -ipInLong; // find lowest bit with 1
            while (step > range) step /= 2;
            ans.add(longToIP(ipInLong, (int) step));
            ipInLong += step;
            range -= step;
        }
        return ans;
    }

    private String longToIP(long x, int step) {
        int[] ans = new int[4];
        ans[0] = (int) (x & 255);
        x >>= 8;
        ans[1] = (int) (x & 255);
        x >>= 8;
        ans[2] = (int) (x & 255);
        x >>= 8;
        ans[3] = (int) x;
        int len = 33;
        while (step > 0) {
            len--;
            step /= 2;
        }
        return ans[3] + "." + ans[2] + "." + ans[1] + "." + ans[0] + "/" + len;
    }
}
