# Fibonacci Sequence Calculator

## Table of Contents
- [1. Executive Summary/Purpose](#1-executive-summarypurpose)
- [2. Proposal](#2-proposal)
- [3. Design Details](#3-design-details)
- [4. Appendices](#4-appendices)

## 1. Executive Summary/Purpose

### 1.1 Background
The Fibonacci sequence is a fundamental mathematical concept where each number is the sum 
of the two preceding ones. While a basic recursive implementation (RecursiveFib) works, 
it suffers from significant performance issues due to redundant calculations. 
This project implements and compares two different approaches to calculating Fibonacci numbers using recursion.

### 1.2 Problem Statement
This project addresses the performance limitations of traditional recursive Fibonacci calculations 
by implementing an optimized solution using memoization. The program demonstrates the significant 
performance difference between two recursive approaches: a basic implementation that recalculates 
values multiple times, and an optimized version that stores previously calculated results in 
an array-based cache. 

## 2. Proposal

The solution demonstrates how algorithmic optimization can 
transform an exponential-time problem into a linear-time solution. This practical implementation 
serves as an example of how proper algorithm design and data structure selection can dramatically
improve program efficiency while maintaining code clarity and reliability.
The original recursive Fibonacci implementation (RecursiveFib) has exponential time complexity O(2^n),
making it impractical for larger numbers. The goal is to develop an optimized solution that:
- Reduces redundant calculations
- Improves execution time
- Handles larger inputs efficiently
- Maintains code readability
- Implements proper error handling

### 2.1 Stakeholders
- Software Developers: Need efficient algorithm implementation
- System Architects: Concerned with performance optimization
- End Users: Require fast and reliable calculations
- Quality Assurance: Need reliable error handling and testing

## 3. Design Details

### 3.1 Architecture Overview:
The improved solution (RecursiveFibSolution) implements:
1. Memoization using an array for caching
2. Recursive calculation with cached value checks
3. Input validation and error handling
4. Clear separation of concerns between calculation and validation

### 3.2 Functional Requirements
- Calculate Fibonacci numbers using recursive methods
- Handle invalid inputs (negative numbers and non-integers)
- Cache previously calculated values to improve efficiency

### 3.3 Technical Architecture
The solution consists of the following components:

1. Main Program Flow:
```
- Input validation
- Cache initialization
- Fibonacci calculation
- Result output
```

## 3.4 Implementation Comparison
1. RecursiveFib (Original Solution):
    - Uses pure recursion without caching
    - Time Complexity: O(2^n) - exponential
    - Space Complexity: O(n) - call stack depth
    - Advantages:
        - Simple implementation
        - Minimal memory usage
    - Disadvantages:
        - Extremely inefficient for larger numbers
        - Recalculates same values multiple times
        - Can cause stack overflow for large inputs

2. RecursiveFibSolution (Improved Solution):
    - Uses recursion with memoization
    - Time Complexity: O(n) - linear
    - Space Complexity: O(n) - array storage
    - Advantages:
        - Significantly faster execution
        - Prevents redundant calculations
        - Handles larger inputs efficiently
    - Disadvantages:
        - Uses additional memory for caching
        - Requires array initialization

## 4. Appendices

### 4.1 Doc Data/Change Log

| Version | Author   | Status | Comments                    |
|---------|----------|--------|----------------------------|
| 1.0     | bcordeir | Draft  | Initial design document    |
| 1.1     | bcordeir | Update | Added implementation comparison |

### 4.2 Core Tenets
- Performance optimization through memoization
- Robust error handling
- Time complexity improvement
- Memory-time trade-off consideration

### 4.3 FAQ
Q: Why use memoization?
A: Memoization dramatically improves performance by storing previously calculated values, reducing time complexity from O(2^n) to O(n).
