# Improved BubbleSort Algorithm Design Document

## Table of Contents
- [1. Executive Summary/Purpose](#1-executive-summarypurpose)
- [2. Proposal](#2-proposal)
- [3. Design Details](#3-design-details)
- [4. Appendices](#4-appendices)

## 1. Executive Summary/Purpose

### 1.1 Summary
This design document outlines the optimization of a Bubble Sort algorithm implementation to
improve its performance by reducing unnecessary passes and comparisons while maintaining
its core sorting functionality.

### 1.2 Problem Statement
The original bubble sort implementation performs unnecessary comparisons and iterations,
even after portions of the array are already sorted. The goal is to improve efficiency by
implementing optimizations that reduce the number of comparisons and terminate early when possible.

## 2. Proposal

### 2.1 Implementation Strategy
The optimization is achieved through:
1. Implementation of a boolean flag (swapped) to detect when no swaps are needed.
2. Tracking the last unsorted element to reduce the comparison window.
3. Using a do-while loop structure for more intuitive flow control.
4. Creating a separate swap method for better code organization.


### 2.2 Stakeholders
- Developers implementing sorting algorithms.
- Students learning algorithm optimization techniques.
- Code maintainers.
- Performance-critical applications requiring sorting functionality.

## 3. Design Details

### 3.1 Architecture Overview:
The solution consists of:
- Original sort() method for baseline comparison.
- Optimized sortImprovement2() method with enhanced features.
- Helper swap() method for clean code.
- Main method for demonstration and testing.


### 3.2 Functional Requirements
1. Must maintain correct sorting functionality.
2. Must implement early termination mechanism.
3. Must track and utilize last unsorted element position.
4. Must provide a clean swap operation.
5. Must handle arrays of various sizes and compositions.


### 3.3 Process Flow:
1. Initialize boolean swapped flag and lastUnsorted index.
2. Begin do-while loop.
3. Reset swapped flag to false.
4. Perform inner loop comparisons up to lastUnsorted index.
5. Perform swaps when needed and update swapped flag.
6. Decrease lastUnsorted index after each pass.
7. Continue until no swaps are needed.
8. Return sorted array.


### 3.4 Expected Behaviors
- Early termination when array becomes sorted.
- Reduced comparison window in each pass.
- Proper handling of various array conditions:
   - Already sorted arrays.
   - Partially sorted arrays.
   - Reverse sorted arrays.
   - Arrays with duplicates.
  
## 4. Appendices

### 4.1 Doc Data/Change Log

| Version | Author   | Status | Comments                    |
|---------|----------|--------|----------------------------|
| 1.0     | bcordeir | Draft  | Initial design document    |
| 1.1     | bcordeir | Update | Added implementation comparison |

### 4.2 Core Tenets
1. Optimization: Reduce unnecessary comparisons.
2. Clarity: Maintain readable and well-documented code.
3. Modularity: Separate concerns (sorting logic, swapping).
4. Efficiency: Implement early termination.
5. Reliability: Ensure consistent sorting results.


### 4.3 FAQ
Q: What are the key improvements over the original implementation?
A: The improved version includes:
- Early termination using the swapped flag.
- Reduced comparison window using lastUnsorted index.
- Modular swap operation.
- More efficient loop structure.

Q: How does the lastUnsorted index improve performance?
A: It reduces the number of comparisons in each pass by excluding already sorted elements at the end of the array.

Q: Why use a do-while loop instead of a for loop?
A: The do-while loop provides a more natural flow for the algorithm, ensuring at least one pass while allowing for early termination.

Q: How does the swap method improve the code?
A: It improves readability, maintainability, and reduces the chance of errors by centralizing the swap logic in one location.
