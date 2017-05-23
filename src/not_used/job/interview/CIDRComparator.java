package iurii.job.interview;

/**
 * Compare ip addresses. Amazon test.
 * @author Iurii
 *
 */
public class CIDRComparator {

    /**
     * Test method
     * 
     * @param args
     */
    public static void main(String[] args) {
        CIDRComparator comparator = new CIDRComparator();
        System.out.println(comparator.compareCIDR("23.45.67.89/16", "23.45.255.255/16")); 
        System.out.println(comparator.compareCIDR("1.2.3.4/24", "1.2.3.4/16"));
        System.out.println(comparator.compareCIDR("172.84.26.128/16", "172.84.26.255/24"));
        System.out.println(comparator.compareCIDR("197.54.16.128/25", "197.54.16.127/25"));
        System.out.println(comparator.compareCIDR("197.54.16.128/32", "197.54.16.128/32"));
    }

    public enum CIDRComparatorResult {
        Equals, Subset, Superset, Disjoint
    }

    public CIDRComparatorResult compareCIDR(String a, String b) {
        String[] aIpAndSuffix = a.split("/");
        String[] aIp = aIpAndSuffix[0].split("\\.");
        short[] aIpInBytes = ipInBytes(aIp);

        String[] bIpAndSuffix = b.split("/");
        String[] bIp = bIpAndSuffix[0].split("\\.");
        short[] bIpInBytes = ipInBytes(bIp);

        int lA = Integer.valueOf(aIpAndSuffix[1]);
        int lB = Integer.valueOf(bIpAndSuffix[1]);
        int n = min(lA, lB);

        boolean arePrefixesEqual = arePrefixEqual(n, aIpInBytes, bIpInBytes);

        if (arePrefixesEqual) {
            if (lA == lB) {
                return CIDRComparatorResult.Equals;
            } else {
                if (lA > lB) {
                    return CIDRComparatorResult.Subset;
                } else {
                    return CIDRComparatorResult.Superset;
                }
            }
        } else {
            return CIDRComparatorResult.Disjoint;
        }

    }

    private int min(int la, int lb) {
        return la > lb ? lb : la;
    }
    
    private short[] ipInBytes(String[] ip) {
        short[] ipInBytes = new short[ip.length];
        for (int i = 0; i < ip.length; i++) {
            ipInBytes[i] = Short.valueOf(ip[i]);
        }
        return ipInBytes;
    }
    
    private boolean arePrefixEqual(int prefixLength, short[] aIp, short[] bIp) {
        for (int i = 0; i < aIp.length; i++) {
            int xorResult = aIp[i] ^ bIp[i];
            if (prefixLength < 8) {
                short compare = (short) (256 >> prefixLength);
                return (xorResult < compare);
            } else {
                prefixLength -= 8;
                if (xorResult != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
