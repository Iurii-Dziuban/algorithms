package iurii.job.interview.booking_com.initial;

import iurii.job.interview.utils.polygons.FourSidedPolygon;
import iurii.job.interview.utils.polygons.FourSidedPolygonCounts;

import java.util.List;

/**
 * Identify whether four sides (given by four integers) can form square, a rectangle or neither
 *
 * Input: each record describes a single polygon and contains four integers,
 * which represent the length of the sides of the polygon.
 *
 * Output: three integers that count number of squares, rectangles and other
 *
 * Squares should not be counted as rectangles. Invalid polygons should not be counted as others.
 * Each side: -2000 <=X <= 2000
 *
 * Possible improvements: chain of interceptors, enum for type of polygon, check logic separate class
 * Created by iurii.dziuban on 07/06/2017.
 */
public class Polygons {

    public FourSidedPolygonCounts countPolygons(List<FourSidedPolygon> polygons) {
        int numberOfRectangles = 0;
        int numberOfSquares = 0;
        int numberOfOther = 0;
        int numberOfInvalid = 0;
        for(FourSidedPolygon polygon : polygons) {
            if (isPolygonInvalid(polygon)) {
                numberOfInvalid++;
                continue;
            }
            if (isPolygonSquare(polygon)) {
                numberOfSquares++;
                continue;
            }
            if (isPolygonRectangle(polygon)) {
                numberOfRectangles++;
                continue;
            }
            numberOfOther++;
        }
        return new FourSidedPolygonCounts(numberOfRectangles, numberOfSquares, numberOfOther, numberOfInvalid);
    }

    private boolean isPolygonRectangle(FourSidedPolygon polygon) {
        return polygon.getSide1() == polygon.getSide3()
                && polygon.getSide2() == polygon.getSide4();
    }

    private boolean isPolygonSquare(FourSidedPolygon polygon) {
        return polygon.getSide1() == polygon.getSide2()
                && polygon.getSide1() == polygon.getSide3()
                && polygon.getSide1() == polygon.getSide4();
    }

    private boolean isPolygonInvalid(FourSidedPolygon polygon) {
        return polygon.getSide1() < 0
                || polygon.getSide2() < 0
                || polygon.getSide3() < 0
                || polygon.getSide4() < 0
                || polygon.getSide1() > polygon.getSide2() + polygon.getSide3() + polygon.getSide4()
                || polygon.getSide2() > polygon.getSide1() + polygon.getSide3() + polygon.getSide4()
                || polygon.getSide3() > polygon.getSide2() + polygon.getSide1() + polygon.getSide4()
                || polygon.getSide4() > polygon.getSide2() + polygon.getSide3() + polygon.getSide1();
    }




}
