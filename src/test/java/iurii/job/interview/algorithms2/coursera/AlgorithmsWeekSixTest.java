package iurii.job.interview.algorithms2.coursera;

import iurii.job.interview.approximation.localsearch.Papadimitrou;
import iurii.job.interview.approximation.localsearch.Scc2SAT;
import iurii.job.interview.graph.structure.OrderedGraph;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 2SAT problem
 */
public class AlgorithmsWeekSixTest {

    @Test
    public void main() throws FileNotFoundException {
        //isSCC = true;
        for (int i = 1; i < 7; i++) {
            Scanner sc = new Scanner(new File("src/main/resources/2sat" + i + ".txt"));
            int variableCount = sc.nextInt();
            OrderedGraph orderedGraph = new OrderedGraph(variableCount * 2);
            while (sc.hasNextInt()) {
                int firstVar = convert(sc.nextInt(), variableCount);
                int secondVar = convert(sc.nextInt(), variableCount);
                orderedGraph.addEdge(not(firstVar, variableCount), secondVar);
                orderedGraph.addEdge(not(secondVar, variableCount), firstVar);
            }
            sc.close();
            Scc2SAT ssc2SAT = new Scc2SAT(orderedGraph);
            System.out.println("Result = " + ssc2SAT.getResult());
            System.out.println("4 and 5 connected = " + ssc2SAT.connected(4, 5));
            System.out.println("Solution = " + ssc2SAT.getSolution());
            System.out.println("GroupNumber 6 = " + ssc2SAT.groupNumber(6));
        }
        //  isPapadimitrou
        /*for (int i = 1; i < 7; i++) {
            Scanner sc = new Scanner(new File("src/main/resources/2sat" + i + ".txt"));
            int variableCount = sc.nextInt();
            int[][] clauses = new int[variableCount][2];
            int index = 0;
            while (sc.hasNextInt()) {
                clauses[index][0] = sc.nextInt();
                clauses[index][1] = sc.nextInt();
                index++;
            }
            sc.close();
            Papadimitrou papadimitrou = new Papadimitrou(clauses);
            System.out.println(papadimitrou.getResult());
        }*/
    }

    private static int convert(int index, int variableCount) {
        if (index < 0) {
            return variableCount * 2 - Math.abs(index);
        } else {
            return index - 1;
        }
    }

    private static int not(int index, int variableCount) {
        return variableCount * 2 - 1 - index;
    }

}
