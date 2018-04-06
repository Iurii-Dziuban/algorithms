package iurii.job.interview.booking_com.initial;

public class Triangles {

    /**
     * return :
     * 0 - No triangle could be formed or input is invalid
     * 1 - An equilateral triangle could be formed
     * 2 - A triangle, which is not equilateral, could be formed
     */
    public int triangle(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0 || (a + b <= c) || (a + c <= b) || (c + b <= a)) {
            return 0;
        } else {
            return a == b || b == c ? 1 : 2;
        }
    }
}
