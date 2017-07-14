package iurii.job.interview.booking_com.initial;

import iurii.job.interview.utils.polygons.FourSidedPolygon;
import iurii.job.interview.utils.polygons.FourSidedPolygonCounts;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iurii.dziuban on 07/06/2017.
 */
public class PolygonsTest {

    private Polygons polygonService = new Polygons();

    @Test
    public void test(){
        List<FourSidedPolygon> polygons = new ArrayList<>();
        polygons.add(new FourSidedPolygon(36, 30, 36, 30));
        polygons.add(new FourSidedPolygon(15, 15, 15, 15));
        polygons.add(new FourSidedPolygon(46, 96,90, 100));
        polygons.add(new FourSidedPolygon(86, 86,86,86));
        polygons.add(new FourSidedPolygon(100, 200, 100, 200));
        polygons.add(new FourSidedPolygon(-100, 200, -100, 200));

        FourSidedPolygonCounts fourSidedPolygonCounts = polygonService.countPolygons(polygons);
        assertThat(fourSidedPolygonCounts.getNumberOfInvalid()).isEqualTo(1);
        assertThat(fourSidedPolygonCounts.getNumberOfOther()).isEqualTo(1);
        assertThat(fourSidedPolygonCounts.getNumberOfRectangles()).isEqualTo(2);
        assertThat(fourSidedPolygonCounts.getNumberOfSquares()).isEqualTo(2);
    }
}
