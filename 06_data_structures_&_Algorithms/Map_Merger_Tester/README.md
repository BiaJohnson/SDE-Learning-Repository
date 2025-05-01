# MergedTester 

## Table of Contents
- [1. Executive Summary/Purpose](#1-executive-summarypurpose)
- [2. Proposal](#2-proposal)
- [3. Design Details](#3-design-details)
- [4. Appendices](#4-appendices)

## 1. Executive Summary/Purpose

### 1.1 Summary
MergedTester is a Java program designed to test the functionality of a Map
merging implementation. It specifically tests the behavior of merging HashMaps
containing String keys and Integer values, validating the correct combination
of values when keys overlap across different maps.


### 1.2 Problem Statement
The program needs to verify the correct merging behavior of multiple HashMaps, particularly focusing on:

- Handling duplicate keys across maps.
- Preserving unique values for the same keys.
- Maintaining single values when duplicates exist.
- Proper handling of unique keys across maps.
- Values must maintain the natural order.

## 2. Proposal

### 2.1 Implementation Strategy
The solution implements map merging using a two-step approach with careful consideration 
for data structure selection and value handling:
1. Data Structure Selection
   - TreeMap : Chosen as the primary container to:
     - Maintain keys in natural sorted order.
     - Provide consistent iteration order.
     - Enable efficient key-based operations.
   - Set<Integer> : Used for values to:
     - Automatically handle duplicate values.
     - Store unique integers for each key.
     - Maintain sorted order (using TreeSet).
2. Merge Implementation: The merge operation is split into two main components:
   a. Main Merge Method:
    - Processes each input map sequentially.
    - Uses a helper method for actual merging logic.
    - Returns final merged result.
   b. Helper Method (addToMergedMap):
    - Iterates through source map entries.
    - Creates new TreeSet (to maintain natural order) for new keys using putIfAbsent.
    - Adds values to existing or new sets.
    - Maintains value uniqueness automatically via Set properties


### 2.2 Stakeholders
- Developers implementing the Maps.merge() functionality.
- QA engineers validating the merge behavior.
- Code reviewers ensuring correct implementation.
- Future maintainers of the codebase.

## 3. Design Details

### 3.1 Architecture Overview:
The program consists of two main components:
1. MergedTester class.
   - Purpose: Serves as the main testing framework for validating map merging operations.
   - Methods: main(String[] args): Entry point that executes all test scenarios.
   - Responsibilities:
     - Setting up test data in multiple HashMaps.
     - Calling the merge method with different map combinations.
     - Displaying actual and expected results.
     - Validating merge behavior across different scenarios
2. Maps class (containing the merge implementation - not shown in current code).
   - Purpose: Contains core functionality for merging maps.
   - Methods: merge(Map<String, Integer> map1, Map<String, Integer> map2):
     - Input: Two Maps with String keys and Integer values.
     - Output: Returns a merged Map containing combined values
   - Responsibilities:
     - Handling duplicate key scenarios.
     - Managing value combinations.
     - Ensuring proper merging logic.
     - Maintaining data integrity during merge operations.

### 3.2 Functional Requirements
1. Test merging of two HashMaps with:
   - Overlapping keys with different values.
   - Overlapping keys with identical values.
   - Unique keys in each map.
2. Validate expected output against predefined test cases
3. Display both actual and expected results for comparison

### 3.3 Process Flow:

````
Input Maps → TreeMap Creation → Process Map1 → Process Map2 → Return Result
↓
For each entry:
↓
Create/Get TreeSet for key
↓
Add value to TreeSet
````


### 3.4 Test Cases:
1. Test Case 1 (Map A + Map B):
   - Tests handling of different values for same keys. 
   - Validates preservation of unique values. 
   - Checks proper merging of identical values.
2. Test Case 2 (Map A + Map C):
   - Tests handling of new unique keys. 
   - Validates consistent value handling.
   - Verifies proper merging of identical values.
3. Test Case 3 (Map C + Map B):
   - Tests different combination of maps.
   - Validates consistency in merge behavior. 
   - Verifies handling of multiple identical values.

### 3.5 Expected Behaviors
1. When keys have different values:
   - Both values should be preserved in a list
2. When keys have identical values:
   - Only one instance of the value should be kept
3. When keys are unique to one map:
   - The key-value pair should be preserved in the result

## 4. Appendices

### 4.1 Doc Data/Change Log

| Version | Author   | Status | Comments                    |
|---------|----------|--------|----------------------------|
| 1.0     | bcordeir | Draft  | Initial design document    |
| 1.1     | bcordeir | Update | Added implementation comparison |

### 4.2 Core Tenets

1. Data Integrity:
   - Original maps remain unchanged.
   - Results provided in new data structure.
2. Ordered Output:
   - Consistent key ordering (TreeMap).
   - Sorted values (TreeSet).
3. Value Uniqueness:
   - No duplicate values per key.
   - Automatic deduplication via Set.
4. Clean Design:
   - Modular implementation.
   - Reusable components.
5. Efficient Processing:
   - Optimal data structures.
   - Single pass through input maps.

### 4.3 FAQ
Q: Why use TreeMap instead of HashMap for the merged results?
A: TreeMap was chosen to maintain keys in natural sorted order, providing consistent and predictable output regardless of input order.

Q: Why use Set<Integer> instead of List<Integer> for storing values?
A: Set automatically handles duplicate values and using TreeSet specifically ensures values are sorted, making the output cleaner and more predictable.
