package iurii.job.interview.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Interview question asked on phone screening:
 *
 * Suppose you have a 1-dimension maze of N rooms indexed with 0, 1, …, N - 1.
 * <p>
 * You can move from any room to its previous or next room, for example, from room 3 to room 2 or to room 4.
 * <p>
 * In addition, each room has a portal, and you can move between portals with the same label. In other words,
 * if the portal in room i and the portal in room j has the same label, you can move directly from room i to room j.
 * <p>
 * Starting from room 0. How many moves at minimum do you need to reach room N  - 1?
 * <p>
 * For example:
 * 10 rooms with portal labels [“1”, “0”, “0”, “7”, “1”, “2”, “2”, “2”, “3”, “7”]
 * <p>
 * The minimal number of moves is 3:
 * 0 -> [portal] -> 4 -> [previous room] -> 3 -> [portal] -> 9.
 *
 * Similar task on leetcode :
 * https://leetcode.com/problems/keys-and-rooms/
 */
public class KeysAndRooms {

    // Moves : -1 ; +1 ; any room with same label ; 
    // keep track of visited rooms
    // try each next move -1; 1; all portals
    // go to next keeping current distance, visited nodes,
    // check if we reached N-1; check minLength;
    // if all paths tried 
    // if we tried all directions and N - 1; 
    // always + 1  (N - 1) steps ; if more than N-1
    // Queue<Integer> nextIndex
    // int[] paths ; -1
    // Map<String, Set<Integer>> 
    // boolean[] 
    // Space complexity : O(N) ;
    // Time complexity : O(N);
    public int findShortestPathFromBeginningToEnd(String[] rooms) {
        // check rooms == null || empty ; rooms.length == 1
        if (rooms == null || rooms.length < 1) {
            throw new IllegalArgumentException("rooms should have at least 1 room");
        }
        Map<String, Set<Integer>> portalsMap = new HashMap<>();
        int n = rooms.length;
        // any start / end can be used in this algorithm
        int start = 0;
        int end = n - 1;
        for (int i = 0; i < n; i++) {
            String room = rooms[i];
            portalsMap.computeIfAbsent(room, k -> new HashSet<>());
            Set<Integer> portal = portalsMap.get(room);
            portal.add(i);
        }
        Set<Integer> visited = new HashSet<>();
        // min paths to all nodes from start can be found (otherwise it is enough to use steps until needed end)
        int[] paths = new int[n];
        // -1 is not visited (should not happen)
        Arrays.fill(paths, -1);
        // important to have LinkedList not PriorityQueue so time is const not log
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        paths[start] = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<Integer> toBeVisited = new HashSet<>(queue);
            Set<Integer> notVisited = new HashSet<>();
            for (int j = 0; j < size; j++) {
                int index = queue.poll();
                visited.add(index);
                if (index - 1 >= 0 && toVisit(visited, toBeVisited, index - 1)) {
                    notVisited.add(index - 1);
                    paths[index - 1] = paths[index] + 1;
                }
                if (index + 1 < n && toVisit(visited, toBeVisited,index + 1)) {
                    toBeVisited.add(index + 1);
                    paths[index + 1] = paths[index] + 1;
                }
                Set<Integer> nextRooms = portalsMap.get(rooms[index]);
                for (int nextRoom : nextRooms) {
                    if (toVisit(visited, toBeVisited, nextRoom)) {
                        paths[nextRoom] = paths[index] + 1;
                        notVisited.add(nextRoom);
                    }
                }
            }
            queue.addAll(notVisited);
        }
        return paths[end];
    }

    private boolean toVisit(Set<Integer> visited, Set<Integer> toBeVisited, int index) {
        return !visited.contains(index) && !toBeVisited.contains(index);
    }
}