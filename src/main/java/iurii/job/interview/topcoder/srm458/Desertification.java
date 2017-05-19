package iurii.job.interview.topcoder.srm458;

import java.util.*;
public class Desertification {
    public int desertArea(String[] island, int T) {
        boolean[][] deserted = new boolean[island.length][island[0].length()];
        Queue<Point> queue = new LinkedList<Point>();
        int desertedCount = 0;
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[0].length(); j++) {
                if (island[i].charAt(j) == 'D') {
                    Point point = new Point();
                    point.x = i;
                    point.y = j;
                    queue.add(point);
                    desertedCount++;
                    deserted[i][j] = true;
                }
            }
        }
        for (int i = 0; i < T; i++) {
            int queueSize = queue.size();
            for (int j = 0; j < queueSize; j++) {
                Point point = queue.remove();
                if (point.x - 1 >= 0 && !deserted[point.x - 1][point.y]) {
                    Point newPoint = new Point();
                    newPoint.x = point.x - 1;
                    newPoint.y = point.y;
                    deserted[newPoint.x][newPoint.y] = true;
                    queue.add(newPoint);
                    desertedCount++;
                }
                if (point.x + 1 < island.length && !deserted[point.x + 1][point.y]) {
                    Point newPoint = new Point();
                    newPoint.x = point.x + 1;
                    newPoint.y = point.y;
                    deserted[newPoint.x][newPoint.y] = true;
                    queue.add(newPoint);
                    desertedCount++;
                }
                if (point.y - 1 >= 0 && !deserted[point.x][point.y - 1]) {
                     Point newPoint = new Point();
                     newPoint.y = point.y - 1;
                     newPoint.x = point.x;
                     deserted[newPoint.x][newPoint.y] = true;
                     queue.add(newPoint);
                     desertedCount++;
                }
                if (point.y + 1 < island[0].length() && !deserted[point.x][point.y + 1]) {
                    Point newPoint = new Point();
                    newPoint.y = point.y + 1;
                    newPoint.x = point.x;
                    deserted[newPoint.x][newPoint.y] = true;
                    queue.add(newPoint);
                    desertedCount++;
                }
            }  
        }
        return desertedCount;   
    }
    
}

class Point {
    int x;
    int y;
}