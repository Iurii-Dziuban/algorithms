package iurii.job.interview.approximation.localsearch;

import java.util.Random;

/**
 * In practice does not work. Think that number of iterations is too big.
 */
public class Papadimitrou {
    
    private final String result;
    
    public Papadimitrou(int[][] clauses) {
        long n = clauses.length;
        long maximumIterationsNumber = 2*n*n;
        long maximum = Math.round(Math.log(n)/ Math.log(2));
        for (int j = 0; j < maximum; j++) {
            boolean[] assignment = generateRandomAssignment(n);
            for (int i = 0; i < maximumIterationsNumber; i++) {
                int unsatisfiedClauseIndex = getUnsatisfiedClauseIndex(clauses, assignment);
                if (unsatisfiedClauseIndex == -1) {
                    result = "satisfiable";
                    return;
                } else {
                    int varIndexToFlip = Math.abs(clauses[unsatisfiedClauseIndex][new Random().nextInt(2)]);
                    assignment[varIndexToFlip] = !assignment[varIndexToFlip];
                }
            }
        }
        result = "unsatisfiable";
    }
    
    private int getUnsatisfiedClauseIndex(int[][] clauses, boolean[] assignment) {
        for (int i = 0; i < clauses.length; i++) {
            if ((clauses[i][0] < 0 && assignment[Math.abs(clauses[i][0]) -1] ||
                 clauses[i][0] > 0 && !assignment[clauses[i][0] - 1]) &&
                 ((clauses[i][1] < 0 && assignment[Math.abs(clauses[i][1]) - 1] ||
                   clauses[i][1] > 0 && !assignment[clauses[i][1] - 1]))) {
                   return i;
            }
        }
        return -1;
    }

    private boolean[] generateRandomAssignment(long n) {
        boolean[] assignment = new boolean[(int)n];
        Random random = new Random();
        for (int i = 0; i < assignment.length; i++) {
            assignment[i] = random.nextBoolean();
        }
        return assignment;
    }

    public String getResult() {
        return result;
    }

}
