# Maximum Subarray — Kadane's Algorithm

## Overview

A Java implementation of the maximum subarray problem using Kadane's algorithm (O(n)) and a divide-and-conquer approach (O(n log n)). Finds the contiguous subarray with the largest sum in an array of positive and negative integers.

## Skills Demonstrated

- Kadane's algorithm (linear-time solution)
- Divide-and-conquer approach
- Big-O complexity comparison
- Input validation and edge case handling

## Tech Stack

- Java (JDK 8+)

## How to Run

```bash
cd 06_data_structures_&_Algorithms/Maximum_Subarray/src
javac *.java
java MaximumSubarray
```

Or open the project folder in IntelliJ IDEA and run `MaximumSubarray`.

## Highlights

- Kadane's algorithm: single pass, O(n) time, O(1) space
- Divide-and-conquer: O(n log n) alternative for comparison
- Example: `[2, -4, 3, 5, -2, 6]` → maximum subarray sum is **12** (subarray `[3, 5, -2, 6]`)
