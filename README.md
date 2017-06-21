# Algorithms

[![Open Source Love](https://badges.frapsoft.com/os/v2/open-source.svg?v=103)](https://github.com/ellerbrock/open-source-badge/)    

[![Build Status](https://travis-ci.org/Iurii-Dziuban/algorithms.svg?branch=master)](https://travis-ci.org/Iurii-Dziuban/algorithms)
[![Coverage Status](https://coveralls.io/repos/github/Iurii-Dziuban/algorithms/badge.svg?branch=master)](https://coveralls.io/github/Iurii-Dziuban/algorithms?branch=master)
[![Dependency Status](https://www.versioneye.com/user/projects/57b8ae5bfc1827003a745b57/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/57b8ae5bfc1827003a745b57)
[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/Iurii-Dziuban/algorithms/issues)

This is Java Project with source files related to Algorithms and Data structures.
Includes implementation of algorithms and data structures from Princeton and Stanford courses on Coursera.

Maven build script is provided.

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

# Booking.com
- CustomerServiceCapacity (CustomerServiceCapacityTest) - find minimum additional number of employers needed to handle all the calls.
- Polygons (PolygonsTest) - 4 sided polygons. Determine type of the polygon and count different types.
- DeltaEncoding (DeltaEncodingTest) - encode list of number with list, each next value is different between current and previous number. If difference is more than some value (e.x. one byte) use escape value.
- SortHotelsList (SortHotelsListTest) - standard map-reduce example. In Big data world can be done by Spark/Hadoop. In java best approach to continue with Stream API and probably use parallelStream for better performance. Be careful not to design solution with adding stream values into collection. Slows down the solution. Better to have the whole pipeline and aggregation function in the end

# Google
- TwoPairParticularSum (TwoPairParticularSumTest) - mock interview find two pairs in array sum is equal to particular one