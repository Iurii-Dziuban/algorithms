package iurii.job.interview.dynamic_programming;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TravelingSalesmanProblem {

    // Will for number of cities <=31 each bit - city present or absent
    public TravelingSalesmanProblem(float[][] edgeMatrix) {
        int CITIES_COUNT_25 = 0x2000000;

        float[] elements = new float[25];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = Float.MAX_VALUE;
        }
        elements[0] = 0;
        Map<Integer, float[]> setMap = new HashMap<Integer, float[]>();
        setMap.put(1, elements);

        for (int m = 2; m <= edgeMatrix.length; m++) {
            System.out.println("m = " + m);
            List<Integer> allPermutations = allPermutations(m, edgeMatrix.length - 1);
            Map<Integer, float[]> curSetMap = new HashMap<Integer, float[]>();
            for (int i = 0; i < allPermutations.size(); i++) {
                float[] vector = new float[25];
                for (int j = 0; j < vector.length; j++) {
                    vector[j] = Float.MAX_VALUE;
                }
                curSetMap.put(allPermutations.get(i), vector);
            }
            System.out.println("permSize =" + allPermutations.size());
            int index = 0;
            for (int permutation : allPermutations) {
                int permutaionToChange1 = permutation;
                index++;
                if (index % 1000000 == 0) {
                    System.out.println("index=" + index + " System time = " + new Date());
                }
                while (permutaionToChange1 != 0) {
                    // way to find first positions of ones in the number
                    int topOne1 = permutaionToChange1 & (0 - permutaionToChange1);
                    int j = Integer.numberOfTrailingZeros(topOne1);

                    if (j != 0) {
                        int permutaionToChange2 = permutation;
                        while (permutaionToChange2 != 0) {
                            int topOne2 = permutaionToChange2 & (0 - permutaionToChange2);
                            int k = Integer.numberOfTrailingZeros(topOne2);
                            if (k != j) {
                                float prevValue = setMap.get(permutation ^ (1 << j))[k];
                                if (prevValue != Float.MAX_VALUE && edgeMatrix[k][j] != Float.MAX_VALUE) {
                                    float value = prevValue + edgeMatrix[k][j];
                                    float[] curPermutationArray = curSetMap.get(permutation);
                                    if (value < curPermutationArray[j]) {
                                        curPermutationArray[j] = value;
                                    }
                                }
                            }
                            permutaionToChange2 = permutaionToChange2 ^ topOne2;
                        }
                    }
                    permutaionToChange1 = permutaionToChange1 ^ topOne1;
                }
            }
            setMap = curSetMap;
        }

        float minValue = Float.MAX_VALUE;
        for (int j = 1; j < edgeMatrix.length; j++) {
            if (setMap.get(CITIES_COUNT_25 - 1)[j] != Float.MAX_VALUE && edgeMatrix[j][0] != Float.MAX_VALUE) {
                float value = setMap.get(CITIES_COUNT_25 - 1)[j] + edgeMatrix[j][0];
                if (value < minValue) {
                    minValue = value;
                }
            }
        }
        System.out.println(minValue == Float.MAX_VALUE ? "NULL" : minValue);
    }

    // find all permutations with 1 at 0 position
    public static List<Integer> allPermutations(int onesCount, int maximum) {
        List<Integer> permutations = new ArrayList<Integer>();
        permutations(onesCount, maximum, 0, maximum, permutations);
        return permutations;
    }

    public static void permutations(int onesCount, int currentPosition, int currentItem, int maximum, List<Integer> permutations) {
        if (onesCount > 1) {
            // > 1
            if (onesCount < currentPosition + 1) {
                permutations(onesCount, currentPosition - 1, currentItem, maximum, permutations);
                permutations(onesCount - 1, currentPosition - 1, currentItem | (1 << currentPosition), maximum, permutations);
            }
            if (onesCount == currentPosition + 1) {
                permutations(onesCount - 1, currentPosition - 1, currentItem | (1 << currentPosition), maximum, permutations);
            }
        } else if (onesCount == 1) {
            // == 1
            if (currentPosition == 0) {
                permutations.add(currentItem + 1);
            } else {
                permutations(onesCount, currentPosition - 1, currentItem, maximum, permutations);
            }
        } else {
            // 0
            permutations.add(currentItem);
        }
    }
}
