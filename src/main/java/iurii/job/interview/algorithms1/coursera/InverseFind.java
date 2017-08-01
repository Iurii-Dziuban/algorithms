package iurii.job.interview.algorithms1.coursera;

/**
 * Finds pairs of values that are out of order in array
 * For example 3,1,2,4,5,7,6 Answer: (3,1) (3,2) (7,6)
 *
 * @author Jacky
 */
public class InverseFind extends iurii.job.interview.sorting.merge.InverseFind {

    public int[] merge(int[] firstHalf, int[] secondHalf) {
        int totalLength = firstHalf.length + secondHalf.length;
        int[] result = new int[totalLength];
        int i = 0;
        int j = 0;
        for (int index = 0; index < totalLength; index++) {
            if (i == firstHalf.length || j < secondHalf.length && firstHalf[i] > secondHalf[j]) {
                for (int k = i; k < firstHalf.length; k++) {
                    //TODO removed only for AlgorithmsWeekOneToAvoidOutOfMemory
                    //list.add(new Pair(firstHalf[k], secondHalf[j]));
                    count++;
                }
                result[index] = secondHalf[j++];
            } else {
                result[index] = firstHalf[i++];
            }
        }
        return result;
    }

}
