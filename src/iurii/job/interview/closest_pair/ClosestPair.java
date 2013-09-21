package iurii.job.interview.closest_pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestPair {

	public static Pair[] closestPair(Pair[] ps) {
		Pair[] pX = mergesort(ps, true);
		Pair[] pY = mergesort(ps, false);
		return findClosest(pX, pY);
	}
	
	public static Pair[] findClosest(Pair[] pX, Pair[] pY) {
		int n = pX.length;
		if (n <= 3) {
			return shortestBruteForce(pX);
		} else {
			int left = n / 2;
			int right = n / 2 + n % 2;
			Pair[] xL = new Pair[left];
			Pair[] xR = new Pair[right];
			for (int i = 0; i < left; i++)
				xL[i] = pX[i];
			for (int i = 0; i < right; i++)
				xR[i] = pX[i + left];
			int xM = pX[n/2].getX();
			List<Pair> yLList = new ArrayList<Pair>();
			List<Pair> yRList = new ArrayList<Pair>();
			for (int i = 0; i < pY.length; i++) {
				if (pY[i].getX() <= xM) {
					yLList.add(pY[i]);
				} else {
					yRList.add(pY[i]);
				}
			}
			Pair[] Pleftmin = findClosest(xL, yLList.toArray(new Pair[yLList.size()]));
			Pair[] Prightmin = findClosest(xR, yRList.toArray(new Pair[yRList.size()]));
			double dmin, closest;
			Pair[] pmin, closestPair;
			if (distance(Pleftmin[0], Pleftmin[1])> distance(Prightmin[0], Prightmin[1])) {
				pmin = Prightmin;
				dmin = distance(Prightmin[0], Prightmin[1]);
			} else {
				pmin = Pleftmin;
				dmin = distance(Pleftmin[0], Pleftmin[1]);
			}
			List<Pair> yS = new ArrayList<Pair>();
			for (int i = 0; i < pY.length; i++) {
				if (Math.abs(xM-pY[i].getX())< dmin) {
					yS.add(pY[i]);
				}
			}
			closest = dmin;
			closestPair = pmin;
			for (int i = 0; i < yS.size() - 1; i++) {
				int k = i+1;
					while ( (k<yS.size()) && (yS.get(k).getY() - yS.get(i).getY()< dmin)) {
						if (distance(yS.get(k), yS.get(i)) < closest) {
							closest = distance(yS.get(k), yS.get(i));
							closestPair = new Pair[] {yS.get(k), yS.get(i)};
						} 
						k++;
					}
			}
			return closestPair;
		}
	}

	// Merge sort
	public static Pair[] mergesort(Pair[] array, boolean isX) {
		int dividePointer = array.length / 2;
		if (dividePointer > 0) {
			Pair[] firstHalf = mergesort(Arrays.copyOfRange(array, 0, dividePointer), isX);
			Pair[] secondHalf = mergesort(Arrays.copyOfRange(array, dividePointer, array.length), isX);
			return merge(firstHalf, secondHalf, isX);
		} else {
			return array;
		}
	}
	
	public static Pair[] merge(Pair[] firstHalf, Pair[] secondHalf, boolean isX) {
		int totalLength = firstHalf.length + secondHalf.length;
		Pair[] result = new Pair[totalLength];
		int i = 0;
		int j = 0;
		for (int index = 0; index < totalLength; index++) {
			if (i == firstHalf.length ||(j < secondHalf.length && (isX ? firstHalf[i].getX() > secondHalf[j].getX() : firstHalf[i].getY() > secondHalf[j].getY()))) {
				result[index] = secondHalf[j++];
			} else {
				result[index] = firstHalf[i++];
			}
		}
		return result;
	}
	
	// end merge sort	
	// O(n^2) naive version of closest pair
    public static Pair[] shortestBruteForce(Pair[] ps) {
    	Pair p1 = null;
    	Pair p2 = null;
 
        double distance = Double.MAX_VALUE;
        for (int i = 0; i < ps.length; i++) {
            for (int j = 0; j < i; j++) {
                if (i == j)
                    continue;
                Pair ptemp1 = ps[i];
                Pair ptemp2 = ps[j];
                if (ptemp1.equals(ptemp2))
                    continue;
 
                double newDistance = distance(ptemp1, ptemp2);
                if (newDistance < distance) {
                    // update
                    distance = newDistance;
                    p1 = ptemp1;
                    p2 = ptemp2;
                }
            }
        }
        Pair[] points = new Pair[]{p1, p2};      
        return points;
    }
	
	private static double distance(Pair pair1, Pair pair2) {
		return Math.sqrt((pair1.getX()-pair2.getX())*(pair1.getX()-pair2.getX()) + (pair1.getY()-pair2.getY())*(pair1.getY()-pair2.getY())); 
	}
	
	public static class Pair{
		private final int x;
		private final int y;
		
		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		
		public String toString() {
			return "["+x+","+y+"]";
		}
	}
}
