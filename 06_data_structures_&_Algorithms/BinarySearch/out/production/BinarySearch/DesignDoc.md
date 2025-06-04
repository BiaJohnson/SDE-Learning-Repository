# BinarySearch Design Document

## Table of Contents
- [1. Executive Summary/Purpose](#1-executive-summarypurpose)
- [2. Proposal](#2-proposal)
- [3. Design Details](#3-design-details)
- [4. Appendices](#4-appendices)

## 1. Executive Summary/Purpose

### 1.1 Summary
This project implements a Binary Search algorithm, a highly efficient search method designed to find target elements within sorted arrays. The implementation provides a 
fundamental searching utility that achieves logarithmic time complexity, making it significantly faster than linear search methods for large datasets. The solution includes 
comprehensive testing and validation to ensure reliability across various use cases.


### 1.2 Problem Statement
Traditional linear search methods become increasingly inefficient as data sets grow larger, resulting in performance bottlenecks in applications. Specific challenges include:
- Need for faster search operations in sorted arrays.
- Requirement for efficient memory usage during search operations.
- Demand for predictable and consistent search performance.

## 2. Proposal

### 2.1 Implementation Strategy
The implementation will be executed through the following structured approach:
1. Core Algorithm Development :
   - Implement iterative binary search approach.
   - Ensure proper handling of array bounds.
   - Incorporate input validation.
   - Maintain O(log n) time complexity.
2. Testing Strategy :
   - Develop comprehensive test cases including:
     - Standard search scenarios.
     - Edge cases (empty arrays, single elements).
     - Boundary conditions.
     - Performance validation.
3. Code Organization :
   - Create modular, well-documented code.
   - Implement clear method signatures.
   - Separate concerns (validation, search logic).
   - Follow clean code principles.
4. Validation Process :
   - Unit testing for functionality verification.
   - Performance testing for efficiency confirmation.
   - Edge case validation.

### 2.2 Stakeholders
- Developers implementing the Maps.merge() functionality.
- QA engineers validating the merge behavior.
- Code reviewers ensuring correct implementation.
- Future maintainers of the codebase.

## 3. Design Details

### 3.1 Architecture Overview:
The Binary Search algorithm is implemented as a standalone search utility that follows a simple, efficient architecture:
1. Core Components :
   - Search Logic Module: Contains the main binary search implementation. 
   - Input Validation Layer: Ensures data integrity and preconditions. 
   - Result Handler: Manages search outcomes and return values.
2. Design Principles :
   - Modularity: Clear separation of validation and search logic.
   - Immutability: Input array remains unchanged during operation.
   - Stateless Operation: No persistent state maintained between searches.
3. Data Flow :
   - Input → Validation → Search Execution → Result Return.

### 3.2 Functional Requirements
1. Core Search Functionality :
   - System must accept an integer array and target value as input.
   - System must return the index of the target element if found.
   - System must return -1 if the target element is not found.
2. Input Handling :
   - Must verify that input array is sorted in ascending order.
   - Must handle arrays of various sizes (including empty arrays).
   - Must validate that input array is not null.
3. Performance Requirements :
   - Must achieve logarithmic time complexity O(log n).
   - Must maintain constant space complexity O(1).
   - Must complete search operations without modifying input array.
4. Error Handling :
   - Must gracefully handle invalid inputs.
   - Must provide clear indication of search results.
   - Must maintain system stability under edge cases.


### 3.3 Process Flow:
1. Input Validation
   - Verify the input array is not null. 
   - Check if the array is sorted (binary search requirement).
   - Validate the target value.
2. Binary Search Execution
   - Initialize left pointer at start (0) and right pointer at end (length-1).
   - While left pointer ≤ right pointer:
     - Calculate middle index = (left + right) / 2 .
     - If middle element equals target, return index. 
     - If target is less than middle element, search left half. 
     - If target is greater than middle element, search right half. 
   - Return -1 if element not found.

### 3.4 Expected Behaviors
1. Success Cases:
   - Returns correct index when target element exists in array. 
   - Returns -1 when target element is not found. 
   - Handles arrays of different sizes efficiently.
2. Edge Cases:
   - Empty array returns -1. 
   - Single element array works correctly. 
   - Duplicate elements returns first occurrence.
   - Array bounds are properly handled.
   - 
## 4. Appendices

### 4.1 Doc Data/Change Log

| Version | Author   | Status | Comments                    |
|---------|----------|--------|----------------------------|
| 1.0     | bcordeir | Draft  | Initial design document    |
| 1.1     | bcordeir | Update | Added implementation comparison |

### 4.2 Core Tenets
1. Efficiency
   - Time Complexity: O(log n).
   - Space Complexity: O(1).
   - No unnecessary iterations.
2. Reliability 
   - Consistent results for all valid inputs. 
   - Proper error handling. 
   - Input validation.
3. Maintainability
   - Clear variable naming. 
   - Well-documented code. 
   - Easy to understand implementation.

### 4.3 FAQ
Q: Why use Binary Search over Linear Search?
A: Binary Search provides O(log n) time complexity compared to Linear Search's O(n), making it significantly faster for large sorted arrays.

Q: What are the prerequisites for Binary Search?
A: The array must be sorted in ascending order before applying Binary Search.

Q: What happens if the array is not sorted?
A: Binary Search will not work correctly on unsorted arrays and may miss existing elements.

Q: Is Binary Search space-efficient?
A: Yes, it uses O(1) extra space as it only needs a few variables regardless of input size.