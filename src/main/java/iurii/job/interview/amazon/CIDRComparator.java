package iurii.job.interview.amazon;

/**
 * Compare ip addresses networks. Amazon test.
 * <p>
 * There are two ip addresses followed by / and number of bits called "subnet mask"
 * <p>
 * Check if first subnet address is equal / subset / superset or disjoint to second subnet address.
 * <p>
 * Note:
 * Regarding input data:
 * assuming that both input values are correct valid values and no validation is needed.
 * <p>
 * info about CIDR notation
 * https://en.wikipedia.org/wiki/Classless_Inter-Domain_Routing
 *
 * Two common solutions: byte[] and long comparisons
 * Prefer long instead of byte[] -> less code and more readable.
 * But potentially byte[] solution can be extended to be used in IPv6 and long not.
 * @author Iurii
 */
public class CIDRComparator {

    private static final long _2_POWER_32 = 4294967296L;
    private static final int MAX_UNSIGNED_BYTE = 256;
    private static final int NUMBER_OF_BYTE_BITS = 8;

    public enum CIDRComparatorResult {
        Equals, Subset, Superset, Disjoint
    }

    // common method
    private CIDRComparatorResult getCidrComparatorResult(byte firstSubnetLength, byte secondSubnetLength, boolean arePrefixesEqualInLong) {
        if (arePrefixesEqualInLong) {
            if (firstSubnetLength == secondSubnetLength) {
                return CIDRComparatorResult.Equals;
            } else {
                if (firstSubnetLength > secondSubnetLength) {
                    return CIDRComparatorResult.Subset;
                } else {
                    return CIDRComparatorResult.Superset;
                }
            }
        } else {
            return CIDRComparatorResult.Disjoint;
        }
    }

    // --------- First solution ----------------------------------------------------------
    // Based on converting to byte array and comparing byte by byte
    // not so elegant, short and readable but more efficient from memory and time consumption
    // Note: assuming values are valid (if needed can be preprocessed)
    public CIDRComparatorResult compareCIDR(String firstSubnet, String secondSubnet) {
        String[] firstSubnetIpAndSuffix = firstSubnet.split("/");
        String[] firstSubnetIp = firstSubnetIpAndSuffix[0].split("\\.");
        byte[] firstSubnetIpInBytes = ipInBytes(firstSubnetIp);

        String[] secondSubnetIpAndSuffix = secondSubnet.split("/");
        String[] secondSubnetIp = secondSubnetIpAndSuffix[0].split("\\.");
        byte[] secondSubnetIpInBytes = ipInBytes(secondSubnetIp);

        byte firstSubnetLength = Byte.parseByte(firstSubnetIpAndSuffix[1]);
        byte secondSubnetLength = Byte.parseByte(secondSubnetIpAndSuffix[1]);
        byte shorterSubnetLength = (byte) Math.min(firstSubnetLength, secondSubnetLength);

        boolean arePrefixesEqual = arePrefixEqual(shorterSubnetLength, firstSubnetIpInBytes, secondSubnetIpInBytes);

        return getCidrComparatorResult(firstSubnetLength, secondSubnetLength, arePrefixesEqual);
    }

    // Note: using short, because Byte in java from -128 to 127 and we need from 0 to 255
    // and it is complex to organize unsigned logic: xor, comparison, shift with signed types
    private byte[] ipInBytes(String[] ip) {
        byte[] ipInBytes = new byte[ip.length];
        for (int i = 0; i < ip.length; i++) {
            short ipAddressOneUnsignedByte = Short.parseShort(ip[i]);
            assert ipAddressOneUnsignedByte >= 0 && ipAddressOneUnsignedByte < MAX_UNSIGNED_BYTE;
            ipInBytes[i] = packByte(ipAddressOneUnsignedByte);
        }
        return ipInBytes;
    }

    // method to compare two prefixes by prefix length
    private boolean arePrefixEqual(byte prefixLength, byte[] firstSubnetIp, byte[] secondSubnetIp) {
        for (int i = 0; i < firstSubnetIp.length; i++) {
            int xorResult = unpackByte(firstSubnetIp[i]) ^ unpackByte(secondSubnetIp[i]);
            if (prefixLength < NUMBER_OF_BYTE_BITS) {
                short compare = (short) (MAX_UNSIGNED_BYTE >> prefixLength);
                return xorResult < compare;
            } else {
                prefixLength -= NUMBER_OF_BYTE_BITS;
                if (xorResult != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // get unsigned byte (positive)
    private int unpackByte(byte byteToUnpack) {
        return byteToUnpack < 0
                ? (byteToUnpack + MAX_UNSIGNED_BYTE) : byteToUnpack;
    }

    // save positive byte into 8 bits of java signed byte
    private byte packByte(int byteToPack) {
        return (byte) byteToPack;
    }

    // --------- Second solution ---------------------------------------------------
    // based on converting and comparing whole ips based on masked using long as storage (or unsigned int)
    // more elegant and readable than byte array. a bit slower, because of overhead to convert to long
    // Note: assuming values are valid (if needed can be preprocessed)
    public CIDRComparatorResult compareCIDR2(String firstSubnet, String secondSubnet) {
        String[] firstSubnetIpAndSuffix = firstSubnet.split("/");
        String[] firstSubnetIp = firstSubnetIpAndSuffix[0].split("\\.");
        long firstSubnetIpInLong = ipToLong(firstSubnetIp);

        String[] secondSubnetIpAndSuffix = secondSubnet.split("/");
        String[] secondSubnetIp = secondSubnetIpAndSuffix[0].split("\\.");
        long secondSubnetIpInLong = ipToLong(secondSubnetIp);

        byte firstSubnetLength = Byte.parseByte(firstSubnetIpAndSuffix[1]);
        byte secondSubnetLength = Byte.parseByte(secondSubnetIpAndSuffix[1]);
        byte shorterSubnetLength = (byte) Math.min(firstSubnetLength, secondSubnetLength);

        boolean arePrefixesEqualInLong = arePrefixEqual(shorterSubnetLength, firstSubnetIpInLong, secondSubnetIpInLong);

        return getCidrComparatorResult(firstSubnetLength, secondSubnetLength, arePrefixesEqualInLong);
    }

    // Note: no unsigned int in Java, so long is taken.
    // (It is complex to organize unsigned logic with signed logic
    // comparison, xor and shift)
    private long ipToLong(String[] ip) {
        long ipInLong = 0;
        for (String value : ip) {
            ipInLong = ipInLong << NUMBER_OF_BYTE_BITS;
            short ipAddressOneUnsignedByte = Short.parseShort(value);
            assert ipAddressOneUnsignedByte >= 0 && ipAddressOneUnsignedByte < MAX_UNSIGNED_BYTE;

            ipInLong += ipAddressOneUnsignedByte;
        }
        return ipInLong;
    }

    // Improvement not to use byte arrays but long. more readable and straight forward
    // Note: no unsigned int in Java, so long is taken.
    // (It is complex to organize unsigned logic with signed logic
    // comparison, xor and shift)
    private boolean arePrefixEqual(byte prefixLength, long firstSubnetIp, long secondSubnetIp) {
        long xorResult = firstSubnetIp ^ secondSubnetIp;
        long compare = _2_POWER_32 >> prefixLength;
        return xorResult < compare;
    }
}