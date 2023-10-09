package iurii.job.interview.amazon.online_assesment;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Similar to Leetcode : https://leetcode.com/problems/search-suggestions-system/description/
 * just starting from index 2
 *
 * Amazon
 * Amazon is building a way to help customers search reviews quicker by providing real-time suggestions to search terms when the customer starts typing. When given a minimum of two characters into the search field the system will suggest at most three keywords from the review word repository. As the customer continues to type in the reviews search bar the relevant keyword suggestions will update automatically.
 *
 * Write an algorithm that will output a maximum of three keyword suggestions after each character is typed by the customer in the search field.
 *
 * If there are more than three acceptable keywords, return the keywords that are first in alphabetical order.
 * Only return keyword suggestions after the customer has entered two characters.
 * Keyword suggestions must start with the characters already typed
 *
 * Both the repository and the customerQuery should be compared in a case-insensitive way.
 *
 * Input
 * The input to the method/function consists of two arguments:
 * repository, a list of unique strings representing the various keywords from the Amazon review comment section;
 * customerQuery, a string representing the full search query of the customer.
 *
 * Output
 * Return a list of a list of strings in lower case, where each list represents the keyword suggestions made by the system as the customer types each character of the customerQuery. Assume the customer types characters in order without deleting or removing any characters. If an output is not possible, return an empty array ([]).
 *
 * Example
 * Input:
 * repository = [ "mobile", "mouse", "moneypot", "monitor", "mousepad" ]
 * customerQuery = "mouse"
 *
 * Output:
 * ["mobile", "moneypot", "monitor"]
 * ["mouse", "mousepad"]
 * ["mouse", "mousepad"]
 * ["mouse", "mousepad"]
 *
 * Explanation:
 * The chain of words that will generate in the search box will be
 * mo, mou, mous, mouse
 * and each line from output shows the suggestion of "mo", "mou", "mous", "mouse", respectively in each line.
 * For the keyword suggestions made by the system that are generated for 'mo', the matches that will be generated are:["mobile", "mouse", "moneypot", "monitor", "mousepad"]
 * Alphabetically, they will be reordered to [ "mobile", "moneypot", "monitor", "mouse", "mousepad" ].
 * Thus the keyword suggestions made by the system are [ "mobile", "moneypot", "monitor"].
 */
public class SearchSuggestionsSystem {

    // almost bruteforce solution
    public List<List<String>> searchSuggestions(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        List<String> lowercaseProducts = Arrays.stream(products).map(String::toLowerCase).collect(Collectors.toList());
        String lowercaseSearchWord = searchWord.toLowerCase();
        for(int ii = 2; ii < lowercaseSearchWord.length(); ii++) {
            String partialQuery = lowercaseSearchWord.substring(0, ii);

            List<String> partialResult = new ArrayList<>();
            for(String word : lowercaseProducts) {
                if(partialQuery.equals(word.substring(0, ii))) {
                    partialResult.add(word);
                    if (partialResult.size() > 3) {
                        Collections.sort(partialResult);
                        partialResult.remove(3);
                    }
                }
            }
            Collections.sort(partialResult);
            result.add(partialResult);
        }
        return result;
    }

    // similar to initial version, bit more bruteforce
    public List<List<String>> searchSuggestions2(String[] products, String searchWord) {
        String queryString = "";
        List<List<String>> result = new ArrayList<>();

        // For each sub query string
        for (int charIndex = 0; charIndex < searchWord.length(); charIndex++) {
            queryString += Character.toLowerCase(searchWord.charAt(charIndex));

            // Don't find suggestions if length is < 2
            if (queryString.length() < 2)
                continue;

            // For each item in repository
            List<String> suggestionsForIndex = new ArrayList<>();
            for (int index = 0; index < products.length; index++) {
                String item = products[index].toLowerCase();

                if (item.startsWith(queryString)) {
                    suggestionsForIndex.add(item);
                }
            }

            // Sort and keep the top 3
            Collections.sort(suggestionsForIndex);
            result.add(suggestionsForIndex.subList(0, 3));
        }
        return result;
    }

    private static final int MIN_QUERY_LENGTH = 2;
    private static final int MAX_SUGGESTION_SIZE = 3;
    private static final Comparator<String> STRING_COMPARATOR = Comparator.reverseOrder();

    public List<List<String>> searchSuggestions3(String[] products, String searchWord) {
        // pre conditions
        if(products == null || searchWord == null || searchWord.length() < MIN_QUERY_LENGTH || products.length == 0) {
            return Collections.emptyList();
        }

        List<List<String>> suggestions = new ArrayList<>();

        // this will separate the customer query into a list of lowercase prefixes
        // ex: customerQuery = "aBc" will be prefixList = ["a","ab","abc"]
        List<String> prefixList = new ArrayList<>();
        String lowerCaseCustomerQuery = searchWord.toLowerCase();
        for (int i = MIN_QUERY_LENGTH; i <= lowerCaseCustomerQuery.length(); i++) {
            prefixList.add(lowerCaseCustomerQuery.substring(0, i));
        }

        // process the entire repository once
        for(String word : products) {
            addWordAsSuggestionIfApplicable(word.toLowerCase(), prefixList, suggestions);
        }

        return suggestions;
    }

