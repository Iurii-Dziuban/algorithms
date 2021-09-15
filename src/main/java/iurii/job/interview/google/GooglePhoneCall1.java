package iurii.job.interview.google;


// almost same as https://leetcode.com/discuss/interview-question/390967/google-phone-screen-common-friends
// looks same as https://leetcode.com/discuss/interview-question/486188/Facebook-or-Phone-or-Friend-Suggestion/433306

import java.util.*;
import java.util.stream.Collectors;

/**
 * More links:
 * 1. https://www.geeksforgeeks.org/friends-pairing-problem/
 * 2. https://www.geeksforgeeks.org/number-groups-formed-graph-friends/
 * 3. https://www.geeksforgeeks.org/comparison-between-adjacency-list-and-adjacency-matrix-representation-of-graph/
 */
public class GooglePhoneCall1 {

    /**
     * Given a social network (whatever presentation works best) and a user,
     * Provide recommendations to the user on potential friends.
     *
     * Potential friend is a person, which is friend of user`s friends but not among user friends.`
     *
     * Follow up: return recommendations in sorted order from the biggest number of common friends
     * ------------------------------------------------------------------------
     *
     * 1. which representation to choose?
     * There are the following representations:
     *     1. Adjacency list
     *     2. Adjacency matrix
     *
     * Both have problematic point is that they represent only connections between a pair of vertexes.
     * Storing the whole graph in memory is problematic.
     *
     * Better to have general object-oriented (decoupled) structure:
     *
     * There is a User class with all corresponding fields
     * there should be unique id (name-surname are not unique)
     * there should be a Set<User> (we probably do not care about the order) - immediate friends.
     *
     * Here also important to notice - graph is undirected: if A is friends of B -> B friend of A.
     *
     * In order to find recommendation -> we need to check only friends of immediate friends,
     * because they will have at least one person (user`s friend) in common friends.
     *
     * N - total number of Users
     * Brute-force solution: check all user`s friends` friends Set<User> - O(N)
     * check common number of friends with User (minimum will be one, because there is at least one friend)
     * check will be O(N) based on check if element is in Set.
     *
     * Important: filter out user node itself and its friends - because they should not be recommended.
     *
     * It will be easier, if we pre-compute frequencies of each friends` friend in the Map -
     * frequencies will give
     *
     * If we need to find any one recommendation :
     * Time complexity : O(N) - check each friend (up to N), and if friend has only one friend, which is user - skip.
     * Space Complexity: O(N) - to maintain list of exclusions + one candidate
     *
     * If there is limit on friends M - when regardless all people count in network: Time Complexity : O(1).
     */
    public User getAnyRecommendation(User user) {
        // user and friends can not be null (null safe)
        if (user == null || user.friends == null) {
           return null;
        }
        Set<User> friends = user.friends;
        // user itself and any of friends can not be recommendation
        Set<User> exclusions = new HashSet<>();
        exclusions.add(user);
        exclusions.addAll(user.friends);
        // let`s check friends of each friend
        for (User friend : friends) {
            Set<User> candidates = friend.friends;
            for (User candidate : candidates) {
                if (!exclusions.contains(candidate)) {
                    return candidate;
                }
            }
        }
        return null;
    }

    /**
     * if we need sort recommendations based on frequency :
     *
     * @param user user
     * @return recommendations sorted by frequency
     */
    public List<Recommendation> getRecommendationsSortedByFrequency(User user) {
        // user and friends can not be null (null safe)
        if (user == null || user.friends == null) {
            return null;
        }
        Set<User> friends = user.friends;
        // user itself and any of friends can not be recommendation
        Set<User> exclusions = new HashSet<>();
        exclusions.add(user);
        exclusions.addAll(user.friends);

        // let`s have HashMap user -> frequency (having friends in common) for the suggestion
        // example A <-> B ; A <-> C; B <-> D; C <-> D; C <-> E
        // D -> 2; E -> 1 frequencies, cause D has B and C in common with A and E has C in common with A
        // user should be immutable to be used as a key in Map;
        Map<User, Integer> frequencies = new HashMap<>();

        // let`s check friends of each friend
        for (User friend : friends) {
            Set<User> candidates = friend.friends;
            for (User candidate : candidates) {
                if (!exclusions.contains(candidate)) {
                    int count = frequencies.getOrDefault(candidate, 0);
                    frequencies.put(candidate, count + 1);
                }
            }
        }
        // we found frequencies -> let`s form sorted list of recommendations based on frequency

        // collect recommendations based on user and frequency
        return frequencies.entrySet().stream()
                .map(entry -> {
                    Recommendation recommendation = new Recommendation();
                    recommendation.frequency = entry.getValue();
                    recommendation.user = entry.getKey();
                    return recommendation;
                })
                // sort from most frequent to less frequent
                .sorted()
                .collect(Collectors.toList());

        // there can be many follow ups:
        // 1. return only the one with most common friends (frequent) if there are multiple - return any.
        // 2. return only up to K recommendations after sorting limit; PriorityQueue probably will not help
        // 3. Maybe there will be variations of this task based on Map <frequency ; Set<User>> - reversed index
        // and sorting Map by frequency

        // In general complexity will be the following:
        // Total Number of edges in graph does not matter; but it can be a variable in terms of common friends..
        // Time Complexity : O(M + N log N)
        //     - M : edges (basically friends and friends of friends)
        //     - N log N - number of friends and sorted by frequency
        // assuming that number of edges does not matter much and can grow up to N^2
        // Time Complexity : O(N^2 + N log N) - O(N^2)
    }

    // equals and hashcode should be implemented based on unique id;
    static class User {
        int id;
        Set<User> friends;
    }

    static class Recommendation implements Comparable<Recommendation> {
        int frequency;
        User user;

        @Override
        public int compareTo(Recommendation o) {
            return o.frequency - frequency;
        }
    }
}
