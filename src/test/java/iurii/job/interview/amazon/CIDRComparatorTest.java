package iurii.job.interview.amazon;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CIDRComparatorTest {

    private CIDRComparator comparator = new CIDRComparator();

    @Test
    public void testMain() {
        CIDRComparator.main(new String[0]);
    }

    @Test
    public void testEquals() {
        assertThat(comparator.compareCIDR("23.45.67.89/16", "23.45.255.25/16")).isEqualTo(CIDRComparator.CIDRComparatorResult.Equals);
        assertThat(comparator.compareCIDR2("23.45.67.89/16", "23.45.255.25/16")).isEqualTo(CIDRComparator.CIDRComparatorResult.Equals);

        assertThat(comparator.compareCIDR("255.255.255.255/17", "255.255.128.255/17")).isEqualTo(CIDRComparator.CIDRComparatorResult.Equals);
        assertThat(comparator.compareCIDR2("255.255.255.255/17", "255.255.128.255/17")).isEqualTo(CIDRComparator.CIDRComparatorResult.Equals);
    }

    @Test
    public void testFirstIsSubsetOfSecond() {
        assertThat(comparator.compareCIDR("1.2.3.4/24", "1.2.3.4/16")).isEqualTo(CIDRComparator.CIDRComparatorResult.Subset);
        assertThat(comparator.compareCIDR2("1.2.3.4/24", "1.2.3.4/16")).isEqualTo(CIDRComparator.CIDRComparatorResult.Subset);

        assertThat(comparator.compareCIDR("255.255.255.255/18", "255.255.255.255/12")).isEqualTo(CIDRComparator.CIDRComparatorResult.Subset);
        assertThat(comparator.compareCIDR2("255.255.255.255/18", "255.255.255.255/12")).isEqualTo(CIDRComparator.CIDRComparatorResult.Subset);
    }

    @Test
    public void testFirstIsSuperSetOfSecond() {
        assertThat(comparator.compareCIDR("172.84.26.128/16", "172.84.26.255/24")).isEqualTo(CIDRComparator.CIDRComparatorResult.Superset);
        assertThat(comparator.compareCIDR2("172.84.26.128/16", "172.84.26.255/24")).isEqualTo(CIDRComparator.CIDRComparatorResult.Superset);

        assertThat(comparator.compareCIDR("255.255.255.255/13", "255.255.255.255/17")).isEqualTo(CIDRComparator.CIDRComparatorResult.Superset);
        assertThat(comparator.compareCIDR2("255.255.255.255/13", "255.255.255.255/17")).isEqualTo(CIDRComparator.CIDRComparatorResult.Superset);
    }

    @Test
    public void testDisjointTwoMasksAreDifferent() {
        assertThat(comparator.compareCIDR("197.54.16.128/25", "197.54.16.127/25")).isEqualTo(CIDRComparator.CIDRComparatorResult.Disjoint);
        assertThat(comparator.compareCIDR2("197.54.16.128/25", "197.54.16.127/25")).isEqualTo(CIDRComparator.CIDRComparatorResult.Disjoint);

        assertThat(comparator.compareCIDR("255.255.255.255/19", "255.255.128.255/18")).isEqualTo(CIDRComparator.CIDRComparatorResult.Disjoint);
        assertThat(comparator.compareCIDR2("255.255.255.255/19", "255.255.128.255/18")).isEqualTo(CIDRComparator.CIDRComparatorResult.Disjoint);

        assertThat(comparator.compareCIDR("127.255.255.255/1", "255.255.128.255/1")).isEqualTo(CIDRComparator.CIDRComparatorResult.Disjoint);
        assertThat(comparator.compareCIDR2("127.255.255.255/1", "255.255.128.255/1")).isEqualTo(CIDRComparator.CIDRComparatorResult.Disjoint);
    }

    @Test
    public void testEqualsWholeMasks() {
        assertThat(comparator.compareCIDR("197.54.16.128/32", "197.54.16.128/32")).isEqualTo(CIDRComparator.CIDRComparatorResult.Equals);
        assertThat(comparator.compareCIDR2("197.54.16.128/32", "197.54.16.128/32")).isEqualTo(CIDRComparator.CIDRComparatorResult.Equals);
    }


    @Test
    public void testEssentials() {

        assertThat(Byte.toUnsignedInt((byte)-56)).isEqualTo(200);

        assertThat((byte) 200).isEqualTo((byte)-56);
        assertThat(((byte)-56) & 0xFF).isEqualTo(200);

        assertThat(((byte)-56) ^ 200).isEqualTo(-256);
        assertThat(((byte)-56) ^ (byte)(-56)).isEqualTo(0);
    }

}