    /**
     * converts a queue into a list, maybe a collections or stream operation could be used instead
     **/
    public static List<String> flattenQueueToList(Queue<String> queue) {
        List<String> queueAsList = new ArrayList<>();
        while(!queue.isEmpty()) {
            String item = queue.poll();
            queueAsList.add(item);
        }
        return queueAsList;
    }

    /**
     * Naming is hard.  This method will take a given word from the repository, check against the first entry in the prefix list.  If it
     * matches, it will add it to the queue and process the next prefix in the list.  If it does not match, it will not process the next
     * prefix and return.
     **/
    private static void addWordAsSuggestionIfApplicable(String word, List<String> prefixList, List<List<String>> suggestions) {
        int index = 0;
        String prefix = prefixList.get(index);

        while(word.startsWith(prefix)) {
            PriorityQueue<String> queue = new PriorityQueue<>(MAX_SUGGESTION_SIZE, STRING_COMPARATOR);
            addWordToQueue(word, queue);

            // it matched last prefix so check next prefix if not at the end of the prefix list, otherwise exit loop
            index++;
            if (index == prefixList.size()) {
                break;
            }
            prefix = prefixList.get(index);
        }

    }

    /**
     * add the suggested word to the queue.  If the queue is less than max suggestion size just add the word, if the queue is full
     * check word against value on top of queue, and if appropriate, pop value off and add new suggestion to queue.
     **/
    private static void addWordToQueue(String word, Queue<String> queue) {
        if(queue.size() < MAX_SUGGESTION_SIZE) {
            queue.add(word);
        } else {
            String peekValue = queue.peek();

            if(peekValue.compareTo(word) > 0) {
                queue.poll();
                queue.add(word);
            }
        }
    }

    // The best solution using Trie + DFS
    // Put all words into Trie
    // Map should be sorted by key TreeMap = should sort on each put or afterward - does not matter
    // Traverse Trie using search word and take first 3 words using DFS for current prefix in tries
    // Time complexity : O(n * m) to form the trie
    public List<List<String>> searchSuggestionsTrieAndDfs(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        Trie root = new Trie();
        // next
        for (String product : products) {
            root.add(product);
        }
        Trie curTrie = root;
        for(int i = 0; i < searchWord.length(); i++) {
            char curChar = searchWord.charAt(i);
            curTrie = curTrie.getNextOrDefault(curChar);
            if (i < 1) {
                // suggest after second char
                continue;
            }
            // dfs to find top 3 answers
            List<String> answer = new ArrayList<>();
            findSuggestions(curTrie, answer);
            result.add(answer);
        }
        return result;
    }

    private void findSuggestions(Trie trie, List<String> answer) {
        if (answer.size() == 3) {
            // return when first 3 sorted are returned
            return;
        }
        // if exists terminal - add
        if (trie.terminalValue != null) {
            answer.add(trie.terminalValue);
        }
        for (char c : trie.next.keySet()) {
            findSuggestions(trie.getNextOrDefault(c), answer);
        }
    }

    public static class Trie {
        public static Trie EMPTY = new Trie();
        // available to query next and TreeMap To be sorted
        Map<Character, Trie> next = new TreeMap<>();
        String terminalValue;

        public void add(String word) {
            Trie curTrie = this;
            for (int i = 0; i < word.length(); i++) {
                char curChar = word.charAt(i);
                if (curTrie.getNext(curChar) == null) {
                    curTrie.next.put(curChar, new Trie());
                }
                curTrie = curTrie.getNext(curChar);
            }
            curTrie.terminalValue = word;
        }

        public Trie getNext(char c) {
            return next.get(c);
        }

        public Trie getNextOrDefault(char c) {
            return next.getOrDefault(c, EMPTY);
        }
    }

    // Time Complexity : O(n log(n)) + O(m log(n)) ; m - word length; n - number of products
    // O(n log(n)) - sorting assuming O(1) string comparison based on hash
    // O(m log(n)) -running binary sort m times on number of products n;
    // O(m^2) because strings are immutable and need copy
    // Space complexity: O(n*m) - products themselves + O(3*m) - result set
    public List<List<String>> searchSuggestionsWithBinarySearch(String[] products, String searchWord) {
        // sorting
        Arrays.sort(products); // nlog(n)

        // binary search first proper word: m log(n)
        List<List<String>> result = new ArrayList<>();

        StringBuilder prefix = new StringBuilder();
        for(int i = 0; i < searchWord.length(); i++) {
            char curChar = searchWord.charAt(i);
            prefix.append(curChar);
            if (i < 1) {
                // suggest after second char
                continue;
            }

            int index = findIndex(prefix.toString(), products);
            if (index == -1) {
                // not found
                continue;
            }
            List<String> curResult = new ArrayList<>();
            // add up to 3 results from sorted if match
            while (index < products.length && products[index].startsWith(prefix.toString()) && curResult.size() < 3) {
                curResult.add(products[index]);
                index++;
            }
            result.add(curResult);
        }
        return result;
    }

    private int findIndex(String prefix, String[] products) {
        int l = 0;
        int h = products.length - 1;
        while (l < h) {
            int index = (h + l) / 2;
            if (products[index].startsWith(prefix)) {
                // find first index with starts with
                while (index - 1 >= 0 && products[index - 1].startsWith(prefix)) {
                    index--;
                }
                return index;
            }
            if (products[index].compareTo(prefix) > 0) {
                h = index - 1;
            } else {
                l = index + 1;
            }
        }
        // not found
        return -1;
    }
}
