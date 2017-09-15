# Algorithms

[![Open Source Love](https://badges.frapsoft.com/os/v2/open-source.svg?v=103)](https://github.com/ellerbrock/open-source-badge/)    

[![Build Status](https://travis-ci.org/Iurii-Dziuban/algorithms.svg?branch=master)](https://travis-ci.org/Iurii-Dziuban/algorithms)
[![Coverage Status](https://coveralls.io/repos/github/Iurii-Dziuban/algorithms/badge.svg?branch=master)](https://coveralls.io/github/Iurii-Dziuban/algorithms?branch=master)
[![Dependency Status](https://www.versioneye.com/user/projects/57b8ae5bfc1827003a745b57/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/57b8ae5bfc1827003a745b57)
[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/Iurii-Dziuban/algorithms/issues)

This is Java Project with source files related to Algorithms and Data structures.
Includes implementation of algorithms and data structures from Princeton and Stanford courses on Coursera.

Maven build script is provided.

## Table of contents:
 * [Static Analysis QA Checks](#checks)
 * [Amazon tasks](#amazon-tasks)
 * [Yandex tasks](#yandex-tasks)
 * [Booking.com tasks](#bookingcom-tasks)
 * [Google tasks](#google-tasks)
 * [Leetcode.com tasks](#leetcodecom-tasks)
 * [Codility.com tasks](#codilitycom-tasks)
 * [Cracking coding interview](#cracking-coding-interview)
 * [Coursera algorithms by Stanford](#coursera-algorithms-by-stanford)
 * [Data structures implementations](#data-structures-implementations)
 * [Graph algorithms](#graph-algorithms)
 * [Sorting algorithms](#sorting-algorithms)
 * [Generic](#generic)
   * [Concurrency](#concurrency) - concurrency related structures
   * [Performance](#performance) - performance related structures
   * [Farm project](#farm-project) - pull model (event are pulled)
   * [Farm listener](#farm-listener) - push model (events are pushed)
 **And much more** : greedy algorithms, topcoder, concurrency, usage of data structures in other algorithms
 
# Checks

Jacoco code coverage, pmd, checkstyle, enforcer, findbugs

# Amazon tasks
- TakeOddObjects (TakeOddObjectsTest) - List contains duplicates. Take only ones, which count is odd.Compare according to equals method. Note: Tests knowledge of Map, Set different implementations: hash, tree, linkedHash.
- CIDRComparator (CIDRComparatorTest) - There are two subnet addresses. Find out the relation: Subset, Superset, Equal, Disjoint . More info : https://en.wikipedia.org/wiki/Classless_Inter-Domain_Routing
- BalancedParenthensies (BalancedParenthensiesTest) - Check if parenthesies are balanced in a string or not. Note: Tests basic knowledge of Stack.
- ProcessorsForTasks (ProcessorsForTasksTest) - find minimum number of processors for tasks
- CountNegativeIntegersInRowColumnWiseSortedMatrix (CountNegativeIntegersInRowColumnWiseSortedMatrixTest) - mock amazon interview question

# Yandex tasks
- Bencode (BencodeTest) - implementation of Bencode protocol for encoding/decoding data. Widely used in torrents. More info: https://en.wikipedia.org/wiki/Bencode

# Booking.com tasks
- CustomerServiceCapacity (CustomerServiceCapacityTest) - find minimum additional number of employers needed to handle all the calls.
- Polygons (PolygonsTest) - 4 sided polygons. Determine type of the polygon and count different types.
- DeltaEncoding (DeltaEncodingTest) - encode list of number with list, each next value is different between current and previous number. If difference is more than some value (e.x. one byte) use escape value.
- SortHotelsList (SortHotelsListTest) - standard map-reduce example. In Big data world can be done by Spark/Hadoop. In java best approach to continue with Stream API and probably use parallelStream for better performance. Be careful not to design solution with adding stream values into collection. Slows down the solution. Better to have the whole pipeline and aggregation function in the end
- FindMaxGuestDayService (FindMaxGuestDayServiceTest) - similar to CustomerServiceCapacity and ProcessorsForTasks.
- PathsFromRoot (PathsFromRootTest) - Binary tree. Find paths from root with specific sum value.

# Google tasks
- TwoPairParticularSum (TwoPairParticularSumTest) - mock interview find two pairs in array sum is equal to particular one

# Leetcode.com tasks
LeetCode is a platform for preparing technical coding interviews. 
Pick from an expanding library of questions, code and submit your solution to see if you have solved it correctly. 
The platform currently supports a total of 11 languages: C, C++, Java, Python, C#, JavaScript, Ruby, Swift, Go, Bash, MySQL.

- LargestRectangleInHistogram (LargestRectangleInHistogramTest) - finding largest rectangle under the histogram

# Codility.com tasks
Codility is a platform for hiring stronger programmers faster. Has requirements for time and space complexity.
Look for "codility" package

- BinaryGap (BinaryGapTest) - find maximal sequence of consecutive zeros that is surrounded by ones (in binary representation)


# Cracking coding interview
- package `cracking`

# Coursera algorithms by Stanford
- package `algorithms1.coursera` and `algorithms2.coursera` 

# Data structures implementations
- package `datastructure`

# Graph algorithms
- package `graph`

# Sorting algorithms
- package `sorting`

# Generic

## Concurrency
- ReadWriteLock - implementation of ReadWriteLock. Many readers can acquire lock (without writers) or only one writer acquires the lock.
- ThreadPool - implementation of thread pool based on wait/notify paradigm with standard array for threads and linkedList for tasks. Implementation of "fair" processing.
- ThreadPoolBlockingQueue - implementation of thread pool based on usage of BlockingQueue primitive 
- ThreadPoolBlockingQueueWithExecutor - implementation with control over the thread pool 

- ConcurrentStack (ConcurrentStackTest) - implementation of thread-safe Stack for multithreaded environment in lock-free (not wait-free!) manner. Wait-free algorithms have stronger guarantees. 
- ConcurrentLinkedList (ConcurrentLinkedListTest) - implementation of thread-safe LinkedList (Queue) for multithreaded environment in lock-free (not wait-free) manner. Wait-free algorithms have stronger guarantees.
- NonBlockingCounter (NonBlockingCounterTest) - implementation of thread-safe counter for multithreaded in lock-free (not wait-free) manner. Wait-free algorithms have stronger guarantees.
## Performance
- FinalDeclarationPerformanceTest - compares operation time using final and non final variables. Final is a bit more efficient.

## Farm project
Application with usage of regex, error handling, working with files (resources), Reflection API, Threads and Concurrency.
- package `iurii.job.interview.generic.listener.farm`.
Console application: ```iurii.job.interview.generic.listener.farm.main.Main -f=animals.properties -l=history.log```
  - `animals.properties` - property file to configure existing Animal classes. Extensible to have less/more classes and change names.
  - `history.log` - file with logs from the application
Basic console commands:
  - ```farm stat``` - statistics of the application
  - ```farm close```- exit the application
  - ```cat|cow|pig|horse <name> [period]``` - create an animal with the name and period of actions (default 5 sec and not less than 5 sec.)
  - ```eat|sleep|die|walk|grow <name>``` - force animal with specific name to do action
Simulation logic for animal the following: **eat**, **sleep**, **walk**, **grow** have equal chances to happen and **die** has 10 times less chance of any other command to happen.

### Farm listener
- FarmListenerTest (`observer_listener_pattern` package) - a test for `Observer/Listener design pattern` with multithreading and concurrency.
`FarmListenerOrObserver` - is in the role of `listener` or `observer` and receives events from the `observable` `AnimalObservable`
That is the main difference in comparison to `Farm project` where there is one Farm Thread 
that makes `pulling` of animals in case they are ready and want to do something.
`Farm Listener` is the example of `pushing` model, where each animal notifies Farm when it needs.

So basically shows pluses and minuses of two approaches `Pull` vs `Push` . 
Similar to client/server, browser/server or mobile app/server models.

Pull model (communication initialized by client):
  - Plus: less resources (Threads, memory)
  - Plus: easier implementation
  - Plus: no need of support from server (Listeners or events)
  - Minus: constant pulling that consumes time (even when there are no events)
  - Minus: No real time
  - Minus: Degradation of time when more elements.
  - Minus: more memory to store events on server
  
Push model (communication initialized by server):
  - Plus: real time
  - Plus: no degradation on number of entities
  - Minus: degradation on the number of events.
  - Minus: consumes more resources (Threads, memory)
  - Minus: implementation of mechanism on both client and server
  - Minus: more memory to store events on client
  
Best approach is to combine both: push and pull models where possible in order to minimize minuses of both approaches.

Actor model (Akka in Scala) - uses underneath this approach, based on the principle of TCP/IP protocol
for configuring push - pull based on back pressure (managing window size in TCP/IP), 
depending on who is quicker: client or server.