package iurii.job.interview.google;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1. Your friend types you a message. His keyboard letter 'e' is broken and when he types it, space ' ' is printed
 * You have a dictionary with correct words - find all possibilities of friends message.
 *
 * Q&A :
 * 1. What type of characters are in message? - Only letters and spaces. No punctuation, etc.
 * 2. What types of words are in dictionary? - Words without spaces, punctuation.
 *
 * public List<String> findAllPossibleMessages(String message, Set<String> dictionaryWords);
 *
 * Approach use DFS and on each character do the following:
 * 1. check if index >= message.length. Check dictionary contains current collected word
 * if yes collect previous words and current message and return in List<String>
 * otherwise return empty list (no answers)
 *
 * 2. if current letter != ' '
 * add letter to current collected word, increase index by 1 and call recursion method;
 *
 * 3. if current letter == ' '
 * 3.1 can be real space - check dictionary contains current collected word -> if yes add to current
 * collected words, call recursion method with increased index by 1,
 * copied list of collected words and empty current message;
 * 3.2 can be 'e' - add e into the current collected word and recursion call with index + 1,
 * current collected word + 'e',
 *
 * Collect all returned List<String> results (empty lists will be skipped)
 *
 * Recursion method signature
 * List<String> dfs(String message, Set<String> dictionaryWords, int index,
 * List<String> collectedWords, String currentCollectedWord);
 *
 * Space complexity : (2^N) worst case; only spaces and space can be real space or 'e'
 * Time complexity: (2^N) worst case; only spaces and space can be real space or 'e'
 *
 * Improvements: put all dictionary words into Trie and check if Leaf node -> contains;
 * if there is no path forward in Trie with next letter - this variant can be skipped;
 *
 *
 * 2. Googleyness and Leadership principles;
 * 2.1 If you organize event : how would you ask for voting which kind of event?
 * Keywords : diversity, inclusiveness, unconscious bias, multiple choices,
 * ask if special accommodation needed
 *
 * 2.2 Tell me about situation when there were multiple ways to go forward,
 * how and why special decision made;
 * Keywords: multiple choices, different opinions, based on data, manager communication,
 * priorities, etc.
 *
 * 2.3 Tell me about successful project, why it was successful?
 * Keywords : different levels of success, quality, customers, deadlines met;
 *
 * 2.4 Tell me about what motivates you?
 * Keywords : client success, company success, team success, your own success;
 *
 * 3. System Design;
 * There are multiple servers for games, games are processed on backend;
 * each server holds 10 users there 500 million users online;
 * game lasts 10 minutes (update on score can be send in the end or during execution,
 * better in the end; but mention score can be lost - it should not).
 *
 * Design leadership board up to 10 results;
 *
 * Main issues: there should be multiple servers checking current score from user;
 * they should have Cache for last 10 results in PriorityQueue<> Min heap,
 * so that old min value can be removed and checked in O(1) time with current score;
 * one server should be enough to store all scores 4 bytes userId, 4 bytes score; even for 5 million users;
 *
 * Updates to leaderboard will be frequent in the beginning when score is low;
 * but later updates will be rear; so when update happens one database should be locked
 * for update (in case concurrent modifications are happening)
 * and other servers should update their caches.
 *
 * Not many requests for update per second (in most cases score should not go to leaderboard)
 * And memory is enough on 1 machine to store all the data;
 *
 * 4. Two coding parts;
 *
 * 4.1 There is a circular linked-list, remove each even node (not value) from this list.
 * Examples: 1->2->1  -> 1->1
 *           1->2->3->1  -> 1->3->1
 *           1->2->3->4->1 -> 1->3->1
 *  Be careful with condition stop/continue;
 *  Be careful to free memory when move from 1->3  2.next may remain in memory but should not;
 *
 *  4.2 Object oriented question :
 *  There is abstract Message class
 *  There is Peer class
 *  System has Peer connected to many other peers (graph structure);
 *  each Peer knows neighbours it connected to and amount (amount of people in Peer);
 *
 *  each Peer has sendMessage(Peer receiver, Message message) method;
 *  each Peer has receiveMessage(Peer sender, Message message) method;
 *
 *  Design both methods, so that Peers can find total amount each Peer has via messages;
 *  network is static;
 *
 *  5. There is an overlapping list of intervals for meetings [long i, long j]  j >= i;
 *  there is a dnd (do not disturb) interval to be inserted into intervals,
 *  so that dnd wins (cuts over events if they have part of time inside dnd);
 *  split list of events into non overlapping with dnd
 *
 *  example: [1,3 e] [4,8 e], [5, 11 e], [13, 15 e]
 *  dnd : [10, 14, dnd]
 *  answer: [1,3 e][4,10 e] [10, 14 dnd][14, 15 e];
 *
 *  Going to task -> solution one by one
 */
