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
 * [Facebook tasks](#facebook-tasks)
 * [Microsoft tasks](#microsoft-tasks)
 * [Leetcode.com tasks](#leetcodecom-tasks)
 * [Codility.com tasks](#codilitycom-tasks)
 * [Design questions](#design-questions)
 * [Interview cake](#interview-cake)
 * [Other interview code tasks](#other-interview-code-tasks)
 * [Cracking coding interview](#cracking-coding-interview)
 * [Coursera algorithms by Stanford](#coursera-algorithms-by-stanford)
 * [Data structures implementations](#data-structures-implementations)
 * [Graph algorithms](#graph-algorithms)
 * [Sorting algorithms](#sorting-algorithms)
 * [Crypto](#crypto)
 * [Combinatorics](#combinatorics)
 * [Recursion](#recursion)
 * [Generic](#generic)
   * [Concurrency](#concurrency) - concurrency related structures
   * [Hotspot](#hotspot) - hotspot related examples
   * [Performance](#performance) - performance related structures
   * [Farm project](#farm-project) - pull model (event are pulled)
   * [Farm listener](#farm-listener) - push model (events are pushed)
   * [String](#string) - string manipulations
   * [Patterns](#patterns) - design patterns examples
   * [Java 8 Features](#java8) - java8 examples
   * [Java EE](#jee) - Java Enterprise Edition (Eclipse EE4J) examples
   * [Java Server Faces](#jsf) - jsf examples
   * [Memory model](#memory-model) - memory model related examples

 **And much more** : greedy algorithms, topcoder, concurrency, usage of data structures in other algorithms
 
# Checks

`Jacoco`/`cobertura` code coverage, `pmd`, `checkstyle`, `enforcer`, `findbugs`

# Amazon tasks
- TakeOddObjects (TakeOddObjectsTest) - List contains duplicates. Take only ones, which count is odd.Compare according to equals method. Note: Tests knowledge of Map, Set different implementations: hash, tree, linkedHash.
- CIDRComparator (CIDRComparatorTest) - There are two subnet addresses. Find out the relation: Subset, Superset, Equal, Disjoint . More info : https://en.wikipedia.org/wiki/Classless_Inter-Domain_Routing
- BalancedParenthensies (BalancedParenthensiesTest) - Check if parenthesies are balanced in a string or not. Note: Tests basic knowledge of Stack.
- ProcessorsForTasks (ProcessorsForTasksTest) - find minimum number of processors for tasks
- CountNegativeIntegersInRowColumnWiseSortedMatrix (CountNegativeIntegersInRowColumnWiseSortedMatrixTest) - mock amazon interview question
- RangeMerge (RangeMergeTest) - sorted array of ints. Encode/Archive/Zip numbers into ranges. Optimized solution
- TrappingRainWater (TrappingRainWaterTest) - array of landscape. Calculate how many units of water will remain after the rain inside.
- KClosestPoints (KClosestPointsTest) - find k closest 2d points to particular one
 
# Yandex tasks
- Bencode (BencodeTest) - implementation of Bencode protocol for encoding/decoding data. Widely used in torrents. More info: https://en.wikipedia.org/wiki/Bencode

# Booking.com tasks
- CustomerServiceCapacity (CustomerServiceCapacityTest) - find minimum additional number of employers needed to handle all the calls.
- Polygons (PolygonsTest) - 4 sided polygons. Determine type of the polygon and count different types.
- DeltaEncoding (DeltaEncodingTest) - encode list of number with list, each next value is different between current and previous number. If difference is more than some value (e.x. one byte) use escape value.
- SortHotelsList (SortHotelsListTest) - standard map-reduce example. In Big data world can be done by Spark/Hadoop. In java best approach to continue with Stream API and probably use parallelStream for better performance. Be careful not to design solution with adding stream values into collection. Slows down the solution. Better to have the whole pipeline and aggregation function in the high
- FindMaxGuestDayService (FindMaxGuestDayServiceTest) - similar to CustomerServiceCapacity and ProcessorsForTasks.
- PathsFromRoot (PathsFromRootTest) - Binary tree. Find paths from root with specific sum value.

# Google tasks
- TwoPairParticularSum (TwoPairParticularSumTest) - mock interview find two pairs in array sum is equal to particular one
- FirstRecurringCharacter (FirstRecurringCharacterTest) - find firstIndex recurring character in string
- RobotTest - iterative, recursive approaches to do steps/counting

# Facebook tasks
- `facebook` package

- Buttons (ButtonsTest) - calculating number of combinations to open the Lock
- IceCapsMelting (IceCapsMeltingTest) - array of temperatures. Find the biggest difference between two (smaller before larger)
- MaximumSubarrayProblem(MaximumSubarrayProblemTest) - find maximum sum of sub array in array
- MinIteratorOfSortedAscendingLists (MinIteratorOfSortedAscendingListsTest) - implement iterator over N sorted lists of elements
- SortedSquaresOfSortedArray (SortedSquaresOfSortedArrayTest) - given sorted list of elements - return sorted list of squared elements
- TypingSuggestions (TypingSuggestionsTest) - return possible correct words from the dictionary

# Microsoft tasks
- `microsoft` package

- LowestCommonAncestor (LowestCommonAncestorTest) - finding lowest common ancestor in the tree

# Leetcode.com tasks
LeetCode is a platform for preparing technical coding interviews. 

Pick from an expanding library of questions, code and submit your solution to see if you have solved it correctly. 
The platform currently supports a total of 11 languages: C, C++, Java, Python, C#, JavaScript, Ruby, Swift, Go, Bash, MySQL.

- 1 TwoSum (TwoSumTest) - find two elements which sum is equal to the target
- 2 AddTwoNumbers (AddTwoNumbersTest) - add two linkedList numbers starting from lowest digit
- 3 LongestSubstringWithoutRepeatingCharacters (LongestSubstringWithoutRepeatingCharactersTest)
- 4 MedianOfTwoSortedArrays (MedianOfTwoSortedArraysTest) - find median of two sorted arrays
- 5 LongestPalindromicSubstring (LongestPalindromicSubstringTest) - efficient algorithm
- 6 ZigZagConversion (ZigZagConversionTest) - form a zigzag string from string with particular width
- 7 ReverseInteger (ReverseIntegerTest) - reverse an integer (might be overflow)
- 8 StringToInteger (StringToIntegerTest) - parsing string to int
- 9 PalindromeNumber (PalindromeNumberTest) - checking integer if it is palindrome
- 10 RegularExpressionMatching (RegularExpressionMatchingTest) - checking wildcard pattern matching
- 11 ContainerWithMostWater (ContainerWithMostWaterTest) - find the container with highest capacity
- 12 IntegerToRoman (IntegerToRomanTest) convert integer value to Roman representation
- 13 RomanToInteger (RomanToIntegerTest) convert Roman string to int. Reverse to RomanToInteger
- 14 LongestCommonPrefix (LongestCommonPrefixTest) find longest common prefix for all strings in the array
- 15 ThreeSum (ThreeSumTest) - 3Sum - find all 3 element pairs, which sum is equal to the target value
- 16 ThreeSumClosest (ThreeSumClosestTest) find 3 sum closest to target
- 17 LetterCombinationsOfAPhoneNumber (LetterCombinationsOfAPhoneNumberTest) - permutation with repetition combinatorics question
- 18 FourSum (FourSumTest) - find all four elements that sum equals target
- 19 RemoveNthNodeFromEndOfList (RemoveNthNodeFromEndOfListTest) - linked list remove
- 20 ValidParentheses same as BalancedParentheses (BalancedParenthesesTest)
- 22 GenerateParentheses (GenerateParenthesesTest) - generate all valid combinations of n parentheses
- 42 TrappingRainWater (TrappingRainWaterTest) - calculate water inside the landscape
- 44 WildcardMatching (WildcardMatchingTest) - checking wildcard pattern matching
- 45 JumpGame2 (JumpGame2Test) - Jump Game / Tower Hopper problem / Minimum number of jumps to reach the high based on possible range to jump from current element.
- 53 MaximumSubarray (MaximumSubarrayProblemTest) - find maximum contiguous  sub array sum in array
- 69 Sqrt (SqrtTest) - calculation of int part of sqrt(x)
- 84 LargestRectangleInHistogram (LargestRectangleInHistogramTest) - finding largest rectangle under the histogram.
- 152 MaximumProductSubarray (MaximumProductSubarrayTest) - idea is similar to MaximumSubarray
- 238 ProductOfArrayExceptSelf (ProductOfArrayExceptSelfTest) - added simple left-right multiplication, and log based that handles zero exists and negative numbers case.
- 273 IntegerToEnglishWords (IntegerToEnglishWordsTest) similar to IntegerToRoman conversion 
- 301 RemoveInvalidParentheses (RemoveInvalidParenthesesTest) removing minimum invalid parentheses with BFS on queue
- 407 TrappingRainWater2 (TrappingRainWater2Test) - 3D extension
- 454 FourSum2 (FourSum2Test) four elements sum equal to target value
- 457 CircularArrayLoop (CircularArrayLoopTest) - finding if loop exists in the connected element array by delta/index jumps stored in array
- 658 FindKClosestElements (FindKClosestElementsTest) - on plain find k closest elements to element
- 744 FindSmallestLetterGreaterThanTarget (FindSmallestLetterGreaterThanTargetTest) - find via linear or binary search
- 751 IPtoCIDR (IPtoCIDRTest) - convert ip to lowest range of CIDRs to cover
- 755 PourWater(PourWaterTest) - pouring water at specific index find the result heights 

# Design questions
- package `design`
  - `ParkingLotDesign` - design of Parking Lot
  - `WhatsAppDesign` - design of messaging system like whatsApp / facebook messager /weChat

# Codility.com tasks
Codility is a platform for hiring stronger programmers faster. Has requirements for time and space complexity.
Look for "codility" package

- BinaryGap (BinaryGapTest) - find maximal sequence of consecutive zeros that is surrounded by ones (in binary representation)
- Equilibrium (EquilibriumTest) - find element in the array, so that sum of element left to it equal to the sum of element right to it
- MissingInteger (MissingIntegerTest) - find minimum positive integer missing in the array
- MaxConsecutiveOnes (MaxConsecutiveOnesTest) - find max consecutive ones in binary representation of int
- package `zooplus` updated - 100% result
   - AllCitiesVacation (AllCitiesVacationTest) - find minimum sub array of consecutive values containing all the values of array
   - SqlFunctionsTask - sql task to right a query based on joins, having and aggregation functions
   - TelephoneNumbersFormatter (TelephoneNumbersFormatterTest) - format telephone number into specific format.
- package `cliqz` updated - 100% result
   - ArrayJumps (ArrayJumpsTest) - find number of jumps to reach out of the array (or -1 in case of cycle)
   - Fibonacci (FibonacciTest) - finding last N digit of the Fibonacci most efficient way O(logN)
   - Kcomplementary (KcomplementaryTest) - finding the number of all 2 pair numbers from array with sum equal to K
- package `onpex` updated - 100% result
   - IntegerPositionInOtherInteger (IntegerPositionInOtherIntegerTest) - find substring position of one integer in another. Based on String.indexOf method, cause integers are not negative
   - LongestSubarrayDifferenceMaxOne (LongestSubarrayDifferenceMaxOneTest) - find maximum subset of ints in array, so that difference between any in the subset is <= 1
   - AdjacentCoinProblem (AdjacentCoinProblemTest) - find maximum equal adjacent two coins count after flipping one of the coins.
- FindDifferentBallWeight - logic task to find the box/ball with bigger weight based on a specific number of weighings.
- CardsSamePositionAfterShuffling - logic/probability/ combinatorics task to find number of cards remain at same position after random shuffling
- OpenTheCombinationLock - logic/probability/combinatorics question on opening the combination lock
- GenerateNumberWithProbability - logic/probability task for generation random uniformly distributed value from range

# Interview cake
Solutions to "interview cake" problems 

# Other interview code tasks

- AnagramsQuick (AnagramsQuickTest) find anagrams of the given word with words from the file. Provide quickest possible solution
- ReverseWords (ReverseWords) reverse each word (based on space separation ' ') in the character array. Optimize code.

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

# Crypto
- package `crypto`
Added implementation of Scrooge coin from crypto currency course

# Combinatorics
- package `combinatorics`
Added initial classes for implementation

# Recursion
- package `recursion`
Methods and algorithms that are solved by recursion
- Count (CountTest) - counting object in list based on simple recursion, tail recursion, stream reduce, stream count method.
- Max (MaxTest) - finding max object in list based on simple recursion, tail recursion, stream reduce, stream max method.
- Sum (SumTest) - summing objects in list based on simple recursion, tail recursion, stream reduce, stream sum method.

# Generic

## Concurrency
- ReadWriteLock - implementation of ReadWriteLock. Many readers can acquire lock (without writers) or only one writer acquires the lock.
- ThreadPool - implementation of thread pool based on wait/notify paradigm with standard array for threads and linkedList for tasks. Implementation of "fair" processing.
- ThreadPoolBlockingQueue - implementation of thread pool based on usage of BlockingQueue primitive 
- ThreadPoolBlockingQueueWithExecutor - implementation with control over the thread pool 
- ForkJoinTest - example of using custom ForkJoinPool in the context and streams make use of it. Experiment with different number for parallelism 

- ConcurrentStack (ConcurrentStackTest) - implementation of thread-safe Stack for multithreaded environment in lock-free (not wait-free!) manner. Wait-free algorithms have stronger guarantees. 
- ConcurrentLinkedList (ConcurrentLinkedListTest) - implementation of thread-safe LinkedList (Queue) for multithreaded environment in lock-free (not wait-free) manner. Wait-free algorithms have stronger guarantees.
- NonBlockingCounter (NonBlockingCounterTest) - implementation of thread-safe counter for multithreaded in lock-free (not wait-free) manner. Wait-free algorithms have stronger guarantees.
- CountDownLatchTest - barrier, which all threads wait. Countdown can be executed from different thread. Usable once.
- CyclicBarrierTest - barrier, which all threads wait. Waiting (which decreases the value) is inside of the threads. Can be reset/reused. Runnable action can be executed at the barrier, before threads are released. BrokenBarrierException if the thread breaks the barrier.

## Hotspot

- package `hotspot` (JVM crashes)
  - NotValidAddressCrashTest - example of crashing VM trying to set value to address that is not readable or writable
  - CrashIntTest - example of crashing JVM when trying to change the link address (between class instance and the field)
  - CrashStringTest - example of crashing JVM when modifying internals of string
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

## String
 - package `string`
 
 - Reverse string via StringBuilder (simplest way using jdk)

## Patterns
 - package `patterns`
 
 - SingletonNCountInstances - example to have specific amount of singletons based on enum properties. Thread safe via atomic int
 
## java8
 - package `java 8` java8 related features
 
## jee
 - package `jee` Java Enterprise Edition (Eclipse EE4J) related
 
## jsf
 - package `jsf` Java Server Faces related
 
## Memory model
 - package `memmorymodel` - related to java memory model


# Ideas
1. package concurrency. Make good tests for the primitive implementations. Add additional examples with Locks.
1. package combinatorics. Implement combinatorics primitive implementations with tests.
1. package dynamic_programming . Implement TODO classes. Implement good tests to cover.
1. 