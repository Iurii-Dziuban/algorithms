package iurii.job.interview.google;

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
 * 1. check if index >= message.length check dictionary contains current collected word
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
 * ask if special accomodation needed
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
 * they should have cache for last 10 results in PriorityQueue<> Min heap,
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
 * 4.1 There is a circular linked list, remove each even node (not value) from this list.
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
 */
public class GoogleOnsite2 {
}
