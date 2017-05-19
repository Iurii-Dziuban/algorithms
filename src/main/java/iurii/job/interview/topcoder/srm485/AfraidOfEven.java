package iurii.job.interview.topcoder.srm485;

public class AfraidOfEven {
    
    public static void main(String[] args) {
        int[] res = new AfraidOfEven().restoreProgression(new int[]{1,1,3,1,5});
        for (int item : res) {
            System.out.print(item + " ");
        }
    }
    
    public int[] restoreProgression(int[] progression) {
        if (progression.length < 3) {
            return progression;
        }
        int maxBit = 1 << 30;
        int first = progression[0];
        boolean firstDone = false;
        while(!firstDone) {
            int second = progression[1];
            boolean secondDone = false;
            while (!secondDone) {
                int d = second - first;
                int next = second + d;
                boolean canBeDone = true;
                for (int i = 2; i < progression.length; i++) {
                    if (!canBeDone(progression[i],next)) {
                        canBeDone = false;
                        break;
                    }
                    next += d;
                }
                if (canBeDone) {
                    int[] result = new int[progression.length];
                    result[0] = first;
                    for (int i = 1; i < result.length; i++) {
                        result[i] = result[i-1] + d;
                    }
                    return result;
                }
                if ((second & maxBit) !=0) {
                    break;
                } else {
                    second = second << 1;
                }
            }
            if ((first & maxBit) !=0) {
                break;
            } else {
                first = first << 1;
            }
        }
        return null;
    }
    
    private boolean canBeDone(int cur, int expected) {
        if (expected < cur) {
            return false;
        }
        int maxBit = 1 << 30;
        while (true) {
            if (cur == expected) {
                return true;
            }
            if ((cur & maxBit) != 0) {
                break;
            }
            cur = cur << 1;
        }
        return false;
    }
}