public class GoogleOnsite2 {

    // ========================== Task 1 ========================================

    /**
     *  * 1. Your friend types you a message. His keyboard letter 'e' is broken and when he types it, space ' ' is printed
     *  * You have a dictionary with correct words - find all possibilities of friends message.
     *  *
     *  * Q&A :
     *  * 1. What type of characters are in message? - Only letters and spaces. No punctuation, etc.
     *  * 2. What types of words are in dictionary? - Words without spaces, punctuation.
     *  *
     *  * public List<String> findAllPossibleMessages(String message, Set<String> dictionaryWords);
     *  *
     *  * Approach use DFS and on each character do the following:
     *  * 1. check if index >= message.length check dictionary contains current collected word
     *  * if yes collect previous words and current message and return in List<String>
     *  * otherwise return empty list (no answers)
     *  *
     *  * 2. if current letter != ' '
     *  * add letter to current collected word, increase index by 1 and call recursion method;
     *  *
     *  * 3. if current letter == ' '
     *  * 3.1 can be real space - check dictionary contains current collected word -> if yes add to current
     *  * collected words, call recursion method with increased index by 1,
     *  * copied list of collected words and empty current message;
     *  * 3.2 can be 'e' - add e into the current collected word and recursion call with index + 1,
     *  * current collected word + 'e',
     *  *
     *  * Collect all returned List<String> results (empty lists will be skipped)
     *  *
     *  * Recursion method signature
     *  * List<String> dfs(String message, Set<String> dictionaryWords, int index,
     *  * List<String> collectedWords, String currentCollectedWord);
     *  *
     *  * Space complexity : (2^N) worst case; only spaces and space can be real space or 'e'
     *  * Time complexity: (2^N) worst case; only spaces and space can be real space or 'e'
     *  *
     *  * Improvements: put all dictionary words into Trie and check if Leaf node -> contains;
     *  * if there is no path forward in Trie with next letter - this variant can be skipped;
     */
    public static final char SPACE = ' ';

    /**
     * 1. Proper implementation with using Trie to quickly check if there is possibility to find needed word.
     *  Space complexity : (2^N) worst case; only spaces and space can be real space or 'e'
     *  Time complexity: (2^N) worst case; only spaces and space can be real space or 'e'
     *
     * @param message message
     * @param dictionaryWords dictionary words
     * @return all possible messages
     */
    public List<String> findAllPossibleMessages(String message, Set<String> dictionaryWords) {
        Trie trie = new Trie();
        trie.insert(dictionaryWords);
        List<String> results = new ArrayList<>();
        int index = 0;
        char[] m = new char[message.length()];
        // recursively call to collect results
        find(m, message, trie, trie, index, results);
        return results;
    }

    /**
     * main recursive function to collect messages
     *
     * @param m current collected message
     * @param message original message
     * @param cur current Trie pointer
     * @param root root of the Trie pointer
     * @param index current index of character in message to check
     * @param results list of possible message
     */
    private void find(char[] m, String message, Trie cur, Trie root, int index, List<String> results) {
        // Base case 1. No match with any dictionary word.  if cur == null -> no match ; return
        if (cur == null) {
            return;
        }
        // Base case 2. if out of bounds, check previously collected word and return
        if (index == message.length()) {
            // result only in case matches word
            if (cur.word != null) {
                results.add(new String(m));
            }
            return;
        }
        char c = message.charAt(index);
        if (c == SPACE) {
            // matches word or character 'e'
            // check if matches word from dictionary
            if (cur.word != null) {
                m[index] = SPACE;
                // if space - start collecting new word from beginning of Trie
                find(m, message, root, root, index + 1, results);
            }
            // otherwise ' ' -> 'e'
            c = 'e';
        }
        // considered non-space character (backtracking)
        m[index] = c;
        // get next element from try
        Trie next = cur.get(c);
        find(m, message, next, root, index + 1, results);
    }

    /**
     * Simplest implementation of Trie.
     * 1. Children - at least empty map.
     * 2. Insertion per word
     * 3. Easy get next node in Trie by char
     */
    private static class Trie {
        Map<Character, Trie> children = new HashMap<>();
        String word;

