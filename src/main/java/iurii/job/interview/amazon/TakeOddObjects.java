package iurii.job.interview.amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 *
 * Amazon task
 *
 * There is a list of objects.
 * Return list of objects, which number is odd in list (according to equals test).
 * Ordering can be no sorting, ordering by appearance in the list, ordering by natural order or Comparator
 *
 * Created by iurii.dziuban on 19/05/2017.
 */
public class TakeOddObjects {

    //General ideas:
    // Objects should be immutable or copied before going to method
    // - otherwise we can not guarantee that someone could change internals.

    // Potentially Map quicker than Set
    // , but in case small amount of duplicates Set solution can be good

    // Approach 1. HashMap and ArrayList. General Type

    /**
     * Good.
     * 1) Easy approach
     * 2) Quick in general if hashcode is ok. 3 times O(n)
     * 3) Null elements are possible
     * 4) Preconditions
     * Bad
     * 1) No concreate types
     * 2) No order
     * 3) No support for mutability - we can not do much
     * 4) A lot of memory for HashMap and List
     */
    public List<Object> takeOddHashMapAndArrayListNoOrderingOrSortingNotTypeSafed(List<Object> list) {
        if (list == null) {
            return new ArrayList<>();
        }
        Map<Object, Integer> countMap = new HashMap<>();
        for (Object obj : list) {
            Integer count = countMap.get(obj);
            if (count == null) {
                countMap.put(obj, 1);
            } else {
                countMap.put(obj, count + 1);
            }
        }
        List<Object> oddObjects = new ArrayList<>();
        for(Map.Entry<Object, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                oddObjects.add(entry.getKey());
            }
        }
        return  oddObjects;
    }

    // Approach 2. HashMap and ArrayList. Concreate type

    /**
     * Good.
     * 1) Easy approach
     * 2) Concreate type
     * 3) Quick in general if hashcode is ok 3 times O(n)
     * 4) Null elements are possible
     * 5) Preconditions
     * Bad
     * 1) No order
     * 2) No support for mutability - we can not do much
     * 3) A lot of memory for HashMap and List
     */
    public <T> List<T> takeOddHashMapAndArrayListNoOrderingTypeSafe(List<T> list) {
        if (list == null) {
            return new ArrayList<T>();
        }
        Map<T, Integer> countMap = new HashMap<>();
        fillCountMap(list, countMap);
        List<T> oddObjects = new ArrayList<>();
        for(Map.Entry<T, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                oddObjects.add(entry.getKey());
            }
        }
        return  oddObjects;
    }

    // Approach 3. LinkedHashMap and ArrayList. Concreate type

    /**
     * Good.
     * 1) Easy approach
     * 2) Concreate type
     * 3) Quick in general if hashcode is ok.
     * 4) Order by appearance
     * 5) Null elements are possible
     * 6) Preconditions
     * Bad
     * 1) No support for mutability - we can not do much
     */
    public <T> List<T> takeOddLinkedHashMapAndArrayListTypeSafeOrderByAppearance(List<T> list) {
        if (list == null) {
            return new ArrayList<T>();
        }
        Map<T, Integer> countMap = new LinkedHashMap<>();
        fillCountMap(list, countMap);

        return countMap.entrySet().stream().filter(entry -> entry.getValue() % 2 == 1)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }


    // Approach 4. LinkedHashSet and HashSet for duplicates. Concreate type

    /**
     * Good.
     * 1) Easy approach
     * 2) Concreate type
     * 3) Quick in general if hashcode is ok. O n log n
     * 4) Order by appearance
     * 5) Null elements are possible
     * 6) Preconditions
     * Bad
     * 1) No support for mutability - we can not do much
     * 2) More memory than LinkedHashMap
     * 3) More operations than LinkedHashMap
     */
    public <T> List<T> takeOddLinkedHashSetAndHashSetForDuplicatesTypeSafeOrderByAppearance(List<T> list) {
        if (list == null) {
            return new ArrayList<T>();
        }
        Set<T> countSet = new LinkedHashSet<T>();
        Set<T> duplicatedSet = new HashSet<T>();
        for (T obj : list) {
            if (!countSet.add(obj)) {
                if (!duplicatedSet.add(obj)) {
                    duplicatedSet.remove(obj);
                }
            }
        }
        countSet.removeAll(duplicatedSet);
        return new ArrayList<T>(countSet);
    }

    // Approach 5. TreeMap and ArrayList from it. Concreate type. Default Comparator

    /**
     * Good.
     * 1) Easy approach
     * 2) Concreate type
     * 3) Quick in general if hashcode is ok.
     * 4) Order by appearance
     * 5) Preconditions
     * Bad
     * 1) No support for mutability - we can not do much
     * 2) Null elements are not possible
     */
    public <T> List<T> takeOddTreeMapAndArrayListFromItOrderByDefaultComparator(List<T> list) {
        if (list == null) {
            return new ArrayList<T>();
        }
        Map<T, Integer> countMap = new TreeMap<>();
        fillCountMap(list, countMap);

        return countMap.entrySet().stream().filter(entry -> entry.getValue() % 2 == 1)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }

    private <T> Map<T, Integer> fillCountMap(List<T> list, Map<T, Integer> countMap) {
        for (T obj : list) {
            Integer count = countMap.get(obj);
            if (count == null) {
                countMap.put(obj, 1);
            } else {
                countMap.put(obj, count + 1);
            }
        }
        return countMap;
    }

    // Approach 6. TreeMap and ArrayList from it. Concreate type. Provided comparator

    /**
     * Good.
     * 1) Easy approach
     * 2) Concreate type
     * 3) Quick in general if hashcode is ok.
     * 4) Order by comparator
     * 5) Preconditions
     * 6) Null elements are possible depending on comparator
     * Bad
     * 1) No support for mutability - we can not do much
     */
    public <T> List<T> takeOddTreeMapAndArrayListFromItOrderByComparator(List<T> list, Comparator<T> comparator) {
        if (list == null) {
            return new ArrayList<T>();
        }
        Map<T, Integer> countMap = new TreeMap<>(comparator);
        fillCountMap(list, countMap);

        return countMap.entrySet().stream().filter(entry -> entry.getValue() % 2 == 1)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }
}
