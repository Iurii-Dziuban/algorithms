package iurii.job.interview.convexhull;

public class Point2D {
    public final int x;
    public final int y;
    public double polarAngle;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void angleTo(Point2D that) {
        double dx = that.x - this.x;
        double dy = that.y - this.y;
        polarAngle = Math.atan2(dy, dx);
    }

    public String toString() {
        return "[" + x + "," + y + "]";
    }
}
