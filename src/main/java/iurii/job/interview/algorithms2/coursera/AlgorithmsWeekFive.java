package iurii.job.interview.algorithms2.coursera;

import iurii.job.interview.dynamic_programming.TravelingSalesmanProblem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Solution for Traveling Salesman Problem takes about 10 minutes to solve. needs 1024M memory
 */
public class AlgorithmsWeekFive {

    /**
     * @param args
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
        /* Check permutations count
         * for (int i = 1; i < 26; i++) {
            List<Integer> allPermutations = TravelingSalesmanProblem.allPermutations(i, 24);
            System.out.println(allPermutations.size()); 
        }*/
        
        Scanner sc = new Scanner(new File("src/main/resources/tsp.txt"));
        int vertexCount = sc.nextInt();
        float[][] edgeMatrix = new float[vertexCount][vertexCount];
        
        List<Point2D> vertexes = new ArrayList<Point2D>();
        for (int i = 0; i < vertexCount; i++) {
            vertexes.add(new Point2D(sc.nextDouble(), sc.nextDouble()));
        }
        sc.close();
        for (int i = 0; i < vertexCount - 1; i++) {
            for (int j = i + 1; j < vertexCount; j++) {
                float weight = (float) Math.sqrt(
                             (vertexes.get(i).x - vertexes.get(j).x) * (vertexes.get(i).x - vertexes.get(j).x) 
                             +
                             (vertexes.get(i).y - vertexes.get(j).y) * (vertexes.get(i).y - vertexes.get(j).y));
                edgeMatrix[i][j] = weight;
                edgeMatrix[j][i] = weight;
            }
        }
        new TravelingSalesmanProblem(edgeMatrix);
    }

}
