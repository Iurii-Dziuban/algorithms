package iurii.job.interview.utils.polygons;

/**
 * Created by iurii.dziuban on 07/06/2017.
 */
public class FourSidedPolygonCounts {
    private int numberOfRectangles;
    private int numberOfSquares;
    private int numberOfOther;
    private int numberOfInvalid;

    public FourSidedPolygonCounts(int numberOfRectangles, int numberOfSquares, int numberOfOther, int numberOfInvalid) {
        this.numberOfRectangles = numberOfRectangles;
        this.numberOfSquares = numberOfSquares;
        this.numberOfOther = numberOfOther;
        this.numberOfInvalid = numberOfInvalid;
    }

    public int getNumberOfRectangles() {
        return numberOfRectangles;
    }

    public int getNumberOfSquares() {
        return numberOfSquares;
    }

    public int getNumberOfOther() {
        return numberOfOther;
    }

    public int getNumberOfInvalid() {
        return numberOfInvalid;
    }
}
