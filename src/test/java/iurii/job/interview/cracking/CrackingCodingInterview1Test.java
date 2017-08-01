package iurii.job.interview.cracking;

import org.junit.Test;

import static iurii.job.interview.cracking.CrackingCodingInterview1.areAnagrams;
import static iurii.job.interview.cracking.CrackingCodingInterview1.areAnagrams2;
import static iurii.job.interview.cracking.CrackingCodingInterview1.isRotation;
import static iurii.job.interview.cracking.CrackingCodingInterview1.isUnique;
import static iurii.job.interview.cracking.CrackingCodingInterview1.isUnique2;
import static iurii.job.interview.cracking.CrackingCodingInterview1.removeDuplicates;
import static iurii.job.interview.cracking.CrackingCodingInterview1.removeDuplicates2;
import static iurii.job.interview.cracking.CrackingCodingInterview1.replaceSpaces;
import static iurii.job.interview.cracking.CrackingCodingInterview1.reverseString;
import static iurii.job.interview.cracking.CrackingCodingInterview1.rotateMatrix;
import static iurii.job.interview.cracking.CrackingCodingInterview1.setZeros;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Arrays and Strings
 */
public class CrackingCodingInterview1Test {

    @Test
    public void creation(){
        new CrackingCodingInterview1();
    }

    @Test
    public void isUniqueTest() {
        assertThat(isUnique("AaBbCcfhdjr")).isTrue();
        assertThat(isUnique("AaBbCcfhdAjr")).isFalse();
    }

    @Test
    public void isUnique2Test() {
        assertThat(isUnique2("AaBbCcfhdjr")).isTrue();
        assertThat(isUnique2("AaBbCcfhdAjr")).isFalse();
    }

    @Test
    public void reverseStringTest() {
        assertThat(reverseString("AaBbCcfhdjr")).isEqualTo("rjdhfcCbBaA");
    }

    @Test
    public void removeDuplicatesTest() {
        assertThat(removeDuplicates("AaBbCcfhdAjr".toCharArray())).isEqualTo("AaBbCcfhdjr ".toCharArray());
        assertThat(removeDuplicates(null)).isEqualTo(null);
    }

    @Test
    public void removeDuplicates2Test() {
        assertThat(removeDuplicates2("AaBbCcfhdAjr".toCharArray())).isEqualTo("AaBbCcfhdjr ".toCharArray());
        assertThat(removeDuplicates2(null)).isEqualTo(null);
    }

    @Test
    public void areAnagramsTest() {
        assertThat(areAnagrams("AaBbCcfhdAjr", "AaBbACcfhdjr")).isTrue();
        assertThat(areAnagrams("AaBbCcfhdAjr", "AaBbCcfhdjrA")).isTrue();
        assertThat(areAnagrams("AaBbCcfhdAjr", "AaBbCcfhdjrD")).isFalse();
        assertThat(areAnagrams(null, "AaBbCcfhdjrD")).isFalse();
    }

    @Test
    public void areAnagrams2Test() {
        assertThat(areAnagrams2("AaBbCcfhdAjr", "AaBbACcfhdjr")).isTrue();
        assertThat(areAnagrams2("AaBbCcfhdAjr", "AaBbCcfhdjrA")).isTrue();
        assertThat(areAnagrams2("AaBbCcfhdAjr", "AaBbCcfhdjrD")).isFalse();
        assertThat(areAnagrams2(null, "AaBbCcfhdjrD")).isFalse();
    }

    @Test
    public void replaceSpacesTest() {
        assertThat(replaceSpaces("Aa Bb Cc f hdBj r".toCharArray())).isEqualTo("Aa%20Bb%20Cc%20f%20hdBj%20r".toCharArray());
    }

    @Test
    public void rotateMatrixTest() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotateMatrix(matrix);

        assertThat(matrix).containsExactly(new int[]{4,8,12,16},
                                           new int[]{3,7,11,15},
                                           new int[]{2,6,10,14},
                                           new int[]{1,5,9,13});

        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateMatrix(matrix1);

        assertThat(matrix1).containsExactly(new int[]{3,6,9},
                new int[]{2,5,8},
                new int[]{1,4,7}
                );
    }

    @Test
    public void setZerosTest() {
        int[][] matrix2 = {{1, 2, 3}, {4, 0, 6}, {7, 8, 9}};
        setZeros(matrix2);
        assertThat(matrix2).containsExactly(new int[]{1,0,3},
                new int[]{0,0,0},
                new int[]{7,0,9}
        );
    }

    @Test
    public void isRotationTest() {
        assertThat(isRotation("hello", "elloh")).isTrue();
        assertThat(isRotation("hello", "ello")).isFalse();
    }
}
