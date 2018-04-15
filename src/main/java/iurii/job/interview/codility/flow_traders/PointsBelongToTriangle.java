package iurii.job.interview.codility.flow_traders;

public class PointsBelongToTriangle {

    public int pointsBelongToTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int p1, int q1, int p2, int q2) {
        boolean isNotTriangle = areaTimesTwo(x1, y1, x2, y2, x3, y3) == 0;
        boolean isP = isPointInside(x1, y1, x2, y2, x3, y3, p1, q1);
        boolean isQ = isPointInside(x1, y1, x2, y2, x3, y3, p2, q2);
        if (isNotTriangle) {
            return 0;
        } else {
            if (isP) {
                return isQ ? 3 : 1;
            } else {
                return isQ ? 2 : 4;
            }
        }
    }

    private boolean isPointInside(int x1, int y1, int x2, int y2, int x3, int y3, int p, int q) {
        long abcArea = areaTimesTwo(x1, y1, x2, y2, x3, y3);
        long abpArea = areaTimesTwo(x1, y1, x2, y2, p, q);
        long apcArea = areaTimesTwo(x1, y1, p, q, x3, y3);
        long pbcArea = areaTimesTwo(p, q, x2, y2, x3, y3);
        return abcArea == abpArea + apcArea + pbcArea;
    }

    private long areaTimesTwo(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
    }

}
