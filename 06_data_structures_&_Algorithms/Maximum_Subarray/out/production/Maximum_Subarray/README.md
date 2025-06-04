# Maximum Subarray Algorithm Implementation

## 1 Executive summary/Purpose
We aim to solve the maximum subarray problem, which involves finding a sequence of numbers in an array
that adds up to the largest possible sum. For example, in the array [2, -4, 3, 5, -2, 6], we need to identify 
the group of consecutive numbers that yields the largest total when summed.

### 1.1 Background
The maximum subarray problem is a fundamental algorithmic challenge in computer science with applications 
in data analysis, financial market analysis, signal processing, and genomic sequence analysis. Various solution 
approaches have been developed over time, ranging from simple brute-force methods to more sophisticated algorithms.

### 1.2 Problem statement

Given an array of integers (positive and negative), find the contiguous subarray with the largest sum. 
We need to implement this in a way that is both correct and efficient, while demonstrating the performance
differences between approaches.

### 1.3 Evolution of Solution Approaches
The problem has seen significant algorithmic advancement over time:

1. Traditional Brute Force Method 
   - Time Complexity: O(n²)
   - Exhaustive evaluation of all possible subarrays
2. Divide-and-Conquer Strategy 
   - Time Complexity: O(n log n)
   - Systematic partitioning and recursive problem solving
3. Kadane's Algorithm
   - Time Complexity: O(n)
   - Optimal linear-time solution

## 2 Proposal

### 2.1 Implementation Focus
Our implementation examines two principal methodologies:
- The divide-and-conquer approach
- Kadane's linear-time algorithm

This comparative analysis aims to demonstrate:
- Algorithmic efficiency differences
- Performance characteristics under varying conditions
- Trade-offs between implementation complexity and execution speed

### 2.2 Stakeholders
- Software developers
- Algorithm researchers
- Data scientists
- Financial analysts

### 2.3 Architecture
The solution implements two distinct approaches for solving the maximum subarray problem:

1. Divide and Conquer Implementation 
   - maxSubarrayAux(): Recursive method that divides the array
   - maxSubarrayCross(): Handles cross-boundary cases
2. Linear Time Implementation (Kadane's Algorithm)
   - maxSubarray(): Iterative method using dynamic programming
3. Input Validation Layer 
   - Null and empty array checking 
   - Edge case handling

### 2.4 Alternatives
1. Current Implementations:
   - Divide and Conquer (O(n log n))
   - Kadane's Algorithm (O(n))
2. Alternative Approaches Not Implemented:
   - Brute Force (O(n²))
   - Dynamic Programming with space optimization 
   - Parallel processing for large arrays
   
## 3 Design details

### 3.1 Functional requirements
. The system shall accept an integer array of any size
. The system shall return null for invalid inputs (null or empty arrays)
. The system shall handle both positive and negative numbers
. The system shall find the maximum sum of any contiguous subarray
. The system shall provide both recursive and iterative solutions
. The system shall handle single-element arrays correctly

### 3.2 Non-functional requirements
1. Performance:
   - Kadane's Algorithm: O(n) time complexity
   - Divide and Conquer: O(n log n) time complexity
2. Reliability:
   - Robust input validation
   - Handling of Integer.MIN_VALUE cases
3. Maintainability:
   - Clear method naming
   - Documented code with comments
   - Separate methods for different approaches
4. Memory Efficiency:
   - O(log n) space complexity for recursive solution
   - O(1) space complexity for iterative solution

## 4 Appendices

### 4.1 Doc data/Change log

|Version| Author   |Status|Comments|
|-------|----------|------|--------|
|1.0| bcordeir |Complete|Initial implementation with both algorithms|

### 4.2 Glossary

. Kadane's Algorithm: An iterative dynamic programming algorithm that maintains local and global maximum sums
. Divide and Conquer: A recursive approach that splits the problem into smaller subproblems
. Cross Sum: The maximum sum that crosses the midpoint in divide and conquer approach
. maxEnding: The maximum sum ending at the current position
. maxSoFar: The global maximum sum found so far

