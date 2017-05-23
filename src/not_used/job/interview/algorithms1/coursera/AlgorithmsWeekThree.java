package iurii.job.interview.algorithms1.coursera;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class AlgorithmsWeekThree {

    private static final int VERTICES_COUNT = 200;
    
    private static int minCut= 100000;
    
    public static synchronized void setMin(int i) {
        if (minCut > i) {
            minCut = i;
        }
    }

    /**
     * @param args
     * @throws FileNotFoundException
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        final int[][] matrix = new int[VERTICES_COUNT][VERTICES_COUNT];
        Scanner sc = new Scanner(new File("kargerMinCut.txt"));
        for (int i = 0; i < VERTICES_COUNT; i++) {
            String nextLine = sc.nextLine();
            String[] values = nextLine.split("\t");
            for (int j = 1; j < values.length; j++) {
                matrix[i][Integer.valueOf(values[j]) - 1] = 1;
            }
        }
        sc.close();
        Thread[] threads = new Thread[210000];
        for (int i = 0; i < 210000; i++) {
            threads[i] = new Thread(){
                public void run() {
                    ThreadMethod(matrix);
                }
            };
            threads[i].run();
            long curProc = Math.round((i /210000.0) *100);
            System.out.println(""+curProc +"%");
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println(minCut);
    }

    private static void ThreadMethod(int[][] matrix) {
        int[][] threadMatrix = new int[200][200];
        for (int i = 0; i < VERTICES_COUNT; i++) {
            for (int j = 0; j < VERTICES_COUNT; j++) {
                threadMatrix[i][j] = matrix[i][j];
            }
        }
        Random random = new Random();
        int i = 0;
        int j;
        for (int iteration = 0; iteration < VERTICES_COUNT - 2; iteration++) {
            /* generate two random vertices, or one edge */
            do {
                i = random.nextInt(VERTICES_COUNT);
                j = random.nextInt(VERTICES_COUNT);
            } while(threadMatrix[i][j] <= 0);

            /* fuse the two vertices i and j */
            threadMatrix[i][j] = 0; 
            threadMatrix[j][i] = 0;

            /* modify other matrix elements according to the vertices that are fused */
            for (int k=0; k < VERTICES_COUNT; k++){
                threadMatrix[i][k] = threadMatrix[i][k] + threadMatrix[j][k];
                threadMatrix[k][i] = threadMatrix[i][k];
                threadMatrix[j][k] = threadMatrix[k][j] = 0;
            }
        }
        /* get the mincut value */
        int col = 0;
        for (int k=0; k < VERTICES_COUNT; k++){
            col = k;
            if (threadMatrix[i][k] > 0) break;
        }
        setMin(threadMatrix[i][col]);
    }

}
