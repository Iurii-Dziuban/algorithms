package iurii.job.interview.topcoder.srm503;
import java.util.*;

/**
 * The Grid Kingdom lies on a plane. There are N cities and M villages in the Grid Kingdom, each is a point on the plane. The i-th city is located at coordinates (cityX[i], cityY[i]) and the i-th village is located at coordinates (villageX[i], villageY[i]). Initially, there are no roads in the kingdom, so no village is initially connected to any city.  To improve this, the king has ordered that each village shall be connected to a city by a system of roads. The scheme for building the roads is as follows:  While there exists a village that is not connected to any city:
Pick one unconnected village (each has an equal probability of being chosen), call it V.
Select a point, X, which is nearest to V, in terms of Euclidean Distance, and is either a city or a village-that-is-already-connected-to-a-city. If multiple such points are equally near, pick any of the nearest points with equal probability.
Construct a road from V to X. The length of this road is equal to the Euclidean Distance between points V and X. V is now connected to a city.

Return the expected total length of all the roads that will be constructed after all villages are connected to a city.
 */
public class KingdomXCitiesandVillagesAnother {
    
    public static void main(String[] args) {
        System.out.println(new KingdomXCitiesandVillagesAnother().determineLength(new int[]{3},new int[]{0}, new int[]{3, 3}, new int[]{2, 1}));
    }
    
    public double determineLength(int[] cityX, int[] cityY, int[] villageX, int[] villageY) {
        List<Point> notConnectedVillages = new ArrayList<Point>();
        for (int i = 0; i < villageX.length; i++) {
            Point village = new Point();
            village.x = villageX[i];
            village.y = villageY[i];
            notConnectedVillages.add(village);
        }
        List<Point> distances = new ArrayList<Point>();
        for (int i = 0; i < cityX.length; i++) {
            Point city = new Point();
            city.x = cityX[i];
            city.y = cityY[i];
            distances.add(city);
        }  
        List<Double> allDistances = addVillage(notConnectedVillages, distances, villageX.length);
        double average = 0;
        for (Double distance : allDistances) {
            average += distance/allDistances.size();
        }
        return average;
    }

    private List<Double> addVillage(
            List<Point> notConnectedVillages, 
            List<Point> distances,
            int size) {
        List<Double> allDistances = new ArrayList<Double>();
        for (int villageIndex = 0; villageIndex < size; villageIndex++) {
            Point village = notConnectedVillages.get(villageIndex);
            notConnectedVillages.remove(villageIndex);
            recalculateDistances(distances, village);
            Collections.sort(distances);    
            double minDistance = distances.get(0).distance;
            distances.add(village);
            if (size != 1) {
                List<Double> subDistances = addVillage(notConnectedVillages, distances, size - 1);
                for (Double subdistance : subDistances) {
                    allDistances.add(subdistance + minDistance);
                }
            } else {
                allDistances.add(minDistance);
            }
            notConnectedVillages.add(villageIndex, village);
            distances.remove(village);
        }
        return allDistances;
    }
    
    private void recalculateDistances(List<Point> distances, Point village) {
        for (Point distance : distances) {
            distance.distance = Math.sqrt((distance.x - village.x) * (distance.x - village.x) + (distance.y - village.y) * (distance.y - village.y));
        }
    }
    
    class Point implements Comparable<Point> {
        int x;
        int y;
        double distance;
        
        public int compareTo(Point other) {
            if (distance - other.distance > 0) {
                return 1;
            } else if (distance - other.distance < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}