        public void insert(Collection<String> words) {
            for(String w : words) {
                insert(w);
            }
        }

        public void insert(String word) {
            Trie cur = this;
            for (char c : word.toCharArray()) {
                if (cur.children.get(c) == null) {
                    cur.children.put(c, new Trie());
                }
                cur = cur.children.get(c);
            }
            cur.word = word;
        }

        public Trie get(char c) {
            return children.get(c);
        }
    }

    // ========================== End Task 1 ========================================

    // ========================== Task 2 ========================================
    /**
     * 2. Googleyness and Leadership principles;
     *  * 2.1 If you organize event : how would you ask for voting which kind of event?
     *  * Keywords : diversity, inclusiveness, unconscious bias, multiple choices,
     *  * ask if special accommodation needed
     *  *
     *  * 2.2 Tell me about situation when there were multiple ways to go forward,
     *  * how and why special decision made;
     *  * Keywords: multiple choices, different opinions, based on data, manager communication,
     *  * priorities, etc.
     *  *
     *  * 2.3 Tell me about successful project, why it was successful?
     *  * Keywords : different levels of success, quality, customers, deadlines met;
     *  *
     *  * 2.4 Tell me about what motivates you?
     *  * Keywords : client success, company success, team success, your own success;
     */
    // ========================== End Task 2 ========================================

    // ========================== Task 3 ========================================
    /**
     *  * Task 3. System Design;
     *  * There are multiple servers for games, games are processed on backend;
     *  * each server holds 10 users there 500 million users online;
     *  * game lasts 10 minutes (update on score can be send in the end or during execution,
     *  * better in the end; but mention score can be lost - it should not).
     *  *
     *  * Design leadership board up to 10 results;
     *  *
     *  * Main issues: there should be multiple servers checking current score from user;
     *  * they should have cache for last 10 results in PriorityQueue<> Min heap,
     *  * so that old min value can be removed and checked in O(1) time with current score;
     *  * one server should be enough to store all scores 4 bytes userId, 4 bytes score; even for 5 million users;
     *  *
     *  * Updates to leaderboard will be frequent in the beginning when score is low;
     *  * but later updates will be rear; so when update happens one database should be locked
     *  * for update (in case concurrent modifications are happening)
     *  * and other servers should update their caches.
     *  *
     *  * Not many requests for update per second (in most cases score should not go to leaderboard)
     *  * And memory is enough on 1 machine to store all the data;
     */

    // ========================== End Task 3 ========================================

    // ========================== Task 4.1 ========================================
    /**
     * Task 4.1 Remove each even node (not value) in singly circular linked list
     *
     * be careful not to have memory leaks with objects remaining in memory.
     *
     * Good source:
     * https://www.geeksforgeeks.org/delete-all-odd-or-even-positioned-nodes-from-circular-linked-list/
     *
     * Possible variation of the task:
     * 1. Remove even nodes based on node.val or based on position in list
     * 2. Remove odd nodes based on node.val or based on position in list
     * 3. Remove each n-th node position at least.
     * 4. What if not singly circular, but both ways.
     *
     * Main caveats:
     * 1. What if there is need to remove head.
     * 2. Then removing node be careful, not to leave memory leak/dangling node without reference
     *    Example A -> B -> C    A.next = C =>   A-> C
     *    and B -> C remains even though there is no link on B cause next reference C is reachable
     *    Proper update: B = A.next;  A.next = C; B.next = null  =>   A-> C; B is collected by GC.
     * 3. Be careful when traversal should be finished.
     *
     * How to address caveats:
     * 1. Determine circular array size; -> should help stop traversing then reaching the end.
     * 2. Update properly links to remove nodes without memory leaks.
     * 3. Use two pointers for traversal - previous element and next.
     * 4. Check special cases - list is null, empty, one node.
     *
     * Time Complexity : O(N) just go through each value (on each value constant operations)
     * MemoryComplexity: O(1) - pointers.
     *
     * Even, means head is at 0 position, so delete head is needed.
     */
    public static Node deleteAllEvenPositionNodes(Node head) {
        int len = length(head);
        // if list have single node
        // then return
        if (len < 2) {
            // do not forget to lose link on head
            return null;
        }
        Node newHead = deleteFirst(head);
        deleteAllOddPositionNodes(newHead);
        return newHead;
    }

