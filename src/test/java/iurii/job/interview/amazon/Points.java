package iurii.job.interview.amazon;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {

    /*public int solution(Point2D[] A) {
        // collecting different lines based on hashcode
        Set<Line> lines = new HashSet<>();
        for (Point2D point : A) {
            int x = point.x;
            int y = point.y;
            // question with zero x or y...
            int sign;
            if (x > 0) {
                if (y > 0) {
                    sign = 1;
                } else {
                    sign = 2;
                }
            } else {
                if (y > 0) {
                    sign = 3;
                } else {
                    sign = 4;
                }
            }
            // in order to have appropriate line format
            int gcd = gcd(Math.abs(x), Math.abs(y));
            // if line exists it will not be added
            lines.add(new Line(Math.abs(x) / gcd, Math.abs(y) / gcd, sign));
        }
        return lines.size();
    }

    private static int gcd(int a1, int b1) {
        int a, b;
        if (a1 > b1) {
            a = a1;
            b = b1;
        } else {
            b = a1;
            a = b1;
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static class Line {
        int x;
        int y;
        int sign;

        public Line (int x, int y, int sign) {
            this.x =x;
            this.y = y;
            this.sign = sign;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x,y,sign);//x + y + sign;
        }

        @Override
        public boolean equals(Object object) {
            if (object instanceof Line) {
                Line line = (Line) object;
                if (x == line.x && y == line.y && sign == line.sign) {
                    return true;
                }
            }
            return false;
        }
    }
}*/



/*// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public String solution(int A, int B, int C, int D, int E, int F) {
        int a,b,c,d,e,f;
        int[] digits = new int[]{A, B, C, D, E, F};
        Arrays.sort(digits);
        if (digits[0] < 2) {
            a = digits[0];
            if (digits[2] <= 5) {
                if (digits[3] > 5) {
                    c = digits[1];
                    e = digits[2];
                    b = digits[3];
                    d = digits[4];
                    f = digits[5];
                } else {
                    if (digits[4] > 5) {
                        b = digits[1];
                        c = digits[2];
                        e = digits[3];
                        d = digits[4];
                        f = digits[5];
                    } else {
                        b = digits[1];
                        c = digits[2];
                        d = digits[3];
                        e = digits[4];
                        f = digits[5];
                    }
                }
                return a + "" + b + ":" + c + d + ":" + e + f;
            }
        } else {
            if (digits[0] == 2) {
                a = 2;
            } else {
                return "NOT POSSIBLE";
            }
            if (digits[1] <= 3) {
                b = digits[1];
                if (digits[3] <= 5) {
                    if (digits[4] > 5) {
                        c = digits[2];
                        e = digits[3];
                        d = digits[4];
                        f = digits[5];
                    } else {
                        c = digits[2];
                        d = digits[3];
                        e = digits[4];
                        f = digits[5];
                    }
                    return a + "" + b + ":" + c + d + ":" + e + f;
                }
            }
        }
        return "NOT POSSIBLE";
    }*/
}