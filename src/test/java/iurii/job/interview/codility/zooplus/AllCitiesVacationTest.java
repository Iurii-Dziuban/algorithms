package iurii.job.interview.codility.zooplus;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IuriiDziuban on 10/22/17.
 */
public class AllCitiesVacationTest {

    @Test
    public void test() {
        AllCitiesVacation allCitiesVacation = new AllCitiesVacation();
        assertThat(allCitiesVacation.findMinDaysToVisitAllCities(new int[]{7, 3, 7, 3, 1, 3, 4, 1})).isEqualTo(5);
    }
}