    /**
     * Be careful with links.
     * https://leetcode.com/discuss/interview-question/219173/facebook-remove-every-alternate-element-from-a-circular-linked-list
     * https://leetcode.com/discuss/interview-question/395171/delete-every-alternative-node-in-a-circular-linked-list
     *
     * Deleting all odd elements means no change to head. it remains.
     * @param head head of the list.
     */
    public static void deleteAllOddPositionNodes(Node head) {
        int len = length(head);
        if (len < 2) {
            return;
        }
        Node current = head;
        do {
            Node toBeDeleted = current.next;
            // Note: current.next.next can not be null in circular list.
            current.next = current.next.next;
            toBeDeleted.next = null;
            current = current.next;
        } while(current != head && current.next != head);
    }

    // Function to delete first. returns new head
    private static Node deleteFirst(Node head) {
        if (head == null) {
            return null;
        }
        Node current = head;

        // only one element
        if (current.next == head) {
            head.next = null; // or head = null is fine for GC
            return null;
        }

        while(current.next != head) {
            current = current.next;
        }
        // removing head from list
        current.next = head.next;
        // prevent memory leak
        head.next = null;
        head = current.next;
        return head;
    }

    // Function return number of nodes present in list
    private static int length(Node head) {
        Node current = head;
        // if list is empty simply return length zero
        if (head == null) {
            return 0;
        }
        int count = 1;
        while (current.next != head) {
            current = current.next;
            count++;
        }
        return count;
    }

    /**
     * minimalistic Node class that points to next Node to form linked list and has value
     */
    public static class Node {
        Node next;
        int val;
    }

    // ========================== End of Task 4.1 ========================================

    // ========================== Task 4.2 ========================================
    /**
     * Task 4.2 There is system of bunkers. Each bunker knows neighbours and number of people.
     * Write distributed system with send message, onReceive message to count number of total people
     * in all the bunkers.
     *
     * This is a design question similar to design network routing tables in the network.
     * Each node should have its own id to be able to check if it is already in table.
     *
     * Approaches to that problem :
     * 1. Proactive: send your own  bunker count or received one to anyone
     *  - Broadcast:
     *    - add your own bunkerId to count into mapping
     *    - send message with your own bunkerId and count to all neighbours.
     *    - receive message from neighbours - check Table - Map if mapping exists,
     *      - if no mapping add mapping and send message to Neighbours (Improvement1: do not send back)
     *      - Improvement2 on receive wait for messages from other members (cache) and send lists
     *      of updates (instead of broadcast)
     *  - Between broadcast and one message - alternative is to send in batches.
     *  - Batching could be hard - when to batch? what if there are no more messages.
     *
     *       Question: how long to wait until all messages are received and sent?
     *      - if we know number of bunkers - it is not an issue
     *      - if we do not know - this can be an issue, because we do not know which message will be the last.
     *      We can put big enough timeout to try give guarantees, but still it will not be precise.
     *
     *  2. Passive : first ask for neighbours and then continue asking for their neighbours and so on
     *     Respond only to the nodes that asked. Initially update routing for neighbours
     *     and then ask neighbours. Navigate only via routing tables.
     *     Update routing tables when new is discovered.
     *
     *  Looks a bit similar to
     *  https://leetcode.com/discuss/interview-question/438213/Print-the-number-of-nodes-in-a-distributed-network/394326
     *  a bit has similarity to https://leetcode.com/problems/critical-connections-in-a-network/
     *
     *  What if we do the following steps: ask direct neighbours for their count and
     *  put into mapping.
     *  Then ask for the neighbour`s neighbours and put into mapping - new ones
     *  if there is no new ones - means there are no new bunkers to discover. we are done.
     *  Each node will run such an algorithm.
     *  This is BFS approach.
     *
     *  Time Complexity : O (2 x the longest path between two bunkers)
     *  Space complexity: O(N)
     */
    public static class Bunker {
        // unique bunkerId
        int id;
        public int getId() {
            return id;
        }
        // neighbours to current bunker
        List<Bunker> neighbours;
        // number of people in bunker
        int count;

        // all updates to mappings /sets should be thread  safe

        // holds direction, based on bunkerId to reach, send to bunker
        Map<Integer, Bunker> routing = new HashMap<>();
        // bunker to id count; when algo is finished calc sum for all bunkers
        Map<Integer, Integer> bunkerIdToCount = new HashMap<>();

        // it tracks messages sent to destination. removed then getting an answer
        Set<Integer> getCountDestinationIds = new HashSet<>();
        Set<Integer> getNeighboursDestinationIds = new HashSet<>();

