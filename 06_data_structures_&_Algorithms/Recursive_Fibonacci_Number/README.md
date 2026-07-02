# Recursive Fibonacci — Memoization Optimization

## Overview

A Java program that calculates Fibonacci numbers using two recursive approaches: a basic implementation with exponential time complexity and an optimized version using array-based memoization for linear time.

## Skills Demonstrated

- Recursion and base case design
- Memoization for performance optimization
- Algorithmic complexity comparison (O(2ⁿ) vs O(n))
- Side-by-side implementation comparison

## Tech Stack

- Java (JDK 8+)

## How to Run

```bash
cd 06_data_structures_&_Algorithms/Recursive_Fibonacci_Number/src
javac *.java
java RecursiveFib
```

For the memoized version, run `java RecursiveFibSolution` instead.

## Highlights

- `RecursiveFib`: basic recursion, recalculates values repeatedly (O(2ⁿ))
- `RecursiveFibSolution`: caches results in an array (O(n))
- Demonstrates how memoization transforms an impractical algorithm into an efficient one
