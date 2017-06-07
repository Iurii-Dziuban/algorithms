package iurii.job.interview.utils.polygons;

/**
 * Created by iurii.dziuban on 07/06/2017.
 */
public class FourSidedPolygon {
    private final int side1;
    private final int side2;
    private final int side3;
    private final int side4;

    public FourSidedPolygon(int side1, int side2, int side3, int side4) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.side4 = side4;
    }

    public int getSide1() {
        return side1;
    }

    public int getSide2() {
        return side2;
    }

    public int getSide3() {
        return side3;
    }

    public int getSide4() {
        return side4;
    }
}