        // flag to determine if all the bunkers are discovered and counts are updated
        boolean isCompleted;

        /**
         * Before starting algo, initialize routing tables and bunker count mapping
         */
        public void initialize() {
            // add direct connections to routing table
            for (Bunker neighbour : neighbours) {
                routing.put(neighbour.getId(), neighbour);
            }
            // add yourself
            routing.put(id, this);
            bunkerIdToCount.put(id, count);
            // kick off the algo
            initiate();
        }

        /**
         * Main starting and continuing algorithm for breadth first search in graph.
         */
        // ask for count neighbours - send
        // on receive - (update routing if needed) send count
        // update count - on receive
        // ask for next neighbour ids - sent
        // update routing - on receive
        // ask new ids for count
        // repeat until there are no new ids.
        public void initiate() {
            // all we know is neighbours
            Set<Integer> idsToSend = neighbours.stream().map(Bunker::getId).collect(Collectors.toSet());
            sendGetCount(idsToSend);
        }

        public void sendGetCount(Set<Integer> idsToSend) {
            if (idsToSend.isEmpty()
                    && getCountDestinationIds.isEmpty()
                    && getNeighboursDestinationIds.isEmpty()) {
                // final condition when all bunker count is in the map
                isCompleted = true;
            }
            for (int receiver : idsToSend) {
                GetCountMessage message = new GetCountMessage();
                message.sender = id;
                message.lastSender = id;
                message.receiver = receiver;
                getCountDestinationIds.add(receiver);
                sendGetCount(message);
            }
            // Potentially messages to receive count and neighbours can be merged into one request
            for (int receiver : idsToSend) {
                GetNeighboursMessage message = new GetNeighboursMessage();
                message.sender = id;
                message.receiver = receiver;
                getNeighboursDestinationIds.add(receiver);
                sendGetNeighbours(message);
            }
        }

        // ====  routing part =====
        public void sendGetNeighbours(GetNeighboursMessage message) {
            routing.get(message.receiver).onReceiveGetNeighbours(message);
        }

        public void sendGetCount(GetCountMessage message) {
            routing.get(message.receiver).onReceiveGetCountMessage(message);
        }

        public void sendGiveNeighbours(GiveNeighboursMessage message) {
            routing.get(message.receiver).onReceiveGiveNeighbours(message);
        }

        public void sendGiveCount(GiveCountMessage message) {
            routing.get(message.receiver).onReceiveGiveCountMessage(message);
        }

        // ==== receiving message: routing or responding ===
        private void onReceiveGetCountMessage(GetCountMessage message) {
            // update routing, if id does not exist there and put last sender as direction
            if (routing.get(message.sender) == null) {
                //Note: should exist cause neighbour
                routing.put(message.sender, routing.get(message.lastSender));
            }
            if (message.receiver == id) {
                GiveCountMessage giveCountMessage = new GiveCountMessage();
                giveCountMessage.count = count;
                giveCountMessage.sender = id;
                giveCountMessage.receiver = message.sender;
                sendGiveCount(giveCountMessage);
            } else {
                // route to destination
                message.lastSender = id;
                // we should know receiver at this step
                sendGetCount(message);
            }
        }

        public void onReceiveGetNeighbours(GetNeighboursMessage message) {
            // update routing, if id does not exist there and put last sender as direction
            if (routing.get(message.sender) == null) {
                //Note: should exist cause neighbour
                routing.put(message.sender, routing.get(message.lastSender));
            }
            if (message.receiver == id) {
                // we are the destination
                Set<Integer> neighbourIds = neighbours.stream().map(Bunker::getId).collect(Collectors.toSet());
                GiveNeighboursMessage giveNeighboursMessage = new GiveNeighboursMessage();
                giveNeighboursMessage.receiver = message.sender;
                giveNeighboursMessage.sender = id;
                giveNeighboursMessage.ids = neighbourIds;
                sendGiveNeighbours(giveNeighboursMessage);
            } else {
                // route to destination
                message.lastSender = id;
                // we should know receiver at this step
                sendGetNeighbours(message);
            }
        }

        public void onReceiveGiveNeighbours(GiveNeighboursMessage message) {
            if (message.receiver == id) {
                getNeighboursDestinationIds.remove(message.sender);
                Set<Integer> newIds = new HashSet<>();
                for (int neighbour : message.ids) {
                    //ignore if routing contains bunker
                    if (!routing.containsKey(neighbour)) {
                        newIds.add(neighbour);
                        //the way to get to neighbour is via sender (should be already in routing)
                        routing.put(neighbour, routing.get(message.sender));
                    }
                }
                // get count from newly discovered bunker ids
                sendGetCount(newIds);
            } else {
                // route to destination
                sendGiveNeighbours(message);
            }
        }

