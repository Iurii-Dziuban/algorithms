package iurii.job.interview.algorithms1.coursera;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class AlgorithmsWeekTwoTest {

    @Test
    public void main() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/main/resources/QuickSort.txt"));
        List<Integer> array = new ArrayList<Integer>();
        while (sc.hasNextInt()) {
            array.add(sc.nextInt());
        }
        sc.close();
        int[] intArray = new int[array.size()];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = array.get(i);
        }
        QuickSortFirstPivot.sort(intArray);
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = array.get(i);
        }
        QuickSortLastPivot.sort(intArray);
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = array.get(i);
        }
        QuickSortMedianPivot.sort(intArray);
        assertThat(QuickSortFirstPivot.comparisonNumber).isEqualTo(162085);
        assertThat(QuickSortLastPivot.comparisonNumber).isEqualTo(164123);
        assertThat(QuickSortMedianPivot.comparisonNumber).isEqualTo(138382);
    }

}