        public void onReceiveGiveCountMessage(GiveCountMessage message) {
            if (message.receiver == id) {
                // remove from queue and update count
                getCountDestinationIds.remove(message.sender);
                bunkerIdToCount.put(message.sender, count);
            } else {
                // route to destination
                sendGiveCount(message);
            }
        }
    }

    // broadcasting with increasing ttl and dropping messages if loop

    public static class GetNeighboursMessage {
        int sender;
        int lastSender;
        int receiver;
    }

    public static class GiveNeighboursMessage {
        int sender;
        int receiver;
        Set<Integer> ids;
    }

    public static class GetCountMessage {
        int sender;
        int receiver;
        int lastSender;
    }

    public static class GiveCountMessage {
        int sender;
        int receiver;
        int count;
    }

    // ========================== End of Task 4.2 ========================================


    // ========================== Task 5 ========================================
    /**
     * 5. There is an overlapping list of intervals for meetings [long i, long j]  j >= i;
     *  there is a dnd (do not disturb) interval to be inserted into intervals,
     *  so that dnd wins (cuts over events if they have part of time inside dnd);
     *  split list of events into non overlapping with dnd
     *
     *  example: [1,3 e] [4,8 e], [5, 11 e], [13, 15 e]
     *  dnd : [10, 14, dnd]
     *  answer: [1,3 e][4,10 e] [10, 14 dnd][14, 15 e];
     *
     *  Let`s assume all intervals with start including and end excluding [start; end).
     *
     */
    public List<Interval> merge(List<Interval> intervals, Interval dnd) {
        if (intervals.isEmpty()) {
            return Collections.singletonList(dnd);
        }
        Comparator<Interval> comparator = Comparator.comparing(Interval::getA).thenComparing(Interval::getB);

        //1. sort in ascending order based on starting point. if same then based on end point
        List<Interval> sorted = intervals.stream()
                .sorted(comparator)
                .collect(Collectors.toList());

        //2. merge intervals
        List<Interval> merged = new ArrayList<>();
        int start = sorted.get(0).a;
        int end = sorted.get(0).b;
        for (int i = 1; i < sorted.size(); i++) {
            Interval interval = sorted.get(i);
            // if there was previous interval, check, if it can be merged -> merge
            // otherwise flush previous interval and start new
            if (end >= interval.a) {
                end = interval.b;
            } else {
                merged.add(new Interval(start, end, IntervalType.E));
                start = interval.a;
                end = interval.b;
            }
        }
        merged.add(new Interval(start, end, IntervalType.E));

        //3. merge with dnd
        List<Interval> cutted = new ArrayList<>();
        for (Interval interval : merged) {
            cutted.addAll(merge(interval, dnd));
        }

        //4. add dnd
        cutted.add(dnd);

        // 5. sort
        return cutted.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    private List<Interval> merge(Interval interval, Interval dnd) {
        //     [  dnd  [int]  ]
        if (dnd.a <= interval.a && dnd.b >= interval.b) {
            return Collections.emptyList();
        }
        //    [  dnd  [ ]  interval   ]
        if (dnd.a <= interval.a && dnd.b >= interval.a) {
            return Collections.singletonList(new Interval(dnd.b, interval.b, IntervalType.E));
        }
        //    [   interval  [ dnd  ]   ]
        if (interval.a <= dnd.a && dnd.b <= interval.b) {
            return Arrays.asList(
                    new Interval(interval.a, dnd.a, IntervalType.E),
                    new Interval(dnd.b, interval.b, IntervalType.E)
            );
        }
        //    [  interval  [ ]  dnd   ]
        if (interval.a <= dnd.a && interval.b >= dnd.a) {
            return Collections.singletonList(new Interval(interval.a, dnd.a, IntervalType.E));
        }
        // else
        //    [ int  ]    [ dnd ]
        //    [dnd]        [int]
        //    return int
        return Collections.singletonList(interval);
    }

    public static class Interval {
        int a;
        int b;
        IntervalType type;

        public Interval(int a, int b, IntervalType type) {
            this.a = a;
            this.b = b;
            this.type = type;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }

    public enum IntervalType {
        E,
        DND,
    }

    // ========================== End of Task 5 ========================================
}
